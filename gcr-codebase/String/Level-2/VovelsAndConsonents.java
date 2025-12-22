import java.util.*;

public class VovelsAndConsonents{
	// method to check vowel and consonent 
	public static String checkLetter(char ch){
		int ascii = ch;
		
		if(ascii >= 65 && ascii <= 90 || ascii >= 97 && ascii <= 122){
			if(ascii < 97) ascii += 32;
			ch = (char)ascii;
			if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return "Vowel";
			return "Consonent";
		}
		return "Not a letter";
	}
	
	// return the count of vowel and consonet in an array
	public static int[] getCount(String s){
		int vowel = 0;
		int consonent = 0;
		for(int i = 0; i < s.length(); i++){
			String curr = checkLetter(s.charAt(i));
			if(curr.equals("Vowel")) vowel++;
			else if(curr.equals("Consonent")) consonent++;
		}
		return new int[]{vowel, consonent};
	}
	
	public static void main(String[] args){
		// creating scanner object and taking input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string : ");
		String s = sc.nextLine().trim();
		
		// calling method and printing result
		int[] result = getCount(s);
		System.out.println("Vowel : " + result[0] + " Consonent : " + result[1]);
		// closing the Scanner
		sc.close();
	}
}