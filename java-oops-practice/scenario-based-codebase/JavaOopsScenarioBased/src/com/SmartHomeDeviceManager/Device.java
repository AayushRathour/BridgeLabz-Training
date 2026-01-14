package com.SmartHomeDeviceManager;

public abstract class Device implements IControllable {

    protected int deviceId;
    private boolean status;
    protected double energyUsage;
    protected String firmwareLog;

    Device(int deviceId, double energyUsage) {
        this.deviceId = deviceId;
        this.energyUsage = energyUsage;
        this.status = false;
        this.firmwareLog = "Secure Log";
    }

    public boolean getStatus() {
        return status;
    }

    protected void setStatus(boolean status) {
        this.status = status;
    }

    double calculateEnergy(int hours) {
        return energyUsage * hours;
    }
}
