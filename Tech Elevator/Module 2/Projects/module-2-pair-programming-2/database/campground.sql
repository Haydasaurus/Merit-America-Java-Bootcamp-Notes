-- database name: campground;
DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS site;
DROP TABLE IF EXISTS campground;
DROP TABLE IF EXISTS park;

BEGIN TRANSACTION;

CREATE TABLE park (
  park_id serial,
  name varchar(80) NOT NULL,          -- Name of the park
  location varchar(50) NOT NULL,      -- State name(s) where park is located
  establish_date date NOT NULL,       -- Date park was established
  area integer NOT NULL,              -- Area in acres
  visitors integer NOT NULL,          -- Latest recorded number of annual visitors
  description varchar(500) NOT NULL,  --
  CONSTRAINT PK_park_park_id PRIMARY KEY (park_id)
);

CREATE TABLE campground (
  campground_id serial,
  park_id integer NOT NULL,               -- Parent park
  name varchar(80) NOT NULL,              -- Name of the campground
  open_from_mm varchar(2) NOT NULL,       -- Campground is open from month: 01=January, 02=February, ... 12=December
  open_to_mm varchar(4) NOT NULL,         -- Campground is open to month: 01=January, 02=February, ... 12=December
  daily_fee money NOT NULL,
  CONSTRAINT PK_campground_campground_id PRIMARY KEY (campground_id)
);

CREATE TABLE site (
  site_id serial,
  campground_id integer NOT NULL,
  site_number integer NOT NULL,                   -- Site numbers are
  max_occupancy integer NOT NULL DEFAULT 6,       -- Sites are limited to 6 people, however some sites are "doubled" (12 people)
  accessible boolean NOT NULL DEFAULT FALSE,      -- Accessible site, reserved for campers with disabilities
  max_rv_length integer NOT NULL DEFAULT 0,       -- RVs/Trailers not permitted if length is 0
  utilities boolean NOT NULL DEFAULT FALSE,       -- Electricity, running water available.
  CONSTRAINT PK_site_site_number_campground_id PRIMARY KEY (site_id)
);

CREATE TABLE reservation (
  reservation_id serial,
  site_id integer NOT NULL,
  name varChar(80) NOT NULL,
  from_date date NOT NULL,
  to_date date NOT NULL,
  create_date date NOT NULL DEFAULT now(),
  CONSTRAINT PK_reservation_reservation_id PRIMARY KEY (reservation_id)
);


-- Acadia
INSERT INTO park (name, location, establish_date, area, visitors, description)
VALUES ('Acadia', 'Maine', '1919-02-26', 47389, 2563129, 'Covering most of Mount Desert Island and other coastal islands, Acadia features the tallest mountain on the Atlantic coast of the United States, granite peaks, ocean shoreline, woodlands, and lakes. There are freshwater, estuary, forest, and intertidal habitats.');

-- Arches
INSERT INTO park (name, location, establish_date, area, visitors, description)
VALUES ('Arches',	'Utah', '1929-04-12', 76518,	1284767, 'This site features more than 2,000 natural sandstone arches, including the famous Delicate Arch. In a desert climate, millions of years of erosion have led to these structures, and the arid ground has life-sustaining soil crust and potholes, which serve as natural water-collecting basins. Other geologic formations are stone columns, spires, fins, and towers.');

-- Cuyahoga
INSERT INTO park (name, location, establish_date, area, visitors, description)
VALUES ('Cuyahoga Valley', 'Ohio', '2000-10-11',32860,	2189849, 'This park along the Cuyahoga River has waterfalls, hills, trails, and exhibits on early rural living. The Ohio and Erie Canal Towpath Trail follows the Ohio and Erie Canal, where mules towed canal boats. The park has numerous historic homes, bridges, and structures, and also offers a scenic train ride.');

-- Acadia Campgrounds
INSERT INTO campground (park_id, name, open_from_mm, open_to_mm, daily_fee) VALUES (1, 'Blackwoods', 1, 12, 35.00);
INSERT INTO campground (park_id, name, open_from_mm, open_to_mm, daily_fee) VALUES (1, 'Seawall', 5, 9, 30.00);
INSERT INTO campground (park_id, name, open_from_mm, open_to_mm, daily_fee) VALUES (1, 'Schoodic Woods', 5, 10, 30.00);

-- Arches Campgrounds
INSERT INTO campground (park_id, name, open_from_mm, open_to_mm, daily_fee) VALUES (2, 'Devil''s Garden', 1, 12, 25.00);
INSERT INTO campground (park_id, name, open_from_mm, open_to_mm, daily_fee) VALUES (2, 'Canyon Wren Group Site', 1, 12, 160.00);
INSERT INTO campground (park_id, name, open_from_mm, open_to_mm, daily_fee) VALUES (2, 'Juniper Group Site', 1, 12, 250.00);

-- Cuyahoga Campgrounds
INSERT INTO campground (park_id, name, open_from_mm, open_to_mm, daily_fee) VALUES (3, 'The Unnamed Primitive Campsites', 5, 11, 20.00);

-- Acadia Blackwoods Sites (Tent, Camper)
INSERT INTO site (site_number, campground_id) VALUES (1, 1);
INSERT INTO site (site_number, campground_id) VALUES (2, 1);
INSERT INTO site (site_number, campground_id) VALUES (3, 1);
INSERT INTO site (site_number, campground_id, utilities) VALUES (4, 1, TRUE);
INSERT INTO site (site_number, campground_id, accessible) VALUES (5, 1, TRUE);
INSERT INTO site (site_number, campground_id, accessible, utilities) VALUES (6, 1, TRUE, TRUE);
-- Acadia Blackwoods Sites (RV/Trainler 20ft)
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (7, 1, 20);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (8, 1, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, accessible, utilities) VALUES (9, 1, 20, TRUE, TRUE);
-- Acadia Blackwoods Sites (RV/Trainler 35ft)
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (10, 1, 35);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (11, 1, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, accessible, utilities) VALUES (12, 1, 35, TRUE, TRUE);

-- Acadia Seawall Sites (Tent)
INSERT INTO site (site_number, campground_id) VALUES (1, 2);
INSERT INTO site (site_number, campground_id) VALUES (2, 2);
INSERT INTO site (site_number, campground_id, utilities) VALUES (3, 2, TRUE);
INSERT INTO site (site_number, campground_id, accessible) VALUES (4, 2, TRUE);
INSERT INTO site (site_number, campground_id, accessible) VALUES (5, 2, TRUE);
INSERT INTO site (site_number, campground_id, accessible, utilities) VALUES (6, 2, TRUE, TRUE);
-- Acadia Seawall Sites (RV/Trailer 20ft)
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (7, 2, 20);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (8, 2, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, accessible, utilities) VALUES (9, 2, 20, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, accessible, utilities) VALUES (10, 2, 20, TRUE, TRUE);
-- Acadia Seawall Sites (RV/Trailer 35ft)
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (11, 2, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, accessible, utilities) VALUES (12, 2, 35, TRUE, TRUE);

-- Acadia Schoodic Sites (Tent and Camper)
INSERT INTO site (site_number, campground_id) VALUES (1, 3);
INSERT INTO site (site_number, campground_id) VALUES (2, 3);
INSERT INTO site (site_number, campground_id, utilities) VALUES (3, 3, TRUE); -- 31 - 35
INSERT INTO site (site_number, campground_id, accessible, utilities) VALUES (4, 3, TRUE, TRUE);
-- Acadia Schoodic Sites (RV/Trailer 20ft)
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (5, 3, 20);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (6, 3, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (7, 3, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, accessible, utilities) VALUES (8, 3, 20, TRUE, TRUE); -- 21 - 22
-- Acadia Schoodic Sites (RV/Trailer 35ft)
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (9, 3, 35); -- 1 - 10
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (10, 3, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, accessible) VALUES (11, 3, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, accessible, utilities) VALUES (12, 3, 35, TRUE, TRUE);

-- Arches Devil's Garden Sites (Tent)
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (1, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (2, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy, utilities) VALUES (3, 4, 10, TRUE);
INSERT INTO site (site_number, campground_id, max_occupancy, utilities) VALUES (4, 4, 10, TRUE);
INSERT INTO site (site_number, campground_id, max_occupancy, accessible, utilities) VALUES (5, 4, 10, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, max_occupancy, accessible, utilities) VALUES (6, 4, 10, TRUE, TRUE);
-- Arches Devil's Garden Sites (RV/Trailer 20ft)
INSERT INTO site (site_number, campground_id, max_occupancy, max_rv_length, utilities) VALUES (7, 4, 7, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_occupancy, max_rv_length, utilities) VALUES (8, 4, 7, 20, TRUE);
-- Arches Canyon Wren Group Site (Tent)
INSERT INTO site (site_number, campground_id, max_occupancy, accessible) VALUES (1, 5, 35, TRUE);
-- Arches Juniper Group Site (Tent)
INSERT INTO site (site_number, campground_id, max_occupancy, accessible) VALUES (1, 6, 55, TRUE);

-- Cuyahoga Unnamed Primitive Campsites Sites (Tent)
INSERT INTO site (site_number, campground_id) VALUES (1, 7);
INSERT INTO site (site_number, campground_id) VALUES (2, 7);
INSERT INTO site (site_number, campground_id) VALUES (3, 7);
INSERT INTO site (site_number, campground_id) VALUES (4, 7);
INSERT INTO site (site_number, campground_id) VALUES (5, 7);

-- Reservations
-- Acadia Blackwoods Sites (1 - 12)
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (1, 'Smith Family Reservation', NOW() - INTERVAL '2 days', NOW() + INTERVAL '2 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (1, 'Lockhart Family Reservation', NOW() - INTERVAL '6 days', NOW() - INTERVAL '3 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (2, 'Jones Reservation', NOW() - INTERVAL '2 days', NOW() + INTERVAL '2 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (3, 'Bauer Family Reservation', NOW(), NOW() + INTERVAL '2 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (4, 'Eagles Family Reservation', NOW() + INTERVAL '5 days', NOW() + INTERVAL '10 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (7, 'Aersomith Reservation', NOW() - INTERVAL '3 days', NOW() + INTERVAL '2 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (9, 'Claus Family Reservation', NOW(), NOW() + INTERVAL '1 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (9, 'Taylor Family Reservation', NOW() - INTERVAL '7 days', NOW() - INTERVAL '5 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (10, 'Astley Family Reservation', NOW() + INTERVAL '14 days', NOW() + INTERVAL '21 days');

-- Acadia Seawall Sites (13 - 24)
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (13, 'Jobs Family Reservation', NOW() + INTERVAL '1 days', NOW() + INTERVAL '4 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (14, 'Cook Family Reservation', NOW() + INTERVAL '1 days', NOW() + INTERVAL '4 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (15, 'Gates Reservation', NOW() + INTERVAL '1 days', NOW() + INTERVAL '4 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (16, 'Cue Family Reservation', NOW() + INTERVAL '1 days', NOW() + INTERVAL '4 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (17, 'Ive Family Reservation', NOW() + INTERVAL '1 days', NOW() + INTERVAL '4 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (18, 'Federighi Family Reservation', NOW() + INTERVAL '1 days', NOW() + INTERVAL '4 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (19, 'Schiller Family Reservation', NOW() + INTERVAL '1 days', NOW() + INTERVAL '4 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (20, 'Williams Family Reservation', NOW() + INTERVAL '1 days', NOW() + INTERVAL '4 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (20, 'Kawasaki Family Reservation', NOW() + INTERVAL '10 days', NOW() + INTERVAL '21 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (20, 'Branson Family Reservation', NOW() + INTERVAL '22 days', NOW() + INTERVAL '28 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (20, 'Zukerberg Family Reservation', NOW() + INTERVAL '30 days', NOW() + INTERVAL '33 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (24, 'Musk Family Reservation', NOW() + INTERVAL '4 days', NOW() + INTERVAL '10 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (24, 'Buffett Family Reservation', NOW() - INTERVAL '4 days', NOW());

-- Acadia Schoodic Woods Sites (25 - 36)
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (25, 'Satya Nedella', NOW() + INTERVAL '3 days', NOW() + INTERVAL '10 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (25, 'Scott Gutherie', NOW() + INTERVAL '10 days', NOW() + INTERVAL '14 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (28, 'Amy Hood', NOW() + INTERVAL '5 days', NOW() + INTERVAL '11 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (29, 'Peggy Johnson', NOW() + INTERVAL '5 days', NOW() + INTERVAL '11 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (31, 'Terry Myerson', NOW() + INTERVAL '9 days', NOW() + INTERVAL '11 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (32, 'Steve Ballmer', NOW() + INTERVAL '13 days', NOW() + INTERVAL '15 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (32, 'Gates Family Reservation', NOW() + INTERVAL '16 days', NOW() + INTERVAL '19 days');

-- Devil's Garden (37 - 44)
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (37, 'Marisa Mayer', NOW() - INTERVAL '15 days', NOW() - INTERVAL '10 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (37, 'Beth Mooney', NOW(), NOW() + INTERVAL '4 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (40, 'William Priemer', NOW() + INTERVAL '2 days', NOW() + INTERVAL '6 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (42, 'Tricia Griffith', NOW() + INTERVAL '3 days', NOW() + INTERVAL '8 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (43, 'Toby Cosgrove', NOW() + INTERVAL '5 days', NOW() + INTERVAL '11 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (43, 'Akram Boutros', NOW() + INTERVAL '12 days', NOW() + INTERVAL '18 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (44, 'Barbara Snyder', NOW() + INTERVAL '9 days', NOW() + INTERVAL '11 days');


-- Canyon Wren (45)
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (45, 'Bill Board', NOW() - INTERVAL '9 days', NOW() + INTERVAL '1 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (45, 'Bill Loney', NOW() + INTERVAL '1 days', NOW() + INTERVAL '11 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (45, 'Cara Van', NOW() + INTERVAL '17 days', NOW() + INTERVAL '21 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (45, 'Forrest Gump', NOW() + INTERVAL '31 days', NOW() + INTERVAL '37 days');

-- Juniper Group Site (46)
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (46, 'Simpson Family', NOW() - INTERVAL '6 days', NOW() + INTERVAL '1 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (46, 'Smith Family', NOW() + INTERVAL '2 days', NOW() + INTERVAL '11 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (46, 'Leela Family', NOW() + INTERVAL '14 days', NOW() + INTERVAL '15 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (46, 'Scott Family', NOW() + INTERVAL '35 days', NOW() + INTERVAL '40 days');

-- Unnamed Primitive Campsites (47 - 51)

ALTER TABLE campground ADD FOREIGN KEY (park_id) REFERENCES park(park_id);
ALTER TABLE site ADD FOREIGN KEY (campground_id) REFERENCES campground(campground_id);
ALTER TABLE reservation ADD FOREIGN KEY (site_id) REFERENCES site(site_id);

COMMIT;