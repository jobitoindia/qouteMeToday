package javaPrograms;

import java.util.Scanner;

public class FactorialUsingRecursion {

	public static long multiplyNumbers(int num)
    {
        if (num >= 1)
            return num * multiplyNumbers(num - 1);
        else
            return 1;
    }
	
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Please Enter the number of your choice");
		int num = sc.nextInt();
        long factorial = multiplyNumbers(num);
        System.out.println("Factorial of " + num + " = " + factorial);

	}

}
