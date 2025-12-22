import java.util.*; 

public class CompareTwoString{

    // Created method to compare two strings character 
    public static boolean compare(String str1, String str2) {

        // Store length of string
        int a = str1.length();
        int b = str2.length();

        if (a != b) return false;

        // Loop through each character of the strings
        for (int i = 0; i < a; i++) {

            // Compare characters at the same index
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }

    
        return true;
    }

    public static void main(String[] args) {

        // Creating Scanner object to take input from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first String value : ");
        String str1 = sc.next();
        System.out.println("Enter the Second String value : ");
        String str2 = sc.next();

        // Calling custom compare method to check equality
        if (compare(str1, str2)) {
            System.out.println("Output is Same");

        } else {
            System.out.println("Output is Different");
        }
    }
}
