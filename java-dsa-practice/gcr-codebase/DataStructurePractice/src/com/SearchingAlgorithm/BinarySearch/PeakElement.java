package com.SearchingAlgorithm.BinarySearch;

public class PeakElement {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 2, 4};
		int n = arr.length;
	    int left = 0;
	    int right = n - 1;
	    int result = -1;

	    while (left <= right) {
	    	int mid = left + (right - left) / 2;

	        if ((mid == 0) || (arr[mid] > arr[mid - 1]) && (mid == n - 1) || (arr[mid] > arr[mid + 1])) {
	            result = mid;
	            break;
	        }

	        if (mid > 0 && arr[mid] < arr[mid - 1]) right = mid - 1;
	        else left = mid + 1;
	    }
	    System.out.println(result);
	}
}