import java.util.Scanner;

public class SumOfNumbers{
	public static void main(String[] args){
		// creating scanner object and taking input
		Scanner sc = new Scanner(System.in);
		double input = sc.nextInt();;
		// initilizing the sum varaible
		double total = 0;
		
		// using while loop for taking input and sum
		while(input != 0){
			total += input;
			input = sc.nextInt();
		}
		
		// printing the output
		System.out.println(total);
		
		sc.close();
	}
}