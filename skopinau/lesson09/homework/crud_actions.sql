-- список всех работников и их данных с датой присвоения последнего звания звания
SELECT surname, birthday, p.title AS position, s.title AS subdivision, r.title rank, rl.getting_date AS rank_date
FROM employee_base_link AS ebl
         JOIN employee AS e ON e.id = ebl.employee_id
         JOIN position AS p ON p.id = ebl.position_id
         JOIN subdivision AS s ON s.id = ebl.subdivision_id
         JOIN rank AS r ON r.id = ebl.rank_id
         JOIN rank_log AS rl ON rl.rank_id = r.id AND rl.employee_id = e.id
ORDER BY r.id;

-- список всех званий с фамилиями работников, имеющих это звание
SELECT r.title AS rank, e.surname
FROM rank AS r
         LEFT JOIN employee_base_link AS ebl ON r.id = ebl.rank_id
         LEFT JOIN employee AS e ON ebl.employee_id = e.id
ORDER BY r.id, e.surname;

-- самый старший капитан
SELECT e.surname, e.birthday
FROM employee AS e
         JOIN employee_base_link AS ebl ON e.id = ebl.employee_id
         JOIN rank AS r ON ebl.rank_id = r.id
WHERE r.title = 'капитан'
ORDER BY e.birthday
LIMIT 1;

-- сколько старших лейтенантов работает в ПАСО-2
SELECT COUNT(*)
FROM employee_base_link AS ebl
         JOIN subdivision AS s ON ebl.subdivision_id = s.id
         JOIN rank AS r ON ebl.rank_id = r.id
WHERE s.title = 'ПАСО-2' AND r.title = 'старший лейтенант';

-- присвоить звание Семашко
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 3, '2022-01-19', 8, 4);
UPDATE employee_base_link SET rank_id = 4 WHERE employee_id = 8;

-- удалить работника Гуринович
DELETE FROM employee WHERE surname = 'Гуринович';

-- добавить нового работника/ плохо, что в 3 таблицы нужно вносить, нужно нормализовать
INSERT INTO employee VALUES (NEXTVAL('employee_seq'), 'Хвасько', 'Валерий', '1992-10-11');
INSERT INTO employee_base_link VALUES (11, 6, 6, 4);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 346, '2019-08-01', 11, 4);