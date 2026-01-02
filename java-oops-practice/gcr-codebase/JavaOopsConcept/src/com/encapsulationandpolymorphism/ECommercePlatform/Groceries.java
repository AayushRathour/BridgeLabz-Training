package com.encapsulationandpolymorphism.ECommercePlatform;

public class Groceries extends Product{
	// constructor
	public Groceries(int productId, String name, int price) {
		super(productId, name, price);
	}
	
	// return discount
	public int calculateDiscount() {
		return (super.getPrice()/50);
	}
}