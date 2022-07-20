SELECT sale_id, total, is_delivery, customer_id
FROM sale
WHERE customer_id IS NULL;

SELECT sale_id, total, is_delivery, customer_id
FROM sale
WHERE customer_id IS NOT NULL;
