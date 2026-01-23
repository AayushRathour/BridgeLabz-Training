package com.Collections.Map_Interface;

import java.util.HashMap;

public class WordFrequencyCounter {
	public static void main(String[] args) {
		String str = "Hello world, hello java!";
		str  = str.toLowerCase();
		String[] words = str.split("[^a-zA-z]+");
		
		HashMap<String, Integer> mp = new HashMap<>();
		
		for(String word : words) mp.put(word, mp.getOrDefault(word, 0)+1);
		System.out.println(mp);
	}
}