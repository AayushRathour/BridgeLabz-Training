import java.util.Scanner;

public class MultiplicationTable{
	public static void main(String[] args){
		// creating scanner object for taking input from user
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Number : ");
		int number = sc.nextInt();
		
		for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
		}

		
		
		
	}	
}