USE northwind;

-- Give me all customer names
-- whose company name begins with the Letter D or E

SELECT *
FROM customers
WHERE company_name LIKE 'D%'
	OR company_name LIKE 'E%';




-- WHERE company_name > 'D'
-- 	AND company_name < 'E';