import java.util.*;

public class FizzBuzz{
    public static void main(String[] args) {
		// Creating Scanner Object and taking input
        Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		int number = sc.nextInt();
		
		//validating input and initializing array
		if(number <= 0){
			System.out.println("Enter a number greater than 0");
			return;
		}
		String[] arr = new String[number+1];
		
		// Iterating values from 1 to number and saving according to given conditions
		for(int i = 1; i <= number; i++){
			if(i%3 == 0 && i%5 == 0) arr[i] = "FizzBuzz";
			else if(i%3 == 0) arr[i] = "Fizz";
			else if(i%5 == 0) arr[i] = "Buzz";
			else arr[i] = ""+i;
		}
		
		// Printing the results
		for(int i = 1; i <= number; i++){
			System.out.print(arr[i] + " ");
		}			
		
		sc.close();
    }
}