import java.util.*;

public class FactorialUsingRecursion{
	// Created functions to get factorail of a number using recursion 
	private static int getFactorial(int n){
		if(n <= 1) return 1;
		
		return n * getFactorial(n-1);
	}
	public static void main(String[] args){
		// creating scanner class object and taking input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		int n = sc.nextInt();
		
		// calling fucntion to print output
		System.out.println(getFactorial(n));
		
	}
}