package com.GameBoxMobileGameDistributionPlatform;

public class StrategyGame extends Game {

    StrategyGame(String title, String genre, int price, String rating) {
        super(title, genre, price, rating);
    }

    public void download() {
        System.out.println(getTitle() + " downloaded (Strategy)");
    }

    public void playDemo() {
        System.out.println("Think-and-plan strategy demo started");
    }
}
