USE northwind;

-- 16. Total sales by any customer who has spent more than $10000
-- Include the CompanyName, State and TotalSales
-- Sort by total sales desc
-- (Use the customer_orders view)

-- (6 rows)

SELECT company_name
	, region
    , SUM(sales_price * quantity) AS total_sales
FROM customer_orders
GROUP BY company_name, region
HAVING SUM(sales_price * quantity) > 10000
ORDER BY total_sales DESC;






