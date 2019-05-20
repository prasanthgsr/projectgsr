package com.cg.eis.service;
import java.util.Map;
import com.cg.eis.bean.Account;
public interface WalletService 
{
  String mobilepattern="[0-9]{10}";
  public boolean validateMobile(String mobile);
  public boolean createAccount(Account ac);
  public Account getAccountByMobile(long mobileNo);
  public Map<Long,Account> getAllAccount();
  public boolean transferMoney(double amount, Account a1, Account a2);
  public boolean addMoney(double amount, Account a1);
  public boolean deleteAccount(long mobile);
}