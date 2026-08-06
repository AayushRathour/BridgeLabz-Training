package com.healthclinic.model;

public class Doctor {
	private int doc_id;
	private String doc_name;
	private String doc_Speciality;
	private int department_id;
	private int doc_fee;
	public Doctor(int doc_id, String doc_name, String doc_Speciality, int department_id, int doc_fee) {
		super();
		this.doc_id = doc_id;
		this.doc_name = doc_name;
		this.doc_Speciality = doc_Speciality;
		this.department_id = department_id;
		this.doc_fee = doc_fee;
	}
	public int getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}
	public String getDoc_name() {
		return doc_name;
	}
	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}
	public String getDoc_Speciality() {
		return doc_Speciality;
	}
	public void setDoc_Speciality(String doc_Speciality) {
		this.doc_Speciality = doc_Speciality;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public int getDoc_fee() {
		return doc_fee;
	}
	public void setDoc_fee(int doc_fee) {
		this.doc_fee = doc_fee;
	}
	@Override
	public String toString() {
		return "Doctor [doc_id=" + doc_id + ", doc_name=" + doc_name + ", doc_Speciality=" + doc_Speciality
				+ ", department_id=" + department_id + ", doc_fee=" + doc_fee + "]";
	}
	
	

}
