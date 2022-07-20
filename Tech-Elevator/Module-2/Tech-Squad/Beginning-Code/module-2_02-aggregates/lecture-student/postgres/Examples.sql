-- Use UnitedStates database

-- Ordering

-- select all parks, order the results by area in descending order

SELECT * FROM park ORDER BY area DESC;

-- select the first 10 parks by alphabetical order of park_name

SELECT * FROM park ORDER BY park_name Limit 10;

-- Aggregate functions

-- count total number of cities

SELECT COUNT(*) FROM city;

-- count number of cities in TX

SELECT COUNT(*) FROM city WHERE state_abbreviation = 'TX';

-- find max, min and average cities population

SELECT MAX(population) FROM city;
SELECT MIN(population) FROM city;
SELECT AVG(population) FROM city;

-- Grouping

-- count number of cities in each state. Sort the results alphabetically by state_abbreviation

SELECT state_abbreviation, COUNT(*) AS num_of_cities FROM city GROUP BY state_abbreviation ORDER BY state_abbreviation;

-- String concatenation

-- select name and nickname of all states and territories that have a nickname (not NULL).
-- The name and nickname should be returned as a single column named

SELECT (state_name || ' (' || state_nickname || ')') AS state_and_nickname FROM state WHERE state_nickname IS NOT NULL;
