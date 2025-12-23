import java.util.*;

public class VowelAndConsonants {

    public static String counting(String str) {
        int vowel = 0;
        int consonant = 0;

        str = str.toLowerCase();

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Text");
        String str = sc.nextLine();

        System.out.println(counting(str));
    }
}
