 package com.cg.eis.dao;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.sql.*;
import com.cg.eis.bean.Account;

public class AccountDaoImpl implements AccountDao {
	Connection con;
	PreparedStatement pst;
	Map<Long,Account> walletAccounts=new ConcurrentHashMap<>();
	/* 
	 * Method to insert new account in a database
	 */
	private void makeConnection()
	{
		try {
			
			String url="jdbc:oracle:thin:@10.219.34.3:1521:orcl";
			String user="trg502";
			String pass="training502";
			con=DriverManager.getConnection(url, user, pass);
			System.out.println("connected    ");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	private void releaseConnection()
	{
		try {
			if(con!=null)
				con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public boolean createAccount(Account ac) {
		walletAccounts.put(ac.getMobileNo(), ac);
		Account ac1=walletAccounts.get(ac.getMobileNo());
		if(ac1!=null)
		{
			try {
				makeConnection();
				pst=con.prepareStatement("insert into Account values(?,?,?,?)");
				pst.setInt(1,ac.getAccNo());
				pst.setString(2, ac.getCustomerName());
				pst.setLong(3, ac.getMobileNo());
				pst.setDouble(4, ac.getBalance());
				
				int insert=pst.executeUpdate();
				System.out.println("Inserted into Account table "+insert);
				releaseConnection();
			
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return true;
		}
		else
			return false;
	}
	
	/* 
	 * Method to retrive account by mobile number in a database
	 */
	@Override
	public Account getAccountByMobile(Long mobileNo) {
//		Account ac=walletAccounts.get(mobileNo);
//		if(ac !=null)
//			return ac;
//		else
//			return null;
		 Account a1 = null;
		 int acno=0;String cname="";long mobile=0;double balance=0.0;
		 boolean created = false;
		  try {
		  makeConnection();
		  pst = con.prepareStatement("select * from Account where mobile = ?");
		  pst.setLong(1,mobileNo);
		  ResultSet rs = pst.executeQuery();
		  if(rs.next())
		  {
		   acno = rs.getInt(1);
		   cname = rs.getString(2);
		   mobile = rs.getLong(3);
		   balance = rs.getDouble(4);
		  }
		  a1 = new Account(acno,mobile,cname,balance);
		  releaseConnection();
		  } catch (SQLException e) {
		  try {
		   con.rollback();
		   releaseConnection();
		  }catch(SQLException e1) {
		   e1.printStackTrace();
		  }
		  e.printStackTrace();
		  created=false;
		  e.printStackTrace();
		  }
		  return a1;
	}

	@Override
	public boolean getAllAccount() throws SQLException {
		// TODO Auto-generated method stub
		 makeConnection();
		 Statement st =con.createStatement();
		 ResultSet rs = st.executeQuery("select * from Account");
		 while(rs.next())
		 {
		  System.out.println("accno : " + rs.getInt("acno"));
		  System.out.println("cname : " +rs.getString("cname"));
		  System.out.println("mobile : "+rs.getLong("mobile"));
		  System.out.println("balance : "+rs.getDouble("balance"));
		  System.out.println("===================================");
		 }
		 releaseConnection();
		 return true;
	}

	@Override
	public boolean updateAccount(Account ac) {
		// TODO Auto-generated method stub
		boolean update1 =false;
		 try {
		  makeConnection();
		  con.setAutoCommit(false);
		  pst = con.prepareStatement("update account set balance =? where acno=?");
		  pst.setDouble(1, ac.getBalance());
		  pst.setInt(2, ac.getAccNo());
		  int u1 = pst.executeUpdate();
		  System.out.println("Updated account 1 in database."+u1);
		  walletAccounts.put(ac.getMobileNo(), ac);
		  update1 = true;
		  con.commit();
		  releaseConnection();
		 } catch (SQLException e) {
		  try {
		  con.rollback();
		  releaseConnection();
		  }catch(SQLException e1) {
		  e1.printStackTrace();
		  }
		  e.printStackTrace();
		  update1=false;
		 }
		 return update1;
	}

	@Override
	public boolean deleteAccount(Long mobileNo) {
	//	Account bd =walletAccounts.remove(mobileNo);
	//	System.out.println(bd+"--------======================");
	//	 if(bd.getMobileNo()==mobileNo)
	//	 {
		  boolean deleted =false;
		  try {
		   makeConnection();
		   con.setAutoCommit(false);
		   pst = con.prepareStatement("delete from Account where mobile = ?");
		   pst.setLong(1, mobileNo);
		   pst.executeUpdate();
		   System.out.println("asdfasdasdasdasdasd-----------");
		   deleted = true;
		   con.commit();
		   releaseConnection();
		  } catch (SQLException e) {
		   try {
		   con.rollback();
		   releaseConnection();
		   }catch(SQLException e1) {
		   e1.printStackTrace();
		   }
		   e.printStackTrace();
		   deleted=false;
		  }
		  return deleted;
//		 }
	//	 else
		//  return false;
	}

	@Override
	public boolean transerferMoney(Account a1, Account a2) {
		boolean transfered=false;
		try {
			makeConnection();
			con.setAutoCommit(false);
			pst=con.prepareStatement("update account set balance=? where acno=?");
			pst.setDouble(1, a1.getBalance());
			pst.setInt(2, a1.getAccNo());
			int u1=pst.executeUpdate();
			System.out.println("updates acc1 in database "+u1);
			
			pst=con.prepareStatement("update account set balance=? where acno=?");
			
			pst.setDouble(1, a2.getBalance());
			System.out.println(a2.getBalance());
			pst.setInt(2, a2.getAccNo());
			System.out.println(a2.getAccNo());
			int u2=pst.executeUpdate();
			System.out.println("updated acc2 in database "+u2);
			
			walletAccounts.put(a1.getMobileNo(), a1);
			walletAccounts.put(a2.getMobileNo(), a2);
			transfered=true;
			con.commit();
			releaseConnection();
		}
		catch(SQLException e)
		{
			try {
				con.rollback();
				releaseConnection();
				System.out.println(e.getMessage());
			}catch(SQLException e1) {
				System.out.println(e1.getMessage());
				e.printStackTrace();
			}
			e.printStackTrace();
			transfered=false;	
		}
		
		return transfered;
	}
	
}
