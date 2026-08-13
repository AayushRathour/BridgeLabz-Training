package com.employeepayroll.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.employeepayroll.Entity.Department;

@Repository
public class DepartmentRepository {

    private final JdbcTemplate jdbcTemplate;

    public DepartmentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Department save(Department department) {

        String sql = """
                INSERT INTO department (name)
                VALUES (?)
                """;

        jdbcTemplate.update(
                sql,
                department.getName()
        );

        return department;
    }

    public List<Department> findAll() {

        String sql = "SELECT * FROM department";

        return jdbcTemplate.query(sql, DepartmentRepository::mapRow);
    }

    public Optional<Department> findById(Long id) {

        String sql = "SELECT * FROM department WHERE id = ?";

        try {
            Department department = jdbcTemplate.queryForObject(sql, DepartmentRepository::mapRow, id);
            return Optional.ofNullable(department);
        } catch (EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }

    public boolean existsById(Long id) {

        String sql = "SELECT COUNT(*) FROM department WHERE id = ?";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }

    public Department update(Long id, Department department) {

        String sql = "UPDATE department SET name = ? WHERE id = ?";

        jdbcTemplate.update(sql, department.getName(), id);

        department.setId(id);
        return department;
    }

    public void deleteById(Long id) {

        String sql = "DELETE FROM department WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static Department mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {

        Department department = new Department();

        department.setId(rs.getLong("id"));
        department.setName(rs.getString("name"));

        return department;
    }
}
