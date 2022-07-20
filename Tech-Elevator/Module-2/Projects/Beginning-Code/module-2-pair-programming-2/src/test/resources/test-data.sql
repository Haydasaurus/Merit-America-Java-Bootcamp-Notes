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


/* test parks */
INSERT INTO park (name, location, establish_date, area, visitors, description)
VALUES ('Park 1', 'Pennsylvania', '1/1/1970', 1024, 512, 'Test description 1'); -- park_id will be 1 due to serial

INSERT INTO park (name, location, establish_date, area, visitors, description)
VALUES ('Park 2', 'Ohio', '1/1/1970', 2048, 1024, 'Test description 2'); -- park_id will be 2 due to serial


/* test campgrounds */
INSERT INTO campground(park_id, name, open_from_mm, open_to_mm, daily_fee)
VALUES (1, 'Test Campground 1', '1', '12', 35); -- campground_id will be 1 due to serial

INSERT INTO campground(park_id, name, open_from_mm, open_to_mm, daily_fee)
VALUES (1, 'Test Campground 2', '1', '12', 35); -- campground_id will be 2 due to serial


/* test sites */
/**** accepts RVs */
INSERT INTO site(campground_id, site_number, max_occupancy, accessible, max_rv_length, utilities)
VALUES (1, 1, 10, true, 33, true); -- site_id will be 1 due to serial

INSERT INTO site(campground_id, site_number, max_occupancy, accessible, max_rv_length, utilities)
VALUES (1, 2, 10, true, 30, true); -- site_id will be 2 due to serial

/**** doesn't accept RVs */
INSERT INTO site(campground_id, site_number, max_occupancy, accessible, max_rv_length, utilities)
VALUES (1, 3, 10, true, 0, true); -- site_id will be 3 due to serial


/* test reservations */
/**** future */
INSERT INTO reservation(site_id, name, from_date, to_date, create_date)
VALUES (1, 'Test Testerson', CURRENT_DATE + 1, CURRENT_DATE + 5, CURRENT_DATE - 23); -- reservation_id will be 1 due to serial

INSERT INTO reservation(site_id, name, from_date, to_date, create_date)
VALUES (1, 'Bob Robertson', CURRENT_DATE + 11, CURRENT_DATE + 18, CURRENT_DATE - 23); -- reservation_id will be 2 due to serial

/**** present */
INSERT INTO reservation(site_id, name, from_date, to_date, create_date)
VALUES (1, 'Manager Managerson', CURRENT_DATE - 5, CURRENT_DATE + 2, CURRENT_DATE - 23); -- reservation_id will be 3 due to serial

/**** past */
INSERT INTO reservation(site_id, name, from_date, to_date, create_date)
VALUES (1, 'Leonard Leonardson', CURRENT_DATE - 11, CURRENT_DATE - 18, CURRENT_DATE - 23); -- reservation_id will be 4 due to serial


ALTER TABLE campground ADD FOREIGN KEY (park_id) REFERENCES park(park_id);
ALTER TABLE site ADD FOREIGN KEY (campground_id) REFERENCES campground(campground_id);
ALTER TABLE reservation ADD FOREIGN KEY (site_id) REFERENCES site(site_id);

COMMIT;