package com.MediStore;

public class Syrup extends Medicine{
	Syrup(String name, int price, int expiryDate, int quantity) {
		super(name, price, expiryDate, quantity);
	}

	public void checkExpiry() {
		System.out.println("Syrup: longer shelf life");
	}
}
