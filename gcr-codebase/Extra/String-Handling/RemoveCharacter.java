import java.util.*;

public class RemoveCharacter{
    public static void main(String[] args) {
		// creating scanner object and taking input from user
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter text : ");
		String str = sc.next();
		System.out.print("Enter char to remove : ");
		char toRemove = sc.next().charAt(0);
		String result = "";
		
		// using for loop to iterate and remove char
		for(char ch : str.toCharArray()){
			if(ch != toRemove) result += ch;
		}
		// printed and close the scanner
		System.out.println("The Final String will be " + result);
		sc.close();
    }
}