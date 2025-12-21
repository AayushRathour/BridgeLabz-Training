import java.util.*;

public class LeepYearOrNot{
	// print year is leep year or not
	public static void checkLeepYear(int year){
		// Check input is valid and then checking for leep year
        if (year >= 1582) {
            if (year % 400 == 0){
				System.out.println("Year is a Leap Year");
			}
            else if (year % 100 == 0) {
                System.out.println("Year is not a Leap Year");
            }
            else if (year % 4 == 0) {
                System.out.println("Year is a Leap Year");
            }
            else {
                System.out.println("Year is not a Leap Year");
            }
        }
        else {
            System.out.println("Enter year more than equal to 1582");
        }
	}
	
	public static void main(String[] args){
		// creating scanner object and taking input from user 
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter year : ");
		int year = sc.nextInt();
		
		// calling function
		checkLeepYear(year);
		
		sc.close();
	}
}