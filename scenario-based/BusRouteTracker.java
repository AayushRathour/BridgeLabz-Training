import java.util.*;

public class BusRouteTracker{
    public static void main(String[] args) {
		// Creating scanner class object and taking input
        Scanner sc = new Scanner(System.in);
        // counted the number of bus stops traveled
		int station = 1;
		
		System.out.println("Thankyou for Chosing us ");
		int i= 1;
		// Used the While Loop for counting the total distance and keep user traveling 
		while(i !=0){
			System.out.println("Do u want to travel more, Press(1) for Travel, (2)for Exit");
			int num =sc.nextInt();
			if(num == 1){
				station ++;
				System.out.println("you Already travelled :"+(5*station)+"KM");
			}
			else if (num == 2){
				i = 0;
			}
			else{
				System.out.println("Wrong Input");
			}
			
		}// Printed the total distance traveled by the user 
		System.out.println("you travelled total :"+(5*station)+"KM");
		System.out.println("Thankyou for Chosing our bus service ");
		
    }
}
