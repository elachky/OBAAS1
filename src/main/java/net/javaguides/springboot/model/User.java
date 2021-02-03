package net.javaguides.springboot.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name =  "user", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User implements Serializable 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5009204590760838703L;

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
	private String phoneNumber;
	
	
	@Column(nullable = false, length = 80)
	private String address;
	
	@Column(nullable = false)
	private String userId;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	private Account account;
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Column(nullable = false)
	private String encryptedPassword;

	@Column(nullable = false)
	private String marketType;
	
	

	public User(String username, String phoneNumber, String address,
			Account account, String userId, String encryptedPassword, String string) 
	{
		super();
		
		this.username = username;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.account = account;
		this.userId = userId;
		this.encryptedPassword = encryptedPassword;
		this.marketType = string;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}



	public String getMarketType() {
		return marketType;
	}

	public void setMarketType(String marketType) {
		this.marketType = marketType;
	}

	public User() {
		
	}
	



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


}