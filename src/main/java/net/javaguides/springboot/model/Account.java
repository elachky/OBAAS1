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
	private long accountNumber;
	private float balance;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;
	
	
	
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	





	public Account(long accountNumber, float balance, User user) {
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
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	
	

}
