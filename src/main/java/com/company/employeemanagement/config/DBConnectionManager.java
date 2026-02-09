package com.company.employeemanagement.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database Connection Manager using Singleton pattern
 * Manages a single connection to the MySQL database
 */
public class DBConnectionManager {

    private static Connection connection;

    private DBConnectionManager() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee_db",
                    "ejaz",
                    "Ejaz@123"
                );
            } catch (SQLException e) {
                throw new RuntimeException("DB Connection Failed", e);
            }
        }
        return connection;
    }
}
