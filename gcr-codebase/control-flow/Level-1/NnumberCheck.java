import java.util.*;

public class NnumberCheck{
	public static void main(String[] args){
		
		// Creating scanner object for taking input from the user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int number = sc.nextInt();
		
		// Used Conditional Statement to Check 
		if (number == 0){
			
			System.out.println("The Number is Zero");
		}
		else if (number > 0){
			
			System.out.println("The Number is Positive");
		}		
		else{
			
			System.out.println("The Number is Negative");
		}
		// Scanner is closed
		sc.close();
			
	
	}
}