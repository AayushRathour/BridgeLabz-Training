package com.encapsulationandpolymorphism.OnlineFoodDeliverySystem;

public class VegItem extends FoodItem {
    // constructor
    public VegItem(String itemName, int price, int quantity) {
        super(itemName, price, quantity);
    }

    public int calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    public int applyDiscount() {
        return 100;
    }

    public void getDiscountDetails() {
        System.out.println("Veg item discount : 100");
    }
}