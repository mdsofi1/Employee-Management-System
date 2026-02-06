package com.company.employeemanagement.model;

import com.company.employeemanagement.annotations.NotNull;

/**
 * Abstract base class for all employee types.
 * Demonstrates Liskov Substitution Principle (LSP) - all subclasses can be used interchangeably.
 * 
 * <p>This class defines common attributes and behaviors for all employees:
 * <ul>
 *   <li>Employee ID - unique identifier</li>
 *   <li>Name - validated as mandatory via {@link NotNull} annotation</li>
 *   <li>Email - validated as mandatory via {@link NotNull} annotation</li>
 *   <li>Department - validated as mandatory via {@link NotNull} annotation</li>
 * </ul>
 * 
 * <p>Subclasses must implement:</p>
 * <ul>
 *   <li>{@link #calculateSalary()} - type-specific salary calculation</li>
 *   <li>{@link #displayDetails()} - type-specific display logic</li>
 * </ul>
 * 
 * @author Employee Management System
 * @version 3.0.0
 * @see PermanentEmployee
 * @see ContractEmployee
 * @see Manager
 */
public abstract class Employee {
    /** Unique identifier for the employee */
    private int employeeId;
    
    /** Employee's full name - mandatory field */
    @NotNull(message = "Employee name is mandatory")
    private String name;
    
    /** Employee's email address - mandatory field */
    @NotNull(message = "Employee email is mandatory")
    private String email;
    
    /** Department the employee belongs to - mandatory field */
    @NotNull(message = "Employee department is mandatory")
    private String department;
    
    /**
     * Default no-argument constructor.
     */
    public Employee() {
    }
    
    /**
     * Parameterized constructor to initialize all employee attributes.
     * 
     * @param employeeId unique identifier for the employee
     * @param name employee's full name
     * @param email employee's email address
     * @param department department the employee belongs to
     */
    public Employee(int employeeId, String name, String email, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.department = department;
    }
    
    // Getters and Setters with JavaDoc
    
    /**
     * Gets the employee's unique identifier.
     * 
     * @return the employee ID
     */
    public int getEmployeeId() {
        return employeeId;
    }
    
    /**
     * Sets the employee's unique identifier.
     * 
     * @param employeeId the employee ID to set
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    
    /**
     * Gets the employee's full name.
     * 
     * @return the employee name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the employee's full name.
     * 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Gets the employee's email address.
     * 
     * @return the email address
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Sets the employee's email address.
     * 
     * @param email the email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Gets the department the employee belongs to.
     * 
     * @return the department name
     */
    public String getDepartment() {
        return department;
    }
    
    /**
     * Sets the department the employee belongs to.
     * 
     * @param department the department name to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }
    
    /**
     * Calculates the employee's salary.
     * Implementation varies by employee type (permanent, contract, manager).
     * 
     * @return the calculated salary amount
     */
    public abstract double calculateSalary();
    
    /**
     * Displays the employee's details to console.
     * Implementation varies by employee type to show type-specific information.
     */
    public abstract void displayDetails();
    
    /**
     * Returns a string representation of the employee.
     * 
     * @return string containing employee's basic information
     */
    @Override
    public String toString() {
        return "Employee [ID=" + employeeId + ", Name=" + name + 
               ", Email=" + email + ", Department=" + department + "]";
    }
}
