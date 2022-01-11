CREATE DATABASE learning_management_system_database;

DROP SCHEMA IF EXISTS user_schema;

CREATE SCHEMA user_schema;

CREATE TABLE user_schema.language_proficiency_level
(
    level_id SERIAL PRIMARY KEY,
    level_designation VARCHAR(32) NOT NULL
);

INSERT INTO user_schema.language_proficiency_level (level_designation)
VALUES ('A1'),
       ('A2'),
       ('B1'),
       ('B2'),
       ('C1'),
       ('C2');

CREATE TABLE user_schema.age_group
(
    group_id SERIAL PRIMARY KEY,
    group_designation VARCHAR(32) NOT NULL
);

INSERT INTO user_schema.age_group (group_designation)
VALUES ('Kids'),
       ('Teenagers'),
       ('Adults');


