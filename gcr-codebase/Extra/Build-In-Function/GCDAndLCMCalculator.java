import java.util.*;

public class GCDAndLCMCalculator{
	// Created functions to get lcm of two numbers
	private static int getLcm(int n1, int n2, int gcd){
		return (n1 * n2) / gcd;
	}
	
	// functions to get gcd of two numbers 
	public static int getGcd(int n1, int n2){
		for(int i = Math.min(n1, n2); i > 1; i--){
			if(n1%i == 0 && n2%i == 0) return i;
		}
		return 1;
	}
	public static void main(String[] args){
		// creating scanner class object and taking input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter two number : ");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		// calling fucntion to print output
		int gcd = getGcd(n1, n2);
		System.out.println("Gcd is " + gcd + " and Lcm is " + getLcm(n1, n2, gcd));
		
	}
}