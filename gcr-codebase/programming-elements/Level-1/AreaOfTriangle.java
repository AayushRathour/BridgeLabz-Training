import java.util.Scanner;

public class AreaOfTriangle{
	public static void main(String[] args){
		
		// Creating scanner object for taking input from user
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter height of triangle : ");
		double height = sc.nextDouble();
		System.out.print("Enter base of triangle : ");
		double base = sc.nextDouble();

		// converting the base and height from cm to inch
		double baseInInch = 0.3937 * base;
		double heightInInch = 0.3937 * height;
		
		// calculating area in centimeter and inch square
		double areaInCentimeter = 0.5 * base * height;
		double areaInInch = 0.5 * baseInInch * heightInInch;
		
		// printing the result
		System.out.println("Your area in square cm is " + areaInCentimeter +  " while in inch is " + areaInInch);
	}
}