import java.util.*;

public class CoffeeCounter{
	public static void main(String[] args){
		// creating scanner class object
		Scanner sc = new Scanner(System.in);
		double gst = 0.05;
		double coffeePrice1 = 100;
		double coffeePrice2 = 150;
		double coffeePrice3 = 200;
		
		System.out.println("Types of coffee - coffee1/coffee2/coffe3 and type exit for exit");
		
		// using while loop and swithc case
		while(true){
			System.out.print("Enter type of coffee : ");
			String type = sc.next();
			double price = 0;
			
			switch(type){
				case("coffee1"):
					price = coffeePrice1;
					break;
				case("coffee2"):
					price = coffeePrice2;
					break;
				case("coffee3"):
					price = coffeePrice3;
					break;
				case("exit"):
					return;
				default : 
					System.out.println("Enter a valid type of coffee");
					continue;
			}
			
			// taking quantity input
			System.out.print("Enter the quantity : ");
			int quantity = sc.nextInt();
			
			// calculating the final price
			price = price * quantity;
			price +=  price * gst;
			
			// printing the price
			System.out.println("The total price is " + price);
		}
	}
}