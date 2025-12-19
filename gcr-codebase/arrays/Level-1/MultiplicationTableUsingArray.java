import java.util.*;

public class MultiplicationTableUsingArray{
	public static void main(String[] args){
		// creating scanner object for taking input from user
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Number : ");
		int number = sc.nextInt();
		int[] array =  new int[10];
		
		for(int i =0; i<10; i++){
			array[i] = (i+1)*number;
		}
		
		for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + (i+1) + " = " + (array[i]));
		}

		
		sc.close();
		
	}	
}