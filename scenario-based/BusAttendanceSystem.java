import java.util.*;

public class BusAttendanceSystem {
    public static void main(String[] args) {
		// Created Scanner object for taking input from user
        Scanner sc = new Scanner(System.in);
		// inisialized two varialbles for counting the students
        int present = 0;
        int absent = 0;
		// Used Loop
        for (int i = 1; i <= 10; i++) {
            System.out.println("Enter P for Present or A for Absent for Student :" +i);
            String stu = sc.next();

            if (stu.equalsIgnoreCase("P")) {
                present++;
            } else if (stu.equalsIgnoreCase("A")) {
                absent++;
            }
        }
		// Printed the number of present and absent students 
        System.out.println("Total Students Present: " + present);
        System.out.println("Total Students Absent: " + absent);
    }
}
