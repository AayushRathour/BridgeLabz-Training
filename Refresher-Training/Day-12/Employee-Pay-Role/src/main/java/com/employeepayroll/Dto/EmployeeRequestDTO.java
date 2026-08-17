package com.employeepayroll.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class EmployeeRequestDTO {

	@NotBlank(message = "Name is Required")
	private String name;
	
	@NotBlank(message = "Email is needed")
	@Email(message ="Email must be Valid")
    private String email;
	
	@NotBlank( message = "Phone is required")
	@Pattern(regexp = "^\\+?[0-9]{9,10}$", message ="Phone must be of 10 digit")
	private String phone;
	
	// Foreign-key value for the employee's department.
	@NotNull(message = "Department Id Required")
	private Long departmentId;
	
	@NotBlank(message = "Designation is Needed")
	private String designation;
	
	@Positive(message = "Salary but be more than 0")
	private Double salary;
	
	public EmployeeRequestDTO() {}

	public EmployeeRequestDTO(@NotBlank(message = "Name is Required") String name,
			@NotBlank(message = "Email is needed") @Email(message = "Email must be Valid") String email,
			@NotBlank(message = "Phone is required") @Pattern(regexp = "^\\+?[0-9]{9,10}$", message = "Phone must be of 10 digit") String phone,
			@NotNull(message = "Department Id Required") Long departmentId,
			@NotBlank(message = "Designation is Needed") String designation,
			@Positive(message = "Salary but be more than 0") Double salary) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.departmentId = departmentId;
		this.designation = designation;
		this.salary = salary;
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

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
	
	
	
}
