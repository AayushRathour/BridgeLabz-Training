import java.util.*;

public class RemoveDuplicates{
    public static void main(String[] args) {
		// creating scanner object and taking input from the user
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Text  : ");
		String s = sc.next();
		
		// useing an array to check and creating a new string with no duplicates
		boolean[] isPresent = new boolean[256];
		String result = "";
		for(char ch : s.toCharArray()){
			if(!isPresent[ch]){
				isPresent[ch] = true;
				result += ch;
			}
		}
		System.out.println("String without duplicates : " + result);
    }
}