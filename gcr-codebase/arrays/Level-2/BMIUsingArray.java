import java.util.*;

public class BMIUsingArray{
	public static void main(String[] args){
		// Creating Scanner Object and initializing array
        Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of person : ");
		int n = sc.nextInt();
		double[] height = new double[n];
		double[] weight = new double[n];
		double[] bmi = new double[n];
		String[] status = new String[n];
		
		// Taking input 
		for(int i = 0; i < n; i++){
			System.out.print("Enter weight and height of person : ");
			weight[i] = sc.nextDouble();
			height[i] = sc.nextDouble();
		}
		
		// Calculating bmi and finding status
		for(int i = 0; i < n; i++){
			bmi[i] = weight[i] / (height[i] * height[i]);
			if (bmi[i] <= 18.4) status[i] = "Underweight";
			else if (bmi[i] >= 18.5 && bmi[i] <= 24.9) status[i] = "Normal";
			else if (bmi[i] >= 25.0 && bmi[i] <= 39.9) status[i] = "Overweight";
			else status[i] = "Obese";
		}
		
		// printing the result
		for(int i = 0; i < n; i++){
			System.out.println("height : " + height[i] + " weight : " + weight[i] + " bmi : " + bmi[i] + " status : " + status[i]);
		}
		
		sc.close();
		
	}	
}