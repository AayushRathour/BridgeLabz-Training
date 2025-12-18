import java.util.*;

public class SumOfNumbers {
    public static void main(String[] args) {

        // creating scanner object and initializing the total variable
        Scanner sc = new Scanner(System.in);
        double total = 0;

        // using while loop for taking input and sum also using break to break the loop
        while (true) {
          
            double input = sc.nextDouble();  
            if (input <= 0) break;
            total += input;
        }

        // printing the output
        System.out.println(total);

        sc.close();
    }
}
