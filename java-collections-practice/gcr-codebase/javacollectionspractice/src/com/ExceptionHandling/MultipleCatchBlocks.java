package com.ExceptionHandling;

public class MultipleCatchBlocks {
	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5,6,4,2};
		int[] arr2 = null;
		
		try {
			System.out.println(arr1[51]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(arr2[0]);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}