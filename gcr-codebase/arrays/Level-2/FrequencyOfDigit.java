import java.util.*;

public class FrequencyOfDigit{
	public static void main(String[] args){
		// Creating Scanner Object, taking input and initializing array
        Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		long number = sc.nextLong();
		int[] digits = new int[20];
		int[] frequency = new int[10];
		
		// storing digits in array
		int index = 0;
		while(number != 0){
			digits[index++] = (int)(number%10);
			number /= 10;
		}
		
		// counting the frequency of each digit
		for(int i = 0; i < index; i++){
			frequency[digits[i]]++;
		}
		
		// printing the result
		for(int i = 0; i < 10; i++){
			System.out.println(i + " : " + frequency[i]);
		}
		
		sc.close();
     
       
		
	}	
}