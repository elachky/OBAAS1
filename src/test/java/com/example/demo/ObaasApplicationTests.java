package com.example.demo;

import net.javaguides.springboot.web.dto.*;
import net.javaguides.springboot.model.*;
import net.javaguides.springboot.repository.*;
import net.javaguides.springboot.web.*;
import net.javaguides.springboot.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import net.javaguides.springboot.OBAASApplication;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.junit.Test;


@SpringBootTest(classes = OBAASApplication.class)
class ObaasApplicationTests {
	@Autowired
	UserRepository userRepository;
	@Autowired
	public UserService userService;

	String password = "hello";
	String username = "mohcine";

	@Test
	void saveAccountTest() {
		UserRegistrationDto registrationDto = new UserRegistrationDto();
		registrationDto.setAccount(new Account(45454545, 1000000));
		registrationDto.setAddress("12 oualfa casablanca");
		registrationDto.setMarketType("U");
		registrationDto.setPassword(password);
		registrationDto.setPhoneNumber("0605040708");
		registrationDto.setUserId("789456");
		registrationDto.setUsername(username);
		UserRegistrationController urc = new UserRegistrationController(userService);
		String str = urc.registerUserAccount(registrationDto);
		int accountN = userRepository.findByUsername(username).getAccount().getAccountNumber();
		assertEquals("redirect:/registration?success="+accountN+"&&user="+username, str);
		str = urc.registerUserAccount(registrationDto);
		assertEquals("redirect:/registration?err", str);
		UserDeletionController udc = new UserDeletionController(userService);
		udc.registerUserAccount(username, accountN, password);
	}

	@Test
	void deleteAccountTest() {UserRegistrationDto registrationDto = new UserRegistrationDto();
		registrationDto.setAccount(new Account(45454545, 1000000));
		registrationDto.setAddress("12 oualfa casablanca");
		registrationDto.setMarketType("U");
		registrationDto.setPassword(password);
		registrationDto.setPhoneNumber("0605040708");
		registrationDto.setUserId("789456");
		registrationDto.setUsername(username);
		UserRegistrationController urc = new UserRegistrationController(userService);
		urc.registerUserAccount(registrationDto);
		UserDeletionController udc = new UserDeletionController(userService);
		int accountN = userRepository.findByUsername(username).getAccount().getAccountNumber();
		assertEquals("redirect:/login?deletion",udc.registerUserAccount(username, accountN, password));
		assertEquals("redirect:/close?invalid",udc.registerUserAccount(username, accountN, password));
	}
	
	@Test
	void accountBalanceTest() {
		
		UserOperationController upc = new UserOperationController(userService);
		UserRegistrationDto registrationDto = new UserRegistrationDto();
		registrationDto.setAccount(new Account(45454545, 1000000));
		registrationDto.setAddress("12 oualfa casablanca");
		registrationDto.setMarketType("U");
		registrationDto.setPassword(password);
		registrationDto.setPhoneNumber("0605040708");
		registrationDto.setUserId("789456");
		registrationDto.setUsername(username);
		UserRegistrationController urc = new UserRegistrationController(userService);
		urc.registerUserAccount(registrationDto);
		int accountN = userRepository.findByUsername(username).getAccount().getAccountNumber();
		assertEquals("redirect:/accountBalance?servfErr",upc.accountBalance(username, password, accountN));
		assertEquals("redirect:/accountBalance?servfErr",upc.accountBalance(username, password, -789));
		UserDeletionController udc = new UserDeletionController(userService);
		udc.registerUserAccount(username, accountN, password);
	}

	@Test
	void payerFactureTest() {
		UserRegistrationDto registrationDto = new UserRegistrationDto();
		registrationDto.setAccount(new Account(45454545, 1000000));
		registrationDto.setAddress("12 oualfa casablanca");
		registrationDto.setMarketType("U");
		registrationDto.setPassword(password);
		registrationDto.setPhoneNumber("0605040708");
		registrationDto.setUserId("789456");
		registrationDto.setUsername(username);
		UserRegistrationController urc = new UserRegistrationController(userService);
		urc.registerUserAccount(registrationDto);
		UserOperationController upc = new UserOperationController(userService);
		int accountN = userRepository.findByUsername(username).getAccount().getAccountNumber();
		Double amount = userService.demandeBalance(username, accountN);
		String service = "internet";
		assertEquals("redirect:/payerFacture?invalid",upc.payerFacture(username, password, accountN, amount - 1, service));
		assertEquals("redirect:/payerFacture?invalid",upc.payerFacture(username, password, accountN, 1000000000, service));
		assertEquals("redirect:/payerFacture?invalid",upc.payerFacture("sfdsfd", password, accountN, 1000000000, service));
		UserDeletionController udc = new UserDeletionController(userService);
		udc.registerUserAccount(username, accountN, password);
	}

	@Test
	void demandeServiceTest() {
		UserRegistrationDto registrationDto = new UserRegistrationDto();
		registrationDto.setAccount(new Account(45454545, 1000000));
		registrationDto.setAddress("12 oualfa casablanca");
		registrationDto.setMarketType("U");
		registrationDto.setPassword(password);
		registrationDto.setPhoneNumber("0605040708");
		registrationDto.setUserId("789456");
		registrationDto.setUsername(username);
		UserRegistrationController urc = new UserRegistrationController(userService);
		urc.registerUserAccount(registrationDto);
		UserOperationController upc = new UserOperationController(userService);
		int accountN = userRepository.findByUsername(username).getAccount().getAccountNumber();
		String service = "internet";
		assertEquals("redirect:/demandeService?servfErr",upc.demandeService(username, password, service, accountN));
		assertEquals("redirect:/demandeService?servfErr",upc.demandeService(username, password, service, accountN));
		assertEquals("redirect:/demandeService?error",upc.demandeService("damogf", password, service, -12345));
		UserDeletionController udc = new UserDeletionController(userService);
		udc.registerUserAccount(username, accountN, password);
	}
}
