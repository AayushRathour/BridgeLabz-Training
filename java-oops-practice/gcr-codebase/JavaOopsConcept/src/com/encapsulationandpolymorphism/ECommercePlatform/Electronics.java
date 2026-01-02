package com.encapsulationandpolymorphism.ECommercePlatform;

public class Electronics extends Product{
	// constructor
	public Electronics(int productId, String name, int price) {
		super(productId, name, price);
	}
	
	// method to calculate discount
	public int calculateDiscount() {
		return super.getPrice()/50;
	}
}