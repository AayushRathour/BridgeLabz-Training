import java.util.*;

public class CountDigits{
    public static void main(String[] args) {
		// Creating scanner object and taking input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number:");
        int number = sc.nextInt();
        int digits = 0;

        // using while loop to count the number of digits
        while (number != 0) {
            number = number / 10;
            digits++;
        }

        // Printing the result
        System.out.println("Number of digits are " + digits);

    }
}