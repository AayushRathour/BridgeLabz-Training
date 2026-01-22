package com.Collections.QueueInterface;

import java.util.*;
public class ImplementStackUsingQueues {
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		Queue<Integer> q = new ArrayDeque<>();
		st.push(1);
		st.push(2);
		st.push(3);
	
		q.add(st.pop());
		System.out.println(q.peek());
	}
	
	
}
