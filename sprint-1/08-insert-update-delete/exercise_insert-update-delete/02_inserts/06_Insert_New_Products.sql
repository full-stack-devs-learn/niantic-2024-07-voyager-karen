USE northwind;

-- Insert 10 new products into the new Sporting Goods Category
-- You can leave the Supplier Id empty for now, but you need to include
-- the product name, category, price, units in stock (20), units on order (0)
-- and re-order level (10) for each product.

INSERT INTO products (product_name, supplier_id, category_id, unit_price, units_in_stock, units_on_order, reorder_level
)
VALUES ('Basketball', NULL, @sporting_goods, 10.00, 20, 0, 10)
	, ('Pro Mountain Bike', NULL, @sporting_goods, 799.00, 20, 0, 10)
    , ('Yoga Mat', NULL, @sporting_goods, 29.99, 20, 0, 10)
    , ('Dumbbell Set', NULL, @sporting_goods, 149.99, 20, 0, 10)
    , ('Paddle Board', NULL, @sporting_goods, 399.99, 20, 0, 10)
    , ('Tennis Racket', NULL, @sporting_goods, 129.99, 20, 0, 10)
    , ('Fitness Tracker', NULL, @sporting_goods, 99.99, 20, 0, 10)
    , ('Soccer Ball', NULL, @sporting_goods, 34.99, 20, 0, 10)
    , ('Treadmill', NULL, @sporting_goods, 599.99, 20, 0, 10)
    , ('Kayak', NULL, @sporting_goods, 899.99, 20, 0, 10)
;

