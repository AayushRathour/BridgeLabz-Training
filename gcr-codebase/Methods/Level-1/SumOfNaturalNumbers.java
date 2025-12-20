import java.util.*;

public class SumOfNaturalNumbers{
	// return sum of numbers taking input n
	public static int getSum(int n){
		int sum = 0;
		for(int i = 1; i <= n; i++){
			sum += i;
		}
		return sum;
	}
	public static void main(String[] args){
		// creating scanner object and taking input 
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		int n = sc.nextInt();
		
		// calling function and printing result
		int sum = getSum(n);
		System.out.println("The sum of n natural number is : " + sum);
		sc.close();
	}
}