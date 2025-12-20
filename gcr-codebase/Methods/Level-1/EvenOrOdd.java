import java.util.*;

class EvenOrOdd{
	// Created a Method and find result using Conditional Statement 
	public static int numberCheck(int n){
		if (n==0){
			return 0;
		}
		else if (n>0){
			return 1;
		}
		return -1;
	}
	
	// Creating Scanner Object, taking input from user 
	public static void main(String[] args ){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number : ");
		int n = sc.nextInt();
		
		
		
		// Calling the method and Returning the output 
		int result = numberCheck(n);
		System.out.println(result);
		
	}
}