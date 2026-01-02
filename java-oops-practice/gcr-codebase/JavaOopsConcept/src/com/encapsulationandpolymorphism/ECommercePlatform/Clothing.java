package com.encapsulationandpolymorphism.ECommercePlatform;

public class Clothing extends Product{
	// constructor
	public Clothing(int productId, String name, int price) {
		super(productId, name, price);
	}
	
	// method to find discount
	public int calculateDiscount() {
		return super.getPrice()/20;
	}
}