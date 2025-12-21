import java.util.*;

public class CalendarDisplay{
    // return month name 
    public static String getMonthName(int month){
        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        return months[month-1];
    }

    // return boolean for leap year
    public static boolean isLeapYear(int year){
		if(year%4==0 && year%100!=0) return true;
		if(year%400==0) return true;
        return false;
    }

    // returns number of days for a given month
    public static int getDaysInMonth(int month, int year){
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        if(month == 2 && isLeapYear(year)) return 29;
        return days[month-1];
    }

    // return frist day of month
    public static int getFirstDay(int m, int y){
		int d = 1;
        // Using the given formula to find the day
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;
		return d0;
	}

    public static void main(String[] args){
		// taking user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month: ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();

        int firstDay = getFirstDay(month,year);
        int totalDays = getDaysInMonth(month,year);

        // print header
        System.out.println(getMonthName(month)+" "+year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // Printing results as specified
        for(int i = 0; i < firstDay; i++){
            System.out.print("    ");
		}
		
        for(int day = 1; day <= totalDays; day++){
            System.out.printf("%3d ",day);
            if((day+firstDay)%7==0) System.out.println();
        }
  
    }
}