import java.util.*;

public class CharFrequencyUniqueChar{

// Created Method to find unique characters using nested loops
    public static char[] getUnique(String strt) {
        int n = strt.length();
        char[] arr = new char[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            char ch = strt.charAt(i);
            boolean isPresent = false;
// Inner loop to check previous characters
            for (int j = 0; j < i; j++) {
                if (strt.charAt(j) == ch) {
                    isPresent = true;
                    break;
                }
            }

            if (!isPresent) {
                arr[count++] = ch;
            }
        }

        char[] result = new char[count];
        for (int i = 0; i < count; i++)
            result[i] = arr[i];

        return result;
    }
 // method to return 2d array with char and frequency
    public static String[][] getGrid(String strt){
        int[] freq = new int[256];
        char[] unique = getUnique(strt);

        for (int i = 0; i < strt.length(); i++) {
            freq[strt.charAt(i)]++;
        }

        int n = unique.length;
        String[][] result = new String[n][2];

        for (int i = 0; i < n; i++) {
            char ch = unique[i];
            result[i][0] = "" + ch;
            result[i][1] = "" + freq[ch];
        }

        return result;
    }

    public static void main(String[] args) {
		// creating scanner object and taking input from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String : ");
        String strt = sc.next();

        String[][] arr = getGrid(strt);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
