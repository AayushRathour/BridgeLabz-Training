import java.util.*;

public class TrainReservation{
    public static void main(String[] args) {
		// Used Scanner for taking input from the user and also create some variable 
        Scanner sc = new Scanner(System.in);
		// puttent the seats 
        int seat =5;
		
		// used while loop for Simulate ticket booking
		while(seat>0){
			System.out.println("Select & Press what u want to do : ");
			System.out.println("(1) for booking Seats ");
			System.out.println("(2) for Checking Seats available");
			System.out.println("(3) For exit ");
			int num = sc.nextInt();
			//used switch case for booking properly 
			switch(num){
				case 1:
					System.out.println("Seat Booked Succesfull ");
					seat -=1;
					break ;
				case 2:
					System.out.println("the remaining Sets are " + seat);
					break;
				case 3:
					return;
			}
		
		
		}
		// printing the output
		System.out.println("Seats are full ,try leter : "+seat+" Remaining");
    }
}
