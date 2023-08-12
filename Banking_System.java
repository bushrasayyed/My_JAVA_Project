//Name: BUSHRA SAYYED 
//Enroll no: EBEON0523698089
//Batch : 9899
//PROJECT TOPIC: BANKING SYSTEM

//**CONCEPTS USED**
//1.DataTypes,2.Types of variables(Global,instance),3.Control Structure,4.Looping Statements,5.Class and objects
//6.Operators,7.Inheritance, 8.Method overriding 9.Interface,10.Functional Interface,11.Polymorphism,
//12.Packages,13.Access Specifiers,14.Exception handling,15.Collection Framework,16.Files in java
//17.Stream API ,18.Lambda Expressions, 19.Enum concept ,20.Strings,21.Type Casting,22.Scanner (for accepting inputs)and its methods;

//***KEYWORDS***
//1.package,2.import,3.class,4.long,5.int,6.public,7.static,8.if,9.else,10.for,
//11.protected,12.interface,13.implements,14.extends,15.final,16.do,17.while,18.enum,19.try ,20.catch,21.switch,22.case,23.break;
package Tiny_Project;
import java.util.*;
import java.io.*;
class RBI 
{	
	void motto()
	{
		System.out.println("-Reserve Bank of India's new Motto-");
		System.out.println("Cash is king,but digital is divine");
	}
}
class bankAccount extends RBI   //Inheriting RBI class 
{
	long sum=0;
	 public void createAccount(String name,String type,int age)
	 {
		 if(name!=null && type!=null && age!=0 )
		 {
			 System.out.println("Hey "+name+"\nYour account is created successfully!!!");
		 Random rn=new Random();
		 System.out.println("Your Account number is ="+rn.nextInt(900000));
		 }
		else 
			 System.out.println("Above details are mandatory to Create account ");
	 }
	public void Branches()
	 {
		ArrayList<String> bb=new ArrayList<String>();   //Creating ArrayList for bank branches
		System.out.println("Our bank branches are in ");
		bb.add("Maharashtra");
		bb.add("Bangalore");
		bb.add("Gujrat");
		bb.add("Rajasthan");
		bb.add("Andra Pradesh");
		bb.add("Madhya Pradesh");
		bb.add("Tamil Nadu");
		bb.add("Delhi");
		bb.add("Goa");
		bb.add("Assam");
		System.out.println(bb);
		System.out.println("Total Branches=>"+bb.stream().count());//Using stream to count total branches
		
	 }

	protected void deposit(long d)
	{
		ArrayList<Long> a=new ArrayList<Long>();
		a.add(d);
		
		for(long num:a)  //Calculating balance after deposit
		{
			sum+=num;
		}
		System.out.println("Your Total balance After deposition is ="+sum+"$");
	}
  protected void Withdraw(long amt)
	{
		if(sum>=amt)
		{
			sum=sum-amt;
			System.out.println("Balance after withdrawal="+sum);
		}
		else
		{
			System.out.println("Your balance is less than "+amt+"\n Transaction failed..!!");
		}
		
	}
  protected void Loans(int ln,long amtt)
{
	System.out.println("You have selected option "+ln);
	System.out.println("You want loan of "+amtt);
	System.out.println("Okay!\nHere is your amount  "+amtt+"$\nNote: Interest rate will be 12%");
	System.out.println("Thanks for visiting!!!");
}
}
interface Cards   //creating interface
{
	public void issue();
	public void pay();
}
class Credit implements Cards   //Implementing interface
{
	 public void issue()
	{
		System.out.println("You have applied for Credit card\n Request Granted!! ");
	    
	}
	 public void pay()
	 {
		 System.out.println("You have to pay- 5$/year");
	 }
}
class Debit implements Cards
{
	public void issue()
	{
		System.out.println("You have applied for Debit card\n Request Granted!! ");
	    
	}
	 public void pay()
	 {
		 System.out.println("You have to pay- 3$/year");
	 }
}

@FunctionalInterface
interface GreetFunc   //Creating functional interface for Greeting
{
	String msg(String message);
}

public class Banking_System {
	//For using different Colors we are initializing Some colors here.
	public static final String ANSI_RESET = "\u001B[0m";
	 public static final String RED = "\033[1;31m";     // RED
	 public static final String GREEN = "\033[1;32m";   // GREEN
	  public static final String YELLOW = "\033[0;33m";  // YELLOW
	  public static final String BLUE = "\033[0;34m";    // BLUE
	  public static final String PURPLE = "\033[1;35m";  // PURPLE
	  public static final String CYAN = "\033[0;36m";    // CYAN
	    
	public static void main(String[] args)throws IOException{
		int s;
		Scanner sc=new Scanner(System.in);
		bankAccount ba=new bankAccount();//Creating object of bankAccount class
		GreetFunc ni=(message)->(message);  //Lambda function for Greeting
		System.out.println(ni.msg(GREEN+"\t\t-----WELCOME TO RESERVE BANK OF INDIA-----"+ANSI_RESET));
		
		do {
			
		System.out.println(CYAN+"  SELECT THE SERVICE(From 1-6)\n------------------------------------\n1.CREATE ACCOUNT\n2.DEPOSIT AMOUNT\n3.WITHDRAW AMOUNT\n4. LOANS OFFERINGS \n5.INSURANCE POLICY \n6.ABOUT US\n7.ISSUE DEBIT CARD/CREDIT CARD\n8.EXIT"+ANSI_RESET);
		 s=sc.nextInt();
		
		switch(s)
		{
		case 1:
			ba.motto();
			System.out.println(YELLOW+"Enter your name-"+ANSI_RESET);
		 	String nm=sc.next();
			System.out.println(YELLOW+"Enter Account Type(savings/business)-"+ANSI_RESET);
			String type=sc.next();
			System.out.println(YELLOW+"Enter  your Age-"+ANSI_RESET);
			int  age=sc.nextInt();
			ba.createAccount(nm,type,age);
			System.out.println();
			break;
		case 2:
			ba.motto();
			System.out.println(GREEN+"Enter the amount you want to deposit "+ANSI_RESET);
			long d=sc.nextLong();
			ba.deposit(d);
			break;
		case 3:
			long amt;
			System.out.println(GREEN+"Enter the amount you want to withdraw"+ANSI_RESET);
			amt=sc.nextLong();
			ba.Withdraw(amt);
		    break;
		case 4:
			ba.motto();
			System.out.println(GREEN+"--Check our loan offerings\nWe offer:--"+ANSI_RESET);
			 enum loan{Home_loan,Education_loan,personal_loan,agriculture_loan}; //Creating enum for types of loans
			System.out.println("1."+loan.Home_loan);
			System.out.println("2."+loan.Education_loan);
			System.out.println("3."+loan.personal_loan);
			System.out.println("4."+loan.agriculture_loan);
			System.out.println(CYAN+"Enter your choice in 1-4"+ANSI_RESET);
			int ln=sc.nextInt();
			System.out.println(YELLOW+"Enter the amount you want"+ANSI_RESET);
			long amtt=sc.nextLong();
			ba.Loans(ln, amtt);
			break;
		case 5:
			File f1=new File("C:\\Bushra\\MY_EDU_Files\\Insurance.txt");//Reading File data 
			
			System.out.println(YELLOW+"Do you want to know about our Insurance Policies?\n 1-yes or 0-no"+ANSI_RESET);
			int c=sc.nextInt();
			if(c==1)
			{
			try(FileInputStream fis=new FileInputStream(f1))
		      {
				int r=0;
		    	 while((r=fis.read())!=-1)
		    	 {
		    		 System.out.print((char)r);
		    	 }
		    	  
		      }
		    catch(IOException e)
		    {
		    	e.printStackTrace();//Exception If any error is fetching file
		    }
			}
			
			break;
		case 6:
			
			ba.motto();
			System.out.println(GREEN+"---About our Branches---"+ANSI_RESET);
			ba.Branches();
			break;
		case 7:
			  ba.motto();
			  System.out.println(YELLOW+"1.Issue Credit card\n2.Issue Debit Card"+ANSI_RESET);
			  int cc=sc.nextInt();
			  if(cc==1)
			  {
				  Credit Cd=new Credit();
				  Cd.issue();
				  Cd.pay();
				  
			  }
			  if(cc==2)
			  {
				  Debit dd=new Debit();
				  dd.issue();
				  dd.pay();
			  }
			  	  
			break;
		case 8:
			System.out.println(GREEN+"Thanks for visiting RBI !!!"+ANSI_RESET);
			System.exit(0);
		}
		}
		while(s!=10);	 
       sc.close();
	}

}

