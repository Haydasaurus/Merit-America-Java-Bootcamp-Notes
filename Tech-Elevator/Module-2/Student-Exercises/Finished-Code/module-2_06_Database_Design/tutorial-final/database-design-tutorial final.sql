/**************************************************************************
-- Step 2: Drop all database objects to start with an empty database
**************************************************************************/
DROP TABLE IF EXISTS pet_service;
DROP TABLE IF EXISTS pet;
DROP TABLE IF EXISTS service;
DROP TABLE IF EXISTS customer;

/**************************************************************************
-- Step 1: Create the customer table
**************************************************************************/
-- Table customer
CREATE TABLE customer(
	customer_id serial NOT NULL,
	name varchar(100) NOT NULL,
	street varchar(100) NULL,
	city varchar(100) NULL,
	state_code char(2) NULL,
	postal_code varchar(10) NULL,
	CONSTRAINT PK_customer PRIMARY KEY (customer_id)
);

/**************************************************************************
-- Step 3: Create the service table
**************************************************************************/
-- Table service
CREATE TABLE service(
	service_id serial NOT NULL,
	name varchar(100) NOT NULL,
	cost numeric(7,2) NOT NULL,
	CONSTRAINT PK_service PRIMARY KEY (service_id)
);

/**************************************************************************
-- Step 4: Create the pet table
**************************************************************************/
-- Table pet
CREATE TABLE pet(
	pet_id serial NOT NULL,
	name varchar(100) NOT NULL,
	type varchar(20) NOT NULL,
	customer_id int NOT NULL,
	CONSTRAINT PK_pet PRIMARY KEY (pet_id),
	CONSTRAINT FK_pet_customer FOREIGN KEY(customer_id) REFERENCES customer (customer_id)
);

/**************************************************************************
-- Step 5: Add a check constraint to the pet table
**************************************************************************/
ALTER TABLE pet
	ADD CONSTRAINT CHK_type CHECK (type IN ('Dog', 'Bird', 'Cat', 'Reptile', 'Fish', 'Primate'));

/**************************************************************************
-- Step 6: Create the pet_service table
**************************************************************************/
-- Table pet_service
CREATE TABLE pet_service(
	pet_service_id serial NOT NULL,
	pet_id int NOT NULL,
	service_id int NOT NULL,
	service_date date NOT NULL,
	CONSTRAINT PK_pet_service PRIMARY KEY (pet_service_id),
	CONSTRAINT FK_pet_service_pet FOREIGN KEY(pet_id) REFERENCES pet (pet_id),
	CONSTRAINT FK_pet_service_service FOREIGN KEY(service_id) REFERENCES service (service_id)
);


/***********************************************************************************************************
 Insert test data into the tables. Un-comment these INSERT and SELECT statements as you create new tables above.
***********************************************************************************************************/

/**************************************************************************
-- Step 1a: Insert test data into the customer table and select it back out.
**************************************************************************/
INSERT INTO customer (name, street, city, state_code, postal_code) VALUES
	('Alfred Hitchcock', '10957 Bellagio Road', 'Bel Air', 'CA', '10957'),
	('Beyonce', '1505 Hadley Street', 'Houston', 'TX', '77002'),
	('Cheryl Hines', '210 Dowd Rd', 'Carthage', 'NC', '28327'),
	('Justin Bieber', '350 5th Ave', 'New York', 'NY', '10118-0110'),
	('Kurt Cobain', '171 Lake Washington Blvd E', 'Seattle', 'WA', '98112'),
	('Lucille Ball', '1000 N Roxbury Dr', 'Beverly Hills', 'CA', '90210'),
	('Michael Jackson', '5225 Figueroa Mountain Road', 'Los Olivos', 'CA', '93441'),
	('Pablo Picasso', '7 Rue des Grands Augustins', 'Paris', 'FR', '75006'),
	('Paul McCartney', '41 West 54th Street', 'New York', 'NY', '10019-5404');
SELECT * FROM customer;


/**************************************************************************
-- Step 3a: Insert test data into the service table and select it back out.
**************************************************************************/
INSERT INTO service (name, cost) VALUES
	('Bath', 25.00),
	('Checkup', 50.00),
	('Clip nails', 14.00),
	('Flea and tick treatment', 12.00),
	('Heart worm test', 30.00),
	('Parvo vaccination', 45.00),
	('Rabies vaccination', 45.00);
SELECT * FROM service;


/**************************************************************************
-- Step 4a: Insert test data into the pet table and select it back out.
**************************************************************************/
INSERT INTO pet (name, type, customer_id) VALUES
	('Sarah', 'Dog', (Select customer_id from customer where name = 'Alfred Hitchcock')),
	('Mr. Jenkins', 'Dog', (Select customer_id from customer where name = 'Alfred Hitchcock')),
	('Stanley', 'Dog', (Select customer_id from customer where name = 'Alfred Hitchcock')),
	('Martha', 'Dog', (Select customer_id from customer where name = 'Paul McCartney')),
	('Thisbe', 'Cat', (Select customer_id from customer where name = 'Paul McCartney')),
	('Lump', 'Dog', (Select customer_id from customer where name = 'Pablo Picasso')),
	('Minou', 'Cat', (Select customer_id from customer where name = 'Pablo Picasso')),
	('Whoopee', 'Dog', (Select customer_id from customer where name = 'Lucille Ball')),
	('Pinto', 'Dog', (Select customer_id from customer where name = 'Lucille Ball')),
	('Quisp', 'Cat', (Select customer_id from customer where name = 'Kurt Cobain')),
	('Fendi', 'Reptile', (Select customer_id from customer where name = 'Beyonce')),
	('Toby', 'Bird', (Select customer_id from customer where name = 'Cheryl Hines')),
	('OG Malley', 'Primate', (Select customer_id from customer where name = 'Justin Bieber')),
	('Bubbles', 'Primate', (Select customer_id from customer where name = 'Michael Jackson'));
SELECT * FROM pet;



/**************************************************************************
-- Step 6a: Insert test data into the pet_service table and select it back out.
**************************************************************************/
INSERT INTO pet_service (service_date, pet_id, service_id) VALUES
	( '2021-01-22', (Select pet_id from pet where name = 'Sarah'),       (Select service_id from service where name = 'Checkup')),
	( '2021-01-22', (Select pet_id from pet where name = 'Mr. Jenkins'), (Select service_id from service where name = 'Checkup')),
	( '2021-01-22', (Select pet_id from pet where name = 'Sarah'),       (Select service_id from service where name = 'Rabies vaccination')),
	( '2021-02-04', (Select pet_id from pet where name = 'Sarah'),       (Select service_id from service where name = 'Bath')),
	( '2021-02-04', (Select pet_id from pet where name = 'Mr. Jenkins'), (Select service_id from service where name = 'Bath')),
	( '2021-02-04', (Select pet_id from pet where name = 'Stanley'),     (Select service_id from service where name = 'Bath')),
	( '2021-02-04', (Select pet_id from pet where name = 'Lump'),        (Select service_id from service where name = 'Flea and tick treatment')),
	( '2021-02-04', (Select pet_id from pet where name = 'Minou'),       (Select service_id from service where name = 'Flea and tick treatment')),
	( '2021-02-04', (Select pet_id from pet where name = 'Lump'),        (Select service_id from service where name = 'Rabies vaccination')),
	( '2021-02-04', (Select pet_id from pet where name = 'Minou'),       (Select service_id from service where name = 'Rabies vaccination')),
	( '2021-02-10', (Select pet_id from pet where name = 'OG Malley'),   (Select service_id from service where name = 'Flea and tick treatment')),
	( '2021-02-11', (Select pet_id from pet where name = 'Bubbles'),     (Select service_id from service where name = 'Flea and tick treatment')),
	( '2021-02-12', (Select pet_id from pet where name = 'Martha'),      (Select service_id from service where name = 'Bath')),
	( '2021-02-12', (Select pet_id from pet where name = 'Martha'),      (Select service_id from service where name = 'Clip nails')),
	( '2021-02-12', (Select pet_id from pet where name = 'Martha'),      (Select service_id from service where name = 'Flea and tick treatment')),
	( '2021-02-12', (Select pet_id from pet where name = 'Martha'),      (Select service_id from service where name = 'Heart worm test')),
	( '2021-02-12', (Select pet_id from pet where name = 'Thisbe'),      (Select service_id from service where name = 'Parvo vaccination')),
	( '2021-02-12', (Select pet_id from pet where name = 'Thisbe'),      (Select service_id from service where name = 'Bath')),
	( '2021-02-12', (Select pet_id from pet where name = 'Thisbe'),      (Select service_id from service where name = 'Clip nails')),
	( '2021-02-12', (Select pet_id from pet where name = 'Thisbe'),      (Select service_id from service where name = 'Flea and tick treatment')),
	( '2021-02-12', (Select pet_id from pet where name = 'Thisbe'),      (Select service_id from service where name = 'Heart worm test')),
	( '2021-02-12', (Select pet_id from pet where name = 'Thisbe'),      (Select service_id from service where name = 'Rabies vaccination'));
SELECT * FROM pet_service;

/**************************************************************************
-- Step 7: Health History Report: by customer, pet, and date
**************************************************************************/
SELECT p.name AS "Pet Name", p.type AS "Pet Type", c.name AS "Owner", ps.service_date AS "Date", s.name AS "Service"
	FROM customer c
	JOIN pet p ON p.customer_id = c.customer_id
	JOIN pet_service ps ON ps.pet_id = p.pet_id
	JOIN service s ON ps.service_id = s.service_id
	ORDER BY c.name, p.name, service_date;
	
/**************************************************************************
-- Step 8: Invoice for McCartney visit of 2/12
**************************************************************************/
SELECT ps.service_date AS "Date", c.name, c.street, c.city, c.state_code, c.postal_code, p.name AS "Pet Name", s.name AS "Service", s.cost
	FROM customer c
	JOIN pet p ON p.customer_id = c.customer_id
	JOIN pet_service ps ON ps.pet_id = p.pet_id
	JOIN service s ON ps.service_id = s.service_id
	WHERE c.name = 'Paul McCartney' AND service_date = '2021-02-12'
	ORDER BY p.name

