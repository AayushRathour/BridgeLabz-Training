import java.util.*;

public class ArmstrongNumber{
    public static void main(String[] args) {
		// Creating scanner object and taking input from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number:");
        int input = sc.nextInt();
        int number = input;
        int sum = 0;
		
		// using while and %10 to access the last digit of number, 
		// dividing it with 10 to reduce the number
        while (number != 0) {
            int digit = number % 10;
            sum = sum + (digit * digit * digit);
            number = number / 10;
        }
		
		// checking and printing the result
        if (sum == input) {
            System.out.println(input + " is an Armstrong Number");
        } else {
            System.out.println(input + " is NOT an Armstrong Number");
        }
		// Scanner Closed 
        sc.close();
    }
}