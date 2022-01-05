--CREATE DATABASE online_course;

DROP TABLE IF EXISTS school_user, course, user_course, module, lesson, question, basket;

CREATE TABLE IF NOT EXISTS course
(
    course_id    SERIAL PRIMARY KEY,
    course_title VARCHAR(50) NOT NULL,
    course_price INTEGER     NOT NULL
);

-- Table for students and teachers
CREATE TABLE IF NOT EXISTS school_user
(
    user_id            SERIAL PRIMARY KEY,
    username           VARCHAR(50),
    password           VARCHAR(50) NOT NULL,
    first_name         VARCHAR(50),
    last_name          VARCHAR(50),
    birthday           date,
    country            VARCHAR(50),
    email              VARCHAR(50) NOT NULL,
    admin              BOOLEAN,
    notification_agree BOOLEAN,
    progress           INTEGER
);

-- Table to connect user with several courses
CREATE TABLE IF NOT EXISTS user_course
(
    course_id INTEGER REFERENCES course (course_id),
    user_id   INTEGER REFERENCES school_user (user_id)
);

CREATE TABLE IF NOT EXISTS module
(
    module_id    SERIAL PRIMARY KEY,
    course_id    INTEGER REFERENCES course (course_id),
    module_title VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS lesson
(
    lesson_id    SERIAL PRIMARY KEY,
    module_id    INTEGER REFERENCES module (module_id),
    lesson_title VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS question
(
    question_id    SERIAL PRIMARY KEY,
    lesson_id      INTEGER REFERENCES lesson (lesson_id),
    question_title VARCHAR(50),
    question_text  VARCHAR(300) NOT NULL
);

CREATE TABLE IF NOT EXISTS basket
(
    basket_id SERIAL PRIMARY KEY,
    user_id   INTEGER REFERENCES school_user (user_id),
    course_id INTEGER REFERENCES course (course_id),
    discount  INTEGER,
    value     INTEGER

);

INSERT INTO course(course_title, course_price)
VALUES ('Basic', 10),
       ('Breathing', 50),
       ('Hormones', 250);

INSERT INTO module(course_id, module_title)
VALUES (1, 'Basics of movement'),
       (1, 'Intuitive nutrition'),
       (1, 'Emotional balance');

INSERT INTO lesson(module_id, lesson_title)
VALUES (1, 'Warm up'),
       (1, 'Sit up'),
       (1, 'Cardio'),
       (1, 'Power'),
       (1, 'Functional'),
       (2, 'Chewing'),
       (2, 'Detox'),
       (2, 'Microflora'),
       (2, 'Bon appetit'),
       (2, 'Variety'),
       (3, 'Start'),
       (3, 'Secret button'),
       (3, 'Information'),
       (3, 'Meditation'),
       (3, 'Healthy sleep');


INSERT INTO school_user(username, password, first_name, last_name, birthday, country, email, admin,
                        notification_agree)
VALUES ('teacher', '1234567', 'Paul', 'Paunch', '2001-03-09', 'Belarus', 'pal@pal.com', true, true),
       ('student1', '1234567', 'John', 'Dow', '2001-03-09', 'Belarus', 'jo@dow.com', false, true),
       ('student2', '1234567', 'Mike', 'Tay', '2001-03-09', 'Belarus', 'mik@tay.com', false, true),
       ('student3', '1234567', 'Nick', 'Clause', '2001-03-09', 'Belarus', 'ded@moroz.com', false, true),
       ('student4', '1234567', 'Mary', 'Magda', '2001-03-09', 'Belarus', 'mary@mag.com', false, false),
       ('student5', '1234567', 'Ann', 'Repo', '2001-03-09', 'Belarus', 'ann@rep.com', false, true),
       ('student6', '1234567', 'Pete', 'Ginsburg', '2001-03-09', 'Belarus', 'pet@gin.com', false, true),
       ('student7', '1234567', 'George', 'Tamely', '2001-03-09', 'Poland', 'geo@tam.com', false, false),
       ('student8', '1234567', 'Den', 'Braun', '2001-03-09', 'Poland', 'den@br.com', false, false),
       ('student9', '1234567', 'Liz', 'Taylor', '2001-03-09', 'Russia', 'liz@tay.com', false, false),
       ('student10', '1234567', 'Helen', 'Gorgeous', '2001-03-09', 'USA', 'hell@gor.com', false, true);

INSERT INTO user_course (course_id, user_id)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (1, 5),
       (1, 6),
       (1, 7),
       (1, 8),
       (1, 9),
       (1, 10);

INSERT INTO school_user(username, password, first_name, last_name, birthday, country, email, admin,
                        notification_agree)
VALUES ('teacher2', '1234567', 'Zara', 'Well', '2001-03-09', 'Russia', 'za@ra.com', true, true),
       ('student11', '1234567', 'Yoko', 'Coca', '2001-03-09', 'Belarus', 'yo@ko.com', false, true),
       ('student12', '1234567', 'Xen', 'Bad', '2001-03-09', 'Belarus', 'xe@ba.com', false, true);

UPDATE school_user
SET birthday = '2000-04-08'
WHERE first_name = 'Zara'
  AND last_name = 'Well';

DELETE
FROM school_user
WHERE first_name = 'Xen'
   OR username = 'student12';

SELECT module_title, lesson_title
FROM module AS m
         JOIN lesson AS l ON l.module_id = m.module_id;

SELECT first_name, last_name, course_title
FROM school_user AS su
         JOIN user_course AS uc ON su.user_id = uc.user_id
         JOIN course AS c ON c.course_id = uc.course_id
WHERE c.course_id = 1 AND admin IS false;
