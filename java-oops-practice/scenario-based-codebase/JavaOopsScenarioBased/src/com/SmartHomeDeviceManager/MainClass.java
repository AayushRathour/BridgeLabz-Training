package com.SmartHomeDeviceManager;

public class MainClass {
    public static void main(String[] args) {

        Device d1 = new Light(101, 5);
        Device d2 = new Camera(102, 8);
        Device d3 = new Thermostat(103, 10);
        Device d4 = new Lock(104, 2);

        d1.turnOn();
        d2.turnOn();

        System.out.println(d1.calculateEnergy(4));
        System.out.println(d2.calculateEnergy(3));

        d3.reset();
        d4.reset();
    }
}