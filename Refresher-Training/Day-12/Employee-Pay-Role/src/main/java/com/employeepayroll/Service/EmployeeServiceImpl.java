package com.employeepayroll.Service;

import org.springframework.data.domain.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    
    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                                DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }
    @Override
    public Employee createEmployee(Employee employee) {

        logger.info("Creating employee with email: {}", employee.getEmail());

        Employee savedEmployee = employeeRepository.save(employee);

        logger.info("Employee created successfully with ID: {}",
                savedEmployee.getId());

        return savedEmployee;
    }

    // Logger for finding an employee
    
    @Override
    public Employee getEmployeeById(Long id) {

        logger.info("Fetching employee with ID: {}", id);

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Employee not found with ID: {}", id);
                    return new RuntimeException("Employee not found");
                });

        logger.info("Employee found with ID: {}", id);

        return employee;
    }
    
    @Override
    public Employee addEmployee(EmployeeRequestDTO request) {

        Department department = findDepartmentOrThrow(request.getDepartmentId());
        Employee employee = EmployeeMapper.toEntity(request, department);

        return employeeRepository.save(employee);
    }
    
    @Override
    public Page<Employee> getAllEmployee(Pageable pageable){
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
    public Employee updateEmployee(Long id, Employee employee) {

        logger.info("Updating employee with ID: {}", id);

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warn(
                        "Cannot update. Employee not found with ID: {}",
                        id
                    );

                    return new RuntimeException(
                        "Employee not found with ID: " + id
                    );
                });

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhone(employee.getPhone());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setDesignation(employee.getDesignation());
        existingEmployee.setSalary(employee.getSalary());

        Employee updatedEmployee =
                employeeRepository.save(existingEmployee);

        logger.info(
            "Employee updated successfully. ID: {}",
            updatedEmployee.getId()
        );

        return updatedEmployee;
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
	@Override
	public Employee updateEmployee(Long id, EmployeeRequestDTO request) {
		// TODO Auto-generated method stub
		return null;
	}
}
