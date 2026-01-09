package com.MediStore;

public class Injection extends Medicine {
	Injection(String name, int price, int expiryDate, int quantity) {
		super(name, price, expiryDate, quantity);
	}

	public void checkExpiry() {
		System.out.println("Injectoin:");
	}
}
