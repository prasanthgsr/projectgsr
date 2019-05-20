package com.cg.eis.bean;

public class Account {
	private int accNo;
	private long mobileNo;
	private String customerName;
	private double balance;
	//default constructor
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public Account(int accNo, long mobileNo, String customerName, double balance) {
		super();
		this.accNo = accNo;
		this.mobileNo = mobileNo;
		this.customerName = customerName;
		this.balance = balance;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", mobileNo=" + mobileNo + ", customerName=" + customerName + ", balance="
				+ balance + "]";
	}
	

	
}
