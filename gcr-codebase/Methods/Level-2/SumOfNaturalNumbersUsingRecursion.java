import java.util.*;

public class SumOfNaturalNumbersUsingRecursion{
	// recusively find and return sum of numbers taking input n
	private static int getSum(int n){
		if(n == 1) return n;
		return n + getSum(n-1);
	}
	public static void main(String[] args){
		// creating scanner object and taking input 
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		int n = sc.nextInt();
		
		// calling recusive function
		int sumUsingRec = getSum(n);
		
		// using formula to find sum
		int sumUsingFormula = (n * (n+1))/2;
		
		// comparing results and printing results
		if(sumUsingRec == sumUsingFormula){
			System.out.println("Sum is equal and sum is " + sumUsingFormula);
		}
		else{
			System.out.println("The sum is not equal");
		}
		sc.close();
	}
}