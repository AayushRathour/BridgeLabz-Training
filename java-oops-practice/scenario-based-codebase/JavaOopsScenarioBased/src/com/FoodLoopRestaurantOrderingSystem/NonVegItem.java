package com.FoodLoopRestaurantOrderingSystem;

public class NonVegItem extends FoodItems {

    NonVegItem(String name, double price, int stock) {
        super(name, "Non Veg", price, stock);
    }

    double applyDiscount(double total) {
        if (total >= 500) {
            return total * 0.9;
        }
        return total;
    }
}
