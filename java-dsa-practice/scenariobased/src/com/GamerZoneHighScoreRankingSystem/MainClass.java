package com.GamerZoneHighScoreRankingSystem;


public class MainClass {
    public static void main(String[] args) {

        int[] playerScores = {980, 1200, 450, 1600, 875, 1320, 1100};

        ScoreSorter.quickSort(playerScores, 0, playerScores.length - 1);

        for (int i = 0; i < playerScores.length; i++) {
            System.out.print(playerScores[i] + " ");
        }
    }
}
