BEGIN TRANSACTION;

DROP TABLE IF EXISTS park_state, park, city, state CASCADE;

CREATE TABLE state (
	state_abbreviation char(2) NOT NULL,
	state_name varchar(50) NOT NULL,
	population int NOT NULL,
	area int NOT NULL,
	capital int /*NOT*/ NULL, --temporarily nullable because it's a foreign key to city.city_id
	sales_tax numeric(5,3) NOT NULL,
	state_nickname varchar(100) NULL,
	census_region varchar(10) NULL,
	CONSTRAINT PK_state PRIMARY KEY(state_abbreviation),      
	CONSTRAINT UQ_state_name UNIQUE(state_name),        
    CONSTRAINT UQ_state_nickname UNIQUE(state_nickname),
	CONSTRAINT CHK_census_region CHECK (census_region IS NULL OR census_region IN ('Northeast', 'South', 'Midwest', 'West'))
);

CREATE TABLE city (
	city_id serial,
	city_name varchar(50) NOT NULL,
	state_abbreviation char(2) NOT NULL,
	population int NOT NULL CONSTRAINT DF_population DEFAULT(0),
	area numeric(5,1) NOT NULL,
	CONSTRAINT PK_city PRIMARY KEY(city_id)
);

CREATE TABLE park (
	park_id serial,
	park_name varchar(50) NOT NULL,
	date_established date NOT NULL,
	area numeric(6,1) NOT NULL,
	has_camping boolean NOT NULL,
	CONSTRAINT PK_park PRIMARY KEY(park_id),
	CONSTRAINT UQ_park_name UNIQUE(park_name)
);

CREATE TABLE park_state (
	park_id int NOT NULL,
	state_abbreviation char(2) NOT NULL,
	CONSTRAINT PK_park_state PRIMARY KEY(park_id, state_abbreviation)
);

-- insert data

-- data collected February 10, 2021
-- state name, abbrev, capital, population (2019 estimate), area (sq km, 2018 data) - https://en.wikipedia.org/wiki/List_of_states_and_territories_of_the_United_States
-- state sales tax (base) - https://en.wikipedia.org/wiki/Sales_taxes_in_the_United_States
-- state nickname (first official nickname only, NULL if no official nickname) - https://en.wikipedia.org/wiki/List_of_U.S._state_and_territory_nicknames
-- census region - https://en.wikipedia.org/wiki/List_of_regions_of_the_United_States#Census_Bureau-designated_regions_and_divisions
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('AL', 'Alabama', 4903185, 135767, 4, 'Heart of Dixie', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('AK', 'Alaska', 731545, 1723337, 0, 'The Last Frontier', 'West');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('AS', 'American Samoa', 57400, 1505, 0, 'Motu o Fiafiaga', NULL);
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('AZ', 'Arizona', 7278717, 295234, 5.6, 'Grand Canyon State', 'West');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('AR', 'Arkansas', 3017804, 137732, 6.5, 'The Natural State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('CA', 'California', 39512223, 423967, 7.25, 'The Golden State', 'West');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('CO', 'Colorado', 5758736, 269601, 2.9, 'Centennial State', 'West');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('CT', 'Connecticut', 3565278, 14357, 6.35, 'Constitution State', 'Northeast');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('DE', 'Delaware', 973764, 6446, 0, 'The First State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('DC', 'District of Columbia', 705749, 176, 5.75, NULL, 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('FL', 'Florida', 21477737, 170312, 6, 'Sunshine State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('GA', 'Georgia', 10617423, 153910, 4, 'Peach State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('GU', 'Guam', 161700, 1478, 4, 'Tano y Chamorro', NULL);
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('HI', 'Hawaii', 1415872, 28313, 4.166, 'Aloha State', 'West');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('ID', 'Idaho', 1787065, 216443, 6, 'Gem State', 'West');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('IL', 'Illinois', 12671821, 149995, 6.25, 'Prairie State', 'Midwest');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('IN', 'Indiana', 6732219, 94326, 7, 'Hoosier State', 'Midwest');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('IA', 'Iowa', 3155070, 145746, 6, 'Hawkeye State', 'Midwest');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('KS', 'Kansas', 2913314, 213100, 6.5, 'Sunflower State', 'Midwest');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('KY', 'Kentucky', 4467673, 104656, 6, 'Bluegrass State ', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('LA', 'Louisiana', 4648794, 135659, 4.45, 'Pelican State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('ME', 'Maine', 1344212, 91633, 5.5, 'Vacationland', 'Northeast');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('MD', 'Maryland', 6045680, 32131, 6, 'Free State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('MA', 'Massachusetts', 6892503, 27336, 6.25, 'The Bay State', 'Northeast');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('MI', 'Michigan', 9986857, 250487, 6, 'The Great Lakes State', 'Midwest');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('MN', 'Minnesota', 5639632, 225163, 6.875, 'Land of 10,000 Lakes', 'Midwest');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('MS', 'Mississippi', 2976149, 125438, 7, 'Magnolia State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('MO', 'Missouri', 6137428, 180540, 4.225, 'Show-Me State', 'Midwest');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('MT', 'Montana', 1068778, 380831, 0, 'Treasure State', 'West');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('NE', 'Nebraska', 1934408, 200330, 5.5, 'Cornhusker State', 'Midwest');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('NV', 'Nevada', 3080156, 286380, 6.85, 'Silver State', 'West');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('NH', 'New Hampshire', 1359711, 24214, 0, 'Granite State', 'Northeast');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('NJ', 'New Jersey', 8882190, 22591, 6.625, 'Garden State', 'Northeast');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('NM', 'New Mexico', 2096829, 314917, 5.125, 'Land of Enchantment', 'West');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('NY', 'New York', 19453561, 141297, 4, 'Empire State', 'Northeast');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('NC', 'North Carolina', 10488084, 139391, 4.75, 'Tar Heel State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('ND', 'North Dakota', 762062, 183108, 5, 'Peace Garden State', 'Midwest');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('MP', 'Northern Mariana Islands', 52300, 5117, 0, NULL, NULL);
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('OH', 'Ohio', 11689100, 116098, 5.75, 'Buckeye State', 'Midwest');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('OK', 'Oklahoma', 3956971, 181037, 4.5, 'Sooner State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('OR', 'Oregon', 4217737, 254799, 0, 'Beaver State', 'West');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('PA', 'Pennsylvania', 12801989, 119280, 6, 'Keystone State', 'Northeast');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('PR', 'Puerto Rico', 3193694, 13791, 10.5, 'Isla del Encanto', NULL);
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('RI', 'Rhode Island', 1059361, 4001, 7, 'Ocean State', 'Northeast');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('SC', 'South Carolina', 5148714, 82933, 6, 'Palmetto State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('SD', 'South Dakota', 884659, 199729, 4, 'The Mount Rushmore State', 'Midwest');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('TN', 'Tennessee', 6829174, 109153, 7, 'Volunteer State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('TX', 'Texas', 28995881, 695662, 6.25, 'Lone Star State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('VI', 'U.S. Virgin Islands', 103700, 1898, 5, NULL, NULL);
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('UT', 'Utah', 3205958, 219882, 5.95, 'Beehive State', 'West');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('VT', 'Vermont', 623989, 24906, 6, 'Green Mountain State', 'Northeast');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('VA', 'Virginia', 8535519, 110787, 5.3, 'The Old Dominion', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('WA', 'Washington', 7614893, 184661, 6.5, NULL, 'West');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('WV', 'West Virginia', 1792147, 62756, 6, 'Mountain State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('WI', 'Wisconsin', 5822434, 169635, 5, NULL, 'Midwest');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('WY', 'Wyoming', 578759, 253335, 4, 'Equality State', 'West');


-- data collected February 10, 2021
-- city name, population (see notes below), area (sq km, 2016 data) - https://en.wikipedia.org/wiki/List_of_United_States_cities_by_population
-- population notes:
--		For the cities listed on wikipedia page link above, 2019 population estimate used
--		Some capitals aren't "cities" because population < 100,000. Population/area data retrieved from those individual Wikipedia pages or other sources, usually with 2019 estimates, but some is 2010 census
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Abilene', 'TX', 123420, 276.4);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Akron', 'OH', 197597, 160.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Albany', 'NY', 96460, 56.8243806);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Albuquerque', 'NM', 560513, 487.4);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Alexandria', 'VA', 159428, 38.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Allen', 'TX', 105623, 70.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Allentown', 'PA', 121442, 45.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Amarillo', 'TX', 199371, 262.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Anaheim', 'CA', 350365, 129.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Anchorage', 'AK', 288000, 4420.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Ann Arbor', 'MI', 119980, 72.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Annapolis', 'MD', 39223, 21.0048189);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Antioch', 'CA', 111502, 76.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Arlington', 'TX', 398854, 248.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Arvada', 'CO', 121272, 100);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Athens', 'GA', 126913, 301.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Atlanta', 'GA', 506811, 345.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Augusta', 'GA', 197888, 783.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Augusta', 'ME', 18697, 150.3230196);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Aurora', 'CO', 379289, 397.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Aurora', 'IL', 197757, 116.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Austin', 'TX', 978908, 809.9);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Bakersfield', 'CA', 384145, 385.4);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Baltimore', 'MD', 593490, 209.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Baton Rouge', 'LA', 220236, 222.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Bayamón', 'PR', 169269, 69.92973);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Beaumont', 'TX', 116825, 212.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Bellevue', 'WA', 148164, 86.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Bend', 'OR', 100421, 85.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Berkeley', 'CA', 121363, 27.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Billings', 'MT', 109577, 113.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Birmingham', 'AL', 209403, 378.4);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Bismarck', 'ND', 73529, 90.131652);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Boise', 'ID', 228959, 212.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Boston', 'MA', 692600, 125.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Boulder', 'CO', 105673, 64.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Bridgeport', 'CT', 144399, 41.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Broken Arrow', 'OK', 110198, 159.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Brownsville', 'TX', 182781, 343.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Buffalo', 'NY', 255284, 104.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Burbank', 'CA', 102511, 45.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Caguas', 'PR', 124606, 28.230891);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Cambridge', 'MA', 118927, 16.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Cape Coral', 'FL', 194495, 273.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Carlsbad', 'CA', 115382, 97.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Carmel', 'IN', 101068, 123);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Carolina', 'PR', 146984, 53.612793);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Carrollton', 'TX', 139248, 94);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Carson City', 'NV', 55916, 407.2500276);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Cary', 'NC', 170282, 146.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Cedar Rapids', 'IA', 133562, 183.4);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Centennial', 'CO', 110937, 76.4);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Chandler', 'AZ', 261165, 168.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Charleston', 'SC', 137566, 282.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Charleston', 'WV', 46536, 84.5372736);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Charlotte', 'NC', 885708, 791);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Charlotte Amalie', 'VI', 18481, 3.107988);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Chattanooga', 'TN', 182799, 370.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Chesapeake', 'VA', 244835, 876.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Cheyenne', 'WY', 64235, 83.8379763);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Chicago', 'IL', 2693976, 588.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Chico', 'CA', 103301, 86.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Chula Vista', 'CA', 274492, 128.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Cincinnati', 'OH', 303940, 200.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Clarksville', 'TN', 158146, 254.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Clearwater', 'FL', 116946, 67.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Cleveland', 'OH', 381009, 201.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Clinton', 'MI', 100471, 72.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Clovis', 'CA', 114584, 62.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('College Station', 'TX', 117911, 132.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Colorado Springs', 'CO', 478221, 506.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Columbia', 'SC', 131674, 345.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Columbia', 'MO', 123195, 168.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Columbus', 'OH', 898553, 565.9);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Columbus', 'GA', 195769, 560.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Concord', 'CA', 129295, 79);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Concord', 'NH', 43627, 174.0214281);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Coral Springs', 'FL', 133759, 61.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Corona', 'CA', 169868, 102.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Corpus Christi', 'TX', 326586, 452.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Costa Mesa', 'CA', 113003, 40.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Dallas', 'TX', 1343573, 882.9);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Daly City', 'CA', 106280, 19.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Davenport', 'IA', 101590, 162.9);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Davie', 'FL', 106306, 90.4);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Dayton', 'OH', 140407, 144.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Denton', 'TX', 141541, 241.9);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Denver', 'CO', 727211, 397);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Des Moines', 'IA', 214237, 230.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Detroit', 'MI', 670031, 359.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Dover', 'DE', 36047, 62.1079602);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Downey', 'CA', 111126, 32.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Durham', 'NC', 278993, 284.4);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Edinburg', 'TX', 101170, 97.4);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('El Cajon', 'CA', 102708, 37.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('El Monte', 'CA', 115487, 24.9);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('El Paso', 'TX', 681728, 665.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Elgin', 'IL', 110849, 96.9);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Elizabeth', 'NJ', 129216, 31.9);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Elk Grove', 'CA', 174775, 109.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Escondido', 'CA', 151625, 96.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Eugene', 'OR', 172622, 114.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Evansville', 'IN', 117979, 122.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Everett', 'WA', 111475, 86.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Fairfield', 'CA', 117133, 105.9);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Fargo', 'ND', 124662, 127.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Fayetteville', 'NC', 211657, 382.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Fontana', 'CA', 214547, 111.4);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Fort Collins', 'CO', 170243, 144.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Fort Lauderdale', 'FL', 182437, 89.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Fort Wayne', 'IN', 270402, 286.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Fort Worth', 'TX', 909585, 888.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Frankfort', 'KY', 27755, 39.0311493);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Fremont', 'CA', 241110, 200.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Fresno', 'CA', 531576, 296.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Frisco', 'TX', 200490, 175.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Fullerton', 'CA', 138632, 58);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Gainesville', 'FL', 133997, 161.4);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Garden Grove', 'CA', 171644, 46.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Garland', 'TX', 239928, 147.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Gilbert', 'AZ', 254114, 176.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Glendale', 'AZ', 252381, 153.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Glendale', 'CA', 199303, 78.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Grand Prairie', 'TX', 194543, 187.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Grand Rapids', 'MI', 201013, 115);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Greeley', 'CO', 108649, 123.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Green Bay', 'WI', 104578, 117.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Greensboro', 'NC', 296710, 332.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Gresham', 'OR', 109381, 60.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Hagåtña', 'GU', 1051, 2.58999);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Hampton', 'VA', 134510, 133.4);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Harrisburg', 'PA', 49528, 30.7172814);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Hartford', 'CT', 122105, 45.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Hayward', 'CA', 159203, 117.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Helena', 'MT', 33124, 43.6672314);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Henderson', 'NV', 320189, 271.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Hialeah', 'FL', 233339, 55.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('High Point', 'NC', 112791, 143);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Hillsboro', 'OR', 109128, 64.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Hollywood', 'FL', 154817, 70.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Honolulu', 'HI', 345064, 156.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Houston', 'TX', 2320268, 1651.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Huntington Beach', 'CA', 199223, 69.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Huntsville', 'AL', 200574, 552.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Independence', 'MO', 116672, 201.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Indianapolis', 'IN', 876384, 936.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Inglewood', 'CA', 108151, 23.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Irvine', 'CA', 287401, 169.9);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Irving', 'TX', 239798, 173.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Jackson', 'MS', 160628, 287.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Jacksonville', 'FL', 911507, 1935.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Jefferson City', 'MO', 42708, 97.5131235);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Jersey City', 'NJ', 262075, 38.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Joliet', 'IL', 147344, 166.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Juneau', 'AK', 31276, 8429.640453);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Jurupa Valley', 'CA', 109527, 111.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Kansas City', 'MO', 495327, 815.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Kansas City', 'KS', 152960, 323.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Kent', 'WA', 132319, 87.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Killeen', 'TX', 151666, 138.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Knoxville', 'TN', 187603, 255.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Lafayette', 'LA', 126185, 139.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Lakeland', 'FL', 112136, 170.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Lakewood', 'CO', 157935, 111.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Lakewood', 'NJ', 106300, 64);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Lancaster', 'CA', 157601, 244.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Lansing', 'MI', 118210, 101.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Laredo', 'TX', 262491, 261.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Las Cruces', 'NM', 103432, 199.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Las Vegas', 'NV', 651319, 348.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('League City', 'TX', 107536, 132.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Lewisville', 'TX', 109212, 95.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Lexington', 'KY', 323152, 734.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Lincoln', 'NE', 289102, 238.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Little Rock', 'AR', 197312, 307.4);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Long Beach', 'CA', 462628, 130.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Los Angeles', 'CA', 3979576, 1213.9);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Louisville', 'KY', 617638, 682.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Lowell', 'MA', 110997, 35.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Lubbock', 'TX', 258862, 322.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Macon', 'GA', 153159, 645.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Madison', 'WI', 259680, 199.4);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Manchester', 'NH', 112673, 85.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('McAllen', 'TX', 143268, 151.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('McKinney', 'TX', 199177, 163.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Memphis', 'TN', 651073, 822.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Meridian', 'ID', 114161, 77.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Mesa', 'AZ', 518012, 357.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Mesquite', 'TX', 140937, 122.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Miami', 'FL', 467963, 93.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Miami Gardens', 'FL', 110001, 47.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Midland', 'TX', 146038, 192.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Milwaukee', 'WI', 590157, 249.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Minneapolis', 'MN', 429606, 139.9);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Miramar', 'FL', 141191, 76.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Mobile', 'AL', 188720, 361);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Modesto', 'CA', 215196, 111.4);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Montgomery', 'AL', 198525, 413.9);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Montpelier', 'VT', 7372, 26.5473975);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Moreno Valley', 'CA', 213055, 132.9);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Murfreesboro', 'TN', 146900, 144.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Murrieta', 'CA', 116223, 87);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Naperville', 'IL', 148449, 100.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Nashville', 'TN', 670820, 1232.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('New Haven', 'CT', 130250, 48.4);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('New Orleans', 'LA', 390144, 438.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('New York City', 'NY', 8336817, 780.9);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Newark', 'NJ', 282011, 62.4);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Newport News', 'VA', 179225, 179);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Norfolk', 'VA', 242742, 138);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Norman', 'OK', 124880, 463.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('North Charleston', 'SC', 115382, 190.9);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('North Las Vegas', 'NV', 251974, 253.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Norwalk', 'CA', 103949, 25.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Oakland', 'CA', 433031, 144.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Oceanside', 'CA', 175742, 107);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Odessa', 'TX', 123334, 117.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Oklahoma City', 'OK', 655057, 1570.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Olathe', 'KS', 140545, 157.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Olympia', 'WA', 52882, 52.0328991);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Omaha', 'NE', 478192, 345);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Ontario', 'CA', 185010, 129.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Orange', 'CA', 138669, 65.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Orlando', 'FL', 287442, 272.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Overland Park', 'KS', 195494, 194.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Oxnard', 'CA', 208881, 69.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Pago Pago', 'AS', 3656, 2.071992);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Palm Bay', 'FL', 115552, 170.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Palmdale', 'CA', 155079, 274.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Pasadena', 'TX', 151227, 112.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Pasadena', 'CA', 141029, 59.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Paterson', 'NJ', 145233, 21.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Pearland', 'TX', 122460, 119.9);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Pembroke Pines', 'FL', 173591, 85.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Peoria', 'AZ', 175961, 455.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Peoria', 'IL', 110417, 124.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Philadelphia', 'PA', 1584064, 347.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Phoenix', 'AZ', 1680992, 1340.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Pierre', 'SD', 13867, 33.7993695);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Pittsburgh', 'PA', 300286, 143.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Plano', 'TX', 287677, 185.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Pomona', 'CA', 151691, 59.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Pompano Beach', 'FL', 112118, 62.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Ponce', 'PR', 131881, 79.512693);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Port St. Lucie', 'FL', 201846, 307.9);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Portland', 'OR', 654741, 345.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Providence', 'RI', 179883, 47.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Provo', 'UT', 116618, 108);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Pueblo', 'CO', 112361, 138.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Raleigh', 'NC', 474069, 375.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Rancho Cucamonga', 'CA', 177603, 103.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Reno', 'NV', 255601, 277.9);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Renton', 'WA', 101751, 60.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Rialto', 'CA', 103526, 57.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Richardson', 'TX', 121323, 74.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Richmond', 'VA', 230436, 154.9);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Richmond', 'CA', 110567, 78);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Riverside', 'CA', 331360, 210.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Rochester', 'NY', 205695, 92.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Rochester', 'MN', 118935, 141.4);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Rockford', 'IL', 145609, 164.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Roseville', 'CA', 141500, 111.4);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Round Rock', 'TX', 133372, 92.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Sacramento', 'CA', 513624, 253.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Saint Paul', 'MN', 308096, 134.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Saipan', 'MP', 47565, 118.880541);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Salem', 'OR', 174365, 125.9);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Salinas', 'CA', 155465, 61.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Salt Lake City', 'UT', 200567, 288);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('San Angelo', 'TX', 101004, 155.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('San Antonio', 'TX', 1547253, 1194);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('San Bernardino', 'CA', 215784, 159.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('San Diego', 'CA', 1423851, 842.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('San Francisco', 'CA', 881549, 121.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('San Jose', 'CA', 1021795, 459.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('San Juan', 'PR', 318441, 102.304605);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('San Mateo', 'CA', 104430, 31.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Sandy Springs', 'GA', 109452, 97.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Santa Ana', 'CA', 332318, 70.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Santa Clara', 'CA', 130365, 47.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Santa Clarita', 'CA', 212979, 136.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Santa Fe', 'NM', 84683, 135.5600766);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Santa Maria', 'CA', 107263, 59.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Santa Rosa', 'CA', 176753, 107);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Savannah', 'GA', 144464, 268.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Scottsdale', 'AZ', 258069, 476.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Seattle', 'WA', 753675, 217);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Shreveport', 'LA', 187112, 277.4);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Simi Valley', 'CA', 125613, 107.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Sioux Falls', 'SD', 183793, 195.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('South Bend', 'IN', 102026, 107.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Sparks', 'NV', 105006, 93);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Spokane', 'WA', 222081, 177.9);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Spokane Valley', 'WA', 101060, 97.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Springfield', 'MO', 167882, 213.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Springfield', 'MA', 153606, 82.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Springfield', 'IL', 114230, 155.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('St. Louis', 'MO', 300576, 160.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('St. Petersburg', 'FL', 265351, 160.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Stamford', 'CT', 129638, 97.4);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Sterling Heights', 'MI', 132438, 94.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Stockton', 'CA', 312697, 159.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Sugar Land', 'TX', 118488, 88.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Sunnyvale', 'CA', 152703, 57);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Surprise', 'AZ', 141664, 279.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Syracuse', 'NY', 142327, 64.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Tacoma', 'WA', 217827, 128.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Tallahassee', 'FL', 194500, 260);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Tampa', 'FL', 399700, 293.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Temecula', 'CA', 114761, 96.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Tempe', 'AZ', 195805, 103.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Thornton', 'CO', 141464, 92.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Thousand Oaks', 'CA', 126813, 143);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Toledo', 'OH', 272779, 209);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Topeka', 'KS', 125310, 159.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Torrance', 'CA', 143592, 53.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Trenton', 'NJ', 83203, 21.2638179);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Tucson', 'AZ', 548073, 597.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Tulsa', 'OK', 401190, 509.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Tuscaloosa', 'AL', 101129, 185.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Tyler', 'TX', 106985, 146.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Vacaville', 'CA', 100670, 75.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Vallejo', 'CA', 121692, 79.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Vancouver', 'WA', 184463, 121.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Ventura', 'CA', 109106, 56.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Victorville', 'CA', 122385, 189.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Virginia Beach', 'VA', 449974, 633.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Visalia', 'CA', 134605, 97.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Vista', 'CA', 101638, 48.4);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Waco', 'TX', 139236, 230.5);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Warren', 'MI', 133943, 89.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Washington', 'DC', 705749, 158.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Waterbury', 'CT', 107568, 73.8);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('West Covina', 'CA', 105101, 41.4);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('West Jordan', 'UT', 116480, 83.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('West Palm Beach', 'FL', 111955, 142.7);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('West Valley City', 'UT', 135248, 91.9);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Westminster', 'CO', 113166, 82.1);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Wichita', 'KS', 389938, 415.4);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Wichita Falls', 'TX', 104683, 187);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Wilmington', 'NC', 123744, 133.6);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Winston-Salem', 'NC', 247945, 343.2);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Woodbridge', 'NJ', 100145, 60.3);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Worcester', 'MA', 185428, 96.9);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ('Yonkers', 'NY', 200370, 46.6);


-- set captials now that cities are populated
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Montgomery' and state_abbreviation = 'AL') WHERE state_name = 'Alabama';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Juneau' and state_abbreviation = 'AK') WHERE state_name = 'Alaska';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Phoenix' and state_abbreviation = 'AZ') WHERE state_name = 'Arizona';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Little Rock' and state_abbreviation = 'AR') WHERE state_name = 'Arkansas';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Sacramento' and state_abbreviation = 'CA') WHERE state_name = 'California';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Denver' and state_abbreviation = 'CO') WHERE state_name = 'Colorado';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Hartford' and state_abbreviation = 'CT') WHERE state_name = 'Connecticut';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Dover' and state_abbreviation = 'DE') WHERE state_name = 'Delaware';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Tallahassee' and state_abbreviation = 'FL') WHERE state_name = 'Florida';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Atlanta' and state_abbreviation = 'GA') WHERE state_name = 'Georgia';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Honolulu' and state_abbreviation = 'HI') WHERE state_name = 'Hawaii';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Boise' and state_abbreviation = 'ID') WHERE state_name = 'Idaho';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Springfield' and state_abbreviation = 'IL') WHERE state_name = 'Illinois';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Indianapolis' and state_abbreviation = 'IN') WHERE state_name = 'Indiana';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Des Moines' and state_abbreviation = 'IA') WHERE state_name = 'Iowa';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Topeka' and state_abbreviation = 'KS') WHERE state_name = 'Kansas';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Frankfort' and state_abbreviation = 'KY') WHERE state_name = 'Kentucky';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Baton Rouge' and state_abbreviation = 'LA') WHERE state_name = 'Louisiana';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Augusta' and state_abbreviation = 'ME') WHERE state_name = 'Maine';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Annapolis' and state_abbreviation = 'MD') WHERE state_name = 'Maryland';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Boston' and state_abbreviation = 'MA') WHERE state_name = 'Massachusetts';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Lansing' and state_abbreviation = 'MI') WHERE state_name = 'Michigan';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Saint Paul' and state_abbreviation = 'MN') WHERE state_name = 'Minnesota';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Jackson' and state_abbreviation = 'MS') WHERE state_name = 'Mississippi';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Jefferson City' and state_abbreviation = 'MO') WHERE state_name = 'Missouri';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Helena' and state_abbreviation = 'MT') WHERE state_name = 'Montana';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Lincoln' and state_abbreviation = 'NE') WHERE state_name = 'Nebraska';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Carson City' and state_abbreviation = 'NV') WHERE state_name = 'Nevada';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Concord' and state_abbreviation = 'NH') WHERE state_name = 'New Hampshire';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Trenton' and state_abbreviation = 'NJ') WHERE state_name = 'New Jersey';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Santa Fe' and state_abbreviation = 'NM') WHERE state_name = 'New Mexico';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Albany' and state_abbreviation = 'NY') WHERE state_name = 'New York';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Raleigh' and state_abbreviation = 'NC') WHERE state_name = 'North Carolina';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Bismarck' and state_abbreviation = 'ND') WHERE state_name = 'North Dakota';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Columbus' and state_abbreviation = 'OH') WHERE state_name = 'Ohio';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Oklahoma City' and state_abbreviation = 'OK') WHERE state_name = 'Oklahoma';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Salem' and state_abbreviation = 'OR') WHERE state_name = 'Oregon';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Harrisburg' and state_abbreviation = 'PA') WHERE state_name = 'Pennsylvania';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Providence' and state_abbreviation = 'RI') WHERE state_name = 'Rhode Island';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Columbia' and state_abbreviation = 'SC') WHERE state_name = 'South Carolina';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Pierre' and state_abbreviation = 'SD') WHERE state_name = 'South Dakota';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Nashville' and state_abbreviation = 'TN') WHERE state_name = 'Tennessee';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Austin' and state_abbreviation = 'TX') WHERE state_name = 'Texas';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Salt Lake City' and state_abbreviation = 'UT') WHERE state_name = 'Utah';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Montpelier' and state_abbreviation = 'VT') WHERE state_name = 'Vermont';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Richmond' and state_abbreviation = 'VA') WHERE state_name = 'Virginia';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Olympia' and state_abbreviation = 'WA') WHERE state_name = 'Washington';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Charleston' and state_abbreviation = 'WV') WHERE state_name = 'West Virginia';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Madison' and state_abbreviation = 'WI') WHERE state_name = 'Wisconsin';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Cheyenne' and state_abbreviation = 'WY') WHERE state_name = 'Wyoming';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Washington' and state_abbreviation = 'DC') WHERE state_name = 'District of Columbia';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Pago Pago' and state_abbreviation = 'AS') WHERE state_name = 'American Samoa';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Hagåtña' and state_abbreviation = 'GU') WHERE state_name = 'Guam';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Saipan' and state_abbreviation = 'MP') WHERE state_name = 'Northern Mariana Islands';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'San Juan' and state_abbreviation = 'PR') WHERE state_name = 'Puerto Rico';
UPDATE state SET capital = (SELECT city_id FROM city c WHERE city_name = 'Charlotte Amalie' and state_abbreviation = 'VI') WHERE state_name = 'U.S. Virgin Islands';


-- data collected February 10, 2021
-- park name, area (sq km, 2019 data) - https://en.wikipedia.org/wiki/List_of_national_parks_of_the_United_States
-- has_camping - https://www.nps.gov/subjects/camping/campground.htm
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Acadia', '2/26/1919', 198.6, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('American Samoa', '10/31/1988', 33.4, false);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Arches', '11/12/1971', 310.3, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Badlands', '11/10/1978', 982.4, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Big Bend', '6/12/1944', 3242.2, false);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Biscayne', '6/28/1980', 700, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Black Canyon of the Gunnison', '10/21/1999', 124.6, false);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Bryce Canyon', '2/25/1928', 145, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Canyonlands', '9/12/1964', 1366.2, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Capitol Reef', '12/18/1971', 979, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Carlsbad Caverns', '5/14/1930', 189.3, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Channel Islands', '3/5/1980', 1009.9, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Congaree', '11/10/2003', 107.1, false);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Crater Lake', '5/22/1902', 741.5, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Cuyahoga Valley', '10/11/2000', 131.8, false);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Death Valley', '10/31/1994', 13793.3, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Denali', '2/26/1917', 19185.8, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Dry Tortugas', '10/26/1992', 261.8, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Everglades', '5/30/1934', 6106.5, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Gates of the Arctic', '12/2/1980', 30448.1, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Gateway Arch', '2/22/2018', 0.8, false);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Glacier', '5/11/1910', 4100, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Glacier Bay', '12/2/1980', 13044.6, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Grand Canyon', '2/26/1919', 4862.9, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Grand Teton', '2/26/1929', 1254.7, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Great Basin', '10/27/1986', 312.3, false);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Great Sand Dunes', '9/13/2004', 434.4, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Great Smoky Mountains', '6/15/1934', 2114.2, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Guadalupe Mountains', '10/15/1966', 349.5, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Haleakalā', '7/1/1961', 134.6, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Hawaiʻi Volcanoes', '8/1/1916', 1317.7, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Hot Springs', '3/4/1921', 22.5, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Indiana Dunes', '2/15/2019', 62.1, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Isle Royale', '4/3/1940', 2314, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Joshua Tree', '10/31/1994', 3217.9, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Katmai', '12/2/1980', 14870.3, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Kenai Fjords', '12/2/1980', 2710, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Kings Canyon', '3/4/1940', 1869.2, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Kobuk Valley', '12/2/1980', 7084.9, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Lake Clark', '12/2/1980', 10602, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Lassen Volcanic', '8/9/1916', 431.4, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Mammoth Cave', '7/1/1941', 218.6, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Mesa Verde', '6/29/1906', 212.4, false);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Mount Rainier', '3/2/1899', 956.6, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('New River Gorge', '12/27/2020', 28.4, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('North Cascades', '10/2/1968', 2042.8, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Olympic', '6/29/1938', 3733.8, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Petrified Forest', '12/9/1962', 895.9, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Pinnacles', '1/10/2013', 108, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Redwood', '10/2/1968', 562.5, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Rocky Mountain', '1/26/1915', 1075.7, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Saguaro', '10/14/1994', 375.8, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Sequoia', '9/25/1890', 1635.2, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Shenandoah', '12/26/1935', 806.2, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Theodore Roosevelt', '11/10/1978', 285.1, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Virgin Islands', '8/2/1956', 60.9, false);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Voyageurs', '4/8/1975', 883.1, false);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('White Sands', '12/20/2019', 592.2, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Wind Cave', '1/9/1903', 137.5, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Wrangell-St. Elias', '12/2/1980', 33682.6, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Yellowstone', '3/1/1872', 8983.2, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Yosemite', '10/1/1890', 3082.7, true);
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Zion', '11/19/1919', 595.9, true);


-- park states - https://en.wikipedia.org/wiki/List_of_national_parks_of_the_United_States
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Acadia'), 'ME');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'American Samoa'), 'AS');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Arches'), 'UT');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Badlands'), 'SD');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Big Bend'), 'TX');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Biscayne'), 'FL');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Black Canyon of the Gunnison'), 'CO');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Bryce Canyon'), 'UT');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Canyonlands'), 'UT');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Capitol Reef'), 'UT');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Carlsbad Caverns'), 'NM');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Channel Islands'), 'CA');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Congaree'), 'SC');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Crater Lake'), 'OR');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Cuyahoga Valley'), 'OH');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Death Valley'), 'CA');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Death Valley'), 'NV');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Denali'), 'AK');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Dry Tortugas'), 'FL');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Everglades'), 'FL');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Gates of the Arctic'), 'AK');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Gateway Arch'), 'MO');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Glacier'), 'MT');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Glacier Bay'), 'AK');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Grand Canyon'), 'AZ');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Grand Teton'), 'WY');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Great Basin'), 'NV');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Great Sand Dunes'), 'CO');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Great Smoky Mountains'), 'NC');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Great Smoky Mountains'), 'TN');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Guadalupe Mountains'), 'TX');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name =  'Haleakalā'), 'HI');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name =  'Hawaiʻi Volcanoes'), 'HI');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Hot Springs'), 'AR');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Indiana Dunes'), 'IN');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Isle Royale'), 'MI');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Joshua Tree'), 'CA');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Katmai'), 'AK');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Kenai Fjords'), 'AK');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Kings Canyon'), 'CA');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Kobuk Valley'), 'AK');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Lake Clark'), 'AK');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Lassen Volcanic'), 'CA');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Mammoth Cave'), 'KY');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Mesa Verde'), 'CO');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Mount Rainier'), 'WA');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'New River Gorge'), 'WV');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'North Cascades'), 'WA');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Olympic'), 'WA');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Petrified Forest'), 'AZ');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Pinnacles'), 'CA');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Redwood'), 'CA');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Rocky Mountain'), 'CO');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Saguaro'), 'AZ');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Sequoia'), 'CA');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Shenandoah'), 'VA');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Theodore Roosevelt'), 'ND');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Virgin Islands'), 'VI');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Voyageurs'), 'MN');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'White Sands'), 'NM');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Wind Cave'), 'SD');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Wrangell-St. Elias'), 'AK');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Yellowstone'), 'WY');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Yellowstone'), 'MT');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Yellowstone'), 'ID');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Yosemite'), 'CA');
INSERT INTO park_state (park_id, state_abbreviation) VALUES ((SELECT park_id FROM park WHERE park_name = 'Zion'), 'UT');


-- foreign keys
ALTER TABLE state ADD CONSTRAINT FK_state_city FOREIGN KEY(capital) REFERENCES city(city_id);

ALTER TABLE city ADD CONSTRAINT FK_city_state FOREIGN KEY(state_abbreviation) REFERENCES state(state_abbreviation);

ALTER TABLE park_state ADD CONSTRAINT FK_park_state_park FOREIGN KEY(park_id) REFERENCES park(park_id);

ALTER TABLE park_state ADD CONSTRAINT FK_park_state_state FOREIGN KEY(state_abbreviation) REFERENCES state(state_abbreviation);

ALTER TABLE state ALTER COLUMN capital SET NOT NULL;

COMMIT;