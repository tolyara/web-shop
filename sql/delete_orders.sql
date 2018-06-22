
CREATE TABLE orders (
	order_id serial PRIMARY KEY,
	account_name_fk VARCHAR(30) NOT NULL references accounts(account_name)
);

INSERT INTO orders () VALUES ('');





