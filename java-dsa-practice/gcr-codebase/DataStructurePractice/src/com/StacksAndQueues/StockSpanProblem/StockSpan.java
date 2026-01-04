package com.StacksAndQueues.StockSpanProblem;

import java.util.*;
public class StockSpan {
	
	    public static void main(String[] args) {

	        int[] price = {100, 80, 60, 70, 60, 75, 85};
	        int n = price.length;
	        int[] span = new int[n];

	        Stack<Integer> st = new Stack<>();

	        for (int i = 0; i < n; i++) {

	            while (!st.isEmpty() && price[st.peek()] <= price[i])
	                st.pop();

	            if (st.isEmpty())
	                span[i] = i + 1;
	            else
	                span[i] = i - st.peek();

	            st.push(i);
	        }

	        for (int x : span)
	            System.out.print(x + " ");
	    }
	

}
