package com.TailorShopSortingOrdersbyDeadline;

import java.util.*;

public class Shorting {
	void insertion() {
	Scanner sc= new Scanner(System.in);
	int[] time = new int[10];
	System.out.println("Enter the timing one by 1");
	for(int i=0; i<10; i++) {
		time[i] = sc.nextInt();
		
	}
	for(int i =0; i<10; i++) {
		int key = time[i];
		int j = i-1;
		
		while( j>= 0 && time[j] > key) {
			time[j+1] =time[j];
			j--;
			
		}
		time[j+1] = key;
		
	}
	System.out.println("Sorted Time is : " + Arrays.toString(time));
}
}