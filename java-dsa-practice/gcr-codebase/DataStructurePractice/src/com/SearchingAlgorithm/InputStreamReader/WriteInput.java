package com.SearchingAlgorithm.InputStreamReader;

import java.io.*;

public class WriteInput {
    public static void main(String[] args) {

        try{
        	InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            FileWriter fw = new FileWriter("output.txt", true);
            
            String input;
            System.out.println("Enter exit to stop : ");

            while (true) {
                input = br.readLine();

                if (input.equalsIgnoreCase("exit")) break;

                fw.write(input);
            }

            System.out.println("Input successfully written to file.");

        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}