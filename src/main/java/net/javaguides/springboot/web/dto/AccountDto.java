package net.javaguides.springboot.web.dto;

import net.javaguides.springboot.model.User;

public class AccountDto {

	private long id;
	private long accountNumber;
	private float balance;
	
	private User user;

	public AccountDto(int accountNumber, int balance, User user) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
}
