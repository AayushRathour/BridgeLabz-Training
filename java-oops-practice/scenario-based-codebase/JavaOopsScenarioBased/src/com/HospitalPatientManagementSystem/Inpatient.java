package com.HospitalPatientManagementSystem;

public class Inpatient extends Patient {
    private int daysAdmitted;

    public Inpatient(int patientId, String name, int daysAdmitted) {
        super(patientId, name);
        this.daysAdmitted = daysAdmitted;
    }

    public void displayInfo() {
        System.out.println(getSummary() + " InPatient Days : " + daysAdmitted);
    }

    public int getDaysAdmitted() {
        return daysAdmitted;
    }
}