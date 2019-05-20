package com.cg.eis.bean;
public class Account 
{
  private int accountNo;
  private String customerName;
  private long mobileNo;
  private double balance;
  public Account() 
  {
     // TODO Auto-generated constructor stub
  }
  public Account(int accountNo, String customerName, long mobileNo, double balance) 
  {
     super();
     this.accountNo = accountNo;
     this.customerName = customerName;
     this.mobileNo = mobileNo;
     this.balance = balance;
  }
  public int getAccountNo() {
     return accountNo;
  }
  public void setAccountNo(int accountNo) {
     this.accountNo = accountNo;
  }
  public String getCustomerName() {
     return customerName;
  }
  public void setCustomerName(String customerName) {
     this.customerName = customerName;
  }
  public long getMobileNo() {
     return mobileNo;
  }
  public void setMobileNo(long mobileNo) {
     this.mobileNo = mobileNo;
  }
  public double getBalance() {
     return balance;
     }
  public void setBalance(double balance) {
     this.balance = balance;
  }
  @Override
  public String toString() {
     return "Account [accountNo=" + accountNo + ", customerName=" + customerName + ", mobileNo=" + mobileNo
           + ", balance=" + balance + "]";
     }
}
