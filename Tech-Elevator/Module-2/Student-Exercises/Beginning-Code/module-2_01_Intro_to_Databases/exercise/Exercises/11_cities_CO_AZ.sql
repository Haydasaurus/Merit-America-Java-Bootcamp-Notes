-- 11. The name, state, and population of all cities in Colorado (CO) or Arizona (AZ) (22 rows)
SELECT city_name, state_abbreviation, population
FROM city
WHERE state_abbreviation = 'CO'
OR state_abbreviation = 'AZ';
