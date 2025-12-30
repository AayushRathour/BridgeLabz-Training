import java.util.*;

public class MovieTicketBooking{
    public static void main(String[] args) {

        // Creating scanner class object and taking input
        Scanner sc = new Scanner(System.in);

        int availableSeats = 10;

        // use while loop and taking user input and booking tickets
        while(true){

            if(availableSeats == 0){
                System.out.println("House Full ");
                break;
            }

            System.out.println("\nAvailable Seats: " + availableSeats);

            System.out.println("Enter the movie type:");
            System.out.println("(1) Action");
            System.out.println("(2) Adventure");
            System.out.println("(3) Comedy");
            System.out.println("(0) Exit");

            int value = sc.nextInt();
			// used codition and switch statement for selection
            if(value == 0){
                System.out.println("Thank you for using Movie Ticket Booking App");
                break;
            }

            switch(value){
                case 1:
                    System.out.println("Action Movie Selected");
                    break;
                case 2:
                    System.out.println("Adventure Movie Selected");
                    break;
                case 3:
                    System.out.println("Comedy Movie Selected");
                    break;
                default:
                    System.out.println("Invalid Movie Type");
                    continue;
            }

            System.out.println("Select Seat Type:");
            System.out.println("(1) Gold - Rs 300");
            System.out.println("(2) Silver - Rs 200");

            int seat = sc.nextInt();
            int totalPrice = 0;

            if(seat == 1){
                totalPrice = 300;
            }
            else if(seat == 2){
                totalPrice = 200;
            }
            else{
                System.out.println("Wrong Seat Input");
                continue;
            }

            availableSeats--;

            System.out.println("Do you want Snacks?");
            System.out.println("(1) Yes - Rs 150");
            System.out.println("(2) No");

            int snack = sc.nextInt();

            if(snack == 1){
                totalPrice += 150;
            }

            // print the results
            System.out.println("Total Price to Pay: Rs " + totalPrice);
            System.out.println("Booking Completed Successfully ");
        }
    }
}
