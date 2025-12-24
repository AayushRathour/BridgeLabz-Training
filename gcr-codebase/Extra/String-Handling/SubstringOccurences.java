import java.util.*;

public class SubstringOccurences{
    public static void main(String[] args) {
		// creating scanner object and taking input
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter string : ");
		String str = sc.nextLine();
		System.out.print("Enter substring : ");
		String subStr = sc.nextLine();
		int n = str.length();
		int m = subStr.length();
		int result = 0;
		
		// using for loop to traverse and match the substring
		for(int i = 0; i < n-m+1; i++){
			if(subStr.equals(s.substring(i, i+m))) result++;
		}
		System.out.println("The occurance of " + subStr + " is " + result);
    }
}






















