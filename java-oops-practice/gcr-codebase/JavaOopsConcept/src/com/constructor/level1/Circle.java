package com.constructor.level1;

public class Circle {
    double radius;

    Circle() {
        this(0);
    }

    Circle(double radius) {
        this.radius = radius;
    }

    public static void main(String[] args) {
        Circle circle1 = new Circle(10);
        System.out.println(circle1.radius);

       
    }
}
