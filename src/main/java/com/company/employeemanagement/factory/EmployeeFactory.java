package com.company.employeemanagement.factory;

import com.company.employeemanagement.model.*;

/**
 * Factory class for creating employee instances.
 * Implements Factory Pattern and demonstrates Open/Closed Principle (OCP).
 * 
 * <p>Benefits:</p>
 * <ul>
 *   <li>Centralizes object creation logic</li>
 *   <li>Easy to add new employee types without modifying existing code</li>
 *   <li>Provides type-safe employee creation</li>
 *   <li>Can add validation or logging during creation</li>
 * </ul>
 * 
 * @author Employee Management System
 * @version 3.0.0
 */
public class EmployeeFactory {
    
    /**
     * Enumeration of supported employee types.
     * Can be extended with new types as needed (OCP).
     */
    public enum EmployeeType {
        /** Permanent full-time employee */
        PERMANENT,
        /** Contract or temporary employee */
        CONTRACT,
        /** Manager with additional responsibilities */
        MANAGER
    }
    
    /**
     * Creates a permanent employee instance.
     * 
     * @param id unique employee identifier
     * @param name employee's full name
     * @param email employee's email address
     * @param department department the employee belongs to
     * @param baseSalary base salary amount
     * @param benefits additional benefits amount
     * @return newly created PermanentEmployee instance
     */
    public static PermanentEmployee createPermanentEmployee(
            int id, String name, String email, String department,
            double baseSalary, double benefits) {
        return new PermanentEmployee(id, name, email, department, baseSalary, benefits);
    }
    
    /**
     * Creates a contract employee instance.
     * 
     * @param id unique employee identifier
     * @param name employee's full name
     * @param email employee's email address
     * @param department department the employee belongs to
     * @param hourlyRate rate per hour worked
     * @param hoursWorked total hours worked
     * @param contractDuration duration of contract in months
     * @return newly created ContractEmployee instance
     */
    public static ContractEmployee createContractEmployee(
            int id, String name, String email, String department,
            double hourlyRate, int hoursWorked, int contractDuration) {
        return new ContractEmployee(id, name, email, department, hourlyRate, hoursWorked, contractDuration);
    }
    
    /**
     * Creates a manager instance.
     * 
     * @param id unique employee identifier
     * @param name manager's full name
     * @param email manager's email address
     * @param department department the manager oversees
     * @param baseSalary base salary amount
     * @param benefits additional benefits amount
     * @param bonus performance or management bonus
     * @return newly created Manager instance
     */
    public static Manager createManager(
            int id, String name, String email, String department,
            double baseSalary, double benefits, double bonus) {
        return new Manager(id, name, email, department, baseSalary, benefits, bonus);
    }
    
    /**
     * Gets a human-readable description for an employee type.
     * 
     * @param type the employee type enum value
     * @return descriptive string for the employee type
     */
    public static String getEmployeeTypeDescription(EmployeeType type) {
        return switch (type) {
            case PERMANENT -> "Permanent Employee";
            case CONTRACT -> "Contract Employee";
            case MANAGER -> "Manager";
        };
    }
}
