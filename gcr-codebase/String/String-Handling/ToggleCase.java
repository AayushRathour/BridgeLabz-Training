import java.util.*;

public class ToggleCase{
    public static void main(String[] args) {
		// creating scanner object and taking input from user
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter string : ");
		String str = sc.nextLine();
		String ans = "";
		
		// used for loop to iterate and finding
		for(char ch : str.toCharArray()){
			if(ch < 97) ch += 32;
			else ch -= 32;
			ans += (char)ch;
		}
		System.out.println("The resultant string " + ans);
    }
}
