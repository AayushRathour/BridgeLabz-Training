package com.SearchingAlgorithm.LinearSearch;

public class FindNegative{
	public static void main(String[] args) {
		int[] arr = {1, 1, 3, 6, -1, 4};
		int result = -1;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] < 0) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
}