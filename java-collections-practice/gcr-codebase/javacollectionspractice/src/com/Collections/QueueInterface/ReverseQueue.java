package com.Collections.QueueInterface;

import java.util.*;

public class ReverseQueue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		Stack<Integer> s = new Stack<>();

		System.out.println("Enter number of elements");
		int n = sc.nextInt();

		System.out.println("Enter the numbers");
		for (int i = 0; i < n; i++) {
			q.add(sc.nextInt());
		}

		while (!q.isEmpty()) {
			s.push(q.poll());
		}

		while (!s.isEmpty()) {
			q.add(s.pop());
		}

		System.out.println(q);
	}
}
