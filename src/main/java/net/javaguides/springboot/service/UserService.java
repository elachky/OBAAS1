package net.javaguides.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.javaguides.springboot.model.Account;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
	Account addAccount( );
	public UserRegistrationDto getUserByUserName(String username);
	int delete(String username, int id);
	String generatePassword(String string);
	int demandeService(String username, String service, int accountN);
	int existUser(String username);
	double demandeBalance(String username, int accountN);
	double payerFacture(String username, int accountN, double amount);
}
