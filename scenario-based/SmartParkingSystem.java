import java.util.*;

public class SmartParkingSystem {
    public static void main(String[] args) {
		// Used Scanner to take input from user
		
        Scanner sc = new Scanner(System.in);
        int space = 0;

        System.out.println("Welcome to smart parking system.");
// used while loop to check the validity 
        while (true) {
            System.out.println("Park(1), Exit(2), Show Occupancy(3), Quit(4)");
            int in = sc.nextInt();
			// Started  switch case for functionining all the system properly
			// inside the case printed the output and perfomed Arethmetic oprtion
            switch (in) {
                case 1:
                    if (space < 5) {
                        space += 1;
                        System.out.println("Vehicle parked");
                    } else {
                        System.out.println("Parking is full");
                    }
                    break;

                case 2:
                    if (space > 0) {
                        space -= 1;
                        System.out.println("Vehicle exited");
                    } else {
                        System.out.println("Parking is empty");
                    }
                    break;

                case 3:
                    System.out.println("Occupied Space in parking : " + space);
                    System.out.println("Available spacce : " + (5 - space));
                    break;

                case 4:
                    return;
            }
        }
    }
}
