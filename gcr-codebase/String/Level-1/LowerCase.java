import java.util.*;

public class LowerCase{
	// Created method to compare strings using the charAt method 
	public static boolean compareStrings(String s1, String s2){
		int n = s1.length();
		int m = s2.length();
		
		// check if size is unequal
		if(n != m) return false;

		for(int i = 0; i < n; i++){
			if(s1.charAt(i) != s2.charAt(i)) return false;
		}
		return true;
	}
	
	// return the string with all character in lower case
	private static String toLowerCase(String s){
		String result = "";
		
		for(int i = 0; i < s.length(); i++){
			int ch = s.charAt(i);
			if(ch < 97) ch += 32;
			result += (char)ch;
		}
		return result;
	}
	
	public static void main(String[] args){
		// creating scanner object and taking input from user printing the results 
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string : ");
		String s = sc.next();
		
		if(compareStrings(toLowerCase(s), s.toLowerCase())) System.out.println("Output is same, and the resultant string is " + (s.toLowerCase()));
		else System.out.println("Output is diffrent");
		
		//Closing Scanner
		sc.close();
	}
}