package com.HashMapsAndHashFunctions.TwoSumProblem;

import java.util.*;
public class TwoSumProblem {
	

	public class Main {
	    public static void main(String[] args) {

	        int[] arr = {2, 7, 11, 15};
	        int target = 9;

	        HashMap<Integer, Integer> map = new HashMap<>();

	        for (int i = 0; i < arr.length; i++) {
	            if (map.containsKey(target - arr[i])) {
	                System.out.println(map.get(target - arr[i]) + " " + i);
	                return;
	            }
	            map.put(arr[i], i);
	        }
	    }
	}

}
