USE northwind;

-- 18. Count the number of customers in each country
-- include the country and total_customer_count
-- (use customers table)

-- (21 rows)

SELECT COUNT(DISTINCT customer_id) AS total_customer_count
	, country
FROM customers
GROUP BY country;



