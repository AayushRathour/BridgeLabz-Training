import java.util.*;

public class ArrayIndexException{
	//Created  method to generate array index out of bound
	public static void generateException(String[] names) throws ArrayIndexOutOfBoundsException{
		String str = names[names.length];
	}
	
	public static void main(String[] args){
		// creating scanner object and taking input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of array : ");
		int n = sc.nextInt();
		String[] names = new String[n];
		System.out.print("Enter names : ");
		for(int i = 0; i < n; i++) names[i] = sc.next();
		
		try{
			generateException(names);
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Exception Handeled");
			e.printStackTrace();
		}
		sc.close();
	}
}