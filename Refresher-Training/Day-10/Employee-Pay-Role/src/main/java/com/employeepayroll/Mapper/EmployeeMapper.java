package com.employeepayroll.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.employeepayroll.Dto.EmployeeRequestDTO;
import com.employeepayroll.Dto.EmployeeResponseDTO;
import com.employeepayroll.Entity.Employee;

public class EmployeeMapper {

    private EmployeeMapper() {
    }

    public static Employee toEntity(EmployeeRequestDTO dto) {

        Employee employee = new Employee();

        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setDepartment(dto.getDepartment());
        employee.setDesignation(dto.getDesignation());
        employee.setSalary(dto.getSalary());

        return employee;
    }

    public static EmployeeResponseDTO toResponseDTO(Employee employee) {

        return new EmployeeResponseDTO(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getDepartment(),
                employee.getDesignation(),
                employee.getSalary()
        );
    }

    public static List<EmployeeResponseDTO> toResponseDTOList(List<Employee> employees) {

        return employees.stream()
                .map(EmployeeMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
