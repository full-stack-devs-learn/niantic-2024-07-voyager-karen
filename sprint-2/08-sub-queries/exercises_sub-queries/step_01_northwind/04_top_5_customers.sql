-- 4. Using only sub-queries
-- Display the names of my top 5 customer
-- and the number of orders each has placed
-- the number of orders  determines top customer

-- (first 5 rows)
-- Save-a-lot Markets               31
-- Ernst Handel                     30
-- QUICK-Stop                       28
-- Folk och f HB                    19
-- Hungry Owl All-Night Grocers     19


USE northwind;

SELECT 
    (SELECT company_name 
    FROM customers 
    WHERE customers.customer_id = orders.customer_id) AS CustomerName,
    COUNT(order_id) AS OrderCount
FROM 
    orders
GROUP BY 
    customer_id
ORDER BY 
    OrderCount DESC
LIMIT 5;

