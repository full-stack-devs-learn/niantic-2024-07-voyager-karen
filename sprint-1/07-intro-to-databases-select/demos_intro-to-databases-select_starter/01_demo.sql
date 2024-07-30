USE world;


-- give me all rows and columns from the city table
SELECT *
FROM city;

-- give me the name, country, population of all cities
SELECT Name
	, CountryCode
    , Population
FROM city
WHERE CountryCode = 'USA'
ORDER BY Population DESC
LIMIT 5;