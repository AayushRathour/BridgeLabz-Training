package com.HashMapsAndHashFunctions.CustomHashMap;

public class MainClass {
	    public static void main(String[] args) {

	        MyHashMap map = new MyHashMap();

	        map.put(1, 10);
	        map.put(11, 20);
	        map.put(2, 30);

	        System.out.println(map.get(1));
	        System.out.println(map.get(11));

	        map.remove(1);
	        System.out.println(map.get(1));
	    }
	

}
