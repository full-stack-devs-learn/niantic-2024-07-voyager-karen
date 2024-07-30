USE northwind;

-- give me the full name and hire date of each employee
SELECT CONCAT(first_name, ' ', last_name) AS full_name
    , hire_date
FROM employees;