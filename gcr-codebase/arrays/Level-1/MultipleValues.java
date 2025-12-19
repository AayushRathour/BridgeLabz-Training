import java.util.*;

public class MultipleValues{
    public static void main(String[] args) {
		
		// Creating Scanner Object and initializing array and variables
        Scanner sc = new Scanner(System.in);
		double[] arr = new double[10];
		double total = 0;
		int index = 0;
		
		// Using infinite while loop to take input from user and store them in array
		while(true){
			System.out.print("Enter number : ");
			int number = sc.nextInt();
			if(number <= 0 || index == 10) break;
			arr[index] = number;
			index++;
		}
		
		// using for loop to calculate the sum of values
		for(int i = 0; i < index; i++){
			total += arr[i];
		}
		
		// Printing the sum of values
		System.out.println("The sum is : " + total);
		
	
    }
}