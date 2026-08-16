package com.employeepayroll.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeepayroll.Entity.Department;

// findAll(), findById(), save(), existsById(), deleteById() 
// all come free from JpaRepository - no manual SQL needed
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
