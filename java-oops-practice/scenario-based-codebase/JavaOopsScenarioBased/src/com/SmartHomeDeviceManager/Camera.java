package com.SmartHomeDeviceManager;

public class Camera extends Device {

    Camera(int id, double usage) {
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
        firmwareLog = "Camera firmware reset";
    }
}