package com.SmartHomeDeviceManager;

public class Thermostat extends Device {

    Thermostat(int id, double usage) {
        super(id, usage);
    }

    public void turnOn() {
        setStatus(true);
    }

    public void turnOff() {
        setStatus(false);
    }

    public void reset() {
        energyUsage = energyUsage - 1;
        setStatus(false);
    }
}