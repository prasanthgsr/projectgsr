package com.cg.eis.dao;

import java.util.*;
import com.cg.eis.bean.*;
public interface AccountDao {
	public boolean createAccount(Account ac);
	public boolean updateAccount(String mobileNo);
	public boolean deleteAccount(String mobileNo);
	public Account getAccountByMobile(String mobileNo);
	public boolean transerferMoney(Account a1, Account a2);
	public Map<String, Account> getAllAccount();
	public boolean addMoney(Account ac);
	
	
}
