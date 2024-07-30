USE northwind;

-- give me the total value of my inventory for each product
-- name, price and total value 
-- only for products and cost more than $50 each


SELECT product_name
	, FLOOR(unit_price)
    , units_in_stock
	, unit_price * units_in_stock
FROM products
WHERE unit_price > 50;