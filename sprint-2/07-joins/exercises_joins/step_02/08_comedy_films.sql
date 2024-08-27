-- 8. Display the Category Name, and film title of all films
-- in the "Comedy" category

-- (58 rows)

USE sakila;

SELECT c.name
	, f.title
FROM category AS c
JOIN film_category AS fc 
	ON c.category_id = fc.category_id
JOIN film AS f
	ON fc.film_id = f.film_id
WHERE c.name = "Comedy";
    


