import java.util.*;

public class TemperatureConverter{
	// Created a functions to convert celsius to fahrenheit
	public static double celsiusToFahrenheit(double celsius){
		return (celsius * 9.0 / 5.0) + 32.0;
	}
	
	// functions to convert fahrenheit to celsius
	public static double fahrenheiToCelsius(double fahrenheit){
		return (fahrenheit - 32.0) * 5.0 / 9.0;
	}
	public static void main(String[] args){
		// creating scanner class object and taking input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter temperature in celsius and fahrenheit : ");
		double celsius = sc.nextDouble();
		double fahrenheit = sc.nextDouble();
		
		// calling fucntion and printing result
		System.out.println(fahrenheit + " in celsius is " + fahrenheiToCelsius(fahrenheit));
		System.out.println(celsius + " in fahrenheit is " + celsiusToFahrenheit(celsius));
		
		sc.close();
	}
}