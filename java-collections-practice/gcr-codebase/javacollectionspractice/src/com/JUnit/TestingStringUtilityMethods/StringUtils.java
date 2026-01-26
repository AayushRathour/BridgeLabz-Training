package com.JUnit.TestingStringUtilityMethods;

public class StringUtils {

    public String reverse(String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
        return rev;
    }

    public boolean isPalindrome(String str) {
        String rev = reverse(str);
        return str.equals(rev);
    }

    public String toUpperCase(String str) {
        return str.toUpperCase();
    }
}
