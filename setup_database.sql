-- Create database if it doesn't exist
CREATE DATABASE IF NOT EXISTS employee_db;

USE employee_db;

-- Drop table if exists
DROP TABLE IF EXISTS employee;

-- Create employee table
CREATE TABLE employee (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(100),
    type VARCHAR(50),
    base_salary DOUBLE
);

-- Display table structure
DESCRIBE employee;
