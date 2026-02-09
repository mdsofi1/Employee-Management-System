package com.company.employeemanagement.repository;

import com.company.employeemanagement.config.DBConnectionManager;
import com.company.employeemanagement.logging.AppLogger;
import com.company.employeemanagement.model.Employee;
import com.company.employeemanagement.model.PermanentEmployee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * JDBC implementation of EmployeeDAO
 * Handles database operations for Employee entities
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    private static final Logger LOGGER = AppLogger.LOGGER;

    @Override
    public void save(Employee employee) {
        String sql = "INSERT INTO employee VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps =
                DBConnectionManager.getConnection().prepareStatement(sql)) {

            ps.setInt(1, employee.getEmployeeId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getDepartment());
            ps.setString(4, employee.getClass().getSimpleName());
            
            // Handle baseSalary for PermanentEmployee
            double baseSalary = 0.0;
            if (employee instanceof PermanentEmployee permEmp) {
                baseSalary = permEmp.getBaseSalary();
            }
            ps.setDouble(5, baseSalary);

            ps.executeUpdate();
            LOGGER.info(() -> "Employee saved with ID: " + employee.getEmployeeId());
        } catch (SQLException e) {
            LOGGER.severe(() -> "Failed to save employee with ID: " + employee.getEmployeeId() + " - " + e.getMessage());
            throw new RuntimeException("Failed to save employee", e);
        }
    }

    @Override
    public Optional<Employee> findById(int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";

        try (PreparedStatement ps =
                DBConnectionManager.getConnection().prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                LOGGER.info(() -> "Employee found with ID: " + id);
                return Optional.of(mapToEmployee(rs));
            }
            LOGGER.info(() -> "Employee not found with ID: " + id);
        } catch (SQLException e) {
            LOGGER.severe(() -> "Failed to find employee with ID: " + id + " - " + e.getMessage());
            throw new RuntimeException("Failed to find employee", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        List<Employee> employees = new ArrayList<>();

        try (PreparedStatement ps =
                DBConnectionManager.getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                employees.add(mapToEmployee(rs));
            }
            LOGGER.info(() -> "Retrieved " + employees.size() + " employees from database");
        } catch (SQLException e) {
            LOGGER.severe(() -> "Failed to retrieve employees: " + e.getMessage());
            throw new RuntimeException("Failed to retrieve employees", e);
        }
        return employees;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";

        try (PreparedStatement ps =
                DBConnectionManager.getConnection().prepareStatement(sql)) {

            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                LOGGER.info(() -> "Employee deleted with ID: " + id);
            } else {
                LOGGER.warning(() -> "No employee found to delete with ID: " + id);
            }
        } catch (SQLException e) {
            LOGGER.severe(() -> "Failed to delete employee with ID: " + id + " - " + e.getMessage());
            throw new RuntimeException("Failed to delete employee", e);
        }
    }

    /**
     * Maps a ResultSet row to an Employee object
     */
    private Employee mapToEmployee(ResultSet rs) throws SQLException {
        PermanentEmployee emp = new PermanentEmployee();
        emp.setEmployeeId(rs.getInt("id"));
        emp.setName(rs.getString("name"));
        emp.setDepartment(rs.getString("department"));
        emp.setBaseSalary(rs.getDouble("base_salary"));
        return emp;
    }
}
