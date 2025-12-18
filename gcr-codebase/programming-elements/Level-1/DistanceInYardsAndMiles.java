import java.util.Scanner;

public class DistanceInYardsAndMiles{
	public static void main(String[] args){
		
		// creating object of scanner for taking input from user
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter distance in feet : ");
		double distanceInFeet = sc.nextDouble();
		
		// calculating distance in yard and mile
		double distanceInYard = distanceInFeet / 3;
		double distanceInMiles = distanceInYard / 1760;
		
		// printing the result
		System.out.println( "Your Height in mile is " + distanceInMiles + " while in yard is " + distanceInYard + " and feet is " + distanceInFeet);
	}
}