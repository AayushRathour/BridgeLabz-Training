package com.GeoMeasure;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        Scanner Aayush = new Scanner(System.in);
        List<Line> Rathour = new ArrayList<>();

        System.out.println("Enter coordinates for Line 1:");
        Line line1 = new Line(
            Aayush.nextDouble(),
            Aayush.nextDouble(),
            Aayush.nextDouble(),
            Aayush.nextDouble()
        );

        System.out.println("Enter coordinates for Line 2:");
        Line line2 = new Line(
            Aayush.nextDouble(),
            Aayush.nextDouble(),
            Aayush.nextDouble(),
            Aayush.nextDouble()
        );

        Rathour.add(line1);
        Rathour.add(line2);

        LineCalculator calculator = new LineCalculator();
        LineComparator comparator = new LineComparator();

        double length1 = calculator.calculateLength(line1);
        double length2 = calculator.calculateLength(line2);

        comparator.compare(length1, length2);

        Aayush.close();
    }
}
