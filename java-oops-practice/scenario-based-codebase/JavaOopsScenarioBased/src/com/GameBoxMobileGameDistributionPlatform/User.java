package com.GameBoxMobileGameDistributionPlatform;

import java.util.ArrayList;

public class User {
    private ArrayList<Game> ownedGames = new ArrayList<>();

    public void buyGame(Game game) {
        ownedGames.add(game);
        System.out.println("Game added to library");
    }
}
