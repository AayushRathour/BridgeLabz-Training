package com.ExceptionHandling;
import java.io.*;
import java.util.*;

public class CompiletimeException {
	public static void main(String[] args) {
		File myFile = new File("data.txt");
		try {
			Scanner sc =new Scanner(myFile);
			while(sc.hasNextLine()) {
				String line =sc.nextLine();
				System.out.println(line);
			}
			sc.close();
		}catch(IOException e){
				System.out.println("File Not found");
				e.printStackTrace();
			}
			
	}
}
