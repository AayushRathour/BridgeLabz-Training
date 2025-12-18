import java.util.Scanner;

public class BonusesOfEmployees{
	public static void main(String[] args){
		// creating scanner object for taking input from user
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your Salary : ");
		int salary = sc.nextInt();
		
		System.out.print("Enter your Year of Working : ");
		int working = sc.nextInt();
		
		if (working <5){
			System.out.println("Sory Not Eligible for Bonus");
		}
		else{
			double bonus = salary*0.05;
			System.out.println("Your  bonus amount is : " + bonus);
		}
		
		
		
		
	}	
}