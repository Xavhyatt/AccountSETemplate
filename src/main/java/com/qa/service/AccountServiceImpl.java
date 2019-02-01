package com.qa.service;


import javax.inject.Inject;

import com.qa.persistence.repository.AccountRepository;


public class AccountServiceImpl implements AccountService {
	
	// This class contains the business rules for the application
	
	@Inject
	private AccountRepository repo;
	
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	public String addAccount(String account) {
		if (account ==  "9") {
			return "{\"message\": \"Account number barred\"}";
		} else {
		return repo.createAccount(account);
		}
	}
	
	public String deleteAccount(int id) {
		return repo.deleteAccount(id);
	}
	
	public void setRepo(AccountRepository repo) {
		this.repo = repo;
	}


	public int getNumberOfAccountsByFirstName(String firstName) {
		
		return repo.getNumberOfAccountsByFirstName(firstName);
	}

	@Override
	public String updateAccount(int id, String account) {
		
		return repo.updateAccount(id, account);
	}



	
}
