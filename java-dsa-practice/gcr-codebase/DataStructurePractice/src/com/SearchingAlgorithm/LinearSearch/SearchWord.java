package com.SearchingAlgorithm.LinearSearch;

public class SearchWord {
	public static void main(String[] args) {
		String[] arr = {"This is testing", "input string", "to find word"};
		String target = "find";
		String result = "Not found";
		
		for(String str : arr) {
			String[] curr = str.split(" ");
			for(String s : curr) {
				if(s.equals(target)){
					result = str;
					break;
				}
			}
		}
		System.out.println(result);
	}
}