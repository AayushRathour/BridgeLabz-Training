import java.util.*;

public class BMICalculatore{
	public static void main(String[] args){
		// creating scanner class object
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter height : ");
		double height = sc.nextDouble();
		System.out.print("Enter weight : ");
		double weight = sc.nextDouble();
		
		// calculating bmi and status 
		double bmi = weight / (height * height);
		String status;
		if(bmi <= 18.4) status = "Underweight";
        else if(bmi <= 24.9) status = "Normal";
        else if(bmi <= 39.9) status = "Overweight";
        else status = "Obese";
		
		// printing the result
		System.out.println("Bmi is " + bmi + " and the bmi category is " + status);
		
		sc.close();
	}
}