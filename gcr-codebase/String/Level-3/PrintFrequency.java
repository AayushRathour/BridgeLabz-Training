import java.util.*;

public class PrintFrequency{
	// return unique characters
    static char[] getChars(String s){
		int n = s.length();
        char[] temp = new char[n];
        int count = 0;

        for (int i = 0; i < n; i++){
            char ch = s.charAt(i);
            boolean isPresent = false;
			
            for (int j = 0; j < i; j++){
                if (s.charAt(j) == ch){
                    isPresent = true;
                    break;
                }
            }
            if (!isPresent) temp[count++] = ch;
        }

        char[] result = new char[count];
        for (int i = 0; i < count; i++){
            result[i] = temp[i];
        }
        return result;
    }
	
	// reutrn a 2d array of char and its freq
    static String[][] getFreq(String s){
		int n = s.length();
        int[] freq = new int[256];

        for (int i = 0; i < n; i++){
            char ch = s.charAt(i);
            freq[ch]++;
        }

        char[] unique = getChars(s);
		int m = unique.length;
        String[][] result = new String[m][2];

        for (int i = 0; i < m; i++){
            char ch = unique[i];
            result[i][0] = "" + ch;
            result[i][1] = "" + freq[ch];
        }
        return result;
    }

    public static void main(String[] args){
		//Creating scanner class object and taking object and printing the results 
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        String s = sc.next();

	
        String[][] result = getFreq(s);
        for (String[] curr : result){
            System.out.println(curr[0] + " " + curr[1]);
        }
		sc.close();
    }
}