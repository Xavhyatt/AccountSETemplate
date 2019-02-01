package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;

import util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class AccountDBRepository implements AccountRepository{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;

	@Override
	public String getAllAccounts() {
		Query query = em.createQuery("Select a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(accounts);
	}

	@Override
	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account anAccount = util.getObjectForJSON(account, Account.class);
		em.persist(anAccount);
		return "{\"message\": \"account created successfully\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(int id) {
		Account accountInDB = findAccount(id);
		if (accountInDB != null) {
			em.remove(accountInDB);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateAccount(int id, String account) {
		Account anAccount = em.find(Account.class, id);
		if(anAccount != null) {
			em.remove(anAccount);
			anAccount.setAccountNum(account);
			em.persist(anAccount);
			return "{\"message\": \"account Number changed successfully\"}";
		}
		
		return "{\"message\": \"account Number change unsuccessful\"}";
	}

	@Override
	public int getNumberOfAccountsByFirstName(String firstName) {
		int numberOfAcc = 0;
		Query query = em.createQuery("Select a FROM Account a WHERE firstName = " + firstName);
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		numberOfAcc = accounts.size();
		return numberOfAcc;
	}
	
	private Account findAccount(int id) {
		return em.find(Account.class, id);
	}

	public void setManager(EntityManager manager) {
		this.em = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
