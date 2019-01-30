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
		return repo.createAccount(account);
	}
	
	public String deleteAccount(Long id) {
		return repo.deleteAccount(id);
	}
	
	public void setRepo(AccountRepository repo) {
		this.repo = repo;
	}

	
}