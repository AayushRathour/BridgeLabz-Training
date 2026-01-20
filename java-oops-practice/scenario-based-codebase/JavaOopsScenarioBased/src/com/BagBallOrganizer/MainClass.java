package com.BagBallOrganizer;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        ArrayList<Bag> bags = new ArrayList<>();

        Bag bag1 = new Bag("B1", "Red", 2);
        Bag bag2 = new Bag("B2", "Blue", 3);

        bags.add(bag1);
        bags.add(bag2);

        Ball ball1 = new Ball("Ball1", "Yellow", "Small");
        Ball ball2 = new Ball("Ball2", "Green", "medium");
        Ball ball3 = new Ball("Ball3", "blue", "Large");

        bag1.addBall(ball1);
        bag1.addBall(ball2);
        bag1.addBall(ball3);

        bag2.addBall(ball3);

        bag1.displayBalls();
        bag1.removeBall("Ball2");
        bag1.displayBalls();

        for (Bag bag : bags) {
            System.out.println( bag.getId() + " Balls " + bag.getBallCount());
        }
    }
}