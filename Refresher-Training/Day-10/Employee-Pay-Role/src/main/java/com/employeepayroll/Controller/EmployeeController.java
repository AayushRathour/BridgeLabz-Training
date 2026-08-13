package com.employeepayroll.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employeepayroll.Dto.EmployeeRequestDTO;
import com.employeepayroll.Dto.EmployeeResponseDTO;
import com.employeepayroll.Entity.Employee;
import com.employeepayroll.Mapper.EmployeeMapper;
import com.employeepayroll.Service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> addEmployee(
            @Valid @RequestBody EmployeeRequestDTO request) {

        Employee employee = EmployeeMapper.toEntity(request);
        Employee saved = employeeService.addEmployee(employee);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(EmployeeMapper.toResponseDTO(saved));
    }

    @GetMapping
    public List<EmployeeResponseDTO> getAllEmployees() {

        return EmployeeMapper.toResponseDTOList(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public EmployeeResponseDTO getEmployeeById(@PathVariable Long id) {

        return EmployeeMapper.toResponseDTO(employeeService.getEmployeeById(id));
    }

    @PutMapping("/{id}")
    public EmployeeResponseDTO updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeRequestDTO request) {

        Employee employee = EmployeeMapper.toEntity(request);
        Employee updated = employeeService.updateEmployee(id, employee);

        return EmployeeMapper.toResponseDTO(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {

        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
