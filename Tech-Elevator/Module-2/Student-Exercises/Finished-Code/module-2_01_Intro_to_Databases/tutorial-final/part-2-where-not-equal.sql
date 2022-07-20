SELECT pizza_id, sale_id, size_id, crust, sauce, price, additional_instructions
FROM pizza
WHERE size_id != 'S';
