package javaPrograms;

import java.util.Scanner;

public class BankingOperation {

	static Scanner sc=new Scanner(System.in);
	static int mainBalance=600000;

	public static void deposit() 
	{
		int depositAmt;
		System.out.println("Please Enter the amount you want to deposit");
		depositAmt=sc.nextInt();
		mainBalance=mainBalance+depositAmt;
		System.out.println("amount after the deposit:"+mainBalance);
	}
	
	public static void withDrawl() 
	{
		int withdrawlAmt;
		System.out.println("Please Enter the amount you want to withdrawl");
		withdrawlAmt=sc.nextInt();
		mainBalance=mainBalance-withdrawlAmt;
		System.out.println("amount after the deposit:"+mainBalance);
	}
	
	public static void checkBalance() {
		System.out.println("My final balance is:"+mainBalance);
	}
	
	public static void main(String[] args) 
	{
		deposit();
		withDrawl();
		checkBalance();
	}
}
