import java.util.Scanner;

public class NaturalNumberAndSumUsingForLoop{
	public static void main(String[] args){
		// creating scanner object and taking input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		int n = sc.nextInt();
		
		if(n <= 0){
			System.out.println("The number entered is not a natural number");
			return;
		}
		
		// using formula
		int sumUsingFormula = (n * (n+1))/2;
		// using for loop
		int sumUsingForLoop = 0;
		for(int i = 1; i <= n; i++){
			sumUsingForLoop += i;
		}
		
		// comparing and printing the result
		if(sumUsingFormula == sumUsingForLoop){
			System.out.println("Sum is equal using while loop and formula, the sum is " + sumUsingFormula);
		}
		
		sc.close();
	}
}