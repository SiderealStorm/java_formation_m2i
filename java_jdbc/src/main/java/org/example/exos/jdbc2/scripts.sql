CREATE DATABASE IF NOT EXISTS exos_jdbc;
CREATE SCHEMA IF NOT EXISTS exo2;

--DROP TABLE IF EXISTS exo2.bank_account, exo2.transaction, exo2.customer ;

CREATE TABLE IF NOT EXISTS exo2.customer (
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	phone VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS exo2.bank_account (
	id SERIAL PRIMARY KEY,
	balance DECIMAL(10,2),
	customer_id INT REFERENCES exo2.customer(id)
);

CREATE TABLE IF NOT EXISTS exo2.transaction (
	id SERIAL PRIMARY KEY,
	amount DECIMAL(10,2),
	type VARCHAR(15),
	account_id INT REFERENCES exo2.bank_account(id)
);

