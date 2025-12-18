import java.util.*;

public class FindLargestNumber{
	public static void main(String[] args){
		
		// Creating scanner object for taking input from the user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first number");
		int number1 = sc.nextInt();
		System.out.println("Enter the 2nd number");
		int number2 = sc.nextInt();
		System.out.println("Enter the 3rd number");
		int number3 = sc.nextInt();
		
		if (number1> number2 && number1> number3){
			System.out.println("The first number is the largest");
		}
		else if (number2>number1 && number2> number3){
			System.out.println("The Second number is the largest");
		}
		else{
			System.out.println("The Third number the largest");
		}
		sc.close();
			
	
	}
}