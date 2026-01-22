package com.Collections.ListInterface;

import java.util.ArrayList;
import java.util.LinkedList;
public class ReverseList {
	public static void main(String[] args) {

		
		ArrayList<Integer> val = new ArrayList<>();
		
		val.add(1);
		val.add(2);
		val.add(3);
		val.add(4);
		val.add(5);
		ArrayList<Integer> ans = new ArrayList<>();
		
		for(int i = val.size()-1; i>=0; i--) {
			ans.add(val.get(i));
			
		}
		System.out.println("Reversed Array is : " + ans);
		
		LinkedList<Integer> ll = new LinkedList<>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		
		LinkedList<Integer> lla = new LinkedList<>();
		for(int i = ll.size()-1; i>= 0; i--) {
			lla.add(ll.get(i));
		}
		System.out.println("Reversed LinkedList is : " + lla);
		
	}
}
