package com.company.employeemanagement.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation for validating non-null and non-empty fields.
 * Used with reflection-based validation framework to enforce mandatory field constraints.
 * 
 * <p>Validates that:</p>
 * <ul>
 *   <li>Field is not null</li>
 *   <li>If field is a String, it's not empty or whitespace-only</li>
 * </ul>
 * 
 * <p>Example usage:</p>
 * <pre>
 * {@code @NotNull(message = "Name is required")}
 * private String name;
 * </pre>
 * 
 * @author Employee Management System
 * @version 3.0.0
 * @see com.company.employeemanagement.validation.ObjectValidator
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NotNull {
    /**
     * The error message to display when validation fails.
     * 
     * @return the validation error message
     */
    String message() default "Field cannot be null";
}
