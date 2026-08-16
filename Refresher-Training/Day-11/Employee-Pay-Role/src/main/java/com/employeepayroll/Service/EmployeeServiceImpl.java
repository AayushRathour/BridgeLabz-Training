package com.employeepayroll.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.employeepayroll.Dto.EmployeeRequestDTO;
import com.employeepayroll.Dto.EmployeeSearchDTO;
import com.employeepayroll.Entity.Department;
import com.employeepayroll.Entity.Employee;
import com.employeepayroll.Exception.ResourceNotFoundException;
import com.employeepayroll.Mapper.EmployeeMapper;
import com.employeepayroll.Repository.DepartmentRepository;
import com.employeepayroll.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                                DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Employee addEmployee(EmployeeRequestDTO request) {

        Department department = findDepartmentOrThrow(request.getDepartmentId());
        Employee employee = EmployeeMapper.toEntity(request, department);

        return employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> getAllEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> searchEmployees(EmployeeSearchDTO criteria, Pageable pageable) {
        Employee probe = new Employee();
        probe.setName(criteria.getName());
        probe.setEmail(criteria.getEmail());
        probe.setPhone(criteria.getPhone());
        probe.setDesignation(criteria.getDesignation());

        // A nested Department containing only its id lets QBE match department_id.
        if (criteria.getDepartmentId() != null) {
            Department department = new Department();
            department.setId(criteria.getDepartmentId());
            probe.setDepartment(department);
        }

        // Text fields are case-insensitive partial matches; null values are ignored.
        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withIgnorePaths("id", "salary")
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("email", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("phone", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("designation", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        return employeeRepository.findAll(Example.of(probe, matcher), pageable);
    }

    @Override
    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }

    @Override
    public Employee updateEmployee(Long id, EmployeeRequestDTO request) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        Department department = findDepartmentOrThrow(request.getDepartmentId());

        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setDepartment(department);
        employee.setDesignation(request.getDesignation());
        employee.setSalary(request.getSalary());

        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {

        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }

        employeeRepository.deleteById(id);
    }

    private Department findDepartmentOrThrow(Long departmentId) {

        return departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Department not found with id: " + departmentId));
    }
}
