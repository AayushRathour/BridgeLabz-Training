import java.util.*;
public class GradeCalculator{
    public static void main(String[] args) {
		
        // Creating scanner object and input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Physics marks:");
        double physics = sc.nextDouble();
        System.out.print("Enter Chemistry marks:");
        double chemistry = sc.nextDouble();
        System.out.print("Enter Maths marks:");
        double maths = sc.nextDouble();
		
		// calculating percentage and finding grade
        double total = physics + chemistry + maths;
        double percentage = total / 3;
		System.out.println("percentage : " + percentage);
        if (percentage >= 80) {
            System.out.println("Grade A");
            System.out.println("Level 4, above agency-normalized standards");
        }
        else if (percentage >= 70) {
            System.out.println("Grade B");
            System.out.println("Level 3, at agency-normalized standards");
        }
        else if (percentage >= 60) {
            System.out.println("Grade C");
            System.out.println("Level 2, below but approaching standards");
        }
        else if (percentage >= 50) {
            System.out.println("Grade D");
            System.out.println("Level 1, well below standards");
        }
        else if (percentage >= 40) {
            System.out.println("Grade E");
            System.out.println("Level 1-, too below standards");
        }
        else {
            System.out.println("Grade R");
            System.out.println("Remedial standards");
        }
    }
}