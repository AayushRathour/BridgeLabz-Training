import java.util.*;

public class BasicCalculator{
	public static void add(int n1, int n2){
		System.out.println(n1 + n2);
	}
	
	public static void substract(int n1, int n2){
		System.out.println(n1 - n2);
	}
	
	public static void divide(int n1, int n2){
		System.out.println(n1 / n2);
	}
	
	public static void multiply(int n1, int n2){
		System.out.println(n1 * n2);
	}
	
	public static void main(String[] args){
		// creating scanner class object and taking input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter two numbers : ");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		System.out.print("Enter operator add/substract/multiply/divide : ");
		String ope = sc.next();
		
		switch(ope){
			case("add") : 
				add(n1, n2);
				break;
			case("substract") : 
				substract(n1, n2);
				break;
			case("dividie") : 
				divide(n1, n2);
				break;
			case("multiply") : 
				multiply(n1, n2);
				break;
			default : System.out.println("Enter valid operation among add/substract/multiply/divide");
		}
		
		sc.close();
	}
}