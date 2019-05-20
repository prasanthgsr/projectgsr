package com.cg.eis.service;

import java.util.*;

import com.cg.eis.bean.Account;

public interface WalletService {
	String mobilePattern="[6-9][0-9]{9}";
	public boolean validateMobile(String mobile);
	public boolean createAccount(Account ac);
	public boolean updateAccount(Account ac);
	public boolean deleteAccount(String mobileNo);
	public Account getAccountByMobile(String l);
	public Map<String, Account> getAllAccount();
	public boolean transferMoney(double amount,Account a1,Account a2);
	public boolean addMoney(double amount,Account ac);
}
