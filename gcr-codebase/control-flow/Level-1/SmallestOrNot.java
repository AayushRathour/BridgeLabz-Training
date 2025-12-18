import java.util.Scanner;

public class SmallestOrNot{
	public static void main(String[] args){
		
		// Creating scanner object for taking input from the user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int number1 = sc.nextInt();
		System.out.println("Enter the 2nd number");
		int number2 = sc.nextInt();
		System.out.println("Enter the 3rd number");
		int number3 = sc.nextInt();
		
		boolean ans = number1<number2 && number1<number3;
	
		System.out.println(" Is the first number the smallest? "+ ans);
			
	
	}
}