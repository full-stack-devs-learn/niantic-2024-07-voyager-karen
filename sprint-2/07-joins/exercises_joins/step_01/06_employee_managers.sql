-- 6. Select the full name of each employee
-- and the full name of their manager

-- hint look at the employee table to see how to
-- determine who the manager is of each employee

-- you will need to do a "self join" to the employees table
-- and you will need to create table aliases to complete this query

-- (9 rows)


-- looks like I added myself so 10 rows returned -- 

USE northwind;

SELECT 
    CONCAT(e.first_name, ' ', e.last_name) AS EmployeeName,
    CONCAT(m.first_name, ' ', m.last_name) AS ManagerName
FROM 
    Employees e
LEFT JOIN 
    Employees m 
    ON e.reports_to = m.employee_id
ORDER BY 
    EmployeeName;




