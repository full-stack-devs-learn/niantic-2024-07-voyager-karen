USE northwind;

-- You were just hired by Northwind Traders, Inc and 
-- you need to add yourself as a Sales Associate to the Employees table.
-- Inlcude your:
    -- full name
    -- job title
    -- preferred title (Mr, Mrs, etc)
    -- Birthday
    -- hire date: (today)
    -- home address
-- leave all other fields null by default


INSERT INTO employees (first_name, last_name, title, title_of_courtesy, birth_date, hire_date, address, city, region, postal_code, country, home_phone, extension, notes, reports_to, salary
)
VALUES ('Karen', 'Delarosa', 'Sales Associate', 'Ms.', '1996-05-29', '2024-07-31', '123 Rainbow Road', NULL, NULL, NULL, NULL, NULL, NULL, 'hi', NULL, NULL);


