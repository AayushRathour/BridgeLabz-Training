import java.util.*;

public class MultiplesBelow100ForLoop {
    public static void main(String[] args) {

        // Creating Scanner object and taking input from the user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int number = sc.nextInt();

        // Checking positive integer and less than 100
        if (number > 0 && number < 100) {

            // for loop from 100 to 1
            for (int i = 100; i >= 1; i--) {
                if (i % number == 0) {
                    System.out.println(i);
                }
            }
        }

        sc.close();
    }
}
