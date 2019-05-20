package com.cg.eis.dao;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import com.cg.eis.bean.Account;

public class AccountDaoImpl implements AccountDao {

	Map<String,Account> walletAccounts=new ConcurrentHashMap<>();
	/* 
	 * Method to insert new account in a database
	 */
	@Override
	public boolean createAccount(Account ac) {
		walletAccounts.put(ac.getMobileNo(), ac);
		Account ac1=walletAccounts.get(ac.getMobileNo());
		if(ac1!=null)
			return true;
		else
			return false;
	}
	
	/* 
	 * Method to retrive account by mobile number in a database
	 */
	@Override
	public Account getAccountByMobile(String mobileNo) {
		Account ac=walletAccounts.get(mobileNo);
		if(ac !=null)
			return ac;
		else
			return null;
	}

	@Override
	public Map<String, Account> getAllAccount() {
		// TODO Auto-generated method stub
		return walletAccounts;
	}

	@Override
	public boolean updateAccount(String mobileNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccount(String mobileNo) {
		Account ac=walletAccounts.get(mobileNo);
		walletAccounts.remove(ac.getMobileNo(), ac);
		Account ac1=walletAccounts.get(ac.getMobileNo());
		if(ac1==null)
			return true;
		else
			return false;
	}

	@Override
	public boolean transerferMoney(Account a1, Account a2) {
		// TODO Auto-generated method stub
		
		return true;
	
		
	}

	@Override
	public boolean addMoney(Account ac) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
