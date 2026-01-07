package com.SearchingAlgorithm.StringBuffer;

import java.util.*;

public class ConcatenateStrings {
    public static void main(String[] args) {

        String[] Aayush = {"Hello", " ", "World", " ", "Java"};

        StringBuffer Rathour = new StringBuffer();

        for (int i = 0; i < Aayush.length; i++) {
            Rathour.append(Aayush[i]);
        }

        System.out.println(Rathour.toString());
    }
}
