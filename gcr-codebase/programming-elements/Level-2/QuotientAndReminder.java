import java.util.Scanner;

public class QuotientAndReminder{
	public static void main(String[] args){
		// Creating scanner object for taking input from the user
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first number : ");
		int num1 = sc.nextInt();
		System.out.print("Enter second number : ");
		int num2 = sc.nextInt();
		
		// calculating quotient and reminder
		int quotient = num1/num2;
		int reminder = num1%num2;
		
		// printing output
		System.out.println("The Quotient is " + quotient + " and Reminder is " + reminder + " of two number " + num1 + " and " + num2);
	}
}