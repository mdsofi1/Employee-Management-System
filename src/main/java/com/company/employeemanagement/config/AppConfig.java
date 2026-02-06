package com.company.employeemanagement.config;

/**
 * Application-wide configuration constants.
 * Demonstrates Single Responsibility Principle (SRP) - handles only configuration.
 * 
 * <p>This utility class provides centralized configuration for:</p>
 * <ul>
 *   <li>Display formatting constants</li>
 *   <li>Validation minimum values</li>
 *   <li>Tax and business rules</li>
 *   <li>Menu option codes</li>
 *   <li>Standard messages</li>
 * </ul>
 * 
 * <p>Benefits of centralized configuration:</p>
 * <ul>
 *   <li>Easy to modify application behavior</li>
 *   <li>Consistent values across the application</li>
 *   <li>Single source of truth for constants</li>
 *   <li>Prevents magic numbers in code</li>
 * </ul>
 * 
 * @author Employee Management System
 * @version 3.0.0
 */
public final class AppConfig {
    
    /**
     * Private constructor to prevent instantiation.
     * This is a utility class with only static members.
     * 
     * @throws AssertionError if instantiation is attempted
     */
    private AppConfig() {
        throw new AssertionError("Cannot instantiate AppConfig");
    }
    
    // ===== Display Constants =====
    /** Standard separator line for console output */
    public static final String SEPARATOR = "========================================";
    /** Prefix for success messages */
    public static final String SUCCESS_PREFIX = "[SUCCESS] ";
    /** Prefix for error messages */
    public static final String ERROR_PREFIX = "[ERROR] ";
    /** Prefix for informational messages */
    public static final String INFO_PREFIX = "[INFO] ";
    
    // ===== Validation Constants =====
    /** Minimum base salary for permanent employees */
    public static final double MIN_BASE_SALARY = 10000.0;
    /** Minimum hourly rate for contract employees */
    public static final double MIN_HOURLY_RATE = 15.0;
    /** Minimum contract duration in months */
    public static final int MIN_CONTRACT_DURATION = 1;
    /** Minimum benefits amount (must be non-negative) */
    public static final double MIN_BENEFITS = 0.0;
    /** Minimum bonus amount (must be non-negative) */
    public static final double MIN_BONUS = 0.0;
    /** Minimum hours worked (must be non-negative) */
    public static final int MIN_HOURS_WORKED = 0;
    
    // ===== Tax Configuration =====
    /** Standard tax rate applied to salaries (15%) */
    public static final double TAX_RATE = 0.15; // 15% tax rate
    
    // ===== Menu Options =====
    public static final int MENU_ADD_EMPLOYEE = 1;
    public static final int MENU_DELETE_EMPLOYEE = 2;
    public static final int MENU_SEARCH_BY_ID = 3;
    public static final int MENU_SEARCH_BY_NAME = 4;
    public static final int MENU_SEARCH_BY_DEPARTMENT = 5;
    public static final int MENU_LIST_ALL = 6;
    public static final int MENU_PAYROLL_SUMMARY = 7;
    public static final int MENU_REPORTS = 8;
    public static final int MENU_SAMPLE_DATA = 9;
    public static final int MENU_EXIT = 0;
    
    // ===== Messages =====
    public static final String MSG_EMPLOYEE_ADDED = "Employee added successfully";
    public static final String MSG_EMPLOYEE_DELETED = "Employee deleted successfully";
    public static final String MSG_EMPLOYEE_NOT_FOUND = "Employee not found";
    public static final String MSG_INVALID_CHOICE = "Invalid choice. Please try again.";
    public static final String MSG_THANK_YOU = "Thank you for using Employee Management System!";
    
    // ===== Application Info =====
    public static final String APP_NAME = "Employee Management System";
    public static final String APP_VERSION = "2.0";
    public static final String APP_TITLE = "   " + APP_NAME;
}
