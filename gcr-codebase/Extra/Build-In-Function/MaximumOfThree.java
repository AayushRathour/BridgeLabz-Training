import java.util.Scanner;

public class MaximumOfThree{
	// functions to get max of 3 number
	private static int getMax(int n1, int n2, int n3){
		return Math.max(n1, Math.max(n2, n3));
	}
	public static void main(String[] args){
		// creating scanner class object and taking input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter 3 number : ");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		
		System.out.println("The largest number is : " + getMax(n1, n2, n3));
		
	}
}