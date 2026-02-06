package com.company.employeemanagement.exception;

/**
 * Custom runtime exception thrown when employee data fails validation.
 * Extends RuntimeException for unchecked exception behavior.
 * 
 * <p>This exception is thrown when:</p>
 * <ul>
 *   <li>Required fields (@NotNull) are null or empty</li>
 *   <li>Numeric fields (@Min) are below minimum values</li>
 *   <li>Business rules are violated (e.g., duplicate employee ID)</li>
 *   <li>Data format or type constraints are not met</li>
 * </ul>
 * 
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * if (employee == null) {
 *     throw new InvalidEmployeeDataException("Employee cannot be null");
 * }
 * }
 * </pre>
 * 
 * @author Employee Management System
 * @version 3.0.0
 * @see com.company.employeemanagement.validation.ObjectValidator
 */
public class InvalidEmployeeDataException extends RuntimeException {
    /**
     * Constructs a new InvalidEmployeeDataException with the specified message.
     * 
     * @param message descriptive error message explaining the validation failure
     */
    public InvalidEmployeeDataException(String message) {
        super(message);
    }
}
