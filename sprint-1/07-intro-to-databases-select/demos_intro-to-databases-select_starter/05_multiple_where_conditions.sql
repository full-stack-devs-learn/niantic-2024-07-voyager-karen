USE northwind;

-- All sales rep in Washington
-- first name, last name, title, state
SELECT first_name
	, last_name
    , title
    , region as state
FROM employees
WHERE title = 'Sales Representative'
	AND region = 'WA';
