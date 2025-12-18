import java.util.*;

public class MultiplesBelow100WhileLoop{
    public static void main(String[] args) {

        // Creating Scanner object and taking input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int number = sc.nextInt();
        int counter = 100;

        // Checking positive integer and less than 100
        if (number > 0 && number < 100) {

            // while loop from 100 to 1
            while (counter > 0) {
                if (counter % number == 0) {
                    System.out.println(counter);
                }
                counter--;
            }
        }

        sc.close();
    }
}
