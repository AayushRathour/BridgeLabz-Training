import java.util.*;

public class DisplayCalendar{
    // created method to return month name
    public static String getMonthName(int month){
        String[] arr = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return arr[month - 1];
    }

    // checking leep year
    public static boolean checkLeepYear(int year){
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

    // Method to return the number of days in a month
    public static int getDays(int month, int year){
        int[] arr = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (month == 2 && checkLeepYear(year)) return 29;
        return arr[month-1];
    }

    // Method to return the first day of month using formula
    public static int getDay(int month, int year){
        int d = 1;
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;
        return d0; 
    }

    // print the calendar
    public static void display(int month, int year){
        String monthName = getMonthName(month);
        int days = getDays(month, year);
        int firstDay = getDay(month, year);

        System.out.println("   " + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < firstDay; i++) System.out.print("    ");
        for (int day = 1; day <= days; day++){
            System.out.printf("%3d ", day);
            if ((day + firstDay) % 7 == 0) System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args){
		// creating scanner class object and taking input from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month and year : ");
        int month = sc.nextInt();
        int year = sc.nextInt();

        // Displaying calendar
        display(month, year);
    }
} 	