-- Drop and create database
DROP DATABASE IF EXISTS budget;
CREATE DATABASE budget;
USE budget;

-- Create person table
CREATE TABLE person (
    person_id INT NOT NULL AUTO_INCREMENT,
    person_name VARCHAR(30) NOT NULL,
    PRIMARY KEY (person_id)
);

-- Create categories table
CREATE TABLE categories (
    category_id INT NOT NULL AUTO_INCREMENT,
    category_name VARCHAR(50) NOT NULL,
    category_type VARCHAR(30) NOT NULL,
    sub_category VARCHAR(30) NOT NULL,
    person_id INT NOT NULL,
    PRIMARY KEY (category_id),
    FOREIGN KEY (person_id) REFERENCES person(person_id)
);

-- Create account table
CREATE TABLE account (
    account_id INT NOT NULL AUTO_INCREMENT,
    account_name VARCHAR(50) NOT NULL,
    account_type VARCHAR(30) NOT NULL,
    person_id INT NOT NULL,
    PRIMARY KEY (account_id),
    FOREIGN KEY (person_id) REFERENCES person(person_id)
);

-- Create transaction table
CREATE TABLE transaction (
    transaction_id INT NOT NULL AUTO_INCREMENT,
    transaction_name VARCHAR(50) NOT NULL,
    account_id INT NOT NULL,
    person_id INT NOT NULL,
    category_id INT NOT NULL, 
    transaction_date DATETIME, 
    amount DECIMAL(10,2) NOT NULL,
    notes VARCHAR(50) NOT NULL,
    PRIMARY KEY (transaction_id),
    FOREIGN KEY (account_id) REFERENCES account(account_id),
    FOREIGN KEY (person_id) REFERENCES person(person_id),
    FOREIGN KEY (category_id) REFERENCES categories(category_id) 
);

-- Insert data into person table
INSERT INTO person(person_name)
VALUES ('Karen'), 
       ('Julian');

-- Insert data into categories table
INSERT INTO categories(category_name, category_type, sub_category, person_id)
VALUES ('Groceries', 'Expense', 'Food', 1),
       ('Salary', 'Income', 'Monthly Income', 1),
       ('Rent', 'Expense', 'Housing', 2),
       ('Freelance', 'Income', 'Additional Income', 2),
       ('Utilities', 'Expense', 'Housing', 1),
       ('Dining Out', 'Expense', 'Food', 1),
       ('Bonus', 'Income', 'One-time Income', 2),
       ('Entertainment', 'Expense', 'Leisure', 2),
       ('Healthcare', 'Expense', 'Medical', 1),
       ('Travel', 'Expense', 'Vacation', 2);

-- Insert data into account table
INSERT INTO account(person_id, account_name, account_type)
VALUES (1, 'Checking Account', 'Checking'),
       (1, 'Savings Account', 'Savings'),
       (2, 'Credit Card', 'Credit Card'),
       (2, 'Checking Account', 'Checking'),
       (2, 'Travel Savings Account', 'Savings'),
       (1, 'Emergency Fund', 'Savings'),
       (1, 'Investment Account', 'Checking'),
       (2, 'Business Checking Account', 'Checking'),
       (1, 'Holiday Fund', 'Savings'),
       (2, 'Entertainment Credit Card', 'Credit Card');

-- Insert data into transaction table
INSERT INTO transaction(category_id, account_id, transaction_name, transaction_date, amount, notes, person_id)
VALUES 
(1, 1, 'Grocery Shopping', '2024-05-20 14:30:00', 150.00, 'Weekly groceries', 1),
(2, 2, 'Monthly Salary', '2024-05-31 10:00:00', 8000.00, 'May salary', 1),
(3, 3, 'Rent Payment', '2024-05-31 16:00:00', 3000.00, 'Monthly rent', 2),
(4, 4, 'Freelance Project', '2024-05-14 18:30:00', 600.00, 'Website development', 2),
(5, 5, 'Utility Bill', '2024-05-30 09:00:00', 100.00, 'Electricity bill', 1),
(6, 1, 'Dining Out', '2024-05-19 19:00:00', 150.00, 'Dinner at a restaurant', 1),
(7, 2, 'Annual Bonus', '2024-05-22 12:00:00', 1000.00, 'Annual performance bonus', 2),
(8, 3, 'Movie Tickets', '2024-05-29 20:00:00', 30.00, 'Weekend movie night', 2),
(9, 4, 'Doctor Visit', '2024-05-25 11:00:00', 120.00, 'Regular checkup', 1),
(10, 5, 'Flight Tickets', '2024-05-24 15:00:00', 800.00, 'Vacation travel', 2);

-- join transaction with other tables 
-- create new variables to display on table
SELECT 
	transaction.transaction_id AS 'Transaction ID',
    transaction.transaction_name AS 'Transaction Name',
    transaction.transaction_date AS 'Date',
    transaction.amount AS 'Amount',
    transaction.notes AS 'Notes',
    account.account_name AS 'Account Name',
    categories.category_name AS 'Category Name',
    person.person_name AS 'Person Name'
FROM transaction
JOIN 
	account ON transaction.account_id = account.account_id
JOIN
	categories ON transaction.category_id = categories.category_id
JOIN
	person ON transaction.person_id = person.person_id;
    
SELECT 
	account.account_id AS 'Account ID',
    account.account_name AS 'Account Name',
    account.account_type AS 'Account Type',
    person.person_name AS 'First Name'
FROM account
JOIN
	person ON account.person_id = person.person_id;
    

SELECT 
	categories.category_id AS 'Category ID',
    categories.category_name AS 'Category Name',
    categories.category_type AS 'Category Type',
    categories.sub_category AS 'Sub Category',
    person.person_name AS 'Person Name'
FROM categories
JOIN
	person ON categories.person_id = person.person_id;
