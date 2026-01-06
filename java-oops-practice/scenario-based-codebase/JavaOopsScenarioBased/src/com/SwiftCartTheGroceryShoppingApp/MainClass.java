package com.SwiftCartTheGroceryShoppingApp;

public class MainClass {
    public static void main(String[] args) {

        Product p1 = new Product("Milk", 50, "Dairy");
        Product p2 = new Product("Rice", 60, "Grains");

        Product[] products = {p1, p2};
        int[] quantity = {2, 3};

        Cart cart = new Cart(products, quantity);
        cart.applyDiscount(30);
        cart.generateBill();
    }
}
