package com.HashMapsAndHashFunctions.AllSubarrayswithZeroSum;

import java.util.*;
public class AllSubarrayswithZeroSum {

	    public static void main(String[] args) {

	        int[] arr = {3, 4, -7, 1, 3, -4, -2, -2};
	        int sum = 0;

	        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	        map.put(0, new ArrayList<>(Arrays.asList(-1)));

	        for (int i = 0; i < arr.length; i++) {

	            sum += arr[i];

	            if (map.containsKey(sum)) {
	                for (int idx : map.get(sum))
	                    System.out.println("Subarray : " + (idx + 1) + " to " + i);
	            }

	            map.putIfAbsent(sum, new ArrayList<>());
	            map.get(sum).add(i);
	        }
	    }

}
