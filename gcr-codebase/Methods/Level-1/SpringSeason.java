import java.util.*;

public class SpringSeason{
	private static void seasonCheck(int month, int day){
		
		// checking weather it is spring season or not and printing result
		if(month == 4 || month == 5 || (month == 3 && day >= 20 && day <= 31) || (month == 6 && day >= 1 && day <= 20)){
			System.out.println("Its a Spring Season");
		}
		else{
			System.out.println("Not a Spring Season");
		}
	}
	public static void main(String[] args){
		
		// creating scanner object and taking input 
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter month : ");
		int month = sc.nextInt();
		System.out.print("Enter day : ");
		int day = sc.nextInt();
		
		// calling function
		seasonCheck(month, day);
		
	
	}
}