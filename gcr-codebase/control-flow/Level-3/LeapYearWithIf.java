import java.util.*;

public class LeapYearWithIf{
    public static void main(String[] args) {
		// Creating scanner object and taking input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year:");
        int year = sc.nextInt();

        // Check input is valid and then checking for leep year
        if (year >= 1582 && ((year%400 == 0) || ((year%100 != 0) && (year%4 == 0)))) {
            System.out.println("Year is a Leap Year");
        }
        else {
            System.out.println("Enter diffrent year");
        }
    }
}