package com.GeoMeasure;

public class LineComparator {
    void compare(double length1, double length2) {
        if (length1 == length2) {
            System.out.println("Both lines are equal in length.");
        } else if (length1 > length2) {
            System.out.println("Line 1 is longer.");
        } else {
            System.out.println("Line 2 is longer.");
        }
    }
}
