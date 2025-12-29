import java.util.*;

public class PhoneRecharge {
    public static void main(String[] args) {

        // Scanner for user input
        Scanner sc = new Scanner(System.in);

        // Initial balance
        int Amount = 3000;

        // Loop until balance is sufficient for minimum recharge
        while (Amount >= 239) {

            // Display current balance
            System.out.println("\nCurrent Balance: Rs" + Amount);
            System.out.println("Enter the Operator (Jio, Airtel, Vi, BSNL) or Exit:");
            String operator = sc.next();

            // Exit condition
            if (operator.equalsIgnoreCase("Exit")) {
                break;
            }

            int price = 0;   
            String plan = "";

            // Operator selection
            switch (operator.toLowerCase()) {

                case "jio":
                    System.out.println("(1) Rs239 : 1.5GB/day, 28 Days");
                    System.out.println("(2) Rs799 : 1.5GB/day, 84 Days");
                    System.out.println("(3) Rs3999 : 2.5GB/day, 365 Days");
                    int j = sc.nextInt();

                    if (j == 1) { price = 239; plan = "Jio Rs239"; }
                    else if (j == 2) { price = 799; plan = "Jio Rs799"; }
                    else if (j == 3) { price = 3999; plan = "Jio Rs3999"; }
                    else { System.out.println("Invalid Plan"); continue; }
                    break;

                case "airtel":
                    System.out.println("(1) Rs299 : 1.5GB/day, 28 Days");
                    System.out.println("(2) Rs839 : 2GB/day, 84 Days");
                    System.out.println("(3) Rs3999 : 2.5GB/day, 365 Days");
                    int a = sc.nextInt();

                    if (a == 1) { price = 299; plan = "Airtel Rs299"; }
                    else if (a == 2) { price = 839; plan = "Airtel Rs839"; }
                    else if (a == 3) { price = 3999; plan = "Airtel Rs3999"; }
                    else { System.out.println("Invalid Plan"); continue; }
                    break;

                case "vi":
                    System.out.println("(1) Rs299 : 1.5GB/day, 28 Days");
                    System.out.println("(2) Rs719 : 1.5GB/day, 84 Days");
                    System.out.println("(3) Rs3099 : 1.5GB/day, 365 Days");
                    int v = sc.nextInt();

                    if (v == 1) { price = 299; plan = "Vi Rs299"; }
                    else if (v == 2) { price = 719; plan = "Vi Rs719"; }
                    else if (v == 3) { price = 3099; plan = "Vi Rs3099"; }
                    else { System.out.println("Invalid Plan"); continue; }
                    break;

                case "bsnl":
                    System.out.println("(1) Rs251 : 2GB/day, 28 Days");
                    System.out.println("(2) Rs797 : 2GB/day, 84 Days");
                    System.out.println("(3) Rs2799 : 3GB/day, 365 Days");
                    int b = sc.nextInt();

                    if (b == 1) { price = 251; plan = "BSNL Rs251"; }
                    else if (b == 2) { price = 797; plan = "BSNL Rs797"; }
                    else if (b == 3) { price = 2799; plan = "BSNL Rs2799"; }
                    else { System.out.println("Invalid Plan"); continue; }
                    break;

                default:
                    System.out.println("Invalid Operator");
                    continue;
            }

            // Balance check and recharge
            if (price > Amount) {
                System.out.println("Insufficient Balance");
            } else {
                Amount -= price;
                System.out.println("Recharge Successful: " + plan);
                System.out.println("Remaining Balance: Rs" + Amount);
            }
        }

        // Final message
        System.out.println("Recharge session ended. Final Balance: Rs" + Amount);
    }
}
