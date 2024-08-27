-- 13. Category popularity report

-- return a list of category names and the number of times
-- a film in that category has been rented

-- sort by most popular category first

-- (16 rows)

USE sakila;

SELECT DISTINCT c.name
	, COUNT(r.rental_id) AS RentalCount
FROM rental AS r
JOIN inventory AS i
	ON r.inventory_id = i.inventory_id
JOIN film AS f
	ON i.film_id = f.film_id
JOIN film_category AS fa 
	ON f.film_id = fa.film_id
JOIN category AS c
	ON fa.category_id = c.category_id
GROUP BY 
	c.name
ORDER BY RentalCount DESC;


