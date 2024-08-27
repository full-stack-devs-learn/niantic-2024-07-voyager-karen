-- 7. List the names of all actors who acted in
-- the film "HUMAN GRAFFITI"

-- (4 rows)

USE sakila;

SELECT a.first_name
	, a.last_name
FROM film AS f 
JOIN film_actor AS fa
	ON f.film_id = fa.film_id
JOIN actor AS a 
	ON fa.actor_id = a.actor_id
WHERE f.title = "HUMAN GRAFFITI"
GROUP BY 
	a.first_name,
    a.last_name
    



