import java.util.*;

public class ElectionBoothManager{
    public static void main(String[] args) {
// created Scanner object for taking input from user 
        Scanner sc = new Scanner(System.in);
		// created 3 candidate variable for storing the voting count 
        int cand1 = 0;
        int cand2 = 0;
        int cand3 = 0;
		// Started Loop for iterating the voters
        while (true) {
            System.out.println("Enter your age (-1 to exit): ");
            int age = sc.nextInt();
			// used condition and Switch case for proper validation  
            if (age == -1) {
                break;
            }

            if (age < 18) {
                System.out.println("Not eligible for voting");
                continue;
            }

            System.out.println("Enter your Candidate (1, 2, 3): ");
            int can = sc.nextInt();

            switch (can) {
                case 1:
                    cand1++;
                    break;
                case 2:
                    cand2++;
                    break;
                case 3:
                    cand3++;
                    break;
                default:
                    System.out.println("Invalid Input");
                    continue;
            }

            System.out.println("Thank you for voting");
        }
		// printing the voting result 
        System.out.println("\nVoting Result:");
        System.out.println("Candidate A: " + cand1);
        System.out.println("Candidate B: " + cand2);
        System.out.println("Candidate C: " + cand3);
    }
}
