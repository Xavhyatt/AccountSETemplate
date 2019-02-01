package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	@Column(length = 50)
	private String firstName;
	
	@Column(length = 50)
	private String lastName;
	
	@Column
	private String accountNum;

	
	public Account() {

	}
	
	
	

	public Account(String firstName, String lastName, String accountNum) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNum = accountNum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	
	

}
