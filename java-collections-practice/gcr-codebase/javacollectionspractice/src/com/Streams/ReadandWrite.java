package com.Streams;

import java.io.*;

public class ReadandWrite {

    public static void main(String[] args) {

        File source = new File("name.txt");
        File destination = new File("destination.txt");

        try {

            if (!source.exists()) {
                System.out.println("Source file does not exist.");
                return;
            }

            FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(destination);

            int ch;

            while ((ch = fis.read()) != -1) {
                fos.write(ch);
            }

            fis.close();
            fos.close();

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
