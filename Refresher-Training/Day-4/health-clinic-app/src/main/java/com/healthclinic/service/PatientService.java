package com.healthclinic.service;

import com.healthclinic.dao.PatientDAO;
import com.healthclinic.model.Patient;

// Patient Service Class

public class PatientService {

	PatientDAO dao = new PatientDAO();

	// Add Patient
	public void addPatient(Patient patient) {
		dao.addPatient(patient);
	}

	// View Patients
	public void viewPatients() {
		dao.viewPatients();
	}

	// Search Patient
	public void searchPatient(int pat_id) {
		dao.searchPatient(pat_id);
	}

	// Update Patient
	public void updatePatient(int pat_id, String phone) {
		dao.updatePatient(pat_id, phone);
	}

	// Delete Patient
	public void deletePatient(int pat_id) {
		dao.deletePatient(pat_id);
	}

	// Count Patients
	public void countPatients() {
		dao.countPatients();
	}

}