CREATE DATABASE "rbac";

SET SEARCH_PATH = 'user';

CREATE TABLE IF NOT EXISTS "user" (
    username VARCHAR(30),
    password VARCHAR(30),
    email VARCHAR(30),
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    age INTEGER,
    birthday DATE,
    operations VARCHAR(100),
    "group" VARCHAR(30),
    objects VARCHAR(100)
    );

ALTER TABLE "user"
DROP birthday;

ALTER TABLE "user"
    ADD COLUMN adress varchar(30);

INSERT INTO "user" (username, password, email, first_name, last_name, age, operations, "group", objects, adress)
VALUES ( 'sergio', '123', 'ser@com', 'sergunio', 'tachini', 23, 'CREATE, READ, UPDATE, DELETE', 'teen', 'USER, DOCUMENT, WORKFLOW, DICTIONARY', 'matusevichh 34'),
       ('andr','22222', 'asd@sdfsd.ty', 'anderson', 'beloo', 23, 'CREATE, READ, UPDATE, DELETE', 'adult','USER, DOCUMENT, WORKFLOW, DICTIONARY', 'garuna 12'),
       ('opa','5555','ema@tyt.by', 'vasua', 'kon', 45,'CREATE, READ, UPDATE, DELETE', 'adult','USER, DOCUMENT, WORKFLOW, DICTIONARY', 'seve 34'),
       ('jora','12344','jora@tyt.by', 'jorik', 'bena', 44,'CREATE, READ, UPDATE, DELETE', 'adult','USER, DOCUMENT, WORKFLOW, DICTIONARY', 'mazurova 44'),
       ('peta','2312','petya@tyt.by', 'petyh', 'petkin', 19,'CREATE, READ, UPDATE, DELETE', 'adult','USER, DOCUMENT, WORKFLOW, DICTIONARY', 'kinova 44'),
       ('nasta','6666','nasta@tyt.by', 'natuha', 'miskina', 25,'CREATE, READ, UPDATE, DELETE', 'adult','USER, DOCUMENT, WORKFLOW, DICTIONARY', 'mavina 44');



INSERT INTO "user" (username) values ('ANDREI');
SELECT DISTINCT username, age FROM "user";
SELECT count (DISTINCT age, username)FROM "user";
SELECT * FROM "user" WHERE username = 'peta';
SELECT * FROM "user" WHERE age >23 AND "group" = 'adult';
SELECT * FROM "user" WHERE age != 23;
SELECT * FROM "user" WHERE NOT age = 23 AND ("group" = 'adult');
SELECT * FROM "user" ORDER BY age ASC ;
SELECT * FROM "user" ORDER BY age DESC;
SELECT * FROM "user" WHERE password IS NOT NULL;
SELECT * FROM "user" WHERE (password,operations) is not null;
SELECT * FROM "user" LIMIT 6;
SELECT * FROM "user" ORDER BY username ASC;
SELECT * FROM "user" WHERE username LIKE ('%et%');
SELECT username AS name1 FROM "user";
ALTER TABLE "user" DROP COLUMN adress;
ALTER TABLE "user" ADD adress varchar(30);
INSERT INTO "user" (adress) VALUES(
                                      'matusevicha 34');
SELECT age, MIN(age), MAX(username) FROM "user"
group by age
;

CREATE DATABASE "BOOKS-AUTORS";
CREATE SCHEMA books_and_authors;
SET SEARCH_PATH = 'books_and_authors';

CREATE TABLE books (
                       ID_Book SERIAL NOT NULL,
                       name varchar(255) NOT NULL,
                       pages_size int,
                       genre varchar(30),
                       PRIMARY KEY (ID_Book)
);

CREATE TABLE authors (
                         ID_Author SERIAL NOT NULL ,
                         name VARCHAR (255) NOT NULL,
                         date_of_birth DATE,
                         ationality varchar(30),
                         PRIMARY KEY (ID_Author));

CREATE TABLE autor_and_book_link (
                                     id_book int,
                                     id_autor int,
                                     FOREIGN KEY (id_book) REFERENCES books(id_book),
                                     FOREIGN KEY (id_autor) REFERENCES authors(id_author),
                                     PRIMARY KEY (id_book,id_autor));
























