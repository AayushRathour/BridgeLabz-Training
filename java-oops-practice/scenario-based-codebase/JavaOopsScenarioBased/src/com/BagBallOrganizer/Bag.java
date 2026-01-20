package com.BagBallOrganizer;

import java.util.*;

public class Bag implements Storable {
    private String id;
    private String color;
    private int capacity;
    private List<Ball> balls;

    public Bag(String id, String color, int capacity) {
        this.id = id;
        this.color = color;
        this.capacity = capacity;
        this.balls = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public int getBallCount() {
        return balls.size();
    }

    public void addBall(Ball ball) {
        if (balls.size() >= capacity) {
            System.out.println("Bag is full!");
            return;
        }
        balls.add(ball);
    }

    public void removeBall(String ballId) {
        for(int i = 0; i < balls.size(); i++) {
        	if(balls.get(i).getId() == ballId) {
        		System.out.println("Ball removed");
        		balls.remove(balls.get(i));
        		return;
        	}
        }
        System.out.println("Ball not found in Bag " + id);
    }

    public void displayBalls() {
        for (Ball b : balls) {
            System.out.println(b);
        }
    }
}