import java.util.*;

class CheckIfPalindrome{
	// method to check palindrom using loop
    static boolean isPalindromeLoop(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
			start++;
			end--;
        }
        return true;
    }

    // method check palindrom using a recusing
    static boolean isPalindromeRecursive(String s, int start, int end){
        if (start >= end) return true;
		
        if (s.charAt(start) != s.charAt(end)) return false;
        return isPalindromeRecursive(s, start+1, end-1);
    }

    // method to reverse string using charAt()
    static char[] reverse(String s){
		int n = s.length();
        char[] result = new char[n];
        int index = 0;

        for (int i = n-1; i >= 0; i--){
            result[index++] = s.charAt(i);
        }
        return result;
    }

    // method to check palindrom using reverse
    static boolean isPalindromeReverse(String s){
        char[] arr1 = s.toCharArray();
        char[] arr2 = reverse(s);

        for (int i = 0; i < arr1.length; i++){
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args){
		// creating scanner class object and taking input from user 
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string : ");
        String s = sc.next();
		
		// calling fucntion and printing the results
		System.out.println(isPalindromeLoop(s) + " " + isPalindromeRecursive(s, 0, s.length()-1) + " " + isPalindromeReverse(s));
    }
}