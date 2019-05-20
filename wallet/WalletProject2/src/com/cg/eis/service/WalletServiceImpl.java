package com.cg.eis.service;

import java.sql.SQLException;
import java.util.*;
import com.cg.eis.bean.*;
import com.cg.eis.dao.*;

public class WalletServiceImpl implements WalletService{
	AccountDao accountdao=new AccountDaoImpl();
	
	
	
//	public boolean validateMobile(Long mobile) {
//		// TODO Auto-generated method stub
//		System.out.println("verifiying mobile "+mobile.matches(mobilePattern));
//		return mobile.matches(mobilePattern);
//		
//	}

	@Override
	public boolean createAccount(Account ac) {
		// TODO Auto-generated method stub
		return accountdao.createAccount(ac);
	}

	@Override
	public Account getAccountByMobile(Long mobileNo) {
		// TODO Auto-generated method stub
		return accountdao.getAccountByMobile(mobileNo);
	}

	@Override
	public boolean getAllAccount() throws SQLException {
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
		return accountdao.updateAccount(ac);
	}

	@Override
	public boolean deleteAccount(Long mobileNo) {
		// TODO Auto-generated method stub
		return accountdao.deleteAccount(mobileNo);
	}

	@Override
	public boolean addMoney(double amount, Account ac) {
		 boolean b= false;
		 double bal = ac.getBalance();
		 bal=bal+amount;
		 ac.setBalance(bal);
		 return accountdao.updateAccount(ac);
	}

	@Override
	public int GenAccId() {
		// TODO Auto-generated method stub
		int orderId=(int) (Math.random()*1000);
		return orderId;
		
	}
	
}
