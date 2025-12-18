import java.util.*;

public class RocketCountdown {
    public static void main(String[] args) {

		// Creating scanner object for taking input from the user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number");
        int number = sc.nextInt();

		// inisialised ans varialble to store countdown
        int ans = number-1;   // fixed
		
		
		// Started While Loop here
        while (ans > 0) {
            System.out.println(ans);
            ans -= 1;    
        }
	
		// Scanner Closed 
        sc.close();
    }
}
