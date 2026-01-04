package com.StacksAndQueues.SlidingWindowMaximum;

import java.util.*;
public class SlidingWindow {

	    public static void main(String[] args) {

	        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
	        int k = 3;
	        int n = arr.length;

	        Deque<Integer> dq = new ArrayDeque<>();

	        for (int i = 0; i < n; i++) {

	            if (!dq.isEmpty() && dq.peekFirst() <= i - k)
	                dq.pollFirst();

	            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i])
	                dq.pollLast();

	            dq.offerLast(i);

	            if (i >= k - 1)
	                System.out.print(arr[dq.peekFirst()] + " ");
	        }
	    
	}

}
