package com.qa.service;

public interface AccountService {
	
	String getAllAccounts();
	
	String addAccount(String account);
	
	String deleteAccount(Long id);
	
	String updateAccount(Long id, String account);
	
	int getNumberOfAccountsByFirstName(String firstName);


}
