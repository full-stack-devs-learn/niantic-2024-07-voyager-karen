-- 11. Least Popular film report
-- return the name of the 20 least popular films
-- title and number of times each film was rented

-- which tables will you need to join?

--
-- (20 rows)

USE sakila;

SELECT f.title
	, COUNT(r.rental_id) AS RentalCount
FROM rental AS r
JOIN inventory AS i
	ON r.inventory_id = i.inventory_id
JOIN film AS f
	ON i.film_id = f.film_id
GROUP BY 
	f.title
ORDER BY RentalCount
LIMIT 20;



