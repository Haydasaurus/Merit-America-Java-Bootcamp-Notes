BEGIN TRANSACTION;

DROP TABLE IF EXISTS pizza_topping, pizza, topping, size, sale, customer CASCADE;

CREATE TABLE customer (
    customer_id serial,
    first_name varchar(20) NOT NULL,
    last_name varchar(20) NOT NULL,
    street_address varchar(50) NOT NULL,
    city varchar(50) NOT NULL,
    phone_number varchar(10) NULL,
    email_address varchar(50) NULL,
    email_offers boolean NOT NULL CONSTRAINT DF_email_offers DEFAULT (FALSE),
    CONSTRAINT PK_customer PRIMARY KEY(customer_id)
);

CREATE TABLE sale (
    sale_id serial,
    total numeric(6,2) NULL,
    is_delivery boolean NOT NULL CONSTRAINT DF_is_delivery DEFAULT (FALSE),
    customer_id int NULL, --nullable foreign key
    CONSTRAINT PK_order PRIMARY KEY(sale_id),
    CONSTRAINT FK_sale_customer_id FOREIGN KEY(customer_id) REFERENCES customer(customer_id),
    CONSTRAINT CK_total CHECK (total > 0)
);

CREATE TABLE size (
    size_id varchar(2) NOT NULL, --S, M, L, XL
    size_description varchar(20) NOT NULL, --Small, Medium, Large, Extra Large
    diameter int NOT NULL, --12, 14, etc
    base_price numeric(4,2) NOT NULL, --9.99, 11.99, etc
	CONSTRAINT PK_pizza_size PRIMARY KEY(size_id),
    CONSTRAINT CK_base_price CHECK (base_price > 0)
);

CREATE TABLE topping (
    topping_name varchar(15) NOT NULL, --Pepperoni, Green peppers, Black olives, etc
    additional_price numeric(3,2) NOT NULL, --1, 2, 2.5, etc
    CONSTRAINT PK_topping PRIMARY KEY(topping_name),
    CONSTRAINT CK_additional_price CHECK (additional_price > 0)
);

CREATE TABLE pizza ( 
    pizza_id serial,
    sale_id int NULL, --foreign key
    size_id varchar(2) NOT NULL, --foreign key
    crust varchar(10) NOT NULL CONSTRAINT DF_crust DEFAULT ('Regular'), --Regular, Thin, Pan
    sauce varchar(10) NOT NULL CONSTRAINT DF_sauce DEFAULT ('Normal'), --Normal, Extra, Light, None
    price numeric(4,2) NULL, --base price + toppings 
    additional_instructions varchar(500) NULL, --cut into squares, etc
    CONSTRAINT PK_pizza PRIMARY KEY(pizza_id),
    CONSTRAINT FK_pizza_size FOREIGN KEY(size_id) REFERENCES size(size_id),
    CONSTRAINT FK_pizza_sale FOREIGN KEY(sale_id) REFERENCES sale(sale_id),
    CONSTRAINT CK_crust CHECK (crust IN ('Regular', 'Thin', 'Pan')),
    CONSTRAINT CK_sauce CHECK (sauce IN ('Normal', 'Extra', 'Light', 'None')),
    CONSTRAINT CK_price CHECK (price > 0)
);

CREATE TABLE pizza_topping (
    pizza_id int NOT NULL, --foreign key
    topping_name varchar(15) NOT NULL, --foreign key
    CONSTRAINT FK_pizza_topping_pizza_id FOREIGN KEY(pizza_id) REFERENCES pizza(pizza_id),
    CONSTRAINT FK_pizza_topping_topping_name FOREIGN KEY(topping_name) REFERENCES topping(topping_name)
);

INSERT INTO size (size_id, size_description, diameter, base_price) VALUES ('S', 'Small', 12, 9.99);
INSERT INTO size (size_id, size_description, diameter, base_price) VALUES ('M', 'Medium', 14, 11.99);
INSERT INTO size (size_id, size_description, diameter, base_price) VALUES ('L', 'Large', 16, 13.99);

INSERT INTO topping (topping_name, additional_price) VALUES ('Pepperoni', 1);
INSERT INTO topping (topping_name, additional_price) VALUES ('Sausage', 1);
INSERT INTO topping (topping_name, additional_price) VALUES ('Extra Cheese', 0.5);
INSERT INTO topping (topping_name, additional_price) VALUES ('Green Peppers', 0.75);
INSERT INTO topping (topping_name, additional_price) VALUES ('Onions', 0.75);
INSERT INTO topping (topping_name, additional_price) VALUES ('Mushrooms', 1);
INSERT INTO topping (topping_name, additional_price) VALUES ('Chicken', 2);
INSERT INTO topping (topping_name, additional_price) VALUES ('Bacon', 1);
INSERT INTO topping (topping_name, additional_price) VALUES ('Anchovies', 1);
INSERT INTO topping (topping_name, additional_price) VALUES ('Black Olives', 0.75);
INSERT INTO topping (topping_name, additional_price) VALUES ('Pineapple', 1.5);
INSERT INTO topping (topping_name, additional_price) VALUES ('Ham', 1);
INSERT INTO topping (topping_name, additional_price) VALUES ('Tomatoes', 0.75);


INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Deanne', 'Mallon', '9709 Ryan Alley', 'Saydol Falls', '3441091536', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Madge', 'Lampaert', '1 Upham Road', 'Kingford', '2647680585', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Elenore', 'Mamwell', '561 Claremont Alley', 'Mayport', null, 'emamwell2@gmail.com', TRUE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Dud', 'Dobbins', '27417 Ronald Regan Plaza', 'Oakview', '8043468703', 'ddobbins3@aol.com', TRUE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Row', 'Woofenden', '79 Hanson Road', 'Oakview', null, null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Robin', 'Besnardeau', '87 Vidon Terrace', 'Oakview', '3106161864', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Rriocard', 'Townsend', '2579 Eastwood Trail', 'Sweetford Beach', '8807062861', 'rtownsend6@yahoo.net', TRUE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Laurette', 'Layzell', '306 Johnson Park', 'Kingford', '8734347455', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Darell', 'Drinkwater', '6 Transport Terrace', 'Springham', null, 'ddrinkwater8@aol.com', FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Dicky', 'Blumire', '73627 Birchwood Plaza', 'Northton Hills', '6057581165', 'dblumire9@gmail.com', FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Sorcha', 'Latliff', '6 Calypso Place', 'Saydol Falls', '2928261128', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Dorotea', 'Jizhaki', '5 Rowland Lane', 'Saydol Falls', null, 'djizhakib@hotmail.com', TRUE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Erskine', 'Ales', '7455 Harper Point', 'Northton Hills', null, null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Morganica', 'Dallas', '2855 Columbus Hill', 'Oakview', '1187502559', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Osbourn', 'Prowse', '3 Thompson Place', 'Aukarta', '2483171810', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Caron', 'Lammerts', '7569 Cordelia Avenue', 'Springham', '7568059006', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Renate', 'Kleinstein', '573 Butterfield Park', 'Sweetford Beach', null, 'rkleinsteing@gmail.com', TRUE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Averyl', 'Sandom', '54348 Hovde Drive', 'Riverport City', '4799042862', 'asandomh@hotmail.com', FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Rowney', 'Auden', '600 La Follette Place', 'Mayport', '3498545912', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Britteny', 'Bickerdike', '88 Eagle Crest Avenue', 'Springham', '3324620515', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Erwin', 'De Mitri', '5 Monica Alley', 'Mayport', null, 'edemitrik@gmail.com', TRUE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Dante', 'Ricca', '307 Di Loreto Plaza', 'Sweetford Beach', null, null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Brade', 'Glamart', '67 West Hill', 'Kingford', '9624937066', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Gunar', 'Boissieux', '891 Pennsylvania Terrace', 'Northton Hills', '8002064343', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Garrett', 'Rolling', '2 Fallview Drive', 'Sweetford Beach', null, null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Annetta', 'McCarlich', '6 Meadow Valley Drive', 'Kingford', null, null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Adelaide', 'Lovell', '5953 Boyd Trail', 'Aukarta', '4638696945', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Richard', 'Drakeford', '4 Maryland Way', 'Kingford', '8642714145', 'rdrakefordr@yahoo.com', FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Joice', 'Chivrall', '65 Porter Alley', 'Sweetford Beach', null, null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Halimeda', 'Ryal', '20158 Sugar Plaza', 'Oakview', '2681101244', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Mildred', 'De Biasi', '94 Wayridge Court', 'Aukarta', null, null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Edyth', 'Cuell', '90975 Iowa Center', 'Springham', '9293433671', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Ambrosi', 'Arndtsen', '1 Del Sol Alley', 'Aukarta', '2712644698', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Garrick', 'Sabbin', '3 Merchant Plaza', 'Saydol Falls', null, null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Ethe', 'Rissen', '26 Mayer Plaza', 'Mayport', '8437594236', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Margaret', 'Peepall', '445 Manufacturers Way', 'Oakview', '6488028216', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Devonne', 'Meran', '5536 Hazelcrest Center', 'Oakview', '3017284087', 'dmeran10@yahoo.com', FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Torrance', 'Gorvette', '9964 Beilfuss Court', 'Northton Hills', '8682148964', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Eimile', 'Wherton', '10 Quincy Hill', 'Springham', null, 'ewherton12@aol.com', FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Shaina', 'Gallally', '4 Duke Lane', 'Northton Hills', '4137243635', 'sgallally13@aol.com', TRUE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Ermin', 'Nolton', '3283 Fair Oaks Avenue', 'Kingford', '6133038477', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Raquel', 'Marcome', '631 Novick Parkway', 'Sweetford Beach', '6977755850', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Cary', 'Sweedy', '771 Delaware Junction', 'Kingford', null, 'csweedy16@hotmail.com', FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Waly', 'Tomet', '7 Oxford Drive', 'Sweetford Beach', null, null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Alard', 'Dungay', '64 Kings Trail', 'Saydol Falls', '8276976659', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Gibby', 'Knight', '68 Elgar Lane', 'Mayport', '6016002059', 'gknight19@gmail.com', FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Luelle', 'Le Borgne', '77927 Elmside Hill', 'Sweetford Beach', '2624888667', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Myriam', 'Stuckes', '4 Magdeline Lane', 'Springham', null, 'mstuckes1b@hotmail.com', TRUE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Roselle', 'Ethridge', '4 Erie Avenue', 'Springham', '2817051570', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Germana', 'Fenna', '1966 Charing Cross Avenue', 'Sweetford Beach', '6534290336', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Jimmy', 'Hayen', '954 Dryden Crossing', 'Riverport City', '8611944186', null, FALSE);
INSERT INTO customer (first_name, last_name, street_address, city, phone_number, email_address, email_offers) VALUES ('Loren', 'Caso', '64 Mayfield Place', 'Springham', '5252304596', null, FALSE);


INSERT INTO sale (customer_id, is_delivery) VALUES (1, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (2, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (null, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (3, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (4, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (5, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (6, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (7, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (8, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (9, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (5, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (null, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (10, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (11, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (12, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (null, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (null, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (13, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (14, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (15, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (5, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (16, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (17, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (null, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (11, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (7, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (18, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (null, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (19, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (20, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (21, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (22, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (23, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (24, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (25, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (19, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (3, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (26, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (null, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (27, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (28, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (29, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (30, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (31, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (null, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (32, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (33, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (19, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (35, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (3, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (37, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (38, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (39, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (40, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (37, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (null, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (41, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (42, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (42, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (43, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (20, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (37, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (null, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (44, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (45, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (46, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (47, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (48, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (49, TRUE);
INSERT INTO sale (customer_id, is_delivery) VALUES (50, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (37, FALSE);
INSERT INTO sale (customer_id, is_delivery) VALUES (52, TRUE);


INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (1, 'M', 'Regular', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (2, 'S', 'Pan', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (3, 'L', 'Regular', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (4, 'L', 'Thin', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (5, 'S', 'Pan', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (6, 'S', 'Regular', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (6, 'S', 'Regular', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce, additional_instructions) VALUES (7, 'L', 'Thin', 'Light', 'Cut into squares');
INSERT INTO pizza (sale_id, size_id, crust, sauce, additional_instructions) VALUES (7, 'L', 'Thin', 'Normal', 'Cut into squares');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (8, 'L', 'Pan', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (9, 'M', 'Thin', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (10, 'M', 'Regular', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (10, 'M', 'Regular', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (10, 'M', 'Regular', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (11, 'L', 'Thin', 'None');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (12, 'M', 'Regular', 'Extra');
INSERT INTO pizza (sale_id, size_id, crust, sauce, additional_instructions) VALUES (12, 'L', 'Regular', 'Extra', 'Half mushroom, half pepperoni');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (13, 'S', 'Regular', 'Extra');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (14, 'S', 'Regular', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (15, 'L', 'Thin', 'None');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (16, 'M', 'Pan', 'Extra');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (17, 'M', 'Regular', 'Extra');
INSERT INTO pizza (sale_id, size_id, crust, sauce, additional_instructions) VALUES (18, 'M', 'Thin', 'Normal', 'Add BBQ sauce');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (18, 'M', 'Regular', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (19, 'M', 'Thin', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (20, 'M', 'Pan', 'Extra');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (20, 'M', 'Regular', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (20, 'M', 'Regular', 'Extra');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (21, 'M', 'Thin', 'Extra');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (22, 'L', 'Regular', 'Light');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (23, 'S', 'Regular', 'Extra');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (24, 'L', 'Regular', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (25, 'S', 'Pan', 'Light');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (25, 'S', 'Pan', 'Light');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (26, 'S', 'Regular', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (26, 'S', 'Regular', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (27, 'L', 'Thin', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (28, 'L', 'Thin', 'Light');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (28, 'M', 'Regular', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (29, 'L', 'Pan', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (30, 'S', 'Regular', 'Extra');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (31, 'S', 'Regular', 'Light');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (31, 'S', 'Thin', 'Light');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (32, 'M', 'Pan', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (33, 'S', 'Pan', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (34, 'L', 'Thin', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (35, 'M', 'Regular', 'Extra');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (36, 'L', 'Regular', 'Extra');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (37, 'L', 'Regular', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (37, 'L', 'Regular', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (37, 'L', 'Regular', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (38, 'L', 'Thin', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (39, 'M', 'Regular', 'Extra');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (39, 'L', 'Regular', 'Extra');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (40, 'L', 'Regular', 'Light');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (40, 'L', 'Thin', 'Light');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (41, 'S', 'Thin', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (42, 'M', 'Regular', 'Extra');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (43, 'M', 'Regular', 'Light');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (44, 'S', 'Pan', 'Extra');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (45, 'L', 'Pan', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (46, 'L', 'Regular', 'Light');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (47, 'S', 'Pan', 'Light');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (48, 'M', 'Pan', 'Extra');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (48, 'M', 'Pan', 'Extra');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (49, 'L', 'Thin', 'None');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (50, 'M', 'Pan', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (51, 'M', 'Thin', 'Light');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (52, 'M', 'Regular', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (52, 'M', 'Regular', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (53, 'S', 'Thin', 'Light');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (54, 'L', 'Pan', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (54, 'L', 'Thin', 'Light');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (55, 'M', 'Thin', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (56, 'M', 'Pan', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (56, 'M', 'Pan', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (57, 'M', 'Thin', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (58, 'M', 'Regular', 'Extra');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (59, 'M', 'Thin', 'None');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (60, 'M', 'Pan', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (60, 'L', 'Pan', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (61, 'M', 'Thin', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (62, 'S', 'Thin', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (63, 'M', 'Pan', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (63, 'M', 'Pan', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (63, 'M', 'Pan', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce, additional_instructions) VALUES (64, 'L', 'Thin', 'Normal', 'Please don''t cut');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (65, 'L', 'Pan', 'Light');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (66, 'L', 'Thin', 'Light');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (67, 'S', 'Pan', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (68, 'L', 'Regular', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (69, 'L', 'Pan', 'Extra');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (70, 'S', 'Thin', 'Extra');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (71, 'S', 'Pan', 'Normal');
INSERT INTO pizza (sale_id, size_id, crust, sauce) VALUES (72, 'L', 'Regular', 'Extra');



INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (1, 'Pepperoni');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (2, 'Tomatoes');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (3, 'Ham');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (4, 'Mushrooms');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (5, 'Extra Cheese');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (6, 'Tomatoes');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (7, 'Green Peppers');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (10, 'Sausage');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (11, 'Green Peppers');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (12, 'Mushrooms');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (13, 'Chicken');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (14, 'Pineapple');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (16, 'Ham');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (16, 'Pineapple');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (17, 'Mushrooms');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (17, 'Pepperoni');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (18, 'Mushrooms');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (19, 'Sausage');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (20, 'Bacon');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (21, 'Ham');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (21, 'Green Peppers');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (22, 'Pineapple');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (23, 'Chicken');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (25, 'Bacon');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (26, 'Black Olives');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (27, 'Mushrooms');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (28, 'Pepperoni');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (30, 'Pineapple');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (31, 'Pepperoni');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (32, 'Tomatoes');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (33, 'Tomatoes');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (34, 'Pepperoni');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (36, 'Onions');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (36, 'Bacon');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (37, 'Sausage');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (38, 'Bacon');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (39, 'Ham');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (40, 'Chicken');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (41, 'Black Olives');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (41, 'Green Peppers');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (43, 'Pepperoni');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (44, 'Green Peppers');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (44, 'Mushrooms');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (46, 'Green Peppers');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (47, 'Onions');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (47, 'Green Peppers');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (49, 'Extra Cheese');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (50, 'Bacon');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (51, 'Tomatoes');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (52, 'Extra Cheese');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (53, 'Tomatoes');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (54, 'Bacon');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (55, 'Chicken');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (56, 'Tomatoes');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (57, 'Black Olives');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (59, 'Black Olives');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (60, 'Green Peppers');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (61, 'Extra Cheese');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (62, 'Pepperoni');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (63, 'Green Peppers');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (63, 'Onions');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (64, 'Pineapple');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (65, 'Onions');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (66, 'Tomatoes');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (67, 'Ham');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (68, 'Extra Cheese');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (69, 'Pepperoni');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (70, 'Tomatoes');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (71, 'Bacon');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (72, 'Bacon');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (73, 'Ham');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (74, 'Chicken');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (76, 'Extra Cheese');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (77, 'Pepperoni');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (78, 'Bacon');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (79, 'Tomatoes');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (80, 'Onions');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (81, 'Sausage');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (82, 'Mushrooms');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (83, 'Tomatoes');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (84, 'Extra Cheese');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (85, 'Sausage');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (86, 'Bacon');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (87, 'Green Peppers');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (88, 'Extra Cheese');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (89, 'Black Olives');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (90, 'Sausage');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (91, 'Mushrooms');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (92, 'Pepperoni');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (93, 'Sausage');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (94, 'Mushrooms');
INSERT INTO pizza_topping (pizza_id, topping_name) VALUES (95, 'Bacon');


--calculate prices
UPDATE pizza SET price = 
    (SELECT base_price FROM size WHERE pizza.size_id = size.size_id) +
    (SELECT COALESCE(SUM(additional_price),0)
        FROM pizza_topping
        JOIN topping ON pizza_topping.topping_name = topping.topping_name
        WHERE pizza.pizza_id = pizza_topping.pizza_id);

UPDATE sale SET total = (SELECT SUM(price) FROM pizza WHERE pizza.sale_id = sale.sale_id);

COMMIT;