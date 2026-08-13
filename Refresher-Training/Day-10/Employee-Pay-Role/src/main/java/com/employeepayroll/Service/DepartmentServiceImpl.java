package com.employeepayroll.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employeepayroll.Entity.Department;
import com.employeepayroll.Exception.ResourceNotFoundException;
import com.employeepayroll.Repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department addDepartment(Department department) {

        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {

        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {

        return departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
    }

    @Override
    public Department updateDepartment(Long id, Department department) {

        if (!departmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Department not found with id: " + id);
        }

        return departmentRepository.update(id, department);
    }

    @Override
    public void deleteDepartment(Long id) {

        if (!departmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Department not found with id: " + id);
        }

        departmentRepository.deleteById(id);
    }
}
