-- Part one: Inner joins

---- Joining pizza and size tables

SELECT pizza_id, size_id, crust, sauce
FROM pizza;

SELECT size_id, size_description, diameter
FROM size;

SELECT pizza_id, size.size_id, size_description, diameter, crust, sauce
FROM pizza
JOIN size ON pizza.size_id = size.size_id;

---- Joining sale and customer tables

SELECT sale_id, customer_id, total
FROM sale;

SELECT customer_id, first_name, last_name
FROM customer;

SELECT sale_id, customer.customer_id, total, first_name, last_name
FROM sale
JOIN customer ON sale.customer_id = customer.customer_id;

---- Joining pizza, pizza_topping, and topping tables

SELECT pizza.pizza_id, sale_id, size_id, price, topping_name
FROM pizza
JOIN pizza_topping ON pizza.pizza_id = pizza_topping.pizza_id;

SELECT pizza_id, topping.topping_name, additional_price
FROM topping
JOIN pizza_topping ON topping.topping_name = pizza_topping.topping_name;

SELECT pizza.pizza_id, sale_id, size_id, price, topping.topping_name, additional_price
FROM pizza
JOIN pizza_topping ON pizza.pizza_id = pizza_topping.pizza_id
JOIN topping ON topping.topping_name = pizza_topping.topping_name;


-- Part two: Outer joins

---- LEFT

SELECT sale_id, total, first_name, last_name
FROM sale
LEFT JOIN customer ON sale.customer_id = customer.customer_id;

---- RIGHT

SELECT sale_id, total, first_name, last_name
FROM customer
RIGHT JOIN sale ON sale.customer_id = customer.customer_id;

SELECT sale_id, total, first_name, last_name
FROM customer
LEFT JOIN sale ON sale.customer_id = customer.customer_id;
--or 
SELECT sale_id, total, first_name, last_name
FROM sale
RIGHT JOIN customer ON sale.customer_id = customer.customer_id;
