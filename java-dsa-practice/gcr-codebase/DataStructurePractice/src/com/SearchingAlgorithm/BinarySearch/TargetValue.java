package com.SearchingAlgorithm.BinarySearch;

public class TargetValue {
	private static boolean searchMatrix(int target, int[][] matrix) {
	    int rows = matrix.length;
	    int cols = matrix[0].length;

	    int left = 0;
	    int right = rows * cols - 1;

	    while (left <= right) {
	        int mid = left + (right - left) / 2;

	        int r = mid / cols;
	        int c = mid % cols;

	        if (matrix[r][c] == target) return true;    
	        else if (matrix[r][c] < target) left = mid + 1; 
	        else right = mid - 1;
	    }
	    return false;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		System.out.println(searchMatrix(5, matrix));
	}
}