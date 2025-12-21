import java.util.*;

public class EuclideanDistanceBetweenTwo{
    // reutrns distance between given points
    public static double findDistance(double x1, double y1, double x2, double y2){
		// using the given formula
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // reutrn and array of slope and intercept
    public static double[] findSlopeAndIntercept(double x1, double y1, double x2, double y2){
        double slope = (y2 - y1) / (x2 - x1);
        double intercept = y1 - (slope * x1);
        return new double[]{slope, intercept};
    }

    public static void main(String[] args){
		// creating scanner object and taking user input
        Scanner sc=new Scanner(System.in);
		System.out.println("Enter the two points");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

		// calling functions and printing results
        double distance = findDistance(x1, y1, x2, y2);
        double[] arr = findSlopeAndIntercept(x1, y1, x2, y2);
        System.out.println(distance);
        System.out.println(arr[0] + "x + " + arr[1]);

    
    }
}