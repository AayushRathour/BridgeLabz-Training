import java.util.*;

public class PowerOfNumberUsingWhileLoop{
    public static void main(String[] args) {

        // Creating Scanner object and taking input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int number = sc.nextInt();
        System.out.print("Enter the power : ");
        int power = sc.nextInt();

        int result = 1;
        int counter = 0;

        // while loop to calculate power
        while (counter < power) {
            result = result * number;
            counter++;
        }

        // printing the result
        System.out.println(result);

        sc.close();
    }
}
