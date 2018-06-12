DROP DATABASE WebShop;
CREATE DATABASE WebShop;
USE WebShop;

CREATE TABLE products (
	product_id serial PRIMARY KEY,
	product_name VARCHAR(20) NOT NULL
);

INSERT INTO products (product_name) VALUES ('Системный блок');
INSERT INTO products (product_name) VALUES ('Монитор');
INSERT INTO products (product_name) VALUES ('Клавиатура');
INSERT INTO products (product_name) VALUES ('Мышь');
INSERT INTO products (product_name) VALUES ('Ноутбук');
INSERT INTO products (product_name) VALUES ('Роутер');
INSERT INTO products (product_name) VALUES ('Колонки');




