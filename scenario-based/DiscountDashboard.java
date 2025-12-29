import java.util.*;

public class DiscountDashboard{
    public static void main(String[] args) {
		// Used Scanner to take input from user
		Scanner sc = new Scanner(System.in);
		int total = 0;
		System.out.println("Ente how many products u bought");
		int pr = sc.nextInt();
		// used the for loop for taking price of diffrent products 
		for(int i = 1; i <= pr; i++ ){
			System.out.println("Enter the cost of Product " +i);
			int price = sc.nextInt();
			
			total = price+total;
		}
		// Calculated the discount for 5% and 10% both 
		double discount = (total*10)/100;
		int discount1 = (total*5)/100;
		
		// used condition to check the and print the discounted amount and discount
		if(total > 1000){
			System.out.println("you got discount of 10% and the discount ammount is : " + discount);
			System.out.println("you got discount of 10% and the discount and amount to pay : " + (total-discount));
			
		}
		else{
			System.out.println("you got discount of 5% and the discount ammount is : " + discount1);
			System.out.println("you got discount of 5% and the discount and amount to pay : " + (total-discount1));
		}

    }
}
