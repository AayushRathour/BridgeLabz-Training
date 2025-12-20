import java.util.*;


public class CalculatingTrignometricFuncions{
	// return an array with sine, cos and tan values
	public static double[] calculateTrigonometricFunctions(double angle) {
		
        // Convert degrees to radians
        double radians = Math.toRadians(angle);
		double[] result = new double[3];

        // Calculate sine and cosine
        result[0] = Math.sin(radians);
        result[1] = Math.cos(radians);
		result[2] = Math.tan(radians);
        return result;
    }
	public static void main(String[] args){
		// creating scanner object and taking input from user 
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter angle : ");
		double angle = sc.nextDouble();
		
		// calling function and printing result
		double[] result = calculateTrigonometricFunctions(angle);
		System.out.println("sine value : " + result[0] + ", cos value : " + result[1] + " and tan value : " + result[2]);
		sc.close();
	}
}