import java.util.*;
public class SmallestAndLargest{
	// return an array with smallest and largest number
	public static int[] getSmallestAndLargest(int number1, int number2, int number3){
		int[] result = new int[2];
		result[0] = Math.min(number1, Math.min(number2, number3));
		result[1] = Math.max(number1, Math.max(number2, number3));
		return result;
	}
	
	public static void main(String[] args){
		// creating scanner object and taking input 
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter 3 numbers : ");
		int number1 = sc.nextInt();
		int number2 = sc.nextInt();
		int number3 = sc.nextInt();
		
		// calling function and printing result
		int[] result = getSmallestAndLargest(number1, number2, number3);
		System.out.println("The smallest number is : " + result[0] + " and largest number is : " + result[1]);
		sc.close();
	}
}