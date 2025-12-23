import java.util.Scanner;

class CheckAnagramOrNot{
	// method to check anagram 
    static boolean isAnagram(String str1, String str2) {
		if(str1.length() != str2.length()) return false;
        int[] freq1 = new int[256];
		int[] freq2 = new int[256];
		
		for(char ch : str1.toCharArray()) freq1[ch]++;
		for(char ch : str2.toCharArray()) freq2[ch]++;

        int index = 0;
		for(int i = 0; i < 256; i++){
			if(freq1[i] != freq2[i]) return false;
		}
        return true;
    }

    public static void main(String[] args){
		// creating scanner class object and taking input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter strings : ");
        String str1 = sc.next();
		String str2 = sc.next();
		
		// calling fucntion and printing results
		System.out.println(isAnagram(str1, str2));
    }
}