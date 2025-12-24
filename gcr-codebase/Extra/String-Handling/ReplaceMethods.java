import java.util.*;

public class ReplaceMethods{
    public static void main(String[] args) {
		// creating scanner object and taking input from user
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter string : ");
		String s = sc.nextLine();
		System.out.print("Enter word to remove : ");
		String remove = sc.next();
		System.out.print("Enter new word : ");
		String newWord = sc.next();
		String result = "";
		
		// using split to split in word and the creating result
		for(String str : s.split(" ")){
			if(!str.equals(remove)) result += " " + str;
			else result += " " + newWord;
		}
		// Printing and after closing the scanner
		System.out.println("The resultatn string is " + result);
		sc.close();
    }
}