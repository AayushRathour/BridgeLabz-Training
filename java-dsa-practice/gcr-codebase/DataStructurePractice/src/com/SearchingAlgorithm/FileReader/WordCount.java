package com.SearchingAlgorithm.FileReader;

import java.io.*;

public class WordCount {
    public static void main(String[] args) {
        String targetWord = "java";
        int count = 0;

        try{
        	BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String line;
            while ((line = br.readLine()) != null) {

                // Split line into words
                String[] words = line.split(" ");

                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) count++;
                }
            }

            System.out.println(targetWord + " " + count);

        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}