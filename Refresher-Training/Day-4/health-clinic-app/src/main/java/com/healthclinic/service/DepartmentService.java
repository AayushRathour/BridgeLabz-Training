package com.healthclinic.service;

import com.healthclinic.dao.DepartmentDAO;
import com.healthclinic.model.Department;

public class DepartmentService {

	DepartmentDAO dao = new DepartmentDAO();

	public void addDepartment(Department department) {

		dao.addDepartment(department);

	}

	public void viewDepartments() {

		dao.viewDepartments();

	}

}