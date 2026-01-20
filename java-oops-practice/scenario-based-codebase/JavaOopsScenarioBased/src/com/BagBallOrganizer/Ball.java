package com.BagBallOrganizer;

public class Ball implements Storable {
    private String id;
    private String color;
    private String size;

    public Ball(String id, String color, String size) {
        this.id = id;
        this.color = color;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String toString() {
        return "Ball " + id + " " + color + " " + size;
    }
}