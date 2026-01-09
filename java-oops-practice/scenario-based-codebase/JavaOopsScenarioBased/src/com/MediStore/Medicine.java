package com.MediStore;

public class Medicine implements ISellable {

	private String name;
	private int price;
	private int expiryDate;
	private int quantity;

	Medicine(String name, int price, int expiryDate) {
		this.name = name;
		this.price = price;
		this.expiryDate = expiryDate;
		this.quantity = 10;
	}

	Medicine(String name, int price, int expiryDate, int quantity) {
		this.name = name;
		this.price = price;
		this.expiryDate = expiryDate;
		this.quantity = quantity;
	}

	public void sell(int qty) {
		if (qty <= quantity) {
			quantity = quantity - qty;
			System.out.println(qty + " sold. Stock left: " + quantity);
		} else {
			System.out.println("Insufficient stock");
		}
	}

	public void checkExpiry() {
		System.out.println("Generic medicine expiry check");
	}

	private int calculateTotalPrice(int qty) {
		return price * qty;
	}

	public int applyDiscount(int qty) {
		int total = calculateTotalPrice(qty);
		int discount = total * 10 / 100;
		return total - discount;
	}
}
