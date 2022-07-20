-- 2. The name and area of all cities in Pennsylvania (PA) (4 rows)
SELECT city_name, area
FROM city
WHERE state_abbreviation = 'PA';
