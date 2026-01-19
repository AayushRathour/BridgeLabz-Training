package com.generics.DynamicMarketplace;

public class BookCategory implements Category {

    public String getName() {
        return "Books";
    }

    public double getMinPrice() {
        return 100;
    }

    public double getMaxPrice() {
        return 2000;
    }
}
