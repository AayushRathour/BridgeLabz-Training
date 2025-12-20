import java.util.*;

class EvenOrOdd{
	public static int NumberCheck(int n){
		if (n==0){
			return 0;
		}
		else if (n>0){
			return 1;
		}
		return -1;
	}
	public static void main(String[] args ){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number : ");
		int n = sc.nextInt();
		
		
		int result = NumberCheck(n);
		System.out.println(result);
		
	}
}