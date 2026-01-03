package com.SmartHomeAutomationSystem;

public class MainClass {
    public static void main(String[] args) {
        User user = new User(1, "Aayush");

        Device light = new Light(0, "Room1");
        Device ac = new AC(1, "Room2");

        user.displayUser();

        light.turnOn();
        ac.turnOn();

        light.turnOff();
        ac.turnOff();
    }
}