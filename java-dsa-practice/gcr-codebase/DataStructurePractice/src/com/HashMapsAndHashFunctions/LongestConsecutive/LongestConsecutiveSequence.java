package com.HashMapsAndHashFunctions.LongestConsecutive;

import java.util.*;
public class LongestConsecutiveSequence {

	    public static void main(String[] args) {

	        int[] arr = {100, 4, 200, 1, 3, 2};
	        HashSet<Integer> set = new HashSet<>();

	        for (int x : arr)
	            set.add(x);

	        int longest = 0;

	        for (int x : arr) {

	            // start only if x is the beginning
	            if (!set.contains(x - 1)) {

	                int curr = x;
	                int len = 1;

	                while (set.contains(curr + 1)) {
	                    curr++;
	                    len++;
	                }

	                longest = Math.max(longest, len);
	            }
	        }

	        System.out.println(longest);
	    }
	

}
