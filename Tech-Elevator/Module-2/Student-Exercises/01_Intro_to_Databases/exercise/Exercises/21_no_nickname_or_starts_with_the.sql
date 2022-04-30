-- 21. The name and nickname for all records in the state table with no official nickname (NULL) or nickname starts with the word "The" (13 rows)
SELECT state_name, state_nickname
FROM state
WHERE state_nickname IS null
OR state_nickname LIKE 'The%';
