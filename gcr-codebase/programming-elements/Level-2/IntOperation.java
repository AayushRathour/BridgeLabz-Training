import java.util.Scanner;

public class IntOperation{
	public static void main(String[] args){
		// creating scanner object for taking input from the user
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first number : ");
		int a = sc.nextInt();
		System.out.print("Enter second number : ");
		int b = sc.nextInt();
		System.out.print("Enter third number : ");
		int c = sc.nextInt();
		
		// calculating results
		int operation1 = a + b * c;
		int operation2 = a * b + c;
		int operation3 = c + a / b;
		int operation4 = a % b + c;
		
		// printing results
		System.out.println("Operation 1 " + operation1 + ", operation 2 " + operation2 + ", Operation 3 " + operation3 + ", operation4 " + operation4);
	}
}