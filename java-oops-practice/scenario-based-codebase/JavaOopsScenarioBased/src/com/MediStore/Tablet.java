package com.MediStore;

public class Tablet extends Medicine{
	Tablet(String name, int price, int expiryDate, int quantity) {
		super(name, price, expiryDate, quantity);
	}

	public void checkExpiry() {
		System.out.println("Tablet: longer shelf life");
	}
}
