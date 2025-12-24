import java.util.*;

public class CompareString{
    public static void main(String[] args) {
		// creating scanner object and taking input from user
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter string 1 : ");
		String str1 = sc.next();
		System.out.print("Enter string 2 : ");
		String str2 = sc.next();
		int n = str1.length();
		int m = str2.length();
		int smallest = n < m ? 0 : 1;
		
		for(int i = 0; i < Math.min(n, m); i++){
			if(str1.charAt(i) < str2.charAt(i)){
				smallest = 0;
				break;
			}
			else if(str1.charAt(i) > str2.charAt(i)){
				smallest = 1;
				break;
			}
		}
		System.out.println("This will come firts : " + (smallest == 0 ? str1 : str2));
		sc.close();
    }
}