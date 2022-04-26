/**************************************************************************
-- Step 2: Drop all database objects to start with an empty database
**************************************************************************/





/**************************************************************************
-- Step 1: Create the customer table
**************************************************************************/
-- Table customer




/**************************************************************************
-- Step 3: Create the service table
**************************************************************************/
-- Table service



/**************************************************************************
-- Step 4: Create the pet table
**************************************************************************/
-- Table pet



/**************************************************************************
-- Step 5: Add a check constraint to the pet table
**************************************************************************/



/**************************************************************************
-- Step 6: Create the pet_service table
**************************************************************************/
-- Table pet_service




/***********************************************************************************************************
 Insert test data into the tables. Un-comment these INSERT and SELECT statements as you create new tables above.
***********************************************************************************************************/

/**************************************************************************
-- Step 1a: Insert test data into the customer table and select it back out.
**************************************************************************/
-- INSERT INTO customer (name, street, city, state_code, postal_code) VALUES
-- 	('Alfred Hitchcock', '10957 Bellagio Road', 'Bel Air', 'CA', '10957'),
-- 	('Beyonce', '1505 Hadley Street', 'Houston', 'TX', '77002'),
-- 	('Cheryl Hines', '210 Dowd Rd', 'Carthage', 'NC', '28327'),
-- 	('Justin Bieber', '350 5th Ave', 'New York', 'NY', '10118-0110'),
-- 	('Kurt Cobain', '171 Lake Washington Blvd E', 'Seattle', 'WA', '98112'),
-- 	('Lucille Ball', '1000 N Roxbury Dr', 'Beverly Hills', 'CA', '90210'),
-- 	('Michael Jackson', '5225 Figueroa Mountain Road', 'Los Olivos', 'CA', '93441'),
-- 	('Pablo Picasso', '7 Rue des Grands Augustins', 'Paris', 'FR', '75006'),
-- 	('Paul McCartney', '41 West 54th Street', 'New York', 'NY', '10019-5404');
-- SELECT * FROM customer;


/**************************************************************************
-- Step 3a: Insert test data into the service table and select it back out.
**************************************************************************/
-- INSERT INTO service (name, cost) VALUES
-- 	('Bath', 25.00),
-- 	('Checkup', 50.00),
-- 	('Clip nails', 14.00),
-- 	('Flea and tick treatment', 12.00),
-- 	('Heart worm test', 30.00),
-- 	('Parvo vaccination', 45.00),
-- 	('Rabies vaccination', 45.00);
-- SELECT * FROM service;


/**************************************************************************
-- Step 4a: Insert test data into the pet table and select it back out.
**************************************************************************/
-- INSERT INTO pet (name, type, customer_id) VALUES
-- 	('Sarah', 'Dog', (Select customer_id from customer where name = 'Alfred Hitchcock')),
-- 	('Mr. Jenkins', 'Dog', (Select customer_id from customer where name = 'Alfred Hitchcock')),
-- 	('Stanley', 'Dog', (Select customer_id from customer where name = 'Alfred Hitchcock')),
-- 	('Martha', 'Dog', (Select customer_id from customer where name = 'Paul McCartney')),
-- 	('Thisbe', 'Cat', (Select customer_id from customer where name = 'Paul McCartney')),
-- 	('Lump', 'Dog', (Select customer_id from customer where name = 'Pablo Picasso')),
-- 	('Minou', 'Cat', (Select customer_id from customer where name = 'Pablo Picasso')),
-- 	('Whoopee', 'Dog', (Select customer_id from customer where name = 'Lucille Ball')),
-- 	('Pinto', 'Dog', (Select customer_id from customer where name = 'Lucille Ball')),
-- 	('Quisp', 'Cat', (Select customer_id from customer where name = 'Kurt Cobain')),
-- 	('Fendi', 'Reptile', (Select customer_id from customer where name = 'Beyonce')),
-- 	('Toby', 'Bird', (Select customer_id from customer where name = 'Cheryl Hines')),
-- 	('OG Malley', 'Primate', (Select customer_id from customer where name = 'Justin Bieber')),
-- 	('Bubbles', 'Primate', (Select customer_id from customer where name = 'Michael Jackson'));
-- SELECT * FROM pet;



/**************************************************************************
-- Step 6a: Insert test data into the pet_service table and select it back out.
**************************************************************************/
-- INSERT INTO pet_service (service_date, pet_id, service_id) VALUES
-- 	( '2021-01-22', (Select pet_id from pet where name = 'Sarah'),       (Select service_id from service where name = 'Checkup')),
-- 	( '2021-01-22', (Select pet_id from pet where name = 'Mr. Jenkins'), (Select service_id from service where name = 'Checkup')),
-- 	( '2021-01-22', (Select pet_id from pet where name = 'Sarah'),       (Select service_id from service where name = 'Rabies vaccination')),
-- 	( '2021-02-04', (Select pet_id from pet where name = 'Sarah'),       (Select service_id from service where name = 'Bath')),
-- 	( '2021-02-04', (Select pet_id from pet where name = 'Mr. Jenkins'), (Select service_id from service where name = 'Bath')),
-- 	( '2021-02-04', (Select pet_id from pet where name = 'Stanley'),     (Select service_id from service where name = 'Bath')),
-- 	( '2021-02-04', (Select pet_id from pet where name = 'Lump'),        (Select service_id from service where name = 'Flea and tick treatment')),
-- 	( '2021-02-04', (Select pet_id from pet where name = 'Minou'),       (Select service_id from service where name = 'Flea and tick treatment')),
-- 	( '2021-02-04', (Select pet_id from pet where name = 'Lump'),        (Select service_id from service where name = 'Rabies vaccination')),
-- 	( '2021-02-04', (Select pet_id from pet where name = 'Minou'),       (Select service_id from service where name = 'Rabies vaccination')),
-- 	( '2021-02-10', (Select pet_id from pet where name = 'OG Malley'),   (Select service_id from service where name = 'Flea and tick treatment')),
-- 	( '2021-02-11', (Select pet_id from pet where name = 'Bubbles'),     (Select service_id from service where name = 'Flea and tick treatment')),
-- 	( '2021-02-12', (Select pet_id from pet where name = 'Martha'),      (Select service_id from service where name = 'Bath')),
-- 	( '2021-02-12', (Select pet_id from pet where name = 'Martha'),      (Select service_id from service where name = 'Clip nails')),
-- 	( '2021-02-12', (Select pet_id from pet where name = 'Martha'),      (Select service_id from service where name = 'Flea and tick treatment')),
-- 	( '2021-02-12', (Select pet_id from pet where name = 'Martha'),      (Select service_id from service where name = 'Heart worm test')),
-- 	( '2021-02-12', (Select pet_id from pet where name = 'Thisbe'),      (Select service_id from service where name = 'Parvo vaccination')),
-- 	( '2021-02-12', (Select pet_id from pet where name = 'Thisbe'),      (Select service_id from service where name = 'Bath')),
-- 	( '2021-02-12', (Select pet_id from pet where name = 'Thisbe'),      (Select service_id from service where name = 'Clip nails')),
-- 	( '2021-02-12', (Select pet_id from pet where name = 'Thisbe'),      (Select service_id from service where name = 'Flea and tick treatment')),
-- 	( '2021-02-12', (Select pet_id from pet where name = 'Thisbe'),      (Select service_id from service where name = 'Heart worm test')),
-- 	( '2021-02-12', (Select pet_id from pet where name = 'Thisbe'),      (Select service_id from service where name = 'Rabies vaccination'));
-- SELECT * FROM pet_service;

/**************************************************************************
-- Step 7: Health History Report: by customer, pet, and date
**************************************************************************/



	
/**************************************************************************
-- Step 8: Invoice for McCartney visit of 2/12
**************************************************************************/



