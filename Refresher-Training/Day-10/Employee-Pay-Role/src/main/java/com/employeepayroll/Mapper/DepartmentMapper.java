package com.employeepayroll.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.employeepayroll.Dto.DepartmentRequestDTO;
import com.employeepayroll.Dto.DepartmentResponseDTO;
import com.employeepayroll.Entity.Department;

public class DepartmentMapper {

    private DepartmentMapper() {
    }

    public static Department toEntity(DepartmentRequestDTO dto) {

        Department department = new Department();
        department.setName(dto.getName());

        return department;
    }

    public static DepartmentResponseDTO toResponseDTO(Department department) {

        return new DepartmentResponseDTO(
                department.getId(),
                department.getName()
        );
    }

    public static List<DepartmentResponseDTO> toResponseDTOList(List<Department> departments) {

        return departments.stream()
                .map(DepartmentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
