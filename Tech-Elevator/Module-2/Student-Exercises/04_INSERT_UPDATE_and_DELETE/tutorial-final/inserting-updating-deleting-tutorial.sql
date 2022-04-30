-- Part one: Query for orders

SELECT c.last_name, c.first_name, c.street_address, s.sale_id, p.pizza_id, p.size_id, p.crust, p.sauce, pt.topping_name 
FROM customer AS c
JOIN sale AS s ON c.customer_id = s.customer_id
JOIN pizza AS p ON s.sale_id = p.sale_id
LEFT JOIN pizza_topping AS pt ON p.pizza_id = pt.pizza_id
WHERE c.last_name = 'Mamwell' AND c.first_name = 'Elenore'
ORDER BY c.last_name, c.first_name, s.sale_id, p.pizza_id;

-- Part two: Add additional pizza

INSERT INTO pizza 
(sale_id, size_id, crust, sauce, price)
VALUES
(50, (SELECT size_id FROM size WHERE size_description = 'Large'), 'Thin', 'Normal', 17.24)
RETURNING pizza_id;

INSERT INTO pizza_topping
(pizza_id, topping_name)
VALUES 
(96, 'Sausage'),
(96, 'Onions'),
(96, 'Mushrooms');

-- Part three: Change existing pizza

UPDATE pizza SET
size_id = (SELECT size_id FROM size WHERE size_description = 'Large'),
price = price + 2
WHERE pizza_id = 67;

-- Part four: Remove additional pizza

DELETE FROM pizza_topping
WHERE pizza_id = 96;

DELETE FROM pizza
WHERE pizza_id = 96;
