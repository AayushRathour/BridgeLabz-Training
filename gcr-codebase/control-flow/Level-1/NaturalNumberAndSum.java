import java.util.*;

public class NaturalNumberAndSum{
	public static void main(String[] args){
		
		// Creating scanner object for taking input from the user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int number = sc.nextInt();
		
		int sum =  number * (number+1) / 2;
		
		if (number>0){
			
			System.out.println("The sum of "+number+" natural numbers is : "+ sum);
		}
		else{
			
			System.out.println("The number"+number+" is not a natural number");
		}
		sc.close();
			
	
	}
}