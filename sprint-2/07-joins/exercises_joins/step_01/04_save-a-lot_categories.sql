-- 4. I want to know what category is the most popular
-- category for my best customer.

-- SELECT the Company Name, Category, and the OrderCount
-- for Save-a-lot Markets. (my best customer)
-- (the order count specifies how many times a category
-- was included in their orders)

-- sort in the order of the most ordered category to the least

-- (8 rows)

USE northwind;

SELECT cu.company_name
	, c.category_name
    , COUNT(*) AS OrderCount
FROM orders AS o
JOIN order_details AS od
	ON o.order_id = od.order_id
JOIN products AS p
	ON od.product_id = p.product_id
JOIN categories AS c
	ON p.category_id = c.category_id
JOIN customers AS cu
	ON o.customer_id = cu.customer_id
WHERE cu.company_name = 'Save-a-lot Markets'
GROUP BY
	cu.company_name,
    c.category_name
ORDER BY OrderCount DESC;
