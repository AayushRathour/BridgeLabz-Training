package com.SmartHomeDeviceManager;

public class Light extends Device {

    Light(int id, double usage) {
        super(id, usage);
    }

    public void turnOn() {
        setStatus(true);
    }

    public void turnOff() {
        setStatus(false);
    }

    public void reset() {
        setStatus(false);
        energyUsage = 1;
    }
}