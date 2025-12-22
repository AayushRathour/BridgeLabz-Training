import java.util.*;

public class StringIndexOutOfBoundsException{
	//created method to generate index out of bound exception
	public static void generateException(String str) throws IndexOutOfBoundsException{
		str.charAt(str.length());
	}
	
	public static void main(String[] args){
		// creating scanner object and taking input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string : ");
		String txt = sc.next();
		
		// using try catch to handle exception
		try{
			generateException(txt);
		}
		catch(IndexOutOfBoundsException a){
			System.out.println("Exception Handeled");
			a.printStackTrace();
		}
	}
}