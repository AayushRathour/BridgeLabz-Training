import java.util.*;

public class HandshakesAmongStudents{
	public static int NumberOfStu(int n){
		return(n * (n - 1) / 2);
	}
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number of Student : ");
		int n = sc.nextInt();
		
		int result  = NumberOfStu(n);
		System.out.println("Possible Number of Hand Shake : "+ result);
		
		
	
		
	}
}