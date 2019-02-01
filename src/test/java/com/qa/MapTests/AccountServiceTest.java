/*package com.qa.MapTests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;

public class AccountServiceTest {
	
	
	private AccountMapRepository repo = new AccountMapRepository();
	

	@Before
	public void setup() {
	
	}
	 
	@Test
	public void addAccountTest() {
		String msg = repo.createAccount("{'id':1,'firstName':'Xav','lastName':'Hyatt','accountNum':'123456'}");
		Assert.assertEquals("Account creation unsuccessful","Xav",msg);
	} 
	
	@Test
	public void add2AccountTest() {
		String msg1 = repo.createAccount("{'id':1,'firstName':'Xav','lastName':'Hyatt','accountNum':'123456'}");
		String msg2 = repo.createAccount("{'id':2,'firstName':'Matt','lastName':'Hunt','accountNum':'123456'}");
		
		boolean msg = false;
		if (msg1.contains("Xav") && msg2.contains("Matt")){
			msg = true;
		} else {
			msg = false;
		}
		
		Assert.assertEquals("Account creation unsuccessful",true,msg);
	}

	@Test
	public void removeAccountTest() {
		repo.createAccount("{'id':1, 'firstName':'Xav','lastName':'Hyatt','accountNum':'123456'}");
		repo.deleteAccount((long) 1);
		boolean msg = false;
		if (repo.getAllAccounts().contains("Xav")){
			msg = false;
		} else {
			msg = true;
		}
		
		Assert.assertEquals("Deletion not successful", true, msg);
	}
	
	@Test
	public void remove2AccountTest() {
		String msg1 = repo.createAccount("{'id':1,'firstName':'Xav','lastName':'Hyatt','accountNum':'123456'}");

		String msg2 = repo.createAccount("{'id':2,'firstName':'Matt','lastName':'Hunt','accountNum':'112233'}");
		repo.deleteAccount((long) 1);
		repo.deleteAccount((long) 2);
		
		boolean msg = false;
		if (!(repo.getAllAccounts().contains("Xav") || repo.getAllAccounts().contains("Matt"))){
			msg = true;
		} else {
			msg = false;
		}
		
		Assert.assertEquals("Deletion not successful", true, msg);
	}
	
	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		repo.createAccount("{'id':1,'firstName':'Xav','lastName':'Hyatt','accountNum':'123456'}");
		repo.createAccount("{'id':2,'firstName':'Matt','lastName':'Hunt','accountNum':'112233'}");

		String msg1 = repo.deleteAccount((long)1);
		String msg2 = repo.deleteAccount((long)2);
		String msg3 = repo.deleteAccount((long)3);
		
		boolean pass = false;
		if (msg1.equals("Account deleted") && msg2.equals("Account deleted") && msg3.equals("Account does not exist")){
			pass = true;
		} else {
			pass = false;
		}
		
		Assert.assertEquals("Deletion not successful", true, pass);
		
	}
	
	@Test
	public void accountConversionToJSONTestWithEmptyMap() {
		String msg = repo.createAccount("{'id':1,'firstName':'Xav','lastName':'Hyatt','accountNum':'123456'}");

		Assert.assertEquals("Account creation unsuccessful","Xav",msg);
	}
	
	@Test
	public void accountConversionToJSONTestEmptyMapWithConversion() {
		String emptyMap =  repo.getAllAccounts();
		
		
		String msg = repo.createAccount("{'id':1,'firstName':'Xav','lastName':'Hyatt','accountNum':'123456'}");
		
		boolean pass = false;
		if (emptyMap.contains("") == true && msg.equals("Xav")){
			pass = true;
		} else {
			pass = false;
		}
		Assert.assertEquals("JSON Created within Map",true, pass);
	
	}

	@Test
	public void accountConversionToJSONTest() {
		String msg = repo.createAccount("{'id':1,'firstName':'Xav','lastName':'Hyatt','accountNum':'123456'}");

		Assert.assertEquals("Account creation unsuccessful","Xav",msg);
	}
	

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		repo.createAccount("{'id':1,'firstName':'Jess','lastName':'Smith','accountNum':'123456'}");
		repo.createAccount("{'id':2,'firstName':'Josh','lastName':'Jones','accountNum':'112233'}");
		repo.createAccount("{'id':3,'firstName':'Tom','lastName':'Bloggs','accountNum':'123123'}");
		repo.createAccount("{'id':4,'firstName':'Matt','lastName':'Hunt','accountNum':'654321'}");
		
		System.out.println(repo.getNumberOfAccountsByFirstName("Tom"));
		Assert.assertEquals("Incorrect number of accounts found", 0, repo.getNumberOfAccountsByFirstName("Paul"));
	}
	
	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		repo.createAccount("{'id':1,'firstName':'Jess','lastName':'Smith','accountNum':'123456'}");
		repo.createAccount("{'id':2,'firstName':'Josh','lastName':'Jones','accountNum':'112233'}");
		repo.createAccount("{'id':3,'firstName':'Tom','lastName':'Bloggs','accountNum':'123123'}");
		repo.createAccount("{'id':4,'firstName':'Matt','lastName':'Hunt','accountNum':'654321'}");
		
		System.out.println(repo.getNumberOfAccountsByFirstName("Tom"));
		Assert.assertEquals("Incorrect number of accounts found", 1, repo.getNumberOfAccountsByFirstName("Tom"));
	}

	@Test
	public void getCountForFirstNamesInAccountWhenMult() {
		repo.createAccount("{'id':1,'firstName':'Tom','lastName':'Smith','accountNum':'123456'}");
		repo.createAccount("{'id':2,'firstName':'Josh','lastName':'Jones','accountNum':'112233'}");
		repo.createAccount("{'id':3,'firstName':'Tom','lastName':'Bloggs','accountNum':'123123'}");
		repo.createAccount("{'id':4,'firstName':'Matt','lastName':'Hunt','accountNum':'654321'}");
		
		
		System.out.println(repo.getNumberOfAccountsByFirstName("Tom"));
		Assert.assertEquals("Incorrect number of accounts found", 2, repo.getNumberOfAccountsByFirstName("Tom"));
	}

}
*/