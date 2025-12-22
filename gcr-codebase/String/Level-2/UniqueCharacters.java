import java.util.*;

public class UniqueCharacters{

    // created a method to find length
    static int getLength(String s) {
        int index1 = 0;
        try {
            while(true) {
                s.charAt(index1);
                index1++;
            }
        } 
		catch (Exception e) {
            return index1;
        }
    }

    // method to return character of unique characters
    public static char[] getUnique(String s) {
        int len = getLength(s);
        char[] curr = new char[len];
        int index = 0;

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            boolean isPresent = false;
            for (int j = 0; j < i; j++) {
                if (ch == s.charAt(j)) {
                    isPresent = true;
                    break;
                }
            }
            if (!isPresent) {
                curr[index++] = ch;
            }
        }
        char[] result = new char[index];
        for (int i = 0; i < index; i++) result[i] = curr[i];
        return result;
    }

    public static void main(String[] args) {
		// creating scanner object and taking input from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = sc.next();

        char[] result = getUnique(s);
        System.out.println(Arrays.toString(result));
    }
}