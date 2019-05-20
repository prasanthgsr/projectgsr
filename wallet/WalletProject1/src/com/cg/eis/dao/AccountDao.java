package com.cg.eis.dao;
import java.util.Map;
import com.cg.eis.bean.Account;
public interface AccountDao 
{
  public boolean createAccount(Account ac);
  public Account getAccountByMobile(long mobileNo);
  public Map<Long,Account> getAllAccount();
  public boolean transferMoney( Account a1, Account a2);
  public boolean addMoney(double amount, Account a1);
  public boolean updateAccount(Account ac);
  public boolean deleteAccount(long mobile);
  }
