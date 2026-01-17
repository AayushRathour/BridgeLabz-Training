package com.ArtExpoSortArtistsbyRegistrationTime;

import java.util.*;
public class ArtExpo {
	public static void main(String[] args) {
		
		int n;
		do {
			
			Scanner sc =new Scanner(System.in);
			System.out.println("Enter the Artist one by one ");
			System.out.println("To stop Entry press 0");
			ArrayList<Integer> ent =new ArrayList<>();
			for(int i =0; i<10000; i++) {
				int t = sc.nextInt();
				if(t==0) {
					break;
				}
				ent.add(t);
				
			}
			for(int i =0; i<ent.size();i++) {
				int key = ent.get(i);
				int j = i-1;
				while(j>= 0 && ent.get(j)>key) {
					ent.set(j+1, ent.get(j));
					j--;
					
				}
				ent.set(j+1, key);
				
			}
			System.out.println("artists registration done, here is the full list : ");
			System.out.println(ent);
			System.out.println("Press 1 to add again : ");
			n = sc.nextInt();
			
		}while(n==1);
		
	}
}