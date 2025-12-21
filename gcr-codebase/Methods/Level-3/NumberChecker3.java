import java.util.*;

class NumberChecker3 {

    // return the count of the digits
    public static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    // return an array of digits
    public static int[] getDigitsArray(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    // return the reverse of array
    public static int[] reverseTheDigit(int[] arr) {
        int[] reverse = new int[arr.length];
        int index = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            reverse[index++] = arr[i];
        }
        return reverse;
    }

    // return the comparison of two arrays
    public static boolean compareTwoArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // check whether number is palindrome or not
    public static boolean palindromeCheck(int number) {
        int[] digits = getDigitsArray(number);
        int[] reverse = reverseTheDigit(digits);
        return compareTwoArrays(digits, reverse);
    }

    // check whether number is duck number or not
    public static boolean duckNumber(int number) {
        int[] digits = getDigitsArray(number);

        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int num = 12321;

        System.out.println("Count: " + countDigits(num));
        System.out.println("Digits: " + Arrays.toString(getDigitsArray(num)));
        System.out.println("Reverse: " + Arrays.toString(reverseTheDigit(getDigitsArray(num))));
        System.out.println("Palindrome: " + palindromeCheck(num));
        System.out.println("Duck Number: " + duckNumber(num));
    }
}
