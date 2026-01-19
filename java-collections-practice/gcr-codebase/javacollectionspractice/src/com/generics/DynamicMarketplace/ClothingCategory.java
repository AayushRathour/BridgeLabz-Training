package com.generics.DynamicMarketplace;

public class ClothingCategory implements Category {

    public String getName() {
        return "Clothing";
    }

    public double getMinPrice() {
        return 300;
    }

    public double getMaxPrice() {
        return 5000;
    }
}
