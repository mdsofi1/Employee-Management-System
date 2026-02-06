package com.company.employeemanagement.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation for validating minimum numeric values.
 * Used with reflection-based validation framework to enforce minimum constraints on fields.
 * 
 * <p>Example usage:</p>
 * <pre>
 * {@code @Min(value = 10000, message = "Salary must be at least 10000")}
 * private double salary;
 * </pre>
 * 
 * @author Employee Management System
 * @version 3.0.0
 * @see com.company.employeemanagement.validation.ObjectValidator
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Min {
    /**
     * The minimum value allowed for the annotated field.
     * 
     * @return the minimum value
     */
    double value();
    
    /**
     * The error message to display when validation fails.
     * 
     * @return the validation error message
     */
    String message() default "Value is below minimum";
}
