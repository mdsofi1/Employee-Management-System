package com.company.employeemanagement.test;

import com.company.employeemanagement.model.Employee;
import com.company.employeemanagement.model.PermanentEmployee;
import com.company.employeemanagement.repository.EmployeeDAO;
import com.company.employeemanagement.repository.EmployeeDAOImpl;

import java.util.List;
import java.util.Optional;

/**
 * Test class for CRUD operations using EmployeeDAO
 */
public class EmployeeDAOTest {

    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAOImpl();

        System.out.println("=== Testing CRUD Operations ===\n");

        // Test 1: Save Employee
        System.out.println("1. Testing SAVE Operation:");
        try {
            Employee emp1 = new PermanentEmployee(101, "John Doe", "john@company.com", "IT", 50000, 5000);
            Employee emp2 = new PermanentEmployee(102, "Jane Smith", "jane@company.com", "HR", 45000, 4000);
            Employee emp3 = new PermanentEmployee(103, "Bob Johnson", "bob@company.com", "Finance", 55000, 6000);
            
            dao.save(emp1);
            dao.save(emp2);
            dao.save(emp3);
            System.out.println("✓ Successfully saved 3 employees\n");
        } catch (Exception e) {
            System.err.println("✗ Failed to save employees: " + e.getMessage() + "\n");
        }

        // Test 2: Find By ID
        System.out.println("2. Testing FIND BY ID Operation:");
        try {
            Optional<Employee> employee = dao.findById(101);
            if (employee.isPresent()) {
                System.out.println("✓ Employee found: " + employee.get().getName());
                System.out.println("  ID: " + employee.get().getEmployeeId());
                System.out.println("  Department: " + employee.get().getDepartment());
            } else {
                System.out.println("✗ Employee not found");
            }
            System.out.println();
        } catch (Exception e) {
            System.err.println("✗ Failed to find employee: " + e.getMessage() + "\n");
        }

        // Test 3: Find All
        System.out.println("3. Testing FIND ALL Operation:");
        try {
            List<Employee> employees = dao.findAll();
            System.out.println("✓ Retrieved " + employees.size() + " employees:");
            for (Employee emp : employees) {
                System.out.println("  - ID: " + emp.getEmployeeId() + ", Name: " + emp.getName() + ", Department: " + emp.getDepartment());
            }
            System.out.println();
        } catch (Exception e) {
            System.err.println("✗ Failed to retrieve employees: " + e.getMessage() + "\n");
        }

        // Test 4: Delete By ID
        System.out.println("4. Testing DELETE Operation:");
        try {
            dao.deleteById(103);
            System.out.println("✓ Employee with ID 103 deleted");
            
            // Verify deletion
            List<Employee> employeesAfterDelete = dao.findAll();
            System.out.println("  Remaining employees: " + employeesAfterDelete.size());
            System.out.println();
        } catch (Exception e) {
            System.err.println("✗ Failed to delete employee: " + e.getMessage() + "\n");
        }

        // Test 5: Find Non-existent Employee
        System.out.println("5. Testing FIND Non-existent Employee:");
        try {
            Optional<Employee> employee = dao.findById(999);
            if (employee.isPresent()) {
                System.out.println("✗ Unexpected: Found employee with ID 999");
            } else {
                System.out.println("✓ Correctly returned empty Optional for non-existent employee");
            }
            System.out.println();
        } catch (Exception e) {
            System.err.println("✗ Error while finding non-existent employee: " + e.getMessage() + "\n");
        }

        System.out.println("=== CRUD Operations Test Complete ===");
    }
}
