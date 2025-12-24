import java.util.*;

public class VowelAndConsonants{
// Created a method 
    public static String counting(String str) {
        int vowel = 0;
        int consonant = 0;

        str = str.toLowerCase();
// Used Loop for 
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowel++;
                } else {
                    consonant++;
                }
            }
        }

        return "Vowels = " + vowel + ", Consonants = " + consonant;
    }
// creating scanner object and taking input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Text");
        String str = sc.nextLine();
// printing the output 
        System.out.println(counting(str));
    }
}
