package com.EmergencyPatientNavigation;

public class Unit {
    String name;
    boolean available;
    Unit next;

    Unit(String name, boolean available) {
        this.name = name;
        this.available = available;
        this.next = null;
    }
}