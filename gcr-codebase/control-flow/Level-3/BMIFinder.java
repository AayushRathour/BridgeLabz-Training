import java.util.*;

class BMIFinder{
    public static void main(String[] args) {
		
        // Creating Scanner object and taking input from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your weight :");
        double weight = sc.nextDouble();
        System.out.print("Enter your height :");
        double heightInCm = sc.nextDouble();
	
		// converting height and calculting BMI 
        double heightInMeter = heightInCm / 100;
        double bmi = weight / (heightInMeter * heightInMeter);
        System.out.println("Your BMI is: " + bmi);
		
        // finding and printing weight
        if (bmi <= 18.4) {
            System.out.println("Underweight");
        }
        else if (bmi >= 18.5 && bmi <= 24.9) {
            System.out.println("Normal");
        }
        else if (bmi >= 25.0 && bmi <= 39.9) {
            System.out.println("Overweight");
        }
        else {
            System.out.println(" Obese");
        }
		sc.close();
    }
}