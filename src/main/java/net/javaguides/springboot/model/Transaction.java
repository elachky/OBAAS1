package net.javaguides.springboot.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Transaction {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id", updatable = false)
	    private Long id;



	    @ManyToOne(cascade=CascadeType.ALL)
	    @JoinColumn(name = "accountNumber")
	    private Account account;

	    @Override
	    public String toString() {
	        return "Transaction{" +
	                "id=" + id +
	                ", account=" + account +
	                '}';
	    }

	    public Transaction() {
	    }

	    public Transaction(Account account) {

	        this.account = account;
	    }

	    public Account getAccount() {
	        return account;
	    }

	    public void setAccount(Account account) {
	        this.account = account;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }


	

}
