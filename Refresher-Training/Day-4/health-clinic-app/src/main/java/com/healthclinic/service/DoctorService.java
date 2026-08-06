package com.healthclinic.service;

import com.healthclinic.dao.DoctorDAO;
import com.healthclinic.model.Doctor;

// Doctor Service Class

public class DoctorService {

	DoctorDAO dao = new DoctorDAO();

	// Add Doctor
	public void addDoctor(Doctor doctor) {
		dao.addDoctor(doctor);
	}

	// View Doctors
	public void viewDoctors() {
		dao.viewDoctors();
	}

	// Search Doctor
	public void searchDoctor(int doc_id) {
		dao.searchDoctor(doc_id);
	}

	// Update Doctor Fee
	public void updateDoctorFee(int doc_id, double fee) {
		dao.updateDoctorFee(doc_id, fee);
	}

	// Delete Doctor
	public void deleteDoctor(int doc_id) {
		dao.deleteDoctor(doc_id);
	}

	// Count Doctors
	public void countDoctors() {
		dao.countDoctors();
	}

}