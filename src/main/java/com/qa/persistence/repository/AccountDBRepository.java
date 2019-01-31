package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;

import util.JSONUtil;

@Transactional(SUPPORTS)
public class AccountDBRepository implements AccountRepository{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	private JSONUtil util = new JSONUtil();

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
	public String deleteAccount(Long id) {
		Account account = em.find(Account.class, id);
		if (account != null) {
			em.remove(account);
		}
		return "{\"message\": \"account deleted successfully\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateAccount(Long id, String account) {
		Account anAccount = em.find(Account.class, id);
		if(anAccount != null) {
			anAccount.setAccountNum(account);
			em.persist(anAccount);
		}
		
		return "{\"message\": \"account Number changed successfully\"}";
	}

	@Override
	public int getNumberOfAccountsByFirstName(String firstName) {
		int numberOfAcc = 0;
		Query query = em.createQuery("Select a FROM Account a WHERE firstName = " + firstName);
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		numberOfAcc = accounts.size();
		return numberOfAcc;
	}

}
