import java.util.*;

public class FizzBuzz{
	public static void main(String[] args){
		// creating scanner object for taking input from user
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Number : ");
		int number = sc.nextInt();
		
		for (int i = 1; i < number; i++) {
            if (number>0 && number%3 ==0){
				System.out.println("Fizz");break;
			}
			else if (number>0 && number%5 ==0){
				System.out.println("Buzz");break;
			}
			else if (number>0 && number%5 ==0 && number%3 ==0 ){
				System.out.println("FizzBuzz");break;
			}
			else{
				System.out.println(number);
			}
			
		}

		
		
		sc.close();
	}	
}