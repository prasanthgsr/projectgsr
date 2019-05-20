package com.cg.eis.dao;

import java.sql.SQLException;
import java.util.*;
import com.cg.eis.bean.*;
public interface AccountDao {
	public boolean createAccount(Account ac);
	public boolean updateAccount(Account ac);
	public boolean deleteAccount(Long mobileNo);
	public boolean transerferMoney(Account a1,Account a2);
	public Account getAccountByMobile(Long mobileNo);
	public boolean getAllAccount() throws SQLException;
	
	
}
