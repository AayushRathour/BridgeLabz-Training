import java.util.*;

public class FrequentCharacter{
    public static void main(String[] args) {
		// creating scanner object and taking input from user
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter string : ");
		String str = sc.next();
		int[] freq = new int[256];
		int max = 0;
		char result = 'a';
		
		// used for loop and frequency array to find most frequent array
		for(char ch : str.toCharArray()){
			freq[ch]++;
			if(freq[ch] > max){
				max = freq[ch];
				result = ch;
			}
		}
		// Printing and closing the scanner
		System.out.println("The most frequent char is " + result);
		sc.close();
    }
}