import java.util.*; 

public class SubstringCreation{
	//used method to compare strings using the charAt method 
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
	
	// method to get substring using the charAt method
	private static String getSubstring(int st, int end, String s){
		String result = "";
		for(int i = st; i < end; i++){
			result += s.charAt(i);
		}
		return result;
	}
	
	public static void main(String[] args){
		// creating scanner object and taking input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter strings : ");
		String str = sc.next();
		System.out.print("Enter start and end index : ");
		int st = sc.nextInt();
		int end = sc.nextInt();
		
		// calling method and printing result
		String resSubstr = getSubstring(st, end, str);
		if(compareStrings(str.substring(st, end), resSubstr)) System.out.println("Output is same" + ", the substring is " + resSubstr);
		else System.out.println("Output is diffrent");
		
		sc.close();
	}
}