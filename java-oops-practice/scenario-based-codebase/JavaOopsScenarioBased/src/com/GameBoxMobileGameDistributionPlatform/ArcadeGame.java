package com.GameBoxMobileGameDistributionPlatform;

public class ArcadeGame extends Game {

    ArcadeGame(String title, String genre, int price, String rating) {
        super(title, genre, price, rating);
    }

    public void download() {
        System.out.println(getTitle() + " downloaded (Arcade)");
    }

    public void playDemo() {
        System.out.println("Fast-paced arcade demo started");
    }
}
