import java.util.*;

public class GreatestFactorWithForLoop{
    public static void main(String[] args) {
		
        //Creating Scanner object, taking input and initiallizing variables
        Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number : ");
        int number = sc.nextInt();
		int greatestFactor = 1;
		int i = number-1;

        // using while loop to print result
        while(i > 1){
			if(number%i == 0){
				greatestFactor = i;
				break;
			}
			i--;
		}
		
		// printing the result
		System.out.println(greatestFactor);
		
		sc.close();
    }
}