import java.util.*;

public class NonRepeatingCharacte{

    // find first non repeating character and reutrn
    public static char getFirstNonRepeating(String s) {
		int n = s.length();
        int[] freq = new int[256];
        for (int i = 0; i < n; i++) freq[s.charAt(i)]++;
        for (int i = 0; i < n; i++) {
            if (freq[s.charAt(i)] == 1){
                return s.charAt(i);
			}
        }
        return '1';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        String s = sc.next();

        char result = getFirstNonRepeating(s);
        System.out.println("First non repeating character is: " + result);
    }
}