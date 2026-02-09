package com.company.employeemanagement.repository;

import java.util.List;
import java.util.Optional;

import com.company.employeemanagement.model.Employee;

/**
 * Data Access Object interface for Employee operations
 * Defines CRUD operations for Employee entities
 */
public interface EmployeeDAO {
    void save(Employee employee);
    Optional<Employee> findById(int id);
    List<Employee> findAll();
    void deleteById(int id);
}
