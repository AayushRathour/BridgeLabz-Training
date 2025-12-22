import java.util.*;

public class BMICalculator{
	// method to return BMI using formual
    static String[] getBmi(double weight, double height) {
        double bmi = weight / (height * height);
        bmi = Math.round(bmi * 100.0) / 100.0;
		
        String status;
        if (bmi <= 18.4) status = "Underweight";
        else if (bmi <= 24.9) status = "Normal";
        else if (bmi <= 39.9) status = "Overweight";
        else status = "Obese";

        return new String[]{String.valueOf(bmi), status};
    }

    // Return 2d array of return height, weight, bmi and status
    static String[][] getGrid(double[][] arr) {
		int n = arr.length;
        String[][] result = new String[n][4];

        for (int i = 0; i < n; i++) {
            double weight = arr[i][0];
            double height = arr[i][1];
            String[] curr = getBmi(weight, height);
            result[i][0] = "" + height;
            result[i][1] = "" + weight; 
            result[i][2] = curr[0];           
            result[i][3] = curr[1];            
        }
        return result;
    }

    // Print the 2d grid 
    static void display(String[][] arr) {
        for (String[] a : arr) {
            System.out.println(a[0] + " " + a[1] + " " + a[2] + " " + a[3]);
        }
    }

    public static void main(String[] args) {
		// creating scanner object and taking input
        Scanner sc = new Scanner(System.in);
        double[][] arr = new double[10][2];
        for (int i = 0; i < 10; i++) {
			System.out.print("Enter weight and height : ");
            arr[i][0] = sc.nextDouble();
            arr[i][1] = sc.nextDouble();
        }
		
		// calling functions
        String[][] result = getGrid(arr);
        display(result);
		
		sc.close();
    }
}