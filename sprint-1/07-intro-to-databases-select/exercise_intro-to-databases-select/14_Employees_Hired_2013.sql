USE northwind;

-- The employee name and title
-- of all employees who were hired
-- in 2013

-- Expected: 3 rows

SELECT first_name
	, last_name 
    , title_of_courtesy
    , hire_date
FROM employees
WHERE hire_date LIKE '2013%';

