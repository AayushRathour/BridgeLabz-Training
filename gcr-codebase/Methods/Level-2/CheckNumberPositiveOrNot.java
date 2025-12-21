import java.util.*;

public class CheckNumberPositiveOrNot{
    // check positive number
    public static boolean positive(int n){
        return n > 0;
    }
	
	// compare two numbers
    public static int compare(int n1,int n2){
        if(n1 > n2) return 1;
        if(n1 < n2) return -1;
        return 0;
    }
	
    // check even number
    public static boolean even(int n){
        return n % 2 == 0;
    }
    public static void main(String[] args){
		// creting scanner class object and taking input
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for(int i = 0; i < 5; i++){
			System.out.print("Enter number : ");
            arr[i] = sc.nextInt();
        }
		
		// calling function and printing output
		for(int i = 0; i < 5; i++){
			if(positive(arr[i])){
				if(even(arr[i])) System.out.println("Positive Even");
				else System.out.println("Positive Odd");
            }
			else System.out.println("Negative");
		}
		
        // comparing the last and first digit and printing output
        int result = compare(arr[0],arr[4]);
        if(result == 0) System.out.println("First and Last are Equal");
        else if(result > 0) System.out.println("First is Greater");
        else System.out.println("First is Smaller");
		
		sc.close();
    }
}