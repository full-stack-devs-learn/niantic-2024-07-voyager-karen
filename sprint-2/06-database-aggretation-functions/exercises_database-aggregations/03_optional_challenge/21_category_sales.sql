USE northwind;

-- 21. Create a query that displays the top 3 most popular categories,
-- include:
    -- the total number of products that were purchased in that category (sum quantity),
    -- and the number of orders that were placed for each category (count unique orders)
-- (use the CustomerOrders View)

-- sort alphabetically by category name

-- expected results
-- ParentCategory	QuantityPurchased	OrdersPlaced
-- Beverages		9532				354
-- Dairy Products	9149				303
-- Confections		7906				295

-- (3 rows)

SELECT category_name AS ParentCategory
	, SUM(quantity) AS QuantityPurchased
    , COUNT(DISTINCT order_id) AS OrderPlaced
FROM customer_orders
GROUP BY category_name
ORDER BY QuantityPurchased DESC
LIMIT 3;





