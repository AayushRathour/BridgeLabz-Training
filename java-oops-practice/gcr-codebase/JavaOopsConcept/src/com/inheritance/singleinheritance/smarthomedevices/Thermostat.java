package com.inheritance.singleinheritance.smarthomedevices;

public class Thermostat extends Device {
    public int temperatureSetting;

    // constructor
    public Thermostat(int deviceId, String status, int temperatureSetting) {
        super(deviceId, status); 
        this.temperatureSetting = temperatureSetting;
    }

    public void displayStatus() {
        super.displayStatus(); 
        System.out.println("Temperature : " + temperatureSetting);
    }
}