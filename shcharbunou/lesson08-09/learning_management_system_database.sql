-- CREATE DATABASE learning_management_system_database;

DROP SCHEMA IF EXISTS test_project_schema CASCADE;

CREATE SCHEMA test_project_schema;

CREATE TABLE test_project_schema.language_proficiency_level
(
    level_id          SERIAL PRIMARY KEY,
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
    group_id          SERIAL PRIMARY KEY,
    group_designation VARCHAR(32) NOT NULL
);

INSERT INTO test_project_schema.age_group (group_designation)
VALUES ('Kids'),
       ('Teenagers'),
       ('Adults');

CREATE TABLE test_project_schema.course
(
    course_id          SERIAL PRIMARY KEY,
    group_id           INTEGER REFERENCES test_project_schema.age_group (group_id) ON DELETE CASCADE,
    level_id           INTEGER REFERENCES test_project_schema.language_proficiency_level (level_id) ON DELETE CASCADE,
    semesters_number   INTEGER     NOT NULL,
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
    purpose_id          SERIAL PRIMARY KEY,
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
    book_id          SERIAL PRIMARY KEY,
    course_id        INTEGER REFERENCES test_project_schema.course (course_id) ON DELETE CASCADE,
    book_designation VARCHAR(64) NOT NULL,
    author           VARCHAR(64) NOT NULL
);

INSERT INTO test_project_schema.book (course_id, book_designation, author)
VALUES (5, 'ENGLISH FILE Student Book', 'Christina Latham-Koenig'),
       (5, 'ENGLISH FILE Workbook', 'Christina Latham-Koenig'),
       (10, 'ENGLISH FILE Student Book', 'Christina Latham-Koenig'),
       (10, 'ENGLISH FILE Workbook', 'Christina Latham-Koenig'),
       (13, 'Roadmap B2 Student Book', 'PEARSON EDUCATION'),
       (13, 'Roadmap B2 Workbook', 'PEARSON EDUCATION');

CREATE TABLE test_project_schema.role
(
    role_id          SERIAL PRIMARY KEY,
    role_designation VARCHAR(16) NOT NULL
);

INSERT INTO test_project_schema.role (role_designation)
VALUES ('ADMIN'),
       ('USER'),
       ('GUEST');

CREATE TABLE test_project_schema.user
(
    user_id    SERIAL PRIMARY KEY,
    first_name VARCHAR(64)        NOT NULL,
    last_name  VARCHAR(64)        NOT NULL,
    username   VARCHAR(64) UNIQUE NOT NULL,
    password   VARCHAR(64)        NOT NULL CHECK ( length(password) > 5 ),
    email      VARCHAR(64)        NOT NULL UNIQUE,
    phone      VARCHAR(32)        NOT NULL UNIQUE,
    role_id    INTEGER            NOT NULL REFERENCES test_project_schema.role (role_id) ON DELETE CASCADE,
    course_id  INTEGER REFERENCES test_project_schema.course (course_id) ON DELETE CASCADE,
    purpose_id INTEGER REFERENCES test_project_schema.purpose (purpose_id) ON DELETE CASCADE
);

INSERT INTO test_project_schema.user (first_name, last_name, username, password, email, phone, role_id, course_id,
                                      purpose_id)
VALUES ('Name1', 'Lastname1', 'username1', '1234pass6789', 'email1@gmail.com', '+3752958748960', 1, null, null),
       ('Name2', 'Lastname2', 'username2', '123456pass789', 'email2@gmail.com', '+3752958748240', 2, 8, 5),
       ('Name3', 'Lastname3', 'username3', '1234ps67as89', 'email3@gmail.com', '+3752948948960', 2, 12, 5),
       ('Name4', 'Lastname4', 'username4', 'pass6789pass', 'email4@gmail.com', '+3754412748960', 3, null, null),
       ('Name5', 'Lastname5', 'username5', '1234passpasspass', 'email5@gmail.com', '+3752958745555', 2, 6, 3),
       ('Name3', 'Lastname6', 'username6', '1234pass6777889989', 'email6@gmail.com', '+375295885478', 2, 8, 5),
       ('Name1', 'Lastname7', 'username7', '1234plllss6789', 'email7@gmail.com', '+3752958748955', 3, null, null),
       ('Name8', 'Lastname8', 'username8', '12passpass6789', 'email8@gmail.com', '+3752952742962', 2, 4, 5),
       ('Name9', 'Lastname9', 'username9', '1234passssap6789', 'email9@gmail.com', '+3752922222233', 2, 4, 5),
       ('Name10', 'Lastname10', 'username10', '1234pa000ss6789', 'email10@gmail.com', '+375293333322', 2, 4, 5);

SELECT c.course_designation, ag.group_designation, lpl.level_designation
FROM test_project_schema.course AS c
         JOIN test_project_schema.age_group AS ag ON c.group_id = ag.group_id
         JOIN test_project_schema.language_proficiency_level AS lpl ON c.level_id = lpl.level_id
ORDER BY c.course_id;

SELECT b.book_designation, b.author, c.course_designation
FROM test_project_schema.book AS b
         JOIN test_project_schema.course AS c ON b.course_id = c.course_id
ORDER BY b.book_id;

SELECT u.username, r.role_designation, c.course_designation, p.purpose_designation
FROM test_project_schema.user AS u
         LEFT JOIN test_project_schema.role AS r ON u.role_id = r.role_id
         LEFT JOIN test_project_schema.course AS c ON u.course_id = c.course_id
         LEFT JOIN test_project_schema.purpose AS p ON u.purpose_id = p.purpose_id
ORDER BY u.user_id;

SELECT u.username, p.purpose_designation
FROM test_project_schema.user AS u
         LEFT JOIN test_project_schema.purpose AS p ON u.purpose_id = p.purpose_id
WHERE p.purpose_id = 5
ORDER BY u.user_id;






