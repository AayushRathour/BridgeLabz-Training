package com.FoodLoopRestaurantOrderingSystem;

public class VegItem extends FoodItems {

    VegItem(String name, double price, int stock) {
        super(name, "Veg", price, stock);
    }

    double applyDiscount(double total) {
        if (total >= 500) {
            return total * 0.9;
        }
        return total;
    }
}
