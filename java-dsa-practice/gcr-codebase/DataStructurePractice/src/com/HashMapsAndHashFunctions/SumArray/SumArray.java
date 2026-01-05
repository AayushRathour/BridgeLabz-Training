package com.HashMapsAndHashFunctions.SumArray;

import java.util.*;
public class SumArray {
	
	    public static void main(String[] args) {

	        int[] arr = {8, 7, 2, 5, 3, 1};
	        int target = 10;

	        HashSet<Integer> set = new HashSet<>();

	        for (int x : arr) {
	            if (set.contains(target - x)) {
	                System.out.println("Pair Found");
	                return;
	            }
	            set.add(x);
	        }

	        System.out.println("No Pair Found");
	    }
	

}
