package com.employeepayroll.Dto;

public class EmployeeResponseDTO {

   private Long id;
   private String name;
   private String email;
   private String phone;
   private Long departmentaId;
   private String departmentName;
   private String designation;
   private double salary;
   
   public EmployeeResponseDTO(Long id, String name, String email, String phone, Long departmentaId, String departmentName,
		String designation, double salary) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.departmentaId = departmentaId;
	this.departmentName = departmentName;
	this.designation = designation;
	this.salary = salary;
   }
   public Long getId() {
	return id;
   }
   public void setId(Long id) {
	this.id = id;
   }
   public String getName() {
	return name;
   }
   public void setName(String name) {
	this.name = name;
   }
   public String getEmail() {
	return email;
   }
   public void setEmail(String email) {
	this.email = email;
   }
   public String getPhone() {
	return phone;
   }
   public void setPhone(String phone) {
	this.phone = phone;
   }
   public Long getDepartmentaId() {
	return departmentaId;
   }
   public void setDepartmentaId(Long departmentaId) {
	this.departmentaId = departmentaId;
   }
   public String getDepartmentName() {
	return departmentName;
   }
   public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
   }
   public String getDesignation() {
	return designation;
   }
   public void setDesignation(String designation) {
	this.designation = designation;
   }
   public double getSalary() {
	return salary;
   }
   public void setSalary(double salary) {
	this.salary = salary;
   }
   
}
