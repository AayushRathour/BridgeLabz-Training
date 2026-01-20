package com.GeoMeasure;

public class LineCalculator {
    double calculateLength(Line Aayush) {
        return Math.sqrt(
            (Aayush.getX2() - Aayush.getX1()) * (Aayush.getX2() - Aayush.getX1()) +
            (Aayush.getY2() - Aayush.getY1()) * (Aayush.getY2() - Aayush.getY1())
        );
    }
}
