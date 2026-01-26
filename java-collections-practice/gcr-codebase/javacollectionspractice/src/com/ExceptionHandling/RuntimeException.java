package com.ExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RuntimeException {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		try {
			
			System.out.println("Enter the 1st Number");
			int n1 = sc.nextInt();
			System.out.println("Enter the 2st Number");
			int n2 = sc.nextInt();
			int ans = n1/n2;
			System.out.println("the ans is " + ans);

			
		}
		catch(ArithmeticException e1){
				System.out.println("Coudntt divide by  " + e1.getMessage());
				e1.printStackTrace();
			}
		catch(InputMismatchException e2) {
			System.out.println("Coudnt Do this " + e2.getMessage());
			e2.printStackTrace();
		}
		finally {
			sc.close();
		}
			
	}
}
