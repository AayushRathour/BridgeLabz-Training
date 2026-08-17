package com.employeepayroll.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

import com.employeepayroll.Entity.Employee;

// JpaRepository provides CRUD/paging/sorting; QueryByExampleExecutor provides example-based searching.
public interface EmployeeRepository extends JpaRepository<Employee, Long>, QueryByExampleExecutor<Employee> {

    Page<Employee> findByDepartment_Id(Long departmentId, Pageable pageable);
}
