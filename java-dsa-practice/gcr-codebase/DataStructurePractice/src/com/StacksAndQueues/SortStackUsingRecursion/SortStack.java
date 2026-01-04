package com.StacksAndQueues.SortStackUsingRecursion;

import java.util.*;

public class SortStack {

	    // main recursive sort function
	    static void sort(Stack<Integer> st) {
	        if (st.isEmpty())
	            return;

	        int x = st.pop();
	        sort(st);
	        insert(st, x);
	    }

	    // insert element in sorted position
	    static void insert(Stack<Integer> st, int x) {
	        if (st.isEmpty() || st.peek() <= x) {
	            st.push(x);
	            return;
	        }

	        int temp = st.pop();
	        insert(st, x);
	        st.push(temp);
	    }

}

