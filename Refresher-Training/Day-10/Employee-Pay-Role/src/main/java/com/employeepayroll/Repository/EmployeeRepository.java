package com.employeepayroll.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.employeepayroll.Entity.Employee;

@Repository
public class EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Employee save(Employee employee) {

        String sql = """
                INSERT INTO employee
                (name, email, phone, department, designation, salary)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        jdbcTemplate.update(
                sql,
                employee.getName(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getDepartment(),
                employee.getDesignation(),
                employee.getSalary()
        );

        return employee;
    }

    public List<Employee> findAll() {

        String sql = "SELECT * FROM employee";

        return jdbcTemplate.query(sql, EmployeeRepository::mapRow);
    }

    public Optional<Employee> findById(Long id) {

        String sql = "SELECT * FROM employee WHERE id = ?";

        try {
            Employee employee = jdbcTemplate.queryForObject(sql, EmployeeRepository::mapRow, id);
            return Optional.ofNullable(employee);
        } catch (EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }

    public boolean existsById(Long id) {

        String sql = "SELECT COUNT(*) FROM employee WHERE id = ?";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }

    public Employee update(Long id, Employee employee) {

        String sql = """
                UPDATE employee
                SET name = ?, email = ?, phone = ?, department = ?, designation = ?, salary = ?
                WHERE id = ?
                """;

        jdbcTemplate.update(
                sql,
                employee.getName(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getDepartment(),
                employee.getDesignation(),
                employee.getSalary(),
                id
        );

        employee.setId(id);
        return employee;
    }

    public void deleteById(Long id) {

        String sql = "DELETE FROM employee WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static Employee mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {

        Employee employee = new Employee();

        employee.setId(rs.getLong("id"));
        employee.setName(rs.getString("name"));
        employee.setEmail(rs.getString("email"));
        employee.setPhone(rs.getString("phone"));
        employee.setDepartment(rs.getString("department"));
        employee.setDesignation(rs.getString("designation"));
        employee.setSalary(rs.getDouble("salary"));

        return employee;
    }
}
