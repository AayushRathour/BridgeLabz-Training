import java.util.*;

public class BMIUsingArray2{
	public static void main(String[] args){
		// Creating Scanner Object and initializing array
        Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of person : ");
		int n = sc.nextInt();
		double[][] personData = new double[n][3];
		String[] weightStatus = new String[n];
		
		// Taking input using the loop
		for(int i = 0; i < n; i++){
			System.out.print("Enter weight and height of person : ");
			personData[i][0] = sc.nextDouble();
			personData[i][1] = sc.nextDouble();
		}
		
		// Calculating bmi and finding status
		for(int i = 0; i < n; i++){
			personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);
			if (personData[i][2] <= 18.4) weightStatus[i] = "Underweight";
			else if (personData[i][2] >= 18.5 && personData[i][2] <= 24.9) weightStatus[i] = "Normal";
			else if (personData[i][2] >= 25.0 && personData[i][2] <= 39.9) weightStatus[i] = "Overweight";
			else weightStatus[i] = "Obese";
		}
		
		// printing the result
		for(int i = 0; i < n; i++){
			System.out.println("height : " + personData[i][1] + " weight : " + personData[i][0] + " bmi : " + personData[i][2] + " status : " + weightStatus[i]);
		}
		
		sc.close();
		
	}	
}