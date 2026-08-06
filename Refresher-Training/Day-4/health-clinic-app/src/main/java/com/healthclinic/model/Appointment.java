package com.healthclinic.model;

import java.sql.Timestamp;

public class Appointment {
	private int appoint_id;
	private int pat_id;
	private int doc_id;
	private Timestamp appoint_date;
	private String status;
	public Appointment(int appoint_id, int pat_id, int doc_id, Timestamp appoint_date, String status) {
		super();
		this.appoint_id = appoint_id;
		this.pat_id = pat_id;
		this.doc_id = doc_id;
		this.appoint_date = appoint_date;
		this.status = status;
	}
	public int getAppoint_id() {
		return appoint_id;
	}
	public void setAppoint_id(int appoint_id) {
		this.appoint_id = appoint_id;
	}
	public int getPat_id() {
		return pat_id;
	}
	public void setPat_id(int pat_id) {
		this.pat_id = pat_id;
	}
	public int getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}
	public Timestamp getAppoint_date() {
		return appoint_date;
	}
	public void setAppoint_date(Timestamp appoint_date) {
		this.appoint_date = appoint_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Appointment [appoint_id=" + appoint_id + ", pat_id=" + pat_id + ", doc_id=" + doc_id + ", appoint_date="
				+ appoint_date + ", status=" + status + "]";
	}
	
	

}
