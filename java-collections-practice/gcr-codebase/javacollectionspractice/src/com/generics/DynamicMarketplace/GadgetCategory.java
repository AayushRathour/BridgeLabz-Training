package com.generics.DynamicMarketplace;

public class GadgetCategory implements Category {

    public String getName() {
        return "Gadgets";
    }

    public double getMinPrice() {
        return 1000;
    }

    public double getMaxPrice() {
        return 100000;
    }
}
