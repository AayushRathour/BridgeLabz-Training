package com.employeepayroll.Controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employeepayroll.Dto.EmployeeRequestDTO;
import com.employeepayroll.Dto.EmployeeResponseDTO;
import com.employeepayroll.Dto.EmployeeSearchDTO;
import com.employeepayroll.Dto.PageResponseDTO;
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

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(EmployeeMapper.toResponseDTO(employeeService.addEmployee(request)));
    }

    // Gets a zero-based page; example: GET /employees?page=0&size=5&sortBy=name&direction=asc.
    @GetMapping
    public PageResponseDTO<EmployeeResponseDTO> getAllEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        return EmployeeMapper.toPageResponseDTO(employeeService.getAllEmployees(
                buildPageRequest(page, size, sortBy, direction)));
    }

    // Searches by example with the same paging and sorting options.
    @PostMapping("/search")
    public PageResponseDTO<EmployeeResponseDTO> searchEmployees(
            @RequestBody EmployeeSearchDTO criteria,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        return EmployeeMapper.toPageResponseDTO(employeeService.searchEmployees(
                criteria, buildPageRequest(page, size, sortBy, direction)));
    }

    @GetMapping("/{id}")
    public EmployeeResponseDTO getEmployeeById(@PathVariable Long id) {

        return EmployeeMapper.toResponseDTO(employeeService.getEmployeeById(id));
    }

    @PutMapping("/{id}")
    public EmployeeResponseDTO updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeRequestDTO request) {

        return EmployeeMapper.toResponseDTO(employeeService.updateEmployee(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {

        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    // Builds a safe Pageable and prevents sorting by unintended entity properties.
    private PageRequest buildPageRequest(int page, int size, String sortBy, String direction) {
        if (page < 0 || size < 1 || size > 100) {
            throw new IllegalArgumentException("page must be at least 0 and size must be between 1 and 100");
        }

        if (!java.util.Set.of("id", "name", "email", "phone", "designation", "salary").contains(sortBy)) {
            throw new IllegalArgumentException("Unsupported sortBy value: " + sortBy);
        }

        if (!"asc".equalsIgnoreCase(direction) && !"desc".equalsIgnoreCase(direction)) {
            throw new IllegalArgumentException("direction must be asc or desc");
        }

        Sort.Direction sortDirection = Sort.Direction.fromOptionalString(direction)
                .orElseThrow(() -> new IllegalArgumentException("direction must be asc or desc"));
        return PageRequest.of(page, size, Sort.by(sortDirection, sortBy));
    }
}
