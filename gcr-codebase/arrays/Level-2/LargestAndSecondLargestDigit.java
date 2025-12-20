import java.util.Scanner;

public class LargestAndSecondLargestDigit{
    public static void main(String[] args) {
		// Creating Scanner Object, taking input and initializing array
        Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		long number = sc.nextLong();
		int[] digits = new int[10];
		
		// storing digits in array and reinitializing if required
		int index = 0;
		int maxIndex = 10;
		while(number != 0){
			if(maxIndex == index){
				maxIndex *= 2;
				int[] temp = new int[maxIndex];
				for(int i = 0; i < index; i++){
					temp[i] = digits[i];
				}
				digits = temp;
			}
			digits[index++] = (int)(number%10);
			number /= 10;
		}
		
		// finding the largest and second largest
		int largest = 0;
		int secondLargest = 0;
		for(int i = 0; i < 10; i++){
			int digit = digits[i];
			if(largest < digit) largest = digit;
			else secondLargest = Math.max(digit, secondLargest);
		}
		
		// printing the result
		System.out.println("Largest is " + largest + " and second largest is " + secondLargest);
		
		sc.close();
    }
}