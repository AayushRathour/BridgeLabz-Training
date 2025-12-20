import java.util.*;

public class QuotientAndReminder{
	// return an array with quotient and reminder
	public static int[] findRemainderAndQuotient(int number, int divisor){
		int[] result = new int[2];
		result[0] = number / divisor;
		result[1] = number % divisor;
		return result;
	}
	
	public static void main(String[] args){
		// creating scanner object and taking input 
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number and divisor : ");
		int number = sc.nextInt();
		int divisor = sc.nextInt();
		
		// calling function and printing result
		int[] result = findRemainderAndQuotient(number, divisor);
		System.out.println("The quotient is : " + result[0] + " and reminder is : " + result[1]);
		sc.close();
	}
}