-- Create a full script with variables that allows you 
-- to add a new Customer into the database. Then create an order for them
-- that includes 5 products. Create 5 variables at the top of the script
-- that store the 5 product names the customer wants to buy. You will use
-- the product names to find the id

-- Requirements
/*
    I should be able to run the script on my machine without having to
    write any queries to look up the id's of any tables. (The only id that
    I should have to know is the new CustomerId - which is a 5 letter code 
    that we will choose )

    Use variables at the top of the script to collect User Input. The rest 
    of the script should run without hardcoding ANY values.

    I.E. if I want to add a new customer, and order, I should be able 
    to change the variables at the beginning of the script, and run the whole
    script.
*/

/*
Customer must include: 
    Customer Id: 5 letter code
    Company Name: (You can use chatgpt or https://businessnamegenerator.com to pick a name)
    Contact Name: (you can use chatgpt or http://random-name-generator.info to pick a name)
    Address
    City
    Region
    Postal Code
    Country

Order:
    Order id: auto generated
    Customer Id: id from the inserted customer
    Order Date: today's date
    Ship Name: Contact name
    Ship Address: The company address information

OrderDetails: (Create 5 line items)
    Order Id: the one created above
    Product Id: use the product names to select/find the id of each product
    Unit Price: use the default list price of each product
    Quantity: you decide - between 1-10
    Discount: 0
*/

SET @customer_id = '12345';
SET @company_name = 'SQL HURTS ME INC.';
SET @contact_name = 'Sea Quil';
SET @address = '911 SQL Road';
SET @city = 'I MISS JAVA';
SET @region = 'CA';
SET @postal_code = '01010';
SET @country = 'SEA';

SET @product1 = 'Gustaf''s Knckebrd';
SET @product2 = 'Tofu';
SET @product3 = 'Konbu';
SET @product4 = 'Teatime Chocolate Biscuits';
SET @product5 = 'Ikura';

-- 1. INSERT new customer INTO customers table

INSERT INTO customers
(
	customer_id
    , company_name
    , contact_name
    , address
    , city
    , region
    , postal_code
    , country
)
VALUES
(
	@customer_id
    , @company_name
    , @contact_name
    , @address
    , @city
    , @region
    , @postal_code
    , @country
);


-- 2. INSERT new order INTO order tables

INSERT INTO orders
(
	customer_id
    , order_date
    , ship_name
    , ship_address
    , ship_city
    , ship_region
    , ship_postal_code
    , ship_country
)
VALUES
(
	@customer_id
    , CURRENT_DATE
	, @contact_name
    , @address
    , @city
    , @region
    , @postal_code
    , @country
);

SET @order_id = LAST_INSERT_ID();

-- 3. INSERT 1 row for each product into the order_details table

SELECT @product_id_1 := product_id
	, @product_price_1 := unit_price
FROM products
WHERE product_name = @product_name_1;

INSERT INTO order_details(order_id, product_id, unit_price)
VALUES (@order_id, @product_id_1, @product_price_1);







