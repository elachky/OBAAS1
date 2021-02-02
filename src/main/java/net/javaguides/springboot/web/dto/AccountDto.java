package net.javaguides.springboot.web.dto;

import net.javaguides.springboot.model.User;

public class AccountDto {

	private long id;
	private int accountNumber;
	private double balance;
	
	private User user;

	public AccountDto(int accountNumber, int balance, User user) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.user = user;
	}
	public AccountDto() {
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double d) {
		this.balance = d;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
