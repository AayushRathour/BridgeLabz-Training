import java.util.*;

public class DisplayCharacterType{
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
	
	// return the 2d array of letter
	public static String[][] getGrid(String s){
		int n = s.length();
		String[][] result = new String[n][2];
		for(int i = 0; i < n; i++){
			result[i][0] = "" + s.charAt(i);
			String curr = checkLetter(s.charAt(i));
			if(curr.equals("Vowel")) result[i][1] = "Vowel";
			else if(curr.equals("Consonent")) result[i][1] = "Consonent";
			else result[i][1] = "Not a letter";
		}
		return result;
	}
	
	// print the character and weather it is a vowel or character
	public static void display(String[][] grid){
		for(String[] s : grid){
			System.out.println(s[0] + " " + s[1]);
		}
	}
	
	public static void main(String[] args){
		// creating scanner object and taking input print the result 
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string : ");
		String s = sc.nextLine().trim();
		
		String[][] grid = getGrid(s);
		display(grid);
		
		sc.close();
	}
}