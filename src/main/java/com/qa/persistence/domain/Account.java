package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Account {
	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Id
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	@Size(min = 6, max =6)
	private String accountNum;

	
	public Account() {

	}
	
	
	

	public Account(String firstName, String lastName, String accountNum) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNum = accountNum;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
