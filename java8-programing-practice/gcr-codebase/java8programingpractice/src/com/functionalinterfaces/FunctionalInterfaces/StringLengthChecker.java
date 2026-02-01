package com.functionalinterfaces.FunctionalInterfaces;

import java.util.function.Function;

public class StringLengthChecker {
    public static void main(String[] args) {

        String message = "Welcome to Java 8";
        int limit = 10;

        Function<String, Integer> lengthFinder = s -> s.length();

        if(lengthFinder.apply(message) > limit) {
            System.out.println("Message exceeds limit");
        } else {
            System.out.println("Message within limit");
        }
    }
}
