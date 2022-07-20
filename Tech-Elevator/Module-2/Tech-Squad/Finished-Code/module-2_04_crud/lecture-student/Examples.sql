-- INSERT

-- Add Legoland to the park table. (It was established on 3/20/1999, has an area of 0.20 square miles and does not offer camping.)

-- SET DateStyle='ISO, DMY';
INSERT INTO park (park_name, date_established, area, has_camping)
VALUES ('Legoland', '3/20/1999', 0.20, false);

-- Since Legoland is in California (CA), add a record representing that to the park_state table.

INSERT INTO park_state (park_id, state_abbreviation)
SELECT park_id, 'CA'
FROM park
WHERE park_name = 'Legoland';


-- UPDATE

-- Change the state nickname of Alaska to "The largest U.S. state."

UPDATE state
SET state_nickname = 'The largest U.S. state'
WHERE state_abbreviation = 'AK';

-- Change the capital of Alaska to Anchorage.

UPDATE state
SET capital = (SELECT city_id FROM city WHERE city_name = 'Anchorage' AND state_abbreviation = 'AK')
WHERE state_abbreviation = 'AK';

-- Change Alaska's nickname back to "The Last Frontier", and change the capital back to Juneau.

UPDATE state
SET state_nickname = 'The Last Frontier',
    capital = (SELECT city_id FROM city WHERE city_name = 'Juneau' AND state_abbreviation = 'AK')
WHERE state_abbreviation = 'AK';


-- DELETE

-- Delete Hawkins, IN from the city table.

DELETE FROM city WHERE city_name = 'Hawkins' AND state_abbreviation = 'IN';


-- REFERENTIAL INTEGRITY

-- Try deleting Legoland from the park table. Try again after deleting its record from the park_state table.

DELETE FROM park
WHERE park_name = 'Legoland';

DELETE FROM park_state
WHERE park_id = (SELECT park_id FROM park WHERE park_name = 'Legoland');


-- CONSTRAINTS

-- NOT NULL constraint
-- Try adding Smallville, KS to the city table without specifying its population or area.

INSERT INTO city (city_name, state_abbreviation)
VALUES ('Smallville', 'KS');

-- DEFAULT constraint
-- Try adding Smallville, KS again, specifying an area but not a population.

INSERT INTO city (city_name, state_abbreviation, area)
VALUES ('Smallville', 'KS', 0.5);

-- Retrieve the new record to confirm it has been given a default, non-null value for population.

SELECT *
FROM city
WHERE city_name = 'Smallville';


-- TRANSACTIONS

-- Delete the record for Smallville, KS within a transaction.

START TRANSACTION;
DELETE FROM city
WHERE city_name = 'Smallville' AND state_abbreviation = 'KS';
COMMIT;

-- Delete all of the records from the park table, but then "undo" the deletion by rolling back the transaction.

START TRANSACTION;
DELETE FROM park_state;
SELECT COUNT(*) FROM park_state;
ROLLBACK;
SELECT COUNT(*) FROM park_state;

