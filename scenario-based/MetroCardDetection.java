import java.util.*;

public class MetroCardDetection{
    public static void main(String[] args) {
// created Scanner object for taking input from user 
        Scanner sc = new Scanner(System.in);
		System.out.println("Ente the Distance :: ");
		int diss = sc.nextInt();
		int remainig = 100;
		// used Condtinal Statement for deducting the  checkin the fare 
		// Printing the results  
		int fare = (diss <= 5)? 10:20;
		if (remainig >= fare){
			remainig = remainig-fare;
			System.out.println("Succesfully Deducted Rs : "+ fare +" remainig U have "+ remainig);
			
		}
		else{	
			System.out.println("Ensufficient Balance");
		}System.out.println("Thank you for using Delhi Metro");
		
    }		
}
