
import java.time.*;

public class ZoneTimeAndZonedDateTime{
	public static void main(String[] args) throws Exception{		
		ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("GMT"));
		ZonedDateTime pstTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
		ZonedDateTime istTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
		
        System.out.println("Current Time in GMT: " + gmtTime);
        System.out.println("Current Time in IST: " + pstTime);
        System.out.println("Current Time in PST: " + istTime);
	}
}