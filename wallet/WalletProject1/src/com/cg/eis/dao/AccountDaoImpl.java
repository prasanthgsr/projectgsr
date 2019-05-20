package com.cg.eis.dao;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.cg.eis.bean.Account;
public class AccountDaoImpl implements AccountDao
{
  //Wallet Account database
  Map<Long,Account> walletAccounts = new ConcurrentHashMap<>();
  /* 
  * Method to insert new Account into Database */
  @Override
  public boolean createAccount(Account ac) {
     walletAccounts.put(ac.getMobileNo(), ac);
     Account ac1 = walletAccounts.get(ac.getMobileNo());
     if(ac1!=null)
     return true;
     else return false;
  }
  /* 
  * Method to get the Account number by Mobile number from DB */
  @Override
  public Account getAccountByMobile(long mobileNo) {
     Account ac2 = walletAccounts.get(mobileNo);
     if(ac2!=null)
     return ac2;
     else 
        return null;
     }
  /* 
  * Method to get all the accounts from DB */
  @Override
  public Map<Long, Account> getAllAccount() {
     // TODO Auto-generated method stub
     return walletAccounts;
  }
  @Override
  public boolean transferMoney(Account ac1, Account ac2) {
     walletAccounts.put(ac1.getMobileNo(), ac1);
     Account a1 = walletAccounts.get(ac1.getMobileNo());
     walletAccounts.put(ac2.getMobileNo(), ac2);
     Account a2 = walletAccounts.get(ac2.getMobileNo());
     if(a1!=null && a2!=null)
        return true;
     else
        return false;
  }
  @Override
  public boolean addMoney(double amount, Account a1) {
     // TODO Auto-generated method stub
     return false;
  }
  @Override
  public boolean updateAccount(Account ac) {
     walletAccounts.put(ac.getMobileNo(), ac);
     Account ac1 = walletAccounts.get(ac.getMobileNo());
     if(ac1!=null)
        return true;
     else
     return false;
  }
  @Override
  public boolean deleteAccount(long mobile) {
     Account bd = walletAccounts.remove(mobile);
     if(bd.getMobileNo()==mobile)
        return true;
     else
     return false;
     }  
}
