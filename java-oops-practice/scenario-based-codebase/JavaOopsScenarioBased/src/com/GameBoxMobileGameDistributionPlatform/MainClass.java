package com.GameBoxMobileGameDistributionPlatform;

public class MainClass {
    public static void main(String[] args) {
        Game g1 = new ArcadeGame("SpeedX", "Arcade", 500, "4.5");
        Game g2 = new StrategyGame("WarPlan", "Strategy", 800, "4.7");

        g1.playDemo();
        g2.playDemo();

        g1.applyDiscount(20);

        User u = new User();
        u.buyGame(g1);
        u.buyGame(g2);
    }
}
