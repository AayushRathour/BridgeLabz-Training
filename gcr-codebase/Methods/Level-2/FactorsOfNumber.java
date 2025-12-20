import java.util.*;

public class FactorsOfNumber{
	// return an array of factors
	public static int[] getFactors(int n) {
		// counting factors
        int count = 0;
		for(int i = 1; i <= n; i++){
			if(n % i == 0) count++;
		}
		
		// storing factors in array
		int[] result = new int[count];
		int index = 0;
		for(int i = 1; i <= n; i++){
			if(n % i == 0) result[index++] = i;
		}
		
		// returning the result
		return result;
    }
	
	// return the sum of factors
	private static int getSum(int[] factors){
		int sum = 0;
		for(int i : factors) sum += i;
		return sum;
	}
	
	// return product of factors
	private static int getProduct(int[] factors){
		int result = 1;
		for(int i : factors) result *= i;
		return result;
	}
	
	// return squared sum 
	private static int getSquaredSum(int[] factors){
		int sum = 0;
		for(int i : factors) sum += (int)Math.pow(i, 2);
		return sum;
	}
	
	public static void main(String[] args){
		// creating scanner object and taking input 
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		int number = sc.nextInt();
		
		// calling function and then calling other function to get result
		int[] factors = getFactors(number);
		int sum = getSum(factors);
		int product = getProduct(factors);
		int squaredSum = getSquaredSum(factors);
		
		// printing results
		System.out.println("sum : " + sum + ", product : " + product + " and square sum : " + squaredSum);
		sc.close();
	}
}