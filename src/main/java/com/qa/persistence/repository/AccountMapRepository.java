package com.qa.persistence.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;

import util.JSONUtil;

public class AccountMapRepository implements AccountRepository{
	
	Map<Long, Account> accountMap = new HashMap<>();
	
	
	private JSONUtil util = new JSONUtil();

	public String getAllAccounts() {

		return util.getJSONForObject(accountMap);
		
	}

	public String createAccount(String account) {
		
		Account acc = util.getObjectForJSON(account, Account.class);
		
		this.accountMap.put(acc.getId(), acc);
		
		
		return acc.getFirstName();
	}

	public String deleteAccount(Long id) {
		String msg = "";
		if(accountMap.containsKey(id)) {
			accountMap.remove(id);
			msg = "Account deleted";
		} else {
			msg = "Account does not exist";
		}		
		return msg;
	}

	public String updateAccount(Long id, String account) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int getNumberOfAccountsByFirstName(String firstName) {
		int numberOfHits = 0;
		for( Account acc: accountMap.values()) {
			
			if(acc.getFirstName().equals(firstName)) {
				numberOfHits ++;
			}
		}
		
		return numberOfHits;
	}
	
		
	
	}


	



