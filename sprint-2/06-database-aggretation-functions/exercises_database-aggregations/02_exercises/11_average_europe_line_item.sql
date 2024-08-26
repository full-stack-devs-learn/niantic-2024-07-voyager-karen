USE northwind;

-- 11. The average sales amount for all sales in Europe
-- (Use the customer_orders view)

-- (1 row) approx $605.99

SELECT AVG(COALESCE(sales_price * quantity))
FROM customer_orders
WHERE country IN ('Germany', 'Switzerland', 'France', 'Portual', 'Finland', 'Poland', 'Ireland', 'Sweden', 'UK');




