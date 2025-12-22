import java.util.*;

public class ArgumentException{
	// Created method to generate illegal argument exception
	public static void generateException(String str) throws IllegalArgumentException{
		str.substring(str.length()+110);
	}
	
	public static void main(String[] args){
		// creating scanner object and taking input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string : ");
		String txt = sc.next();
		
		try{
			generateException(txt);
		}
		catch(IllegalArgumentException e){
			System.out.println("Exception Handeled");
			e.printStackTrace();
		}
	}
}