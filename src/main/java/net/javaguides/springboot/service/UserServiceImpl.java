package net.javaguides.springboot.service;

import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getEncryptedPassword(), new ArrayList<>());		
	}

	@Override
	public int delete(String username, int accountNumber) 
	{
		Account account = accountRepo.findByAccountNumber(accountNumber);
		User user = userRepository.findByUsername(username);
		if(account!= null&&account.getAccountNumber()==user.getAccount().getAccountNumber()) {
			if (user!= null) {
				userRepository.delete(user);
				accountRepo.delete(account);
				return 0;
			}	
		}
		return -1;
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
		if (user == null) throw new UsernameNotFoundException(username);
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
public double demandeBalance(String username, int accountN) {
	Account account = accountRepo.findByAccountNumber(accountN);
	User user = userRepository.findByUsername(username);
	if (user == null) throw new UsernameNotFoundException(username);
	if(account!=null&&account.getAccountNumber()==user.getAccount().getAccountNumber()) {
			
		return account.getBalance(); 
		
	}else {
		return -1;
		//compte inexiste ou vous avez pas le droit d'acces !!
	}		
	}
	public int existUser(String username) {
		User user = userRepository.findByUsername(username);
		if (user!= null) {
			return 1;
		}else {
			return 0;
		}
		
	}

	@Override
	public double payerFacture(String username, int accountN, double amount) {
		double b=demandeBalance(username,accountN);
		if(b==-1) {
			return -1;
		}else {
			if(b>=amount) {
				Account account = accountRepo.findByAccountNumber(accountN);
				account.setBalance(b-amount);
				accountRepo.save(account);
				return b;
			}else {
				return -2;
			}
		}
		
	}
	@Override
	public int transfer(String userName, int fromAccount, int toAccount, double balance) {
		Account account = accountRepo.findByAccountNumber(fromAccount);
		User user = userRepository.findByUsername(userName);
		//if (user == null) throw new UsernameNotFoundException(account.getId()+"");
		if(account!=null&&account.getAccountNumber()==user.getAccount().getAccountNumber()&&balance>0) {
			if(account.getBalance()>=balance) {
				Account account2 = accountRepo.findByAccountNumber(toAccount);
				if(account2==null)
					return -1;
				account.setBalance(account.getBalance()-balance);
				account2.setBalance(account2.getBalance()+balance);
				accountRepo.save(account);
				accountRepo.save(account2);
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
