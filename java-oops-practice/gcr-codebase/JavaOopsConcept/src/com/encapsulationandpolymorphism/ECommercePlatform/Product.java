package com.encapsulationandpolymorphism.ECommercePlatform;

public abstract class Product implements Taxable {
	private int productId;
	private String name;
	private int price;
	
	// constructor
	public Product(int productId, String name, int price) {
		this.productId = productId;
		this.name = name;
		this.price = price;
	}

	// abstract method
	public abstract int calculateDiscount();
	
	// 5% tax
	public int calculateTax() {
		return price/20;
	}
	
	// method to get tax details
	public void getTaxDetails() {
		System.out.println("Price : " + price + ", tax(5%) : " + this.calculateTax() );
	}
	
	// getter and setter
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}