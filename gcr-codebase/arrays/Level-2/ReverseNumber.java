import java.util.*;

public class ReverseNumber{
	public static void main(String[] args){
		// Creating Scanner Object, taking input and initializing array
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number : ");
		int number = sc.nextInt();
		int[] digits  = new int[10];
		
		// storing digits in array and reinitializing if required
		int index = 0;
		while(number != 0){
			if(index == 10) break;
			digits[index++] = (number%10);
			number /= 10;
		}
		
		// storing in the reverse order digits
		int[] reverse = new int[10];
		for(int i = 0; i < 10; i++) reverse[i] = digits[i];
		
		// printing the result
		for(int i = 0; i < 10; i++) System.out.print(reverse[i] + " ");
		
		sc.close();
		
	}
}