import java.util.*;

public class PowerOfNumber{
    public static void main(String[] args) {

        // Creating Scanner object and taking input from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int number = sc.nextInt();
        System.out.print("Enter the power : ");
        int power = sc.nextInt();

        int result = 1;

        // for loop to calculate power
        for (int i = 1; i <= power; i++) {
            result = result * number;
        }

        // printing the result
        System.out.println(result);

        sc.close();
    }
}
