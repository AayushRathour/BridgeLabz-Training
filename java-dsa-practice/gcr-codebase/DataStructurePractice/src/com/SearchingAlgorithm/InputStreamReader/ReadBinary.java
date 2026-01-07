package com.SearchingAlgorithm.InputStreamReader;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReadBinary {
    public static void main(String[] args) {
        try {
        	FileInputStream fis = new FileInputStream("input.txt");
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}