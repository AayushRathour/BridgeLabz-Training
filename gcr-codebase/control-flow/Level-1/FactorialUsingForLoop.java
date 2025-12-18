import java.util.Scanner;

public class FactorialUsingForLoop{
	public static void main(String[] args){
		// creating scanner object,  taking input and initializing variables
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		int n = sc.nextInt();
		int factorial = 1;
		
		// Checking input
		if(n <= 0){
			System.out.println("Enter a positive number ");
			return;
		}
		// calculating the factorial
		for(int i = 2; i <= n; i++){
			factorial *= i;
		}
		      
		// printing the results
		System.out.println("Factorial is : " + factorial);
		
		sc.close();
	}
}