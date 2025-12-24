import java.util.*;

public class LongestWord{
// returning the word
    static String find(String str) {
        String[] a = str.split(" ");
        String max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i].length() > max.length()) {
                max = a[i];
            }
        }
        return max;
    }
// Created Scanner object to take input from user
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Text : ");
        String str = sc.nextLine();

        System.out.println(find(str));
    }
}
