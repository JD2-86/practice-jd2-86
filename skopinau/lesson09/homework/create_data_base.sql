CREATE DATABASE checking_homework;

CREATE SCHEMA rescue_hr;

CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    surname VARCHAR(32),
    name VARCHAR(32),
    birthday DATE
);

CREATE TABLE position (
    id SERIAL PRIMARY KEY,
    title VARCHAR(32)
);

CREATE TABLE subdivision (
    id SERIAL PRIMARY KEY,
    title VARCHAR(32)
);

CREATE TABLE rank (
    id SERIAL PRIMARY KEY,
    title VARCHAR(32)
);

CREATE TABLE employee_base_link (
    employee_id INTEGER,
    position_id INTEGER,
    subdivision_id INTEGER,
    rank_id INTEGER,
    FOREIGN KEY (employee_id) REFERENCES employee ON DELETE CASCADE,
    FOREIGN KEY (position_id) REFERENCES position ON DELETE CASCADE,
    FOREIGN KEY (subdivision_id) REFERENCES subdivision ON DELETE CASCADE,
    FOREIGN KEY (rank_id) REFERENCES rank ON DELETE CASCADE,
    PRIMARY KEY (employee_id)
);

CREATE TABLE rank_log (
    id SERIAL PRIMARY KEY,
    order_number INTEGER,
    getting_date DATE,
    employee_id INTEGER,
    rank_id INTEGER,
    FOREIGN KEY (employee_id) REFERENCES employee ON DELETE CASCADE,
    FOREIGN KEY (rank_id) REFERENCES rank ON DELETE CASCADE
);