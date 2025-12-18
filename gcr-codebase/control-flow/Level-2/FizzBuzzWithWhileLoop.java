import java.util.*;

public class FizzBuzzWithWhileLoop{
	public static void main(String[] args){
		// creating scanner object for taking input from user
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Number : ");
		int number = sc.nextInt();
		
			// Started a For Loop  
		while(number>0) {
			
			// Used If Else Conditions 
            if (number>0 && (number%5 ==0 && number%3 ==0 )){
				System.out.println("FizzBuzz");break;
			}
			else if (number>0 && number%5 ==0){
				System.out.println("Buzz");break;
			}
			else if (number>0 && number%3 ==0){
				System.out.println("Fizz");break;
			}
			else{
				System.out.println(number);break;
			}
			
		}

		
		// Scanner Closed 
		sc.close();
	}	
}