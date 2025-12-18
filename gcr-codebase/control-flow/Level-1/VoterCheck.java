import java.util.*;

public class VoterCheck{
	public static void main(String[] args){
		
		// Creating scanner object for taking input from the user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Age");
		int number = sc.nextInt();
		
		
		if (number>=18){
			
			System.out.println("The person's age is : "+number+" and can vote");
		}
		else{
			
			System.out.println("The person's age is : "+number+" and cannot vote");
		}
		sc.close();
			
	
	}
}