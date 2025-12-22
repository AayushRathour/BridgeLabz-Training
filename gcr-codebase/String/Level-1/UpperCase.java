import java.util.*;

public class UpperCase{
	// Created method to compare strings using the charAt method 
	private static boolean compareStrings(String s1, String s2){
		int a = s1.length();
		int b = s2.length();
		
		// check if size is unequal
		if(a != b) return false;
		
		// using charAt to check equality
		for(int i = 0; i < a; i++){
			if(s1.charAt(i) != s2.charAt(i)) return false;
		}
		return true;
	}
	
	// returning the string with all character in upper case
	private static String toUpperCase(String s){
		String result = "";
		
		for(int i = 0; i < s.length(); i++){
			int ch = s.charAt(i);
			if(ch >= 97) ch -= 32;
			result += (char)ch;
		}
		return result;
	}
	public static void main(String[] args){
		// creating scanner object and taking input from user 
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string : ");
		String s = sc.next();
		
		// calling method and printing the result
		if(compareStrings(toUpperCase(s), s.toUpperCase())) System.out.println("Output is same, and the resultant string is " + (s.toUpperCase()));
		else System.out.println("Output is diffrent");
		
		
		// Closing Scanner
		sc.close();
	}
}