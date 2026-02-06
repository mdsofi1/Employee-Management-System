package com.company.employeemanagement.repository;

import com.company.employeemanagement.model.Employee;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for employee data access operations.
 * Demonstrates Dependency Inversion Principle (DIP) - high-level modules depend on this abstraction.
 * 
 * <p>This interface defines the contract for employee data access, allowing for multiple implementations:</p>
 * <ul>
 *   <li>EmployeeRepository - in-memory implementation</li>
 *   <li>JdbcEmployeeRepository - database implementation (future)</li>
 *   <li>RestApiEmployeeRepository - REST API implementation (future)</li>
 * </ul>
 * 
 * <p>Benefits of interface-based design:</p>
 * <ul>
 *   <li>Easy to swap implementations without changing business logic</li>
 *   <li>Easy to mock for unit testing</li>
 *   <li>Supports different storage mechanisms</li>
 *   <li>Follows SOLID principles</li>
 * </ul>
 * 
 * @author Employee Management System
 * @version 3.0.0
 * @see EmployeeRepository
 */
public interface IEmployeeRepository {
    
    /**
     * Adds a new employee to the repository.
     * 
     * @param employee the employee to add (must not be null)
     * @return true if the employee was added successfully, false if employee is null or already exists
     */
    boolean addEmployee(Employee employee);
    
    /**
     * Removes an employee from the repository by their ID.
     * 
     * @param employeeId the unique identifier of the employee to remove
     * @return true if the employee was found and removed, false if not found
     */
    boolean removeEmployee(int employeeId);
    
    /**
     * Finds an employee by their unique identifier.
     * Uses Optional to handle cases where employee might not exist.
     * 
     * @param employeeId the unique identifier of the employee
     * @return Optional containing the employee if found, empty Optional otherwise
     */
    Optional<Employee> findEmployeeById(int employeeId);
    
    /**
     * Finds employees whose names contain the search string (case-insensitive).
     * 
     * @param name the name or partial name to search for
     * @return list of employees matching the search criteria (empty list if none found)
     */
    List<Employee> findEmployeesByName(String name);
    
    /**
     * Finds all employees in a specific department (case-insensitive).
     * 
     * @param department the department name to search for
     * @return list of employees in the specified department (empty list if none found)
     */
    List<Employee> findEmployeesByDepartment(String department);
    
    /**
     * Retrieves all employees from the repository.
     * 
     * @return list of all employees (empty list if repository is empty)
     */
    List<Employee> getAllEmployees();
    
    /**
     * Updates an existing employee's information.
     * The employee is identified by their ID, and all other fields are updated.
     * 
     * @param employee the employee with updated information
     * @return true if the employee was found and updated, false if not found or employee is null
     */
    boolean updateEmployee(Employee employee);
    
    /**
     * Check if employee exists by ID
     * @param employeeId The ID to check
     * @return true if exists, false otherwise
     */
    boolean employeeExists(int employeeId);
    
    /**
     * Get total number of employees
     * @return The count of employees
     */
    int getEmployeeCount();
    
    /**
     * Clear all employees (for testing purposes)
     */
    void clearAll();
}
