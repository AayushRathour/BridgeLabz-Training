import java.util.*;

public class AnagramCheck{
    public static void main(String[] args) {
		// creating scanner object and taking input
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter string 1 : ");
		String str1 = sc.next();
		System.out.print("Enter string 2 : ");
		String str2 = sc.next();
		int[] freq1 = new int[256];
		int[] freq2 = new int[256];
		boolean isAnagram = true;
		
		// using for loop to iterate and count frequency
		for(char ch : str1.toCharArray()){
			freq1[ch]++;
		}
		for(char ch : str2.toCharArray()){
			freq2[ch]++;
		}
		
		// comparing the frequency
		for(int i = 0; i < 256; i++){
			if(freq1[i] != freq2[i]){
				isAnagram = false;
				break;
			}
		}
		if(isAnagram) System.out.println("The strings are anagram");
		else System.out.println("The strings are not anagram");
		sc.close();
    }
}