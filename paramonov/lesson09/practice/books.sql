DROP SCHEMA IF EXISTS library;

CREATE SCHEMA library;

DROP TABLE IF EXISTS book;

CREATE TABLE book
(
    books_id        SERIAL primary key,
    title           VARCHAR(50),
    number_of_pages INT,
    genre           VARCHAR
);

DROP TABLE IF EXISTS author;

CREATE TABLE author
(
    author_id   SERIAL primary key,
    full_name   VARCHAR(50),
    birthday    DATE,
    nationality VARCHAR(50)
);

CREATE TABLE books_plus_authors_link
(
    author_id int,
    book_id   int,
    PRIMARY KEY (author_id, book_id),
    FOREIGN KEY (author_id) REFERENCES author (author_id),
    FOREIGN KEY (book_id) REFERENCES book (books_id)
);

INSERT INTO books_plus_authors_link(author_id, book_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (1, 4),
       (4, 5),
       (5, 6),
       (4,7),
       (6,8),
       (5,9),
       (7,10);

INSERT INTO author (full_name, birthday, nationality)
VALUES ('F.Dostoevsky', '1770-4-30', 'russian'),
       ('X.Chernishevsky', '1860-5-25', 'russian'),
       ('X.Mendeleev', '1750-9-15', 'russian'),
       ('X.Xxxxxandberg', '1870-1-1', 'english'),
       ('A.Pushkin', '1703-10-10', 'russian'),
       ('Narod', '1-1-1', 'arabian'),
       ('Narod', '862-1-2', 'ukraine');

INSERT INTO book (title, number_of_pages, genre)
VALUES ('Idiot', 512, 'tragicomedy'),
       ('What to do?', 1024, 'Truestory'),
       ('Chemistry', 10000, 'tutorial'),
       ('Twin', 311, 'tragicomedy'),
       ('Triple', 421, 'comedy'),
       ('Fairy Tales', 10020200, 'fairy tales'),
       ('Twinly', 521, 'comedy'),
       ('MATH', 666, 'tutorial'),
       ('The tale of the King Sultan', 118, 'fairy tales'),
       ('Ditties', 2000, 'fairy tales');

