package com.healthclinic.model;

public class Patient {
	private int pat_id ;
	private String pat_name;
	private String pat_phone;
	public Patient(int pat_id, String pat_name, String pat_phone) {
		super();
		this.pat_id = pat_id;
		this.pat_name = pat_name;
		this.pat_phone = pat_phone;
	}
	public int getPat_id() {
		return pat_id;
	}
	public void setPat_id(int pat_id) {
		this.pat_id = pat_id;
	}
	public String getPat_name() {
		return pat_name;
	}
	public void setPat_name(String pat_name) {
		this.pat_name = pat_name;
	}
	public String getPat_phone() {
		return pat_phone;
	}
	public void setPat_phone(String pat_phone) {
		this.pat_phone = pat_phone;
	}
	@Override
	public String toString() {
		return "Patient [pat_id=" + pat_id + ", pat_name=" + pat_name + ", pat_phone=" + pat_phone + "]";
	}
	
	
	
}
