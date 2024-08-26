USE northwind;

-- 8. The smallest line item amount made in Europe
-- (Use the customer_orders view)

-- (1 row) $4.80

SELECT MIN(COALESCE(sales_price * quantity)) AS line_item
FROM customer_orders
WHERE country IN ('Germany', 'Switzerland', 'France', 'Portual', 'Finland', 'Poland', 'Ireland', 'Sweden', 'UK')




