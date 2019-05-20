package com.cg.eis.service;



import java.util.Map;



import com.cg.eis.bean.Account;
import com.cg.eis.dao.AccountDao;
import com.cg.eis.dao.AccountDaoImpl;
public class WalletServiceImpl implements WalletService
{
  AccountDao accountdao = new AccountDaoImpl();
  @Override
  public boolean validateMobile(String mobile) {
     // TODO Auto-generated method stub
     return mobile.matches(mobilepattern);
  }
  @Override
  public boolean createAccount(Account ac) {
     // TODO Auto-generated method stub
     return accountdao.createAccount(ac);
     }
  @Override
  public Account getAccountByMobile(long mobileNo) {
     // TODO Auto-generated method stub
     return accountdao.getAccountByMobile(mobileNo);
  }
  @Override
  public Map<Long, Account> getAllAccount() {
     // TODO Auto-generated method stub
     return accountdao.getAllAccount();
  }
  @Override
  public boolean transferMoney(double amount, Account a1, Account a2) {
     // TODO Auto-generated method stub
     try 
     {
     double bal1 = a1.getBalance();
     bal1=bal1-amount;
     a1.setBalance(bal1);
     double bal2 = a2.getBalance();
     bal2 = bal2+amount;
     a2.setBalance(bal2);
     }
     catch(Exception e)
     {
        e.printStackTrace();
     }
     return accountdao.transferMoney( a1, a2);
  }
  @Override
  public boolean addMoney(double amount, Account a1) 
  {
     // TODO Auto-generated method stub
     boolean b = false;
     double bal = a1.getBalance();
     bal = bal+amount;
     a1.setBalance(bal);
     return accountdao.updateAccount(a1);
  }
  @Override
  public boolean deleteAccount(long mobile) {
     // TODO Auto-generated method stub
     return accountdao.deleteAccount(mobile);
  }
}
