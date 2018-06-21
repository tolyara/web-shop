
CREATE TABLE order_product (
	order_product_id serial PRIMARY KEY,
	order_id integer NOT NULL,
	product_id integer NOT NULL,
	product_name varchar(30) NOT NULL,
	product_amount integer NOT NULL
);








