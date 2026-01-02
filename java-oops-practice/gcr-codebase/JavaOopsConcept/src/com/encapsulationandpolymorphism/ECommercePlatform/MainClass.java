package com.encapsulationandpolymorphism.ECommercePlatform;

import java.util.*;

public class MainClass {
	public static int getTotal(List<Product> list) {
		int total = 0;
		for(Product product : list) {
			total += product.getPrice() + product.calculateTax() - product.calculateDiscount();
		}
		return total;
	}
	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();
		
		list.add(new Clothing(0, "Shirt", 1000));
		list.add(new Groceries(1, "Oil", 1500));
		list.add(new Electronics(2, "Fan", 2000));
		
		System.out.println("Total price " + getTotal(list));
	}
}