import java.util.*;

public class BMIOfAll{
    // calculate BMI of person using formula
    public static void findBMI(double[][] person){
        for(int i = 0; i < person.length; i++){
            double heightInMeter = person[i][1]/100; 
            person[i][2] = person[i][0] / (heightInMeter * heightInMeter);
        }
    }
	
    // find bmi status and return array of strings 
    public static String[] bmiStatus(double[][] person){
		// creating array
        String[] status = new String[10];
		
		// storing array
        for(int i = 0; i < 10; i++){
            if(person[i][2] <= 18.4) status[i] = "Underweight";
            else if(person[i][2] <= 24.9) status[i] = "Normal";
            else if(person[i][2] <= 39.9) status[i] = "Overweight";
            else status[i] = "Obese";
        }
        return status;
    }
	
    public static void main(String[] args){
		// creating scanner object and taking input
        Scanner sc = new Scanner(System.in);
        double[][] personData = new double[10][3];
        for(int i = 0; i < 10; i++){
            System.out.print("Enter weight and height of person : ");
            personData[i][0] = sc.nextDouble();
            personData[i][1] = sc.nextDouble();
        }
		
        // call function to find bmi and status
        findBMI(personData);
        String[] status = bmiStatus(personData);
		
		
        // print result
        for(int i = 0; i < 10; i++){
            System.out.println("Person " +(i+1) + " " + personData[i][0] + " " + personData[i][1] + " " + personData[i][2] + " " + status[i]) ;
        }
        sc.close();
    }
}