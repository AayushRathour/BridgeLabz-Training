package com.SwiftCartTheGroceryShoppingApp;

public class Cart implements Checkout {

    private Product[] products;
    private int[] quantity;
    private int totalPrice;

    Cart(Product[] products, int[] quantity) {
        this.products = products;
        this.quantity = quantity;
        calculateTotal();
    }

    private void calculateTotal() {
        totalPrice = 0;
        for (int i = 0; i < products.length; i++) {
            totalPrice = totalPrice + (products[i].getPrice() * quantity[i]);
        }
    }

    public void applyDiscount(int coupon) {
        totalPrice = totalPrice - coupon;
    }

    public void generateBill() {
        System.out.println("Final Amount: " + totalPrice);
    }
}
