import java.util.Scanner;

public class GuessingNumber{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int lo = 0;
		int hi = 100;
		
		while(true){
			int mid = (lo + hi)/2;
			System.out.println("Is the number : " + mid);
			System.out.println("If number is equal enter 0, if number is gussed number is smaller enter -1 else enter 1");
			int n = sc.nextInt();
			if(n == 0) break;
			if(n == -1) lo = mid+1;
			else hi = mid-1;
		}
	}
}