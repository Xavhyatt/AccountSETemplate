package com.qa.service;

public interface AccountService {
	
	String getAllAccounts();
	
	String addAccount(String account);
	
	String deleteAccount(int id);
	
	String updateAccount(int id, String account);
	
	int getNumberOfAccountsByFirstName(String firstName);


}
