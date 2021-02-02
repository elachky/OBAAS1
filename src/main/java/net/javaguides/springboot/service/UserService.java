package net.javaguides.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.javaguides.springboot.model.Account;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.web.dto.AccountDto;
import net.javaguides.springboot.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
	Account addAccount( );
	public UserRegistrationDto getUserByUserId(String userId);
	void delete(int id);
	String generatePassword(String string);
	int transfer(String userId,int fromAccount,int toAccount,double balance);
}
