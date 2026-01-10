package com.FoodLoopRestaurantOrderingSystem;

public class MainClass {
    public static void main(String[] args) {

        FoodItems f1 = new VegItem("Paneer Combo", 250, 5);
        FoodItems f2 = new NonVegItem("Chicken Burger", 350, 3);

        Order order = new Order(f1, f2);

        System.out.println("Total Bill: " + order.placeOrder());
    }
}
