-- 10. The name and area of parks that have an area less than or equal to 700 square kilometers and provides camping (21 rows)
SELECT park_name, area
FROM park
WHERE area <= 700
AND has_camping = 'true';
