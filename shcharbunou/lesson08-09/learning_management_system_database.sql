-- CREATE DATABASE learning_management_system_database;

DROP SCHEMA IF EXISTS test_project_schema CASCADE;

CREATE SCHEMA test_project_schema;

CREATE TABLE test_project_schema.language_proficiency_level
(
    level_id SERIAL PRIMARY KEY,
    level_designation VARCHAR(32) NOT NULL
);

INSERT INTO test_project_schema.language_proficiency_level (level_designation)
VALUES ('ZERO'),
       ('A1'),
       ('A2'),
       ('B1'),
       ('B2'),
       ('C1'),
       ('C2');

CREATE TABLE test_project_schema.age_group
(
    group_id SERIAL PRIMARY KEY,
    group_designation VARCHAR(32) NOT NULL
);

INSERT INTO test_project_schema.age_group (group_designation)
VALUES ('Kids'),
       ('Teenagers'),
       ('Adults');

CREATE TABLE test_project_schema.course
(
    course_id SERIAL PRIMARY KEY,
    group_id INTEGER REFERENCES test_project_schema.age_group (group_id),
    level_id INTEGER REFERENCES test_project_schema.language_proficiency_level (level_id),
    semesters_number INTEGER NOT NULL,
    course_designation VARCHAR(64) NOT NULL
);

INSERT INTO test_project_schema.course (group_id, level_id, semesters_number, course_designation)
VALUES (1, 1, 1, 'Little Kids'),
       (1, 1, 1, 'Kids'),
       (1, 1, 1, 'Juniors'),
       (2, 2, 1, 'Teens'),
       (3, 2, 1, 'Beginner'),
       (3, 2, 3, 'Elementary 1-3'),
       (3, 2, 1, 'Elementary 4'),
       (3, 3, 3, 'Pre-intermediate 1-3'),
       (3, 3, 1, 'Pre-intermediate 4'),
       (3, 4, 3, 'Intermediate 1-3'),
       (3, 4, 3, 'Intermediate 4-6'),
       (3, 5, 3, 'Upper-intermediate'),
       (3, 6, 3, 'Pre-advanced 1-3'),
       (3, 6, 3, 'Lower-advanced'),
       (3, 7, 3, 'Upper-advanced ');

CREATE TABLE test_project_schema.purpose
(
    purpose_id SERIAL PRIMARY KEY,
    purpose_designation VARCHAR(64) NOT NULL
);

INSERT INTO test_project_schema.purpose (purpose_designation)
VALUES ('TOEFL/IELTS exams'),
       ('Interview preparation'),
       ('Corporate training'),
       ('Individual sessions'),
       ('Just courses');

CREATE TABLE test_project_schema.book
(
    book_id SERIAL PRIMARY KEY,
    course_id INTEGER REFERENCES test_project_schema.course(course_id),
    book_designation VARCHAR(64) NOT NULL,
    author VARCHAR(64) NOT NULL
);

INSERT INTO test_project_schema.book (course_id, book_designation, author)
VALUES (5, 'ENGLISH FILE Student Book', 'Christina Latham-Koenig'),
       (5, 'ENGLISH FILE Workbook', 'Christina Latham-Koenig'),
       (10, 'ENGLISH FILE Student Book', 'Christina Latham-Koenig'),
       (10, 'ENGLISH FILE Workbook', 'Christina Latham-Koenig'),
       (13, 'Roadmap B2 Student Book', 'PEARSON EDUCATION'),
       (13, 'Roadmap B2 Workbook', 'PEARSON EDUCATION');





