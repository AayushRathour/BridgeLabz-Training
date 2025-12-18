import java.util.Scanner;

public class EvenOrOdd{
	public static void main(String[] args){
		// creating scanner object for taking input from user
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		int number = sc.nextInt();
		
		
		// Use Condition Statements  
		
		for (int i =1; i <= number; i++){
			if (i%2 ==0){
				System.out.println(i+ " is a Even number");
			}
			else{
				System.out.println(i+ " is a odd number");
				}
		
		
		// Scanner Closed 
		sc.close();
	}
}
}