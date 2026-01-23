package com.Collections.Set_Interface;

import java.util.Set;


public class CheckSet {
	public static boolean compare(Set<Integer> set1, Set<Integer> set2) {
		for(int i : set1) {
			if(!set2.contains(i)) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Set<Integer> set1 = Set.of(1,2,3,4,5);
		Set<Integer> set2 = Set.of(5,4,1,2,6);
		
		if(compare(set1, set2)) System.out.println("Set1 and set2 are equal!");
		else System.out.println("Set1 and set2 are not equal!");
	}
}