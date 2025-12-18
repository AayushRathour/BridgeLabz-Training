import java.util.Scanner;

public class Calculator{
    static public void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking the first no as input 
		System.out.println("Enter the First Number");
        int number1 = sc.nextInt();
		
		// Taking the Second no as input 
		System.out.println("Enter the second Number");
        int number2 = sc.nextInt();

		// Adding the 2 Numbers
        int add = number1+number2;
		
		// Substracting the 2 Numbers
		int Subs = number1-number2;
		
		// Multiplication of the 2 Numbers
		int Multi = number1*number2;
		
		// Division of the 2 Numbers
		int Div = number1/number2;
		

        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers : "+number1+" and : "+ number2 +"is "+add+","+Subs +","+Multi+" and"+Div);
    }
}
