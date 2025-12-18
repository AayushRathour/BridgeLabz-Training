import java.util.Scanner;

public class DoubleOperation{
	public static void main(String[] args){
	
		// creating scanner object for taking input from the user
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first number : ");
		double a = sc.nextDouble();
		System.out.print("Enter second number : ");
		double b = sc.nextDouble();
		System.out.print("Enter third number : ");
		double c = sc.nextDouble();
		
		// calculating results
		double operation1 = a + b * c;
		double operation2 = a * b + c;
		double operation3 = c + a / b;
		double operation4 = a % b + c;
		
		// printing results
		System.out.println("Operation 1 " + operation1 + ", operation 2 " + operation2 + ", Operation 3 " + operation3 + ", operation4 " + operation4);
	}
}