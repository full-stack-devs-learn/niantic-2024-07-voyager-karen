-- 2. Create a product categories report

-- Columns to include:
-- ------------------
-- Category Name
-- Product Name
-- Unit Price


-- Use a sub query to display the Category Name
-- you are not allowed to use a JOIN statment

-- sort by category name, then product name

USE Northwind;

SELECT 
    (SELECT category_name 
    FROM categories 
    WHERE categories.category_id = products.category_id) AS CategoryName,
    product_name,
    unit_price
FROM 
    products
ORDER BY 
    CategoryName,
    product_name;



