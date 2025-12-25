import java.util.*;

public class PrimeNumberChecker{
	// functions to check prime number 
	private static boolean isPrime(int n){
		if(n <= 2) return false;
		for(int i = 2; i < n; i++){
			if(n%i == 0) return false;
		}
		return true;
	}
	public static void main(String[] args){
		// creating scanner class object and taking input from user
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		int n = sc.nextInt();
		
		System.out.println("Is n prime ? " + isPrime(n));
		
	}
}