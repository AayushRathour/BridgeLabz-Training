import java.util.*;

public class RoundCalculation{
	public static int NumberOfRound(int first,int second, int Third){
		return(5000/(first+ second+ Third));
	}
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first Side : ");
		int first = sc.nextInt();
		System.out.println("Enter the Second Side : ");
		int second = sc.nextInt();
		System.out.println("Enter the Third Side : ");
		int Third = sc.nextInt();
		
		int result  = NumberOfRound(first, second, Third);
		System.out.println("The user need  : "+ result+ "Round ");
		
		
	
		
	}
}