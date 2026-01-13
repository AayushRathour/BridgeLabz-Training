package com.SupermarketBillingQueue;

public class MainClass {
	public static void main(String[] args) {
		Customer c1 = new Customer("Customer 1");
		BillingSystem system = new BillingSystem();
		
		system.showItems();
		
		system.buyItem(c1, new Item("Rice", 5));
		system.buyItem(c1, new Item("Bread", 100));
		system.buyItem(c1, new Item("Pasta", 1));
		
		system.addInQueue(c1);
		
		system.processCustomer();
	}
}