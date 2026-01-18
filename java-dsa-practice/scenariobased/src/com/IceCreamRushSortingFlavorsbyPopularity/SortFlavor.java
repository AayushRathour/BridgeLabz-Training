package com.IceCreamRushSortingFlavorsbyPopularity;

import java.util.Arrays;

public class SortFlavor {
	private static void sort(Flavor[] flavors) {
		int n = flavors.length;
		 
		 for(int i = 0; i < n-1; i++) {
			 for(int j = 0; j < n-i-1; j++) {
				 if(flavors[j].sold > flavors[j+1].sold) {
					 Flavor temp = flavors[j];
					 flavors[j] = flavors[j+1];
					 flavors[j+1] = temp;
				 }
			 }
		 }
	}
	
	public static void main(String[] args) {
		Flavor[] flavors = {
				new Flavor("Flavor 1", 20),
				new Flavor("Flavor 2", 30),
				new Flavor("Flavor 3", 40),
				new Flavor("Flavor 4", 10),
				new Flavor("Flavor 5", 32),
				new Flavor("Flavor 6", 120),
				new Flavor("Flavor 7", 27)
		};
		sort(flavors);
		System.out.println(Arrays.toString(flavors));
	}
}