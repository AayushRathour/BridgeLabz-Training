package com.SupermarketBillingQueue;

import java.util.*;


public class Customer {
	String name;
	List<Item> items = new ArrayList<Item>();
	double price;
	
	public Customer(String name) {
		this.name = name;
	}
}