BEGIN TRANSACTION;

DROP TABLE IF EXISTS catcards;

CREATE TABLE catcards (
  id serial PRIMARY KEY,
  img_url varchar(256) NOT NULL,   -- image URL
  fact varchar(1000) NOT NULL,       -- Cat Fact
  caption varchar(256) NOT NULL    -- User-provided caption
);

COMMIT TRANSACTION;
