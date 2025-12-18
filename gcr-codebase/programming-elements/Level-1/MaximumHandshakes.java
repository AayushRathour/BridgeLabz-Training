import java.util.Scanner;

public class MaximumHandshakes{
	public static void main(String[] args){
		
		// creating object of scanner taking taking input from user
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of students : ");
		int students = sc.nextInt();
		
		
		//find total number of handshakes
		double handshakes = students * (students - 1 ) / 2; 
	
		// printing the output
		System.out.printf( "The number of possible handshakes are " + handshakes);
	}
}