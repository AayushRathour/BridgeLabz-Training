import java.util.*;

public class NumberGuessingGame{
    public static void main(String[] args) {
		// Used Scanner to take input from user
        Scanner sc = new Scanner(System.in);
		int random = (int)(Math.random()*100)+1; 
		int att = 5;
		// used do- while loop to check the validity 
	
        do{
			System.out.println("guess a number between 1 and 100.");
			int num = sc.nextInt();
			// started Codition to chack the number is coreect or low or high
			if (num  == random ){
				System.out.println("You guessed right its " + random);
				att -=1;
				return;
			}
			else if( num > random){
				System.out.println("Too high");
				att -=1;
			}
			else if (num < random){
				System.out.println("Too low");
				att -=1;
			}
			
		}while(att>0);
		
		// printed the currect number
		System.out.println("The Correct num is " +random);
    }
}
