package com.CinemaHouseMovieTimeSorting;

import java.util.*;

public class CinemaHouse {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the no of movies ");
	int n = sc.nextInt();
	System.out.println("Enter the time  ");
	int[] time = new int[n];
	for(int i =0; i<n;i++) {
		time[i]= sc.nextInt(); 
	}
	for(int i = 0; i<n-1; i++) {
		for(int j= 0; j<n-1; j++) {
			 if(time[j]> time[j+1]) {
				 int ans = time[j];
				 time[j] =time[j+1];
				 time[j+1] = ans;
			 }
		}
		
	}
	System.out.println("Movie time sorted : "+ Arrays.toString(time));

	
}
}