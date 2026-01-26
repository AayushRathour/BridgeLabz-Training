package com.ExceptionHandling;


import java.util.*;
import java.util.Scanner;


public class CustomException {
	private static void validateAge(int age) throws InvalidAgeException{
		if(age < 18) throw new InvalidAgeException("Age must be 18 or above");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("Enter you age : ");
			int age = sc.nextInt();
			validateAge(age);
		}
		catch (InvalidAgeException e) {
			System.out.println(e.getMessage());
		}
		finally {
			sc.close();
		}
	}
}