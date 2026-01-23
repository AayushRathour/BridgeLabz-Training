package com.ECommerceProductInventory;

public class Node {
	int sku;
	String details;
	Node left;
	Node right;
	
	Node(int sku, String details) {
		this.sku = sku;
		this.details = details;
	}
	
	public String toString() {
		return sku + " " + details;
	}
}