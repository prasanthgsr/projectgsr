package com.cg.eis.pl;
import com.cg.eis.service.*;

import java.util.*;

import com.cg.eis.bean.*;
public class WalletDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		WalletService service=new WalletServiceImpl();
		Account a;
		int i=1;
		System.out.println("Enter any option");
		System.out.println("1.Create Account\n2.Update Account\n3.Delete Account\n4.Retrive Account\n5.Transefer money to accounts\n6.Add Money\n7.Exit");
		int ch=sc.nextInt();
		do {
			switch(ch) {
			case 1: //Create account
					
					System.out.println("Enter Mobile Number");
					String mob=sc.next();
					if(service.validateMobile(mob))
					{	
						System.out.println("Enter Name");
						String name=sc.next();
						a=new Account(i,mob,name,6000);
						if(service.createAccount(a))
							System.out.println("Added successfully");
						else {
							System.out.println("Sorry");
							
						}
						i++;
					}
					break;
			case 2: //Update Account
					System.out.println("Enter mobile to get update account");
					String mobUp=sc.next();
					if(service.validateMobile(mobUp))
					{
						Account ac5=service.getAccountByMobile(mobUp);
						System.out.println(ac5);
						System.out.println("Only name can be updated if u want change PRESS 1 or 0");
						int op=sc.nextInt();
						if(op==1) {
							System.out.println("Enter Name");
							String name=sc.next();
							ac5.setCustomerName(name);
							System.out.println("Ur name is updated"+service.getAccountByMobile(mobUp));
							//service.updateAccount(ac5);
						}
					}
					else
					{
						System.out.println("check the mobile number u have entered");
					}
					break;
			case 3: //Delete Account
					System.out.println("Enter the mobile number to delete the account");
					String mob1=sc.next();
					
					if(service.validateMobile(mob1))
					{	
						if(service.deleteAccount(mob1))
							System.out.println("Delete successfully");
						else
							System.out.println("Sorry");
					}
					
					break;
			case 4: //retrive account
					System.out.println("Enter mobile number to check ");
					String mobcheck=sc.next();
					if(service.validateMobile(mobcheck))
						System.out.println(service.getAccountByMobile(mobcheck));
					break;
			case 5: //Transfer Money
					System.out.println("Enter amount to transefer");
					int amnt=sc.nextInt();
					System.out.println("Enter sender mobile number");
					String mobile1=sc.next();
					if(service.validateMobile(mobile1)) {
						Account ac1=service.getAccountByMobile(mobile1);
						System.out.println("Enter reciever mobile number");
						String mobile2=sc.next();
						if(service.validateMobile(mobile2)) {
							Account ac2=service.getAccountByMobile(mobile2);
							if(service.transferMoney(amnt, ac1, ac2))
								System.out.println("transefered successfully");
							else
								System.out.println("Sorry");
						}
					}
					break;
			case 6: //Add Money
					System.out.println("Enter mobile number");
					String mob5=sc.next();
					Account ac5=service.getAccountByMobile(mob5);
					System.out.println("Enter  money to add into the account");
					double amt=sc.nextDouble();
					if(service.addMoney(amt,ac5))
						System.out.println("Money is added\n\n");
					else
						System.out.println("not added");
					break;
			case 7: System.exit(0);
					
			}
			System.out.println("1.Create Account\n2.Update Account\n3.Delete Account\n4.Retrive Account\n5.Transefer money to accounts\n6.Add Money\n7.Exit");
			 ch=sc.nextInt();
		}while(ch!=7);

		System.out.println("Printing all account that are created and used");
		Map<String,Account> allac=service.getAllAccount();
		System.out.println(allac);
	}



}
