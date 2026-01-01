package com.objectmodelling.level1.EcommercePlatform;

public class DriverClass {
	public static void main(String[] args) {
		Customer customer = new Customer(1, "customer 1");

        Product p1 = new Product("P01", "Laptop", 100000.00);

        Order order1 = new Order("O9001");
        order1.addProduct(p1);

        customer.placeOrder(order1);
	}
}