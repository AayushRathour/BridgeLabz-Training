import java.util.*;

public class CheckPrimeOrNot{
    public static void main(String[] args) {
		// Create scanner object and take input from the user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number:");
        int number = sc.nextInt();

        boolean isPrime = true;
		//check input 
        if (number <= 1) {
			System.out.println("Enter number greater than 1");
        }
        // use of for Loop
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

		// printing results
        if (isPrime) {
            System.out.println(number + " is a Prime Number");
        } 
		else {
            System.out.println(number + " is not a Prime Number");
        }
		sc.close();
    }
}