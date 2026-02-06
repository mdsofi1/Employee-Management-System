package com.company.employeemanagement.exception;

/**
 * Custom runtime exception thrown when an employee is not found in the system.
 * Extends RuntimeException for unchecked exception behavior.
 * 
 * <p>This exception is typically thrown by:</p>
 * <ul>
 *   <li>EmployeeService when searching/updating/deleting non-existent employees</li>
 *   <li>EmployeeRepository when employee lookup fails</li>
 * </ul>
 * 
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * Employee emp = repository.findById(id)
 *     .orElseThrow(() -> new EmployeeNotFoundException(id));
 * }
 * </pre>
 * 
 * @author Employee Management System
 * @version 3.0.0
 */
public class EmployeeNotFoundException extends RuntimeException {
    /**
     * Constructs a new EmployeeNotFoundException with employee ID.
     * 
     * @param id the ID of the employee that was not found
     */
    public EmployeeNotFoundException(int id) {
        super("Employee not found with ID: " + id);
    }
}
