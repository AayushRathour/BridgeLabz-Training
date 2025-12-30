import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class LibraryReminderApp{
	public static void main(String[] args){
		// Creating scanner class object and taking input
		Scanner sc = new Scanner(System.in);

		// using for loop for 5 iterations
        for (int i = 1; i <= 5; i++) {
			// taking input
            System.out.print("Enter due date (YYYY-MM-DD): ");
            LocalDate date1 = LocalDate.parse(sc.nextLine());

            System.out.print("Enter return date (YYYY-MM-DD): ");
            LocalDate date2 = LocalDate.parse(sc.nextLine());
			
			// using inbuilt fucntion to find diffrence between days
            long days = ChronoUnit.DAYS.between(date1, date2);

			// printing results
            if (days > 0) System.out.println("Total fine " + (days*5));
			else System.out.println("Returned on time");
        }
	}
}