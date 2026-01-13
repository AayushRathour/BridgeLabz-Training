package com.SupermarketBillingQueue;

public class Pair {
	int price;
	int stock;
	
	public Pair(int price, int stock) {
		this.price = price;
		this.stock = stock;
	}
	
	public String toString() {
		return price + " " + stock;
	}
}	