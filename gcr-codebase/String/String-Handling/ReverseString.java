import java.util.*;

public class ReverseString{

    // creating scanner object and taking input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Text :");
        String str = sc.nextLine();
		String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }
		// printing the output
        System.out.println(reverse);
    }
}
