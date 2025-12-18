import java.util.*;

public class SpringSeason{
	public static void main(String[] args){
		
		// Creating scanner object for taking input from the user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Month First");
		int month = sc.nextInt();
		System.out.println("Enter the Date");
		int date = sc.nextInt();
		
		
		// Used Conditional Statement to Check 
		if ((month == 3 && date >=20 && date <=31)  || (month == 4 && date <=20)){
			
			System.out.println("Its a Spring Season");
		}
		else{
			
			System.out.println("Not a Spring Season");
		}
		// Scanner is closed
		sc.close();
			
	
	}
}