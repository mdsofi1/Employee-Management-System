package com.company.employeemanagement.interfaces;

import com.company.employeemanagement.model.Employee;

/**
 * Custom functional interface for filtering employees based on conditions.
 * Demonstrates functional programming concepts with lambda expressions and method references.
 * 
 * <p>This interface provides:</p>
 * <ul>
 *   <li>Single abstract method (SAM) for testing employee conditions</li>
 *   <li>Default methods for composing conditions (AND, OR, NEGATE)</li>
 *   <li>Support for lambda expressions and method references</li>
 * </ul>
 * 
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * // Simple condition
 * EmployeeCondition highEarner = e -> e.calculateSalary() > 100000;
 * 
 * // Composed conditions
 * EmployeeCondition engineer = e -> e.getDepartment().equals("Engineering");
 * EmployeeCondition highEarningEngineer = highEarner.and(engineer);
 * 
 * // Filter employees
 * List<Employee> filtered = employees.stream()
 *     .filter(e -> highEarningEngineer.test(e))
 *     .collect(Collectors.toList());
 * }
 * </pre>
 * 
 * @author Employee Management System
 * @version 3.0.0
 * @since Week 4 - Functional Programming
 */
@FunctionalInterface
public interface EmployeeCondition {
    /**
     * Tests if an employee satisfies this condition.
     * This is the single abstract method (SAM) of this functional interface.
     * 
     * @param employee the employee to test against the condition
     * @return true if the employee satisfies the condition, false otherwise
     */
    boolean test(Employee employee);
    
    /**
     * Returns a composed condition that represents a logical AND of this condition and another.
     * Short-circuits if this condition is false.
     * 
     * @param other the condition to AND with this condition
     * @return a composed condition that tests both conditions
     */
    default EmployeeCondition and(EmployeeCondition other) {
        return (employee) -> this.test(employee) && other.test(employee);
    }
    
    /**
     * Returns a composed condition that represents a logical OR of this condition and another.
     * Short-circuits if this condition is true.
     * 
     * @param other the condition to OR with this condition
     * @return a composed condition that tests either condition
     */
    default EmployeeCondition or(EmployeeCondition other) {
        return (employee) -> this.test(employee) || other.test(employee);
    }
    
    /**
     * Returns a condition that represents the logical negation (NOT) of this condition.
     * 
     * @return a condition that returns the opposite of this condition's result
     */
    default EmployeeCondition negate() {
        return (employee) -> !this.test(employee);
    }
}
