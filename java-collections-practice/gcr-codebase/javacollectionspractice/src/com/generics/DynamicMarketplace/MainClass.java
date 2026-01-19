package com.generics.DynamicMarketplace;

import java.util.*;

public class MainClass {

    public static void main(String[] args) {

        Product<BookCategory> book =
                new Product<>("Java Fundamentals", 800, new BookCategory());

        Product<ClothingCategory> shirt =
                new Product<>("Denim Shirt", 1500, new ClothingCategory());

        Product<GadgetCategory> phone =
                new Product<>("Smartphone", 30000, new GadgetCategory());

        ArrayList<Product<?>> catalog = new ArrayList<>();
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);

        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(phone, 5);

        for (Product<?> p : catalog) {
            p.display();
        }
    }
}
