package com.generics.DynamicMarketplace;

public class DiscountUtil {

    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.price = product.price - (product.price * percentage / 100);
    }
}
