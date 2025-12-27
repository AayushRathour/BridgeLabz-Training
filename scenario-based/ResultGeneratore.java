import java.util.*;

public class ResultGeneratore {
    public static void main(String[] args) {
		// Created a scanner object for taking the input from the user
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Sub 1 number :: ");
        int sub1 = sc.nextInt();
        System.out.println("Enter the Sub 2 number :: ");
        int sub2 = sc.nextInt();
        System.out.println("Enter the Sub 3 number :: ");
        int sub3 = sc.nextInt();
        System.out.println("Enter the Sub 4 number :: ");
        int sub4 = sc.nextInt();
        System.out.println("Enter the Sub 5 number :: ");
        int sub5 = sc.nextInt();
		
		// Calculated the average and used the Switch case for assigning the grade
        int average = (sub1 + sub2 + sub3 + sub4 + sub5) / 5;
        int total = average / 10;
        char grade = 'F';

        switch (total) {
            case 10:
            case 9:
            case 8:
                grade = 'A';
                break;
            case 7:
            case 6:
                grade = 'B';
                break;
            case 5:
                grade = 'C';
                break;
            case 4:
                grade = 'D';
                break;
            default:
                grade = 'F';
        }
		// Printed the average and grade of the student 

        System.out.println("The average marks you got is: " + average);
        System.out.println("Your grade is: " + grade);
    }
}
