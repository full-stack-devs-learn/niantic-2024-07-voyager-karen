-- 5. The order details table includes the line item for each sale.
-- the Line Total is the SalesPrice * Quantity - Discount%.

-- I want a customer sales report
-- include customer names (compay_name), and their total sales amount (after discount)
-- sorted by sales total highest to lowest

-- The first 3 rows should be
-- CompanyName			SalesTotal
-- QUICK-Stop			110277.31
-- Ernst Handel			104874.98
-- Save-a-lot Markets	104361.95

-- (89 rows)

USE northwind;

SELECT 
    cu.company_name
    , SUM((od.unit_price * od.quantity) * (1 - od.discount)) AS SalesTotal
FROM 
    customers cu
JOIN 
    orders AS o
    ON cu.customer_id = o.customer_id
JOIN 
    order_details AS od 
    ON o.order_id = od.order_id
GROUP BY 
    cu.company_name
ORDER BY 
    SalesTotal DESC;


