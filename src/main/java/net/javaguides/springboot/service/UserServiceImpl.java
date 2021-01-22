package net.javaguides.springboot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

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

	private UserRepository userRepository;
	private AccountRepository accountRepository;
	
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
			  registrationDto.getFirstName(),
			  registrationDto.getLastName(),
			  registrationDto.getEmail(),
			  registrationDto.getPhoneNumber(),
			  registrationDto.getAddress(),
			  registrationDto.getAccounts(),
			  utils.generateStringId(15),
			  passwordEncoder.encode(registrationDto.getPassword()),
			  1);
	  
	  return userRepository.save(user); 
	}
	
	@Override
	public Account saveAccount(AccountDto accountDto)
	{
		long accountNum = ( int )( Math.random() * 9999 ); if(accountNum <= 1000 ) accountNum = accountNum + 1000;
		float balance = ( int )( Math.random() * 9999 ); if(balance <= 1000 ) balance = balance + 1000;

		Account account = new Account(accountNum, balance, new User());
		return accountRepository.save(account);

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
	
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getEncryptedPassword(), new ArrayList<>());		
	}



	
}
