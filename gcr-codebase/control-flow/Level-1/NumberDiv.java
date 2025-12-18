import java.util.Scanner;

public class NumberDiv{
	public static void main(String[] args){
		
		// Creating scanner object for taking input from the user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int no = sc.nextInt();
		
		// Putten the Conditional Statement 
		if (no%5 ==0){
			System.out.println("The Number is divisible");
			
		}
		else{
			System.out.println("The number is not Divisible");
		}
		
		//Closed the Scanner
		sc.close();
	}
}