import java.util.*;

public class RocketCountdownUsingLoop{
    public static void main(String[] args) {

		// Creating scanner object for taking input from the user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number");
        int number = sc.nextInt();
	
		
		// Started While Loop here
        for (int ans = number-1 ; ans > 0; ans--) {
            System.out.println(ans);
             
        }
	
		// Scanner Closed 
        sc.close();
    }
}
