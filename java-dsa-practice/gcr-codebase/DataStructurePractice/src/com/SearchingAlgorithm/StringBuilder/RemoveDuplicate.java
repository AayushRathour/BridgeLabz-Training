package com.SearchingAlgorithm.StringBuilder;

import java.util.*;

public class RemoveDuplicate{
    public static void main(String[] args) {
        String input = "programming";

        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!set.contains(ch)) {
                set.add(ch);
                sb.append(ch);
            }
        }

        System.out.println(sb.toString());
    }
}
