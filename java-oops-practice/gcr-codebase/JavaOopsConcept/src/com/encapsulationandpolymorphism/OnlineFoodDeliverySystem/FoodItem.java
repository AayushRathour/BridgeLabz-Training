package com.encapsulationandpolymorphism.OnlineFoodDeliverySystem;

public abstract class FoodItem implements Discountable {
    private String itemName;
    private int price;
    private int quantity;

    // constructor
    public FoodItem(String itemName, int price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // abstract method
    public abstract int calculateTotalPrice();

    // concrete method
    public void getItemDetails() {
        System.out.println(itemName + " Price : " + price + " Quantity : " + quantity);
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}