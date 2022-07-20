SELECT pizza_id, sale_id, size_id, crust, sauce, price, additional_instructions
FROM pizza
WHERE price > 15;

SELECT pizza_id, sale_id, size_id, crust, sauce, price, additional_instructions
FROM pizza
WHERE price < 10;

SELECT pizza_id, sale_id, size_id, crust, sauce, price, additional_instructions
FROM pizza
WHERE price <= 10.99;
