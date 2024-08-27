-- 10. Count of films in each category
-- that GRACE MOSTEL has appeared in as an actress

-- include first_name, last_name, category_name, film_count

-- (11 rows)

USE sakila;

SELECT a.first_name
	, a.last_name
    , c.name
    , COUNT(fa.film_id) AS film_count
FROM category AS c 
JOIN film_category AS fc
	ON c.category_id = fc.category_id
JOIN film AS f 
	ON fc.film_id = f.film_id
JOIN film_actor AS fa 
	ON f.film_id = fa.film_id
JOIN actor AS a
	ON fa.actor_id = a.actor_id
WHERE a.first_name = 'GRACE'
	AND a.last_name = 'MOSTEL'
GROUP BY
	a.first_name
	, a.last_name
    , c.name;

