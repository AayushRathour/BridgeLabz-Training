package com.employeepayroll.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.employeepayroll.Dto.EmployeeRequestDTO;
import com.employeepayroll.Dto.EmployeeResponseDTO;
import com.employeepayroll.Dto.PageResponseDTO;
import com.employeepayroll.Entity.Department;
import com.employeepayroll.Entity.Employee;

public class EmployeeMapper {

    private EmployeeMapper() {
    }

    // The service resolves the department so this mapper stays database-free.
    public static Employee toEntity(EmployeeRequestDTO dto, Department department) {

        Employee employee = new Employee();

        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setDepartment(department);
        employee.setDesignation(dto.getDesignation());
        employee.setSalary(dto.getSalary());

        return employee;
    }

    public static EmployeeResponseDTO toResponseDTO(Employee employee) {

        Department department = employee.getDepartment();

        return new EmployeeResponseDTO(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getPhone(),
                department != null ? department.getId() : null,
                department != null ? department.getName() : null,
                employee.getDesignation(),
                employee.getSalary()
        );
    }

    public static List<EmployeeResponseDTO> toResponseDTOList(List<Employee> employees) {

        return employees.stream()
                .map(EmployeeMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
    // Maps page metadata and employee content into a JSON-friendly response.
    public static PageResponseDTO<EmployeeResponseDTO> toPageResponseDTO(Page<Employee> page) {

        List<EmployeeResponseDTO> content = toResponseDTOList(page.getContent());

        Sort sort = page.getSort();
        String sortBy = sort.isSorted() ? sort.iterator().next().getProperty() : null;
        String sortDirection = sort.isSorted() ? sort.iterator().next().getDirection().name() : null;

        return new PageResponseDTO<>(
                content,
                page.getNumber(),         
                page.getSize(),            
                page.getTotalElements(),  
                page.getTotalPages(),     
                page.isLast(),             
                sortBy,
                sortDirection
        );
    }
}
