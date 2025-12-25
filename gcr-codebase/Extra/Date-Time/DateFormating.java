import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateFormating{
    public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-YYYY");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("YYYY0-MM-dd");
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("EEE-YYYY-MM-dd");
		
		System.out.println(date.format(formatter1));
		System.out.println(date.format(formatter2));
		System.out.println(date.format(formatter3));
    }
}