package com.HospitalPatientManagementSystem;

public abstract class Patient {
    private int patientId;
    private String name;
    private String medicalHistory;

    // normal admission
    public Patient(int patientId, String name) {
        this.patientId = patientId;
        this.name = name;
        this.medicalHistory = "Not Available";
    }

    // emergency admission
    public Patient(int patientId, String name, String medicalHistory) {
        this.patientId = patientId;
        this.name = name;
        this.medicalHistory = medicalHistory;
    }

    public abstract void displayInfo();

    public String getSummary() {
        return "Id : " + patientId + " Name : " + name;
    }

    // getter and setter
    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
}