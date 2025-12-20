import java.util.*;

public class SimpleIntrest{
	public static double CalSI(double principal, double rate, double time){
		 return(principal * rate * time / 100);
	}
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Principal Amount : ");
		double principal= sc.nextDouble();
		System.out.println("Enter the Rate of Intrest : ");
		double rate = sc.nextDouble();
		System.out.println("Enter the Time in Year: ");
		double time = sc.nextDouble();
		
		double si = CalSI(principal, rate, time);
		System.out.println("Simple Intrest is : "+ si);
		
		
	
		
	}
}