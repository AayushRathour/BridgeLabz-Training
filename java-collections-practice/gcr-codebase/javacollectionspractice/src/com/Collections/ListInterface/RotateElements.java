package com.Collections.ListInterface;

import java.util.*;
public class RotateElements {
	public static void main(String[] args) {

		ArrayList<Integer> val = new ArrayList<>();

		val.add(1);
		val.add(2);
		val.add(3);
		val.add(4);
		val.add(5);

		System.out.println(val);

		int n = val.size();
		int k = 2;
		k = k % n;

		reverse(val, 0, k - 1);
		reverse(val, k, n - 1);
		reverse(val, 0, n - 1);

		System.out.println(val);
	}

	static void reverse(ArrayList<Integer> val, int i, int j) {
		while (i < j) {
			int temp = val.get(i);
			val.set(i, val.get(j));
			val.set(j, temp);
			i++;
			j--;
		}
	}
}
