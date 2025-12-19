import java.util.*;

public class MultiplicationTable6To9{
    public static void main(String[] args) {
		
		// Creating Scanner Object and initializing array and variables
        Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number");
		int input = sc.nextInt();
		int number = input;
		
		// created a array to store values
		int[] multiplicationResult = new int[10];
		
		// Using for loop we initialized value and printed output
		
		for(int i = 6; i<10; i++){
			multiplicationResult[i] =i*number;
		}
		for (int i =6 ; i<10; i++){
			System.out.println(i + "*" +number + " = "+ (multiplicationResult[i]));
		}
	
    }
}