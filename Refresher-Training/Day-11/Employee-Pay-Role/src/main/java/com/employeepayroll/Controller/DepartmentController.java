package com.employeepayroll.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employeepayroll.Dto.DepartmentRequestDTO;
import com.employeepayroll.Dto.DepartmentResponseDTO;
import com.employeepayroll.Entity.Department;
import com.employeepayroll.Mapper.DepartmentMapper;
import com.employeepayroll.Service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentResponseDTO> addDepartment(
            @Valid @RequestBody DepartmentRequestDTO request) {

        Department department = DepartmentMapper.toEntity(request);
        Department saved = departmentService.addDepartment(department);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(DepartmentMapper.toResponseDTO(saved));
    }

    @GetMapping
    public List<DepartmentResponseDTO> getAllDepartments() {

        return DepartmentMapper.toResponseDTOList(departmentService.getAllDepartments());
    }

    @GetMapping("/{id}")
    public DepartmentResponseDTO getDepartmentById(@PathVariable Long id) {

        return DepartmentMapper.toResponseDTO(departmentService.getDepartmentById(id));
    }

    @PutMapping("/{id}")
    public DepartmentResponseDTO updateDepartment(
            @PathVariable Long id,
            @Valid @RequestBody DepartmentRequestDTO request) {

        Department department = DepartmentMapper.toEntity(request);
        Department updated = departmentService.updateDepartment(id, department);

        return DepartmentMapper.toResponseDTO(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {

        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}
