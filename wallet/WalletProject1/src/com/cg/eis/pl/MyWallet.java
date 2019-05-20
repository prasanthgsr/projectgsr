package com.cg.eis.pl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import com.cg.eis.bean.Account;
import com.cg.eis.service.*;
public class MyWallet 
{
  public static void main(String[] args) throws NumberFormatException, IOException 
  {
     WalletService service = new WalletServiceImpl();
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     System.out.println("Enter the number of Accounts");
     int a_no = Integer.parseInt(br.readLine());
     for(int i = 1;i<=a_no;i++)
     {
     System.out.println("Enter Details of Account Holder : "+i);
    System.out.println("Enter the Account Number : ");
    int accno = Integer.parseInt(br.readLine());
    System.out.println("Enter the Account Holder Name : ");
    String cusName = br.readLine();
    System.out.println("Enter the Mobile number : ");
   boolean b = false;
    long mob = 0;
    do {
       String mobile = br.readLine();
      if(service.validateMobile(mobile))
        {
           mob = Long.parseLong(mobile);
           b = true;
        }
        else
           System.out.println("Please enter the correct Mobile Number.....");
        }while(b!=true);
     System.out.println("Enter Account Balance :::: ");
     Double bal = Double.parseDouble(br.readLine());
     Account a1 = new Account (accno,cusName,mob,bal);
     boolean added = service.createAccount(a1);
     System.out.println("Account is Added....."+added);
     }
     System.out.println("1. Display All Accounts....");
     System.out.println("2. Update an Account.......");
     System.out.println("3. Delete an Account.......");
     System.out.println("4. Transfer Money .........");
     System.out.println("5. Add Money to the Account....");
     System.out.println("6. Get account using Mobile Number....");
     int ch = Integer.parseInt(br.readLine());
     int i =0;
     do {
        i++;
        switch(ch)
        {
        case 1: Map<Long,Account> allAc = service.getAllAccount();
              System.out.println(allAc);
              break;
        case 2 : System.out.println("The Update Feature is currently Not available ");
               break;
        case 3 : System.out.println("Enter Mobile number to delete the account..");
                long mob2 = Long.parseLong(br.readLine());
                boolean res = service.deleteAccount(mob2);
                System.out.println("Delete Succesfull...."+res);
                break;
        case 4 : System.out.println("Enter the amount to transfer...");
              double amount = Double.parseDouble(br.readLine());
              System.out.println("Enter the sender Mobile Number...");
              long mono1 = Long.parseLong(br.readLine());
              System.out.println("Enter the Receiver Mobile number....");
              long mono2 = Long.parseLong(br.readLine());
              Account a1 = service.getAccountByMobile(mono1);
              Account a2 = service.getAccountByMobile(mono2);
              boolean trans = service.transferMoney(amount, a1, a2);
              System.out.println(trans +"Transffered");
              break;
        case 5 : System.out.println("Enter the Money to add : ");
              double amt = Double.parseDouble(br.readLine());
              String m1 = br.readLine();
              System.out.println("Enter Mobile number to add the money ");
              long mono = Long.parseLong(m1);
              Account ob1 = service.getAccountByMobile(mono);
              boolean res1 = service.addMoney(amt, ob1);
              System.out.println(res1);
              break;
        case 6 : System.out.println("Enter the mmobile number to retrieve the account details ");
               long mob1 = Long.parseLong(br.readLine());
               System.out.println(mob1);
               Account myAc = service.getAccountByMobile(mob1);
               System.out.println(myAc);
                break;
        default : System.out.println("Please choose a Valid Option : ");
        }
        System.out.println("1. Display All Accounts....");
        System.out.println("2. Update an Account.......");
        System.out.println("3. Delete an Account.......");
        System.out.println("4. Transfer Money .........");
        System.out.println("5. Add Money to the Account....");
        System.out.println("6. Get account using Mobile Number....");
        ch = Integer.parseInt(br.readLine());
       }
     while(ch!=7);
     }
}