CREATE TABLE authors(
                        id_author INTEGER,
                        name_author VARCHAR(32),
                        birthday_author DATE,
                        nationality_author VARCHAR(32)
);

INSERT INTO authors (id_author, name_author, birthday_author, nationality_author)
VALUES
    (1, 'Джошуа Блох', '1979-02-28', 'США'),
    (2, 'Роберт Мартин', '1968-06-14', 'США'),
    (3, 'Кей Хорстманн', '1976-11-06', 'Канада'),
    (4, 'Эрик Фримен', '1977-09-17', 'Англия'),
    (5, 'Элизабет Робсон', '1973-01-22', 'Англия'),
    (6, 'Крейг Уолсон', '1966-03-30', 'США'),
    (7, 'Фёдор Достоевский', '1877-11-11', 'Россия');
