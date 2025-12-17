import java.util.Scanner;

public class FeeDiscountCalculatorWithInput{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking student fee as input
		System.out.println("Enter the Total Fee");
        double fee = sc.nextDouble();

        // Taking discount percentage as input
		System.out.println("Enter the Disscount ");
        double discountPercent = sc.nextDouble();

        // Calculating discount amount
        double discount = (fee * discountPercent) / 100;

        // Calculating final fee after discount
        double finalFee = fee - discount;

        // Printing output
        System.out.println(
            "The discount amount is INR " + discount +
            " and final discounted fee is INR " + finalFee
        );
    }
}
