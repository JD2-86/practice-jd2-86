-- task 1
INSERT INTO "user"
VALUES ('alex_s', 'qazwsxedc', 'alex@smith.com', 'Alex', 'Smith', 26, 'CR', 'CREATE, READ', 'DOCUMENT, USER',
        'Madrid, Spain'),
       ('james_b', 'qwerty123', 'james@browm.com', 'James', 'Brown', 41, 'CRUD', 'CREATE, READ, UPDATE, DELETE',
        'DICTIONARY, WORKFLOW, USER, DOCUMENT', 'New-York, USA'),
       ('ivaN-21', '123pass123', 'ivanov.ivan@base.com', 'Ivan', 'Ivanov', 16, 'R', 'READ', 'DOCUMENT', 'Riga, Latvia'),
       ('marshall_g', '1password1', 'marshall@gomez.com', 'Marshall', 'Gomez', 35, 'CRU', 'CREATE, READ, UPDATE',
        'WORKFLOW, DOCUMENT', 'London, England'),
       ('wil_sher', 'pass123321', 'edwart@william@sherman.com', 'William', 'Sherman', 31, NULL, 'READ', 'DOCUMENT',
        'Liverpool, England'),
       ('bill_east', 'mypass123', 'bill@east.com', 'Bill', 'East', 29, 'CR', 'CREATE ,READ', 'DOCUMENT, DICTIONARY',
        'Paris, France'),
       ('alfred_t', '123456789', 'alfred@thompson.com', 'Alfred', 'Thompson', 52, 'CRUD',
        'CREATE, READ, UPDATE, DELETE', 'DICTIONARY, WORKFLOW, USER, DOCUMENT', 'New York, USA'),
       ('ivan_i', '987654321', 'ivan@ivanov.com', 'Ivan', 'Ivanov', 27, 'CRU', 'CREATE, READ, UPDATE',
        'DOCUMENT, USER', 'Moscow, Russia'),
       ('kate-t', 'password1', 'kate@tera.com', 'Kate', 'Tera', 32, NULL, 'READ', 'DICTIONARY, WORKFLOW, USER, DOCUMENT',
        'Minsk, Belarus'),
       ('mary_m', 'qwer123', 'mary@myers.com', 'Mary', 'Myers', 27, 'RD', 'READ, DELETE',
        'DICTIONARY, WORKFLOW, USER, DOCUMENT', 'Sofia, Bulgary'),
       ('tony_the_best', 'tony321', 'tony@gmail.com', 'Tony', 'Stark', 45, NULL, 'CREATE, DELETE',
        'DOCUMENT', 'Los-Angeles, USA');
-- task 2
SELECT *
FROM "user";

SELECT email, username
FROM "user";

SELECT DISTINCT first_name
FROM "user";

SELECT username
FROM "user"
WHERE last_name LIKE 'Ivanov'
  AND first_name LIKE 'Ivan' ;

SELECT username
FROM "user"
WHERE age > 30;

SELECT *
FROM "user"
ORDER BY age;

SELECT *
FROM "user"
ORDER BY username;

SELECT *
FROM "user"
WHERE "group" IS NOT NULL;

SELECT *
FROM "user"
LIMIT 3;

SELECT *
FROM "user"
LIMIT 3
OFFSET 3;

-- task 3

UPDATE "user"
SET age = age + 1;

-- task 4

DELETE
FROM "user"
WHERE age <18;


DELETE
FROM "user"
WHERE username IS NOT NULL;