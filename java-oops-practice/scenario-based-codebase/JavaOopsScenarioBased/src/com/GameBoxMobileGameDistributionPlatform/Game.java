package com.GameBoxMobileGameDistributionPlatform;

public abstract class Game implements IDownloadable {
    private String title;
    private String genre;
    protected int price;
    private String rating;

    Game(String title, String genre, int price, String rating) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.rating = rating;
    }

    public void applyDiscount(int percent) {
        price = price - (price * percent / 100);
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }
}
