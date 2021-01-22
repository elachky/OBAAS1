package net.javaguides.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Account 
{
	@Id
	@GeneratedValue
	private long id;
	private String accountNumber;
	private float balance;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;
	
	
	
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Account(long id, String accountNumber, float balance) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}




	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	
	

}
