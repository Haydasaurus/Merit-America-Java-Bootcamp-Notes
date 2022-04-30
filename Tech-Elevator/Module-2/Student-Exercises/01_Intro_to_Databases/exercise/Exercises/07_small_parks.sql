-- 7. The name, date established, and area of parks with an area less than 100 square kilometers (6 rows)
SELECT park_name, date_established, area
FROM park
WHERE area < 100;
