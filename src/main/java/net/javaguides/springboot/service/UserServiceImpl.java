package net.javaguides.springboot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import net.javaguides.springboot.model.Account;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.AccountRepository;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.utils.Utils;
import net.javaguides.springboot.web.dto.AccountDto;
import net.javaguides.springboot.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private Utils utils;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	
	  public User save(UserRegistrationDto registrationDto) 
	{
	  
	  User user = new User(
			  registrationDto.getUsername(),
			  registrationDto.getPhoneNumber(),
			  registrationDto.getAddress(),
			  registrationDto.getAccount(),
			  utils.generateStringId(15),
			  passwordEncoder.encode(registrationDto.getPassword()),
			  registrationDto.getMarketType());
	  
		int balance = ( int )( Math.random() * 9999 );
		int accountNumber = ( int )( Math.random() * 999999999 );
		if( balance <= 1000 ) balance = balance + 1000;
	  user.setAccount(new Account(accountNumber, balance));
	  return userRepository.save(user); 
	}
	@Override
	public Account addAccount() 
	{
		int balance = ( int )( Math.random() * 9999 );
		int accountNumber = ( int )( Math.random() * 999999999 );
		if( balance <= 1000 ) balance = balance + 1000;
				  
		Account account = new Account(accountNumber, balance);
		
		return accountRepo.save(account);
	}
	
	/*
	 * public User save(UserRegistrationDto registrationDto) { User user = new
	 * User(); BeanUtils.copyProperties(registrationDto, user);
	 * 
	 * //Parce que userDto contient les propr. disponibles dans notre Client API (ou
	 * il y a juste first/last name, email...)
	 * //user.setEncryptedPassword(bCrypyPasswordEncoder.encode(userDto.getPassword(
	 * ))); user.setEncryptedPassword("bsbfsbfsnlcallwleqljelqjjejelj");
	 * user.setUserId(utils.generateStringId(15));
	 * 
	 * //Generate a balance int randomNumber = ( int )( Math.random() * 9999 ); if(
	 * randomNumber <= 1000 ) randomNumber = randomNumber + 1000;
	 * user.setBalance(randomNumber);
	 * 
	 * User newUser = userRepo.save(user);
	 * 
	 * return newUser; }
	 */
	 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getEncryptedPassword(), new ArrayList<>());		
	}

	@Override
	public void delete(int accountNumber) 
	{

		Account account = accountRepo.findByAccountNumber(accountNumber);
		if(account == null) throw new UsernameNotFoundException("Invalid username or password.");
		
		User user = userRepository.findByAccountId(account.getId());
		if (user == null) throw new UsernameNotFoundException(account.getId()+"");
		userRepository.delete(user);
		accountRepo.delete(account);
		
		
	}
	public String generatePassword(String pwd) {
		
		return  passwordEncoder.encode(pwd);
	}
	
	
	public UserRegistrationDto getUserByUserId(String userId) {
		User user = userRepository.findByUserId(userId);
		if (user == null) throw new UsernameNotFoundException(userId);
		UserRegistrationDto userDto = new UserRegistrationDto();
		BeanUtils.copyProperties(user, userDto);
		return userDto;
	}
	public AccountDto getAccountByAccountNumber(int accountNumber) {
		Account account = accountRepo.findByAccountNumber(accountNumber);
		if (account == null) throw new UsernameNotFoundException(accountNumber+"");
		AccountDto accountDto = new AccountDto();
		BeanUtils.copyProperties(account, accountDto);
		return accountDto;
	}

	@Override
	public int demandeService(String username, String service, int accountN) {
		
		Account account = accountRepo.findByAccountNumber(accountN);
		User user = userRepository.findByUsername(username);
		if (user == null) throw new UsernameNotFoundException(account.getId()+"");
		if(account!=null&&account.getAccountNumber()==user.getAccount().getAccountNumber()) {
			if(account.getBalance()>=5) {
				account.setBalance(account.getBalance()-5);
				accountRepo.save(account);
				return 1;
			}else {
				return 0;
				//solde insuffisant !!
			}
		}else {
			return -1;
			//compte inexiste ou vous avez pas le droit d'acces !!
		}
	}

	
}
