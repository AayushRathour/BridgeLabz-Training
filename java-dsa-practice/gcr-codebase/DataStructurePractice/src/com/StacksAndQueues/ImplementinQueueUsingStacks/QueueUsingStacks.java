package com.StacksAndQueues.ImplementinQueueUsingStacks;

import java.util.*;
public class QueueUsingStacks {
	
	    Stack<Integer> s1 = new Stack<>();
	    Stack<Integer> s2 = new Stack<>();

	    // enqueue operation
	    void enqueue(int x) {
	        s1.push(x);
	    }

	    // dequeue operation
	    int dequeue() {

	        if (s2.isEmpty()) {
	            while (!s1.isEmpty())
	                s2.push(s1.pop());
	        }

	        if (s2.isEmpty())
	            return -1;

	        return s2.pop();
	    }
	

}
