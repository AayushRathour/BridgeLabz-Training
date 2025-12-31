import java.util.*;

public class CurrencyExchangeKiosk{
    public static void main(String[] args) {
		// Creating scanner class object and taking input
        Scanner sc = new Scanner(System.in);
        int choice;
		// used Do-While loop for looping and asking user for more exchanges
        do{
            System.out.println("Enter the Indian Rs Amount to Exchange");
            double rupee = sc.nextDouble();

            System.out.println("Enter to convert (1) USD, (2) Euro, (3) Japanese Yen, (4) Exit");
            int ex = sc.nextInt();
			// Started the Switch case
            switch(ex){
                case 1:
                    System.out.println("Currency converted Successfully to USD");
                    System.out.println("You got USD : " + (rupee / 83.0));
                    break;

                case 2:
                    System.out.println("Currency converted Successfully to Euro");
                    System.out.println("You got Euro : " + (rupee / 90.0));
                    break;

                case 3:
                    System.out.println("Currency converted Successfully to Japanese Yen");
                    System.out.println("You got Japanese Yen : " + (rupee / 0.56));
                    break;

                case 4:
                    return;
            }
			/// Asked usr if he want more exchanges
            System.out.println("Do you want to exchange more? Enter (1) If Yes");
            choice = sc.nextInt();

        } while(choice == 1);
    }
}
