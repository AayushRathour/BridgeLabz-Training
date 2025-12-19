import java.util.*;

public class AbundantNumber{
	public static void main(String[] args) {
		// Creating Scanner object and taking input
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
		
		// Created a sum named variable and assigned value 0 
		int sum = 0;
		
		// Started a Loop 
		for(int i = 1; i<number; i++){
			if (number %i ==0){
				sum += i;
				
			}
		}
		// Started the Condition Statement to Print 
		if (sum >number){
			System.out.println(" Abundant Number");
		}
        else{
			System.out.println("Not Abundant Number");
		}
     

		// Closed Scanner 
        sc.close();
    }
}