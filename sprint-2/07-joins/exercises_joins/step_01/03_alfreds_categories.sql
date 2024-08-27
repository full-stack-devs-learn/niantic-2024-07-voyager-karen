-- 3.  List of all the categories 
-- that Alfreds Futterkiste has ever ordered
-- (5 rows)


-- had to use distinct 

USE Northwind;


SELECT DISTINCT c.category_name
FROM categories AS c
JOIN products AS p
	ON c.category_id = p.category_id
JOIN order_details AS od
	ON p.product_id = od.product_id
JOIN orders AS o
	ON od.order_id = o.order_id
JOIN customers AS cu
	ON o.customer_id = cu.customer_id
WHERE cu.company_name = 'Alfreds Futterkiste';


