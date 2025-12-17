import java.util.*;

public class KMtoMilesWithInput{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		// Asking the User for Input
		System.out.println("Enter the Distance in KM");
		
		// Taking the input from user
		double KM = sc.nextInt();
	 
		System.out.println("The distance " + KM + " km in miles is : " + (KM *1.6));
		
		
		
	}
}