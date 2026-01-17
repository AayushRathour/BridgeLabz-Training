package com.RoboWarehouseShelfLoadingRobot;

import java.util.*;

public class RoboWarehouse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of packages  ");
		int n = sc.nextInt();
		System.out.println("Enter the weights ");
		int[] weight = new int[n];
		for(int i =0; i<n;i++) {
			weight[i]= sc.nextInt(); 
		}
		for(int i =0; i<weight.length; i++) {
			int key = weight[i];
			int j = i-1;
			while(j>= 0 && weight[j] > key ) {
				weight[j+1] = weight[j];
				j--;
			}
			weight[j+1] =key;
			
		}
		System.out.println("The Package loaded succesfully : " +Arrays.toString(weight));
	}	
}

