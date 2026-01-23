package com.Collections.Map_Interface;

import java.util.HashMap;

public class HighestValue {
	public static void main(String[] args) {
		HashMap<String, Integer> mp = new HashMap<String, Integer>();
		mp.put("A", 10);
		mp.put("B", 40);
		mp.put("C", 30);
		
		String result = "";
		int max = 0;
		
		for(String key : mp.keySet()) {
			if(max < mp.get(key)) {
				max = mp.get(key);
				result = key;
			}
		}
		
		System.out.println(result);
	}
}