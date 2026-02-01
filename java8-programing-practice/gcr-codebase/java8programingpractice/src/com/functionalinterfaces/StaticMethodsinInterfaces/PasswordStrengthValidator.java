package com.functionalinterfaces.StaticMethodsinInterfaces;

interface SecurityUtils {

    static boolean isStrongPassword(String password) {

        if(password.length() < 8)
            return false;

        boolean hasUpper = false;
        boolean hasDigit = false;

        for(int i=0;i<password.length();i++){
            char ch = password.charAt(i);

            if(Character.isUpperCase(ch))
                hasUpper = true;

            if(Character.isDigit(ch))
                hasDigit = true;
        }

        return hasUpper && hasDigit;
    }
}

public class PasswordStrengthValidator {
    public static void main(String[] args) {

        String pwd = "Admin123";

        if(SecurityUtils.isStrongPassword(pwd))
            System.out.println("Strong Password");
        else
            System.out.println("Weak Password");
    }
}
