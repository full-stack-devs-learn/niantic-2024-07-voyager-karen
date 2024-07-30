USE northwind;

-- The Product name, price and the number
-- of units available for sale (in stock + on order)
-- of all dairy products

-- Hint: Be sure to create a column alias for 
-- the new column

-- Expected: 10 rows

SELECT product_name
	, unit_price
    , units_in_stock
FROM products_by_category
WHERE category_name = 'Dairy Products';

