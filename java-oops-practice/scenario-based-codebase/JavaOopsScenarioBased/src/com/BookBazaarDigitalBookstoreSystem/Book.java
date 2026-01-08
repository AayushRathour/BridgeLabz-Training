package com.BookBazaarDigitalBookstoreSystem;

public abstract class Book implements IDiscountable {
    protected String title;
    protected String author;
    protected double price;
    private int stock;

    public Book(String title, String author, double price, int stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }

    public boolean reduceStock(int qty) {
    	if(stock < qty) return false;
    	stock -= qty;
        return true;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }
}