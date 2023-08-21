-- DROP TABLE IF EXISTS exo1.student;

CREATE TABLE IF NOT EXISTS exo1.student (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    class_number INT,
    degree_date DATE
);
