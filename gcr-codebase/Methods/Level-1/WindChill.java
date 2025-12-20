import java.util.*;

public class WindChill{
	// return wind chill temperature taking temperature 
	// Taking windSpeed as input also
	public static double calculateWindChill(double temperature, double windSpeed){
		return 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
	}
	public static void main(String[] args){
		// creating scanner object and taking input from user
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter temperature and windSpeed : ");
		double temperature = sc.nextDouble();
		double windSpeed = sc.nextDouble();
		
		// calling function the and printing result
		double windChillTemp = calculateWindChill(temperature, windSpeed);
		System.out.println("The wind chill temperature is : " + windChillTemp);
		sc.close();
	}
}