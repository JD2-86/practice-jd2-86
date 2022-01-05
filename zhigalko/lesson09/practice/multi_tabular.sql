CREATE DATABASE multi_tabular_database;

CREATE SCHEMA library;

CREATE TABLE library.book
(
          book_id SERIAL PRIMARY KEY,
        book_name TEXT    NOT NULL,
    page_quantity INTEGER NOT NULL
                  CHECK (page_quantity > 0),
            genre VARCHAR(128) NOT NULL
);

CREATE TABLE library.author
(
        author_id SERIAL PRIMARY KEY,
             name VARCHAR(128)       NOT NULL,
    birthday_date DATE               NOT NULL,
      nationality VARCHAR(64) NOT NULL
);

CREATE TABLE library.book_author_link
(
      book_id INTEGER REFERENCES library.book (book_id) ON DELETE CASCADE,
    author_id INTEGER REFERENCES library.author (author_id) ON DELETE CASCADE,
    PRIMARY KEY (book_id, author_id)
);

INSERT INTO library.book (book_name, page_quantity, genre)
VALUES ('Богатый папа, бедный папа', 275, 'Бизнес-литература'),
       ('Атлант расправил плечи', 905, 'Роман'),
       ('Дненадцать стульев',456,'Русская классика'),
       ('HEADFIRST.Паттерны проектирования', 651,'Программирование'),
       ('Убийство в Восточном эскпрессе',831,'Роман'),
       ('Отрочество',760, 'Повесть'),
       ('Война и мир', 2000, 'Роман'),
       ('Капитал', 700, 'Экономика'),
       ('Смерть на Ниле',620,'Роман'),
       ('Собака Баскервилей', 630,'Детектив'),
       ('Внутри убийцы', 589, 'Детектив');

INSERT INTO library.author(name, birthday_date, nationality)
VALUES ('Роберт Кийосаки', '1947-04-08', 'Американец'),
       ('Айн Рэнд','1905-01-20','Русская'),
       ('Илья Ильф','1897-10-03','Русский'),
       ('Евгений Петров','1902-11-30','Русский'),
       ('Эрик Фримэн', '1960-10-5', 'Американец'),
       ('Элизабет Робсон', '1968-2-5', 'Американка'),
       ('Артур Конан Дойл', '1859-05-22','Англичанин'),
       ('Лев Толстой','1828-08-28','Русский'),
       ('Карл Маркс','1818-05-05','Немец'),
       ('Майк Омер','1979-06-20','Израильтянин'),
       ('Агата Кристи','1890-09-15','Англичанка');

INSERT INTO library.book_author_link (book_id, author_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (3, 4),
       (4, 5),
       (4, 6),
       (5, 11),
       (6, 8),
       (7, 8),
       (8, 9),
       (9, 11),
       (10, 7),
       (11,10);

SELECT name AS book_author,
       book_name
FROM author AS a
         JOIN book_author_link AS bal ON a.author_id = bal.author_id
         JOIN book AS b ON bal.book_id = b.book_id;

SELECT DISTINCT b.book_name,
                a.nationality
FROM book AS b
         JOIN book_author_link AS bal ON b.book_id = bal.book_id
         JOIN author AS a ON a.author_id = bal.author_id
WHERE nationality LIKE 'Русск%';

SELECT *
FROM book AS b
         JOIN book_author_link AS bal ON b.book_id = bal.book_id
         JOIN author AS a ON a.author_id = bal.author_id
WHERE EXTRACT(YEAR FROM a.birthday_date) > 1900;

DELETE
FROM book
WHERE book_name = 'Внутри убийцы';

DELETE
FROM author
WHERE author_id = 10;

SELECT a.name,
       a.nationality,
       avg(b.page_quantity)
FROM author AS a
         JOIN book_author_link AS bal ON a.author_id = bal.author_id
         JOIN book AS b ON bal.book_id = b.book_id
GROUP BY a.name, a.nationality, a.birthday_date
ORDER BY EXTRACT(YEAR FROM a.birthday_date);

SELECT a.name,
       a.nationality,
       avg(b.page_quantity)
FROM author AS a
         JOIN book_author_link AS bal ON a.author_id = bal.author_id
         JOIN book AS b ON bal.book_id = b.book_id
GROUP BY a.name, a.nationality, a.birthday_date
HAVING avg(b.page_quantity) > 300;

SELECT a.name,
       (SELECT avg(page_quantity) AS number_of_pages
        FROM book) AS avg_number_all_authors,
       avg(page_quantity)
FROM author AS a
         JOIN book_author_link AS bal ON a.author_id = bal.author_id
         JOIN book b on bal.book_id = b.book_id
GROUP BY a.name
HAVING avg(b.page_quantity) > (SELECT avg(page_quantity) AS number_of_pages FROM book);

