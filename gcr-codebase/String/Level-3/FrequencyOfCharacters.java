import java.util.*;

public class CharFrequency{
	// return an array of string
    public static int[] getFrequency(String text) {
		int[] frequency = new int[256];
        for(char ch : text.toCharArray()){
			frequency[(int)ch]++;
		}
		return frequency;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String text = sc.next();
		
		// calling function to pring output
        System.out.println(Arrays.toString(getFrequency(text)));
    }
}