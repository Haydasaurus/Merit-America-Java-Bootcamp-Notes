-- 4. The name, population, and nickname of the states in the "Northeast" census region (9 rows)
SELECT state_name, population, state_nickname
FROM state
WHERE census_region = 'Northeast';
