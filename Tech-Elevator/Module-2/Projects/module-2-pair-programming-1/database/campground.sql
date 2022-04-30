DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS site;
DROP TABLE IF EXISTS campground;
DROP TABLE IF EXISTS park;

DROP SEQUENCE IF EXISTS reservation_reservation_id_seq;
DROP SEQUENCE IF EXISTS site_site_id_seq;
DROP SEQUENCE IF EXISTS campground_campground_id_seq;
DROP SEQUENCE IF EXISTS park_park_id_seq;

CREATE SEQUENCE park_park_id_seq
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE park (
  park_id integer DEFAULT nextval('park_park_id_seq'::regclass) NOT NULL,
  name varchar(80) NOT NULL,          -- Name of the park
  location varchar(50) NOT NULL,      -- State name(s) where park is located
  establish_date date NOT NULL,       -- Date park was established
  area integer NOT NULL,              -- Area in acres
  visitors integer NOT NULL,          -- Latest recorded number of annual visitors
  description varchar(500) NOT NULL,  --
  CONSTRAINT pk_park_park_id PRIMARY KEY (park_id)
);

CREATE SEQUENCE campground_campground_id_seq
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE campground (
  campground_id integer DEFAULT nextval('campground_campground_id_seq'::regclass) NOT NULL,
  park_id integer NOT NULL,               -- Parent park
  name varchar(80) NOT NULL,              -- Name of the campground
  open_from_mm varchar(2) NOT NULL,       -- Campground is open from month: 01=January, 02=February, ... 12=December
  open_to_mm varchar(4) NOT NULL,         -- Campground is open to month: 01=January, 02=February, ... 12=December
  daily_fee money NOT NULL,
  CONSTRAINT pk_campground_campground_id PRIMARY KEY (campground_id)
);

CREATE SEQUENCE site_site_id_seq
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE site (
  site_id integer DEFAULT nextval('site_site_id_seq'::regclass) NOT NULL,
  campground_id integer NOT NULL,
  site_number integer NOT NULL,                   -- Site numbers are
  max_occupancy integer NOT NULL DEFAULT 6,       -- Sites are limited to 6 people, however some sites are "doubled" (12 people)
  accessible boolean NOT NULL DEFAULT FALSE,      -- Accessible site, reserved for campers with disabilities
  max_rv_length integer NOT NULL DEFAULT 0,       -- RVs/Trailers not permitted if length is 0
  utilities boolean NOT NULL DEFAULT FALSE,       -- Electricity, running water available.
  CONSTRAINT pk_site_site_number_campground_id PRIMARY KEY (site_id)
);

CREATE SEQUENCE reservation_reservation_id_seq
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE reservation (
  reservation_id integer DEFAULT nextval('reservation_reservation_id_seq'::regclass) NOT NULL,
  site_id integer NOT NULL,
  name varChar(80) NOT NULL,
  from_date date NOT NULL,
  to_date date NOT NULL,
  create_date date NOT NULL DEFAULT now(),
  CONSTRAINT pk_reservation_reservation_id PRIMARY KEY (reservation_id)
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
INSERT INTO campground (park_id, name, open_from_mm, open_to_mm, daily_fee) VALUES (1, 'Blackwoods', '01', '12', 35.00);
INSERT INTO campground (park_id, name, open_from_mm, open_to_mm, daily_fee) VALUES (1, 'Seawall', '05', '09', 30.00);
INSERT INTO campground (park_id, name, open_from_mm, open_to_mm, daily_fee) VALUES (1, 'Schoodic Woods', '05', '10', 30.00);

-- Arches Campgrounds
INSERT INTO campground (park_id, name, open_from_mm, open_to_mm, daily_fee) VALUES (2, 'Devil''s Garden', '01', '12', 25.00);
INSERT INTO campground (park_id, name, open_from_mm, open_to_mm, daily_fee) VALUES (2, 'Canyon Wren Group Site', '01', '12', 160.00);
INSERT INTO campground (park_id, name, open_from_mm, open_to_mm, daily_fee) VALUES (2, 'Juniper Group Site', '01', '12', 250.00);

-- Cuyahoga Campgrounds
INSERT INTO campground (park_id, name, open_from_mm, open_to_mm, daily_fee) VALUES (3, 'The Unnamed Primitive Campsites', '05', '11', 20.00);

-- Acadia Blackwoods Sites (Tent, Camper)
INSERT INTO site (site_number, campground_id) VALUES (1, 1); -- 1 - 10
INSERT INTO site (site_number, campground_id) VALUES (2, 1);
INSERT INTO site (site_number, campground_id) VALUES (3, 1);
INSERT INTO site (site_number, campground_id) VALUES (4, 1);
INSERT INTO site (site_number, campground_id) VALUES (5, 1);
INSERT INTO site (site_number, campground_id) VALUES (6, 1);
INSERT INTO site (site_number, campground_id) VALUES (7, 1);
INSERT INTO site (site_number, campground_id) VALUES (8, 1);
INSERT INTO site (site_number, campground_id) VALUES (9, 1);
INSERT INTO site (site_number, campground_id) VALUES (10, 1);
INSERT INTO site (site_number, campground_id) VALUES (11, 1); -- 11 - 20
INSERT INTO site (site_number, campground_id) VALUES (12, 1);
INSERT INTO site (site_number, campground_id) VALUES (13, 1);
INSERT INTO site (site_number, campground_id) VALUES (14, 1);
INSERT INTO site (site_number, campground_id) VALUES (15, 1);
INSERT INTO site (site_number, campground_id) VALUES (16, 1);
INSERT INTO site (site_number, campground_id) VALUES (17, 1);
INSERT INTO site (site_number, campground_id) VALUES (18, 1);
INSERT INTO site (site_number, campground_id) VALUES (19, 1);
INSERT INTO site (site_number, campground_id) VALUES (20, 1);
INSERT INTO site (site_number, campground_id) VALUES (21, 1); -- 21 - 30
INSERT INTO site (site_number, campground_id) VALUES (22, 1);
INSERT INTO site (site_number, campground_id) VALUES (23, 1);
INSERT INTO site (site_number, campground_id) VALUES (24, 1);
INSERT INTO site (site_number, campground_id) VALUES (25, 1);
INSERT INTO site (site_number, campground_id) VALUES (26, 1);
INSERT INTO site (site_number, campground_id) VALUES (27, 1);
INSERT INTO site (site_number, campground_id) VALUES (28, 1);
INSERT INTO site (site_number, campground_id) VALUES (29, 1);
INSERT INTO site (site_number, campground_id) VALUES (30, 1);
INSERT INTO site (site_number, campground_id) VALUES (31, 1); -- 31 - 40
INSERT INTO site (site_number, campground_id) VALUES (32, 1);
INSERT INTO site (site_number, campground_id) VALUES (33, 1);
INSERT INTO site (site_number, campground_id) VALUES (34, 1);
INSERT INTO site (site_number, campground_id) VALUES (35, 1);
INSERT INTO site (site_number, campground_id) VALUES (36, 1);
INSERT INTO site (site_number, campground_id) VALUES (37, 1);
INSERT INTO site (site_number, campground_id) VALUES (38, 1);
INSERT INTO site (site_number, campground_id) VALUES (39, 1);
INSERT INTO site (site_number, campground_id) VALUES (40, 1);
INSERT INTO site (site_number, campground_id) VALUES (41, 1); -- 41 - 50
INSERT INTO site (site_number, campground_id) VALUES (42, 1);
INSERT INTO site (site_number, campground_id) VALUES (43, 1);
INSERT INTO site (site_number, campground_id) VALUES (44, 1);
INSERT INTO site (site_number, campground_id) VALUES (45, 1);
INSERT INTO site (site_number, campground_id) VALUES (46, 1);
INSERT INTO site (site_number, campground_id) VALUES (47, 1);
INSERT INTO site (site_number, campground_id) VALUES (48, 1);
INSERT INTO site (site_number, campground_id) VALUES (49, 1);
INSERT INTO site (site_number, campground_id) VALUES (50, 1);
INSERT INTO site (site_number, campground_id) VALUES (51, 1); -- 51 - 60
INSERT INTO site (site_number, campground_id) VALUES (52, 1);
INSERT INTO site (site_number, campground_id) VALUES (53, 1);
INSERT INTO site (site_number, campground_id) VALUES (54, 1);
INSERT INTO site (site_number, campground_id) VALUES (55, 1);
INSERT INTO site (site_number, campground_id) VALUES (56, 1);
INSERT INTO site (site_number, campground_id) VALUES (57, 1);
INSERT INTO site (site_number, campground_id) VALUES (58, 1);
INSERT INTO site (site_number, campground_id) VALUES (59, 1);
INSERT INTO site (site_number, campground_id) VALUES (60, 1);
INSERT INTO site (site_number, campground_id) VALUES (61, 1); -- 61 - 70
INSERT INTO site (site_number, campground_id) VALUES (62, 1);
INSERT INTO site (site_number, campground_id) VALUES (63, 1);
INSERT INTO site (site_number, campground_id) VALUES (64, 1);
INSERT INTO site (site_number, campground_id) VALUES (65, 1);
INSERT INTO site (site_number, campground_id) VALUES (66, 1);
INSERT INTO site (site_number, campground_id) VALUES (67, 1);
INSERT INTO site (site_number, campground_id) VALUES (68, 1);
INSERT INTO site (site_number, campground_id) VALUES (69, 1);
INSERT INTO site (site_number, campground_id) VALUES (70, 1);
INSERT INTO site (site_number, campground_id) VALUES (71, 1); -- 71 - 80
INSERT INTO site (site_number, campground_id) VALUES (72, 1);
INSERT INTO site (site_number, campground_id) VALUES (73, 1);
INSERT INTO site (site_number, campground_id) VALUES (74, 1);
INSERT INTO site (site_number, campground_id) VALUES (75, 1);
INSERT INTO site (site_number, campground_id) VALUES (76, 1);
INSERT INTO site (site_number, campground_id) VALUES (77, 1);
INSERT INTO site (site_number, campground_id) VALUES (78, 1);
INSERT INTO site (site_number, campground_id) VALUES (79, 1);
INSERT INTO site (site_number, campground_id) VALUES (80, 1);
INSERT INTO site (site_number, campground_id) VALUES (81, 1); -- 81 - 90
INSERT INTO site (site_number, campground_id) VALUES (82, 1);
INSERT INTO site (site_number, campground_id) VALUES (83, 1);
INSERT INTO site (site_number, campground_id) VALUES (84, 1);
INSERT INTO site (site_number, campground_id) VALUES (85, 1);
INSERT INTO site (site_number, campground_id) VALUES (86, 1);
INSERT INTO site (site_number, campground_id) VALUES (87, 1);
INSERT INTO site (site_number, campground_id) VALUES (88, 1);
INSERT INTO site (site_number, campground_id) VALUES (89, 1);
INSERT INTO site (site_number, campground_id) VALUES (90, 1);
INSERT INTO site (site_number, campground_id) VALUES (91, 1); -- 91 - 100
INSERT INTO site (site_number, campground_id) VALUES (92, 1);
INSERT INTO site (site_number, campground_id) VALUES (93, 1);
INSERT INTO site (site_number, campground_id) VALUES (94, 1);
INSERT INTO site (site_number, campground_id) VALUES (95, 1);
INSERT INTO site (site_number, campground_id) VALUES (96, 1);
INSERT INTO site (site_number, campground_id) VALUES (97, 1);
INSERT INTO site (site_number, campground_id) VALUES (98, 1);
INSERT INTO site (site_number, campground_id) VALUES (99, 1);
INSERT INTO site (site_number, campground_id) VALUES (100, 1);
INSERT INTO site (site_number, campground_id) VALUES (101, 1); -- 101 - 110
INSERT INTO site (site_number, campground_id) VALUES (102, 1);
INSERT INTO site (site_number, campground_id) VALUES (103, 1);
INSERT INTO site (site_number, campground_id) VALUES (104, 1);
INSERT INTO site (site_number, campground_id) VALUES (105, 1);
INSERT INTO site (site_number, campground_id) VALUES (106, 1);
INSERT INTO site (site_number, campground_id) VALUES (107, 1);
INSERT INTO site (site_number, campground_id) VALUES (108, 1);
INSERT INTO site (site_number, campground_id) VALUES (109, 1);
INSERT INTO site (site_number, campground_id) VALUES (110, 1);
INSERT INTO site (site_number, campground_id) VALUES (111, 1); -- 111 - 120
INSERT INTO site (site_number, campground_id) VALUES (112, 1);
INSERT INTO site (site_number, campground_id) VALUES (113, 1);
INSERT INTO site (site_number, campground_id) VALUES (114, 1);
INSERT INTO site (site_number, campground_id) VALUES (115, 1);
INSERT INTO site (site_number, campground_id) VALUES (116, 1);
INSERT INTO site (site_number, campground_id) VALUES (117, 1);
INSERT INTO site (site_number, campground_id) VALUES (118, 1);
INSERT INTO site (site_number, campground_id) VALUES (119, 1);
INSERT INTO site (site_number, campground_id) VALUES (120, 1);
INSERT INTO site (site_number, campground_id) VALUES (121, 1); -- 121 - 130
INSERT INTO site (site_number, campground_id) VALUES (122, 1);
INSERT INTO site (site_number, campground_id) VALUES (123, 1);
INSERT INTO site (site_number, campground_id) VALUES (124, 1);
INSERT INTO site (site_number, campground_id) VALUES (125, 1);
INSERT INTO site (site_number, campground_id) VALUES (126, 1);
INSERT INTO site (site_number, campground_id) VALUES (127, 1);
INSERT INTO site (site_number, campground_id) VALUES (128, 1);
INSERT INTO site (site_number, campground_id) VALUES (129, 1);
INSERT INTO site (site_number, campground_id) VALUES (130, 1);
INSERT INTO site (site_number, campground_id) VALUES (131, 1); -- 131 - 140
INSERT INTO site (site_number, campground_id) VALUES (132, 1);
INSERT INTO site (site_number, campground_id) VALUES (133, 1);
INSERT INTO site (site_number, campground_id) VALUES (134, 1);
INSERT INTO site (site_number, campground_id) VALUES (135, 1);
INSERT INTO site (site_number, campground_id) VALUES (136, 1);
INSERT INTO site (site_number, campground_id) VALUES (137, 1);
INSERT INTO site (site_number, campground_id) VALUES (138, 1);
INSERT INTO site (site_number, campground_id) VALUES (139, 1);
INSERT INTO site (site_number, campground_id) VALUES (140, 1);
INSERT INTO site (site_number, campground_id) VALUES (141, 1); -- 141 - 150
INSERT INTO site (site_number, campground_id) VALUES (142, 1);
INSERT INTO site (site_number, campground_id) VALUES (143, 1);
INSERT INTO site (site_number, campground_id) VALUES (144, 1);
INSERT INTO site (site_number, campground_id) VALUES (145, 1);
INSERT INTO site (site_number, campground_id) VALUES (146, 1);
INSERT INTO site (site_number, campground_id) VALUES (147, 1);
INSERT INTO site (site_number, campground_id) VALUES (148, 1);
INSERT INTO site (site_number, campground_id) VALUES (149, 1);
INSERT INTO site (site_number, campground_id) VALUES (150, 1);
INSERT INTO site (site_number, campground_id) VALUES (151, 1); -- 151 - 160
INSERT INTO site (site_number, campground_id) VALUES (152, 1);
INSERT INTO site (site_number, campground_id) VALUES (153, 1);
INSERT INTO site (site_number, campground_id) VALUES (154, 1);
INSERT INTO site (site_number, campground_id) VALUES (155, 1);
INSERT INTO site (site_number, campground_id) VALUES (156, 1);
INSERT INTO site (site_number, campground_id) VALUES (157, 1);
INSERT INTO site (site_number, campground_id) VALUES (158, 1);
INSERT INTO site (site_number, campground_id) VALUES (159, 1);
INSERT INTO site (site_number, campground_id) VALUES (160, 1);
INSERT INTO site (site_number, campground_id) VALUES (161, 1); -- 161 - 170
INSERT INTO site (site_number, campground_id) VALUES (162, 1);
INSERT INTO site (site_number, campground_id) VALUES (163, 1);
INSERT INTO site (site_number, campground_id) VALUES (164, 1);
INSERT INTO site (site_number, campground_id) VALUES (165, 1);
INSERT INTO site (site_number, campground_id) VALUES (166, 1);
INSERT INTO site (site_number, campground_id) VALUES (167, 1);
INSERT INTO site (site_number, campground_id) VALUES (168, 1);
INSERT INTO site (site_number, campground_id) VALUES (169, 1);
INSERT INTO site (site_number, campground_id) VALUES (170, 1);
INSERT INTO site (site_number, campground_id) VALUES (171, 1); -- 171 - 180
INSERT INTO site (site_number, campground_id) VALUES (172, 1);
INSERT INTO site (site_number, campground_id) VALUES (173, 1);
INSERT INTO site (site_number, campground_id) VALUES (174, 1);
INSERT INTO site (site_number, campground_id) VALUES (175, 1);
INSERT INTO site (site_number, campground_id) VALUES (176, 1);
INSERT INTO site (site_number, campground_id) VALUES (177, 1);
INSERT INTO site (site_number, campground_id, utilities) VALUES (178, 1, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (179, 1, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (180, 1, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (181, 1, TRUE); -- 181 - 190
INSERT INTO site (site_number, campground_id, utilities) VALUES (182, 1, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (183, 1, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (184, 1, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (185, 1, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (186, 1, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (187, 1, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (188, 1, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (189, 1, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (190, 1, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (191, 1, TRUE); -- 191 - 200
INSERT INTO site (site_number, campground_id, utilities) VALUES (192, 1, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (193, 1, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (194, 1, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (195, 1, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (196, 1, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (197, 1, TRUE);
INSERT INTO site (site_number, campground_id, accessible) VALUES (198, 1, TRUE);
INSERT INTO site (site_number, campground_id, accessible) VALUES (199, 1, TRUE);
INSERT INTO site (site_number, campground_id, accessible) VALUES (200, 1, TRUE);
INSERT INTO site (site_number, campground_id, accessible) VALUES (201, 1, TRUE);
INSERT INTO site (site_number, campground_id, accessible) VALUES (202, 1, TRUE); -- 201 - 210
INSERT INTO site (site_number, campground_id, accessible) VALUES (203, 1, TRUE);
INSERT INTO site (site_number, campground_id, accessible) VALUES (204, 1, TRUE);
INSERT INTO site (site_number, campground_id, accessible) VALUES (205, 1, TRUE);
INSERT INTO site (site_number, campground_id, accessible, utilities) VALUES (206, 1, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, accessible, utilities) VALUES (207, 1, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, accessible, utilities) VALUES (208, 1, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, accessible, utilities) VALUES (209, 1, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, accessible, utilities) VALUES (210, 1, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, accessible, utilities) VALUES (211, 1, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, accessible, utilities) VALUES (212, 1, TRUE, TRUE); -- 211 - 214
INSERT INTO site (site_number, campground_id, accessible, utilities) VALUES (213, 1, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, accessible, utilities) VALUES (214, 1, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, accessible, utilities) VALUES (215, 1, TRUE, TRUE);

-- Acadia Blackwoods Sites (RV/Trainler 20ft)
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (216, 1, 20); -- 1 - 10
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (217, 1, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (218, 1, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (219, 1, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (220, 1, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (221, 1, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (222, 1, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (223, 1, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (224, 1, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (225, 1, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (226, 1, 20); -- 11 - 20
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (227, 1, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (228, 1, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (229, 1, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (230, 1, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (231, 1, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (232, 1, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (233, 1, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (234, 1, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (235, 1, 20);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (236, 1, 20, TRUE); -- 21 - 30
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (237, 1, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (238, 1, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (239, 1, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (240, 1, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (241, 1, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (242, 1, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (243, 1, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, accessible, utilities) VALUES (244, 1, 20, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, accessible, utilities) VALUES (245, 1, 20, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, accessible, utilities) VALUES (246, 1, 20, TRUE, TRUE); -- 31

-- Acadia Blackwoods Sites (RV/Trainler 35ft)
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (247, 1, 35); -- 1 - 10
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (248, 1, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (249, 1, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (250, 1, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (251, 1, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (252, 1, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (253, 1, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (254, 1, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (255, 1, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (256, 1, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (257, 1, 35); -- 11 - 20
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (258, 1, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (259, 1, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (260, 1, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (270, 1, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (271, 1, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (272, 1, 35);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (273, 1, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (274, 1, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (275, 1, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (276, 1, 35, TRUE); -- 21 - 30
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (277, 1, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (278, 1, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (279, 1, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (280, 1, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (281, 1, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (282, 1, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, accessible, utilities) VALUES (283, 1, 35, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, accessible, utilities) VALUES (284, 1, 35, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, accessible, utilities) VALUES (285, 1, 35, TRUE, TRUE);

-- Acadia Seawall Sites (Tent)
INSERT INTO site (site_number, campground_id) VALUES (1, 2); -- 1 - 10
INSERT INTO site (site_number, campground_id) VALUES (2, 2);
INSERT INTO site (site_number, campground_id) VALUES (3, 2);
INSERT INTO site (site_number, campground_id) VALUES (4, 2);
INSERT INTO site (site_number, campground_id) VALUES (5, 2);
INSERT INTO site (site_number, campground_id) VALUES (6, 2);
INSERT INTO site (site_number, campground_id) VALUES (7, 2);
INSERT INTO site (site_number, campground_id) VALUES (8, 2);
INSERT INTO site (site_number, campground_id) VALUES (9, 2);
INSERT INTO site (site_number, campground_id) VALUES (10, 2);
INSERT INTO site (site_number, campground_id) VALUES (11, 2); -- 11 - 20
INSERT INTO site (site_number, campground_id) VALUES (12, 2);
INSERT INTO site (site_number, campground_id) VALUES (13, 2);
INSERT INTO site (site_number, campground_id) VALUES (14, 2);
INSERT INTO site (site_number, campground_id) VALUES (15, 2);
INSERT INTO site (site_number, campground_id) VALUES (16, 2);
INSERT INTO site (site_number, campground_id) VALUES (17, 2);
INSERT INTO site (site_number, campground_id) VALUES (18, 2);
INSERT INTO site (site_number, campground_id) VALUES (19, 2);
INSERT INTO site (site_number, campground_id) VALUES (20, 2);
INSERT INTO site (site_number, campground_id) VALUES (21, 2); -- 21 - 30
INSERT INTO site (site_number, campground_id) VALUES (22, 2);
INSERT INTO site (site_number, campground_id) VALUES (23, 2);
INSERT INTO site (site_number, campground_id) VALUES (24, 2);
INSERT INTO site (site_number, campground_id) VALUES (25, 2);
INSERT INTO site (site_number, campground_id) VALUES (26, 2);
INSERT INTO site (site_number, campground_id) VALUES (27, 2);
INSERT INTO site (site_number, campground_id) VALUES (28, 2);
INSERT INTO site (site_number, campground_id) VALUES (29, 2);
INSERT INTO site (site_number, campground_id) VALUES (30, 2);
INSERT INTO site (site_number, campground_id) VALUES (31, 2); -- 31 - 40
INSERT INTO site (site_number, campground_id) VALUES (32, 2);
INSERT INTO site (site_number, campground_id) VALUES (33, 2);
INSERT INTO site (site_number, campground_id) VALUES (34, 2);
INSERT INTO site (site_number, campground_id) VALUES (35, 2);
INSERT INTO site (site_number, campground_id) VALUES (36, 2);
INSERT INTO site (site_number, campground_id) VALUES (37, 2);
INSERT INTO site (site_number, campground_id) VALUES (38, 2);
INSERT INTO site (site_number, campground_id) VALUES (39, 2);
INSERT INTO site (site_number, campground_id) VALUES (40, 2);
INSERT INTO site (site_number, campground_id) VALUES (41, 2); -- 41 - 50
INSERT INTO site (site_number, campground_id) VALUES (42, 2);
INSERT INTO site (site_number, campground_id) VALUES (43, 2);
INSERT INTO site (site_number, campground_id) VALUES (44, 2);
INSERT INTO site (site_number, campground_id) VALUES (45, 2);
INSERT INTO site (site_number, campground_id) VALUES (46, 2);
INSERT INTO site (site_number, campground_id) VALUES (47, 2);
INSERT INTO site (site_number, campground_id) VALUES (48, 2);
INSERT INTO site (site_number, campground_id) VALUES (49, 2);
INSERT INTO site (site_number, campground_id) VALUES (50, 2);
INSERT INTO site (site_number, campground_id) VALUES (51, 2); -- 51 - 60
INSERT INTO site (site_number, campground_id) VALUES (52, 2);
INSERT INTO site (site_number, campground_id) VALUES (53, 2);
INSERT INTO site (site_number, campground_id) VALUES (54, 2);
INSERT INTO site (site_number, campground_id) VALUES (55, 2);
INSERT INTO site (site_number, campground_id) VALUES (56, 2);
INSERT INTO site (site_number, campground_id) VALUES (57, 2);
INSERT INTO site (site_number, campground_id) VALUES (58, 2);
INSERT INTO site (site_number, campground_id) VALUES (59, 2);
INSERT INTO site (site_number, campground_id) VALUES (60, 2);
INSERT INTO site (site_number, campground_id) VALUES (61, 2); -- 61 - 70
INSERT INTO site (site_number, campground_id) VALUES (62, 2);
INSERT INTO site (site_number, campground_id) VALUES (63, 2);
INSERT INTO site (site_number, campground_id) VALUES (64, 2);
INSERT INTO site (site_number, campground_id) VALUES (65, 2);
INSERT INTO site (site_number, campground_id) VALUES (66, 2);
INSERT INTO site (site_number, campground_id) VALUES (67, 2);
INSERT INTO site (site_number, campground_id) VALUES (68, 2);
INSERT INTO site (site_number, campground_id) VALUES (69, 2);
INSERT INTO site (site_number, campground_id) VALUES (70, 2);
INSERT INTO site (site_number, campground_id) VALUES (71, 2); -- 71 - 80
INSERT INTO site (site_number, campground_id) VALUES (72, 2);
INSERT INTO site (site_number, campground_id) VALUES (73, 2);
INSERT INTO site (site_number, campground_id) VALUES (74, 2);
INSERT INTO site (site_number, campground_id) VALUES (75, 2);
INSERT INTO site (site_number, campground_id) VALUES (76, 2);
INSERT INTO site (site_number, campground_id) VALUES (77, 2);
INSERT INTO site (site_number, campground_id) VALUES (78, 2);
INSERT INTO site (site_number, campground_id) VALUES (79, 2);
INSERT INTO site (site_number, campground_id) VALUES (80, 2);
INSERT INTO site (site_number, campground_id) VALUES (81, 2); -- 81 - 90
INSERT INTO site (site_number, campground_id) VALUES (82, 2);
INSERT INTO site (site_number, campground_id) VALUES (83, 2);
INSERT INTO site (site_number, campground_id) VALUES (84, 2);
INSERT INTO site (site_number, campground_id) VALUES (85, 2);
INSERT INTO site (site_number, campground_id) VALUES (86, 2);
INSERT INTO site (site_number, campground_id) VALUES (87, 2);
INSERT INTO site (site_number, campground_id) VALUES (88, 2);
INSERT INTO site (site_number, campground_id) VALUES (89, 2);
INSERT INTO site (site_number, campground_id) VALUES (90, 2);
INSERT INTO site (site_number, campground_id) VALUES (91, 2); -- 91 - 100
INSERT INTO site (site_number, campground_id) VALUES (92, 2);
INSERT INTO site (site_number, campground_id) VALUES (93, 2);
INSERT INTO site (site_number, campground_id) VALUES (94, 2);
INSERT INTO site (site_number, campground_id) VALUES (95, 2);
INSERT INTO site (site_number, campground_id) VALUES (96, 2);
INSERT INTO site (site_number, campground_id) VALUES (97, 2);
INSERT INTO site (site_number, campground_id) VALUES (98, 2);
INSERT INTO site (site_number, campground_id) VALUES (99, 2);
INSERT INTO site (site_number, campground_id) VALUES (100, 2);
INSERT INTO site (site_number, campground_id) VALUES (101, 2); -- 101 - 110
INSERT INTO site (site_number, campground_id) VALUES (102, 2);
INSERT INTO site (site_number, campground_id) VALUES (103, 2);
INSERT INTO site (site_number, campground_id) VALUES (104, 2);
INSERT INTO site (site_number, campground_id) VALUES (105, 2);
INSERT INTO site (site_number, campground_id) VALUES (106, 2);
INSERT INTO site (site_number, campground_id) VALUES (107, 2);
INSERT INTO site (site_number, campground_id) VALUES (108, 2);
INSERT INTO site (site_number, campground_id) VALUES (109, 2);
INSERT INTO site (site_number, campground_id) VALUES (110, 2);
INSERT INTO site (site_number, campground_id) VALUES (111, 2); -- 111 - 120
INSERT INTO site (site_number, campground_id) VALUES (112, 2);
INSERT INTO site (site_number, campground_id) VALUES (113, 2);
INSERT INTO site (site_number, campground_id) VALUES (114, 2);
INSERT INTO site (site_number, campground_id) VALUES (115, 2);
INSERT INTO site (site_number, campground_id, utilities) VALUES (116, 2, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (117, 2, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (118, 2, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (119, 2, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (120, 2, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (121, 2, TRUE); -- 121 - 130
INSERT INTO site (site_number, campground_id, utilities) VALUES (122, 2, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (123, 2, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (124, 2, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (125, 2, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (126, 2, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (127, 2, TRUE);
INSERT INTO site (site_number, campground_id, accessible) VALUES (128, 2, TRUE);
INSERT INTO site (site_number, campground_id, accessible) VALUES (129, 2, TRUE);
INSERT INTO site (site_number, campground_id, accessible) VALUES (130, 2, TRUE);
INSERT INTO site (site_number, campground_id, accessible) VALUES (131, 2, TRUE); -- 131 - 138
INSERT INTO site (site_number, campground_id, accessible, utilities) VALUES (132, 2, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, accessible, utilities) VALUES (133, 2, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, accessible, utilities) VALUES (134, 2, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, accessible, utilities) VALUES (135, 2, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, accessible, utilities) VALUES (136, 2, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, accessible, utilities) VALUES (137, 2, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, accessible, utilities) VALUES (138, 2, TRUE, TRUE);

-- Acadia Seawall Sites (RV/Trailer 20ft)
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (139, 2, 20); -- 1 - 10
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (140, 2, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (141, 2, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (142, 2, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (143, 2, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (144, 2, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (145, 2, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (146, 2, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (147, 2, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (148, 2, 20);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (149, 2, 20, TRUE); -- 11 - 20
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (150, 2, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (151, 2, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (152, 2, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (153, 2, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (154, 2, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (155, 2, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (156, 2, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, accessible, utilities) VALUES (157, 2, 20, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, accessible, utilities) VALUES (158, 2, 20, TRUE, TRUE);

-- Acadia Seawall Sites (RV/Trailer 35ft)
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (159, 2, 35); -- 1 - 10
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (160, 2, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (161, 2, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (162, 2, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (163, 2, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (164, 2, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (165, 2, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (166, 2, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (167, 2, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (168, 2, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (169, 2, 35); -- 11 - 20
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (170, 2, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (171, 2, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (172, 2, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (173, 2, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (174, 2, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (175, 2, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (176, 2, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (177, 2, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (178, 2, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (179, 2, 35); -- 21 - 30
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (180, 2, 35);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (181, 2, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (182, 2, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (183, 2, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (184, 2, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (185, 2, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (186, 2, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (187, 2, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (188, 2, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (189, 2, 35, TRUE); -- 31 - 40
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (190, 2, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (191, 2, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (192, 2, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (193, 2, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (194, 2, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, accessible, utilities) VALUES (195, 2, 35, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, accessible, utilities) VALUES (196, 2, 35, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, accessible, utilities) VALUES (197, 2, 35, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, accessible, utilities) VALUES (198, 2, 35, TRUE, TRUE);

-- Acadia Schoodic Sites (Tent and Camper)
INSERT INTO site (site_number, campground_id) VALUES (1, 3); -- 1 - 10
INSERT INTO site (site_number, campground_id) VALUES (2, 3);
INSERT INTO site (site_number, campground_id) VALUES (3, 3);
INSERT INTO site (site_number, campground_id) VALUES (4, 3);
INSERT INTO site (site_number, campground_id) VALUES (5, 3);
INSERT INTO site (site_number, campground_id) VALUES (6, 3);
INSERT INTO site (site_number, campground_id) VALUES (7, 3);
INSERT INTO site (site_number, campground_id) VALUES (8, 3);
INSERT INTO site (site_number, campground_id) VALUES (9, 3);
INSERT INTO site (site_number, campground_id) VALUES (10, 3);
INSERT INTO site (site_number, campground_id) VALUES (11, 3); -- 11 - 20
INSERT INTO site (site_number, campground_id) VALUES (12, 3);
INSERT INTO site (site_number, campground_id) VALUES (13, 3);
INSERT INTO site (site_number, campground_id) VALUES (14, 3);
INSERT INTO site (site_number, campground_id) VALUES (15, 3);
INSERT INTO site (site_number, campground_id) VALUES (16, 3);
INSERT INTO site (site_number, campground_id) VALUES (17, 3);
INSERT INTO site (site_number, campground_id) VALUES (18, 3);
INSERT INTO site (site_number, campground_id) VALUES (19, 3);
INSERT INTO site (site_number, campground_id) VALUES (20, 3);
INSERT INTO site (site_number, campground_id) VALUES (21, 3); -- 21 - 30
INSERT INTO site (site_number, campground_id) VALUES (22, 3);
INSERT INTO site (site_number, campground_id) VALUES (23, 3);
INSERT INTO site (site_number, campground_id) VALUES (24, 3);
INSERT INTO site (site_number, campground_id) VALUES (25, 3);
INSERT INTO site (site_number, campground_id) VALUES (26, 3);
INSERT INTO site (site_number, campground_id, utilities) VALUES (27, 3, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (28, 3, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (29, 3, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (30, 3, TRUE);
INSERT INTO site (site_number, campground_id, utilities) VALUES (31, 3, TRUE); -- 31 - 35
INSERT INTO site (site_number, campground_id, utilities) VALUES (32, 3, TRUE);
INSERT INTO site (site_number, campground_id, accessible, utilities) VALUES (33, 3, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, accessible, utilities) VALUES (34, 3, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, accessible, utilities) VALUES (35, 3, TRUE, TRUE);

-- Acadia Schoodic Sites (RV/Trailer 20ft)
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (36, 3, 20); -- 1 - 10
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (37, 3, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (38, 3, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (39, 3, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (40, 3, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (41, 3, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (42, 3, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (43, 3, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (44, 3, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (45, 3, 20);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (46, 3, 20); -- 11 - 20
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (47, 3, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (48, 3, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (49, 3, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (50, 3, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (51, 3, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (52, 3, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (53, 3, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (54, 3, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (55, 3, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, accessible, utilities) VALUES (56, 3, 20, TRUE, TRUE); -- 21 - 22
INSERT INTO site (site_number, campground_id, max_rv_length, accessible, utilities) VALUES (57, 3, 20, TRUE, TRUE);

-- Acadia Schoodic Sites (RV/Trailer 35ft)
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (58, 3, 35); -- 1 - 10
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (59, 3, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (60, 3, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (61, 3, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (62, 3, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (63, 3, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (64, 3, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (65, 3, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (66, 3, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (67, 3, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (68, 3, 35); -- 11 - 20
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (69, 3, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (70, 3, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (71, 3, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (72, 3, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (73, 3, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (74, 3, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (75, 3, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (76, 3, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (77, 3, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (78, 3, 35); -- 21 - 30
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (79, 3, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (80, 3, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (81, 3, 35);
INSERT INTO site (site_number, campground_id, max_rv_length) VALUES (82, 3, 35);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (83, 3, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (84, 3, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (85, 3, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (86, 3, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (87, 3, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, utilities) VALUES (88, 3, 35, TRUE); -- 31 - 35
INSERT INTO site (site_number, campground_id, max_rv_length, accessible) VALUES (89, 3, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, accessible) VALUES (90, 3, 35, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, accessible, utilities) VALUES (91, 3, 35, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, max_rv_length, accessible, utilities) VALUES (92, 3, 35, TRUE, TRUE);

-- Arches Devil's Garden Sites (Tent)
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (1, 4, 10); -- 1 - 10
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (2, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (3, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (4, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (5, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (6, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (7, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (8, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (9, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (10, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (11, 4, 10); -- 11 - 20
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (12, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (13, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (14, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (15, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (16, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (17, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (18, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (19, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (20, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (21, 4, 10); -- 21 - 30
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (22, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (23, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (24, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (25, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (26, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (27, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy) VALUES (28, 4, 10);
INSERT INTO site (site_number, campground_id, max_occupancy, utilities) VALUES (29, 4, 10, TRUE);
INSERT INTO site (site_number, campground_id, max_occupancy, utilities) VALUES (30, 4, 10, TRUE);
INSERT INTO site (site_number, campground_id, max_occupancy, utilities) VALUES (31, 4, 10, TRUE); -- 31 - 40
INSERT INTO site (site_number, campground_id, max_occupancy, utilities) VALUES (32, 4, 10, TRUE);
INSERT INTO site (site_number, campground_id, max_occupancy, utilities) VALUES (33, 4, 10, TRUE);
INSERT INTO site (site_number, campground_id, max_occupancy, utilities) VALUES (34, 4, 10, TRUE);
INSERT INTO site (site_number, campground_id, max_occupancy, utilities) VALUES (35, 4, 10, TRUE);
INSERT INTO site (site_number, campground_id, max_occupancy, utilities) VALUES (36, 4, 10, TRUE);
INSERT INTO site (site_number, campground_id, max_occupancy, utilities) VALUES (37, 4, 10, TRUE);
INSERT INTO site (site_number, campground_id, max_occupancy, utilities) VALUES (38, 4, 10, TRUE);
INSERT INTO site (site_number, campground_id, max_occupancy, utilities) VALUES (39, 4, 10, TRUE);
INSERT INTO site (site_number, campground_id, max_occupancy, utilities) VALUES (40, 4, 10, TRUE);
INSERT INTO site (site_number, campground_id, max_occupancy, utilities) VALUES (41, 4, 10, TRUE); -- 41 - 47
INSERT INTO site (site_number, campground_id, max_occupancy, utilities) VALUES (42, 4, 10, TRUE);
INSERT INTO site (site_number, campground_id, max_occupancy, utilities) VALUES (43, 4, 10, TRUE);
INSERT INTO site (site_number, campground_id, max_occupancy, accessible, utilities) VALUES (44, 4, 10, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, max_occupancy, accessible, utilities) VALUES (45, 4, 10, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, max_occupancy, accessible, utilities) VALUES (46, 4, 10, TRUE, TRUE);
INSERT INTO site (site_number, campground_id, max_occupancy, accessible, utilities) VALUES (47, 4, 10, TRUE, TRUE);

-- Arches Devil's Garden Sites (RV/Trailer 20ft)
INSERT INTO site (site_number, campground_id, max_occupancy, max_rv_length, utilities) VALUES (48, 4, 7, 20, TRUE);
INSERT INTO site (site_number, campground_id, max_occupancy, max_rv_length, utilities) VALUES (49, 4, 7, 20, TRUE);

 -- Arches Canyon Wren Group Site (Tent)
INSERT INTO site (site_number, campground_id, max_occupancy, accessible) VALUES (1, 5, 35, TRUE);

-- Arches Juniper Group Site (Tent)
INSERT INTO site (site_number, campground_id, max_occupancy, accessible) VALUES (1, 6, 55, TRUE);

-- Cuyahoga Unnamed Primitive Campsites Sites (Tent)
INSERT INTO site (site_number, campground_id) VALUES (1, 7); -- 1 - 5
INSERT INTO site (site_number, campground_id) VALUES (2, 7);
INSERT INTO site (site_number, campground_id) VALUES (3, 7);
INSERT INTO site (site_number, campground_id) VALUES (4, 7);
INSERT INTO site (site_number, campground_id) VALUES (5, 7);

-- Reservations
-- Acadia Blackwoods Sites (1 - 276)
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (1, 'Smith Family Reservation', NOW() - INTERVAL '2 days', NOW() + INTERVAL '2 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (1, 'Lockhart Family Reservation', NOW() - INTERVAL '6 days', NOW() - INTERVAL '3 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (2, 'Jones Reservation', NOW() - INTERVAL '2 days', NOW() + INTERVAL '2 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (3, 'Bauer Family Reservation', NOW(), NOW() + INTERVAL '2 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (4, 'Eagles Family Reservation', NOW() + INTERVAL '5 days', NOW() + INTERVAL '10 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (7, 'Aersomith eservation', NOW() - INTERVAL '3 days', NOW() + INTERVAL '2 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (9, 'Claus Family Reservation', NOW(), NOW() + INTERVAL '1 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (9, 'Taylor Family Reservation', NOW() - INTERVAL '7 days', NOW() - INTERVAL '5 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (10, 'Astley Family Reservation', NOW() + INTERVAL '14 days', NOW() + INTERVAL '21 days');

-- Acadia Seawall Sites (277 - 474)
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (277, 'Jobs Family Reservation', NOW() + INTERVAL '1 days', NOW() + INTERVAL '4 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (278, 'Cook Family Reservation', NOW() + INTERVAL '1 days', NOW() + INTERVAL '4 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (279, 'Gates Reservation', NOW() + INTERVAL '1 days', NOW() + INTERVAL '4 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (280, 'Cue Family Reservation', NOW() + INTERVAL '1 days', NOW() + INTERVAL '4 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (281, 'Ive Family Reservation', NOW() + INTERVAL '1 days', NOW() + INTERVAL '4 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (282, 'Federighi Family Reservation', NOW() + INTERVAL '1 days', NOW() + INTERVAL '4 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (283, 'Schiller Family Reservation', NOW() + INTERVAL '1 days', NOW() + INTERVAL '4 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (284, 'Williams Family Reservation', NOW() + INTERVAL '1 days', NOW() + INTERVAL '4 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (285, 'Kawasaki Family Reservation', NOW() + INTERVAL '10 days', NOW() + INTERVAL '21 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (286, 'Branson Family Reservation', NOW() + INTERVAL '22 days', NOW() + INTERVAL '28 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (287, 'Zukerberg Family Reservation', NOW() + INTERVAL '30 days', NOW() + INTERVAL '33 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (288, 'Musk Family Reservation', NOW() + INTERVAL '4 days', NOW() + INTERVAL '10 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (289, 'Buffett Family Reservation', NOW() - INTERVAL '4 days', NOW());

-- Acadia Schoodic Woods Sites (475 - 566 )
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (475, 'Satya Nedella', NOW() + INTERVAL '3 days', NOW() + INTERVAL '10 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (476, 'Scott Gutherie', NOW() + INTERVAL '10 days', NOW() + INTERVAL '14 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (477, 'Amy Hood', NOW() + INTERVAL '5 days', NOW() + INTERVAL '11 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (478, 'Peggy Johnson', NOW() + INTERVAL '5 days', NOW() + INTERVAL '11 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (479, 'Terry Myerson', NOW() + INTERVAL '9 days', NOW() + INTERVAL '11 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (480, 'Steve Ballmer', NOW() + INTERVAL '13 days', NOW() + INTERVAL '15 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (481, 'Gates Family Reservation', NOW() + INTERVAL '16 days', NOW() + INTERVAL '19 days');

-- Devil's Garden (567 - 615)
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (567, 'Marisa Mayer', NOW() - INTERVAL '15 days', NOW() - INTERVAL '10 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (568, 'Beth Mooney', NOW(), NOW() + INTERVAL '4 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (569, 'William Priemer', NOW() + INTERVAL '2 days', NOW() + INTERVAL '6 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (570, 'Tricia Griffith', NOW() + INTERVAL '3 days', NOW() + INTERVAL '8 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (571, 'Toby Cosgrove', NOW() + INTERVAL '5 days', NOW() + INTERVAL '11 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (572, 'Akram Boutros', NOW() + INTERVAL '12 days', NOW() + INTERVAL '18 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (573, 'Barbara Snyder', NOW() + INTERVAL '9 days', NOW() + INTERVAL '11 days');

-- Canyon Wren (616)
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (616, 'Bill Board', NOW() - INTERVAL '9 days', NOW() + INTERVAL '1 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (616, 'Bill Loney', NOW() + INTERVAL '1 days', NOW() + INTERVAL '11 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (616, 'Cara Van', NOW() + INTERVAL '17 days', NOW() + INTERVAL '21 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (616, 'Forrest Gump', NOW() + INTERVAL '31 days', NOW() + INTERVAL '37 days');

-- Juniper Group Site (617)
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (617, 'Simpson Family', NOW() - INTERVAL '6 days', NOW() + INTERVAL '1 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (617, 'Smith Family', NOW() + INTERVAL '2 days', NOW() + INTERVAL '11 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (617, 'Leela Family', NOW() + INTERVAL '14 days', NOW() + INTERVAL '15 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (617, 'Scott Family', NOW() + INTERVAL '35 days', NOW() + INTERVAL '40 days');

-- The Unnamed Primitive Campsites (618 - 622)
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (618, 'Johnson Family', NOW() - INTERVAL '6 days', NOW() + INTERVAL '1 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (619, 'Sparrow Family', NOW() + INTERVAL '2 days', NOW() + INTERVAL '11 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (620, 'Woodford Family', NOW() + INTERVAL '14 days', NOW() + INTERVAL '15 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (621, 'Williams Family', NOW() + INTERVAL '35 days', NOW() + INTERVAL '40 days');
INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (622, 'Jameson Family', NOW() + INTERVAL '40 days', NOW() + INTERVAL '40 days');



ALTER TABLE campground ADD FOREIGN KEY (park_id) REFERENCES park(park_id);
ALTER TABLE site ADD FOREIGN KEY (campground_id) REFERENCES campground(campground_id);
ALTER TABLE reservation ADD FOREIGN KEY (site_id) REFERENCES site(site_id);
