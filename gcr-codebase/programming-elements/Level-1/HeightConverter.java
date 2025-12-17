import java.util.Scanner;

public class HeightConverter{
    static public void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking height in centimeters
		System.out.println("Enter the Height");
        double heightCm = sc.nextDouble();

        // Converting cm to inches
        double totalInches = heightCm / 2.54;

        // Calculating feet
        int feet = (int)(totalInches / 12);

        // Calculating remaining inches
        double inches = totalInches % 12;

        System.out.println(
            "Your Height in cm is " + heightCm +
            " while in feet is " + feet +
            " and inches is " + inches
        );
    }
}
