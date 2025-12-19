import java.util.*;

public class ProgramForCalculatorUsingSwitchCase{
	public static void main(String[] args) {
		
		// Creating Scanner object and taking input
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number : ");
        double first = sc.nextDouble();
		System.out.print("Enter second number : ");
        double second = sc.nextDouble();
		System.out.print("Enter operator : ");
        String op = sc.next();

        // using switch case to calculate and print output
        switch (op) {
            case "+":
                System.out.println("Result: " + (first + second));
                break;
            case "-":
                System.out.println("Result: " + (first - second));
                break;
            case "*":
                System.out.println("Result: " + (first * second));
                break;
            case "/":
                System.out.println("Result: " + (first / second));
                break;
            default:
                System.out.println("Invalid Operator");

		// Closed Scanner 
        sc.close();
    }
}
}