-- 14. The state name, nickname, and census region for states that start with the word "New" (4 rows)
SELECT state_name, state_nickname, census_region
FROM state
WHERE state_name LIKE 'New%';
