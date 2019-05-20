package com.cg.eis.service;

import java.util.*;
import com.cg.eis.bean.*;
import com.cg.eis.dao.*;

public class WalletServiceImpl implements WalletService{
	AccountDao accountdao=new AccountDaoImpl();
	
	WalletService ws;
	
	@Override
	public boolean validateMobile(String mobile) {
		System.out.println("verifiying mobile "+mobile.matches(mobilePattern));
		
		return mobile.matches(mobilePattern);
	}

	@Override
	public boolean createAccount(Account ac) {
		// TODO Auto-generated method stub
		return accountdao.createAccount(ac);
	}

	@Override
	public Account getAccountByMobile(String mobileNo) {
		// TODO Auto-generated method stub
		return accountdao.getAccountByMobile(mobileNo);
	}

	@Override
	public Map<String, Account> getAllAccount() {
		// TODO Auto-generated method stub
		return accountdao.getAllAccount();
	}

	@Override
	public boolean transferMoney(double amount, Account a1, Account a2) {
		double bal1=a1.getBalance();
		bal1=bal1-amount;
		a1.setBalance(bal1);
		double bal2=a2.getBalance();
		bal2=bal2+amount;
		a2.setBalance(bal2);
		return accountdao.transerferMoney(a1, a2);
		
	}

	@Override
	public boolean updateAccount(Account ac) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccount(String mobileNo) {
		// TODO Auto-generated method stub
		return accountdao.deleteAccount(mobileNo);
	}

	@Override
	public boolean addMoney(double amount, Account ac) {
		// TODO Auto-generated method stub
		double bal3=ac.getBalance()+amount;
		ac.setBalance(bal3);
		return accountdao.addMoney(ac);
	}

	
	
}
