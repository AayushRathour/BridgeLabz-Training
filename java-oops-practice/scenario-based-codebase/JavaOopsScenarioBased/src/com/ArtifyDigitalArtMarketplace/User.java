package com.ArtifyDigitalArtMarketplace;

public class User {
	String name;
	int walletBalance;
	
	User(String name){
		this.name = name;
		this.walletBalance =10000;
		
	}
	User(String name,int walletBalance){
		this.name = name;
		this.walletBalance =walletBalance;
	}
	public void showBalance() {
		System.out.println(walletBalance);
		
	}
	
	
}
