package com;

import java.util.*;
import java.io.*;
public class DatatoCSV {
	public static void main(String[] args)throws Exception {
		FileWriter fw = new FileWriter("New.csv");
	    fw.write("ID,Name,RollNo\n");
        fw.write("1,Aayush,001\n");
        fw.write("2,Rahul,002\n");
        fw.close();
	}
	
}
