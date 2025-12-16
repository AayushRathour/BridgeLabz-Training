import java.util.*;
public class CelciToFah{
	
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the temperature in Celsius to Change");
		int C= sc.nextInt();
		System.out.println((C* 9/5) + 32);
	}
}