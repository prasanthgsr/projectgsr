package com.cg.eis.service;

import java.sql.SQLException;
import java.util.*;

import com.cg.eis.bean.Account;

public interface WalletService {
String mobilePattern="[0-9]{10}";
//	public boolean validateMobile(long mob);
	public boolean createAccount(Account ac);
	public boolean updateAccount(Account ac);
	public boolean deleteAccount(Long mobileNo);
	public Account getAccountByMobile(Long l);
	public boolean getAllAccount() throws SQLException;
	public int GenAccId();
	public boolean transferMoney(double amount,Account a1,Account a2);
	public boolean addMoney(double amount,Account ac);
}
