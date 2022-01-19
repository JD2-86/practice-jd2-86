CREATE SEQUENCE employee_seq START 1 INCREMENT 1;

INSERT INTO employee VALUES (NEXTVAL('employee_seq'), 'Скопинов', 'Дмитрий', '1993-03-17');
INSERT INTO employee VALUES (NEXTVAL('employee_seq'), 'Панасик', 'Дмитрий', '1994-04-24');
INSERT INTO employee VALUES (NEXTVAL('employee_seq'), 'Карпеленя', 'Андрей', '1992-12-31');
INSERT INTO employee VALUES (NEXTVAL('employee_seq'), 'Гуринович', 'Андрей', '1995-11-12');
INSERT INTO employee VALUES (NEXTVAL('employee_seq'), 'Герасим', 'Ирина', '1990-10-15');
INSERT INTO employee VALUES (NEXTVAL('employee_seq'), 'Захаревич', 'Евгений', '1993-02-10');
INSERT INTO employee VALUES (NEXTVAL('employee_seq'), 'Варкович', 'Юрий', '1989-05-29');
INSERT INTO employee VALUES (NEXTVAL('employee_seq'), 'Семашко', 'Никита', '1997-09-29');
INSERT INTO employee VALUES (NEXTVAL('employee_seq'), 'Радомский', 'Дмитрий', '1975-06-03');
INSERT INTO employee VALUES (NEXTVAL('employee_seq'), 'Скобля', 'Назар', '1995-07-21');

CREATE SEQUENCE position_seq START 1 INCREMENT 1;

INSERT INTO position VALUES (NEXTVAL('position_seq'), 'начальник отдела');
INSERT INTO position VALUES (NEXTVAL('position_seq'), 'зам. начальник отдела');
INSERT INTO position VALUES (NEXTVAL('position_seq'), 'начальник части');
INSERT INTO position VALUES (NEXTVAL('position_seq'), 'начальник отряда');
INSERT INTO position VALUES (NEXTVAL('position_seq'), 'старший инженер');
INSERT INTO position VALUES (NEXTVAL('position_seq'), 'старший инспектор');
INSERT INTO position VALUES (NEXTVAL('position_seq'), 'инспектор');
INSERT INTO position VALUES (NEXTVAL('position_seq'), 'начальник караула');
INSERT INTO position VALUES (NEXTVAL('position_seq'), 'начальник дежурной смены');
INSERT INTO position VALUES (NEXTVAL('position_seq'), 'главный специалист');

CREATE SEQUENCE subdivision_seq START 1 INCREMENT 1;

INSERT INTO subdivision VALUES (NEXTVAL('subdivision_seq'), 'руководство');
INSERT INTO subdivision VALUES (NEXTVAL('subdivision_seq'), 'СИРиКО');
INSERT INTO subdivision VALUES (NEXTVAL('subdivision_seq'), 'ПАСЧ-1');
INSERT INTO subdivision VALUES (NEXTVAL('subdivision_seq'), 'ПАСО-2');
INSERT INTO subdivision VALUES (NEXTVAL('subdivision_seq'), 'ПАСЧ-3');
INSERT INTO subdivision VALUES (NEXTVAL('subdivision_seq'), 'ИНиП');
INSERT INTO subdivision VALUES (NEXTVAL('subdivision_seq'), 'ПАСП-11');
INSERT INTO subdivision VALUES (NEXTVAL('subdivision_seq'), 'ПАСП-12');
INSERT INTO subdivision VALUES (NEXTVAL('subdivision_seq'), 'ПАСП-13');
INSERT INTO subdivision VALUES (NEXTVAL('subdivision_seq'), 'ПАСП-14');

CREATE SEQUENCE rank_seq START 1 INCREMENT 1;

INSERT INTO rank VALUES (NEXTVAL('rank_seq'), 'полковник');
INSERT INTO rank VALUES (NEXTVAL('rank_seq'), 'подполковник');
INSERT INTO rank VALUES (NEXTVAL('rank_seq'), 'майор');
INSERT INTO rank VALUES (NEXTVAL('rank_seq'), 'капитан');
INSERT INTO rank VALUES (NEXTVAL('rank_seq'), 'старший лейтенант');
INSERT INTO rank VALUES (NEXTVAL('rank_seq'), 'лейтенант');
INSERT INTO rank VALUES (NEXTVAL('rank_seq'), 'младший лейтенант');
INSERT INTO rank VALUES (NEXTVAL('rank_seq'), 'старший прапорщик');
INSERT INTO rank VALUES (NEXTVAL('rank_seq'), 'прапорщик');
INSERT INTO rank VALUES (NEXTVAL('rank_seq'), 'старшина');
INSERT INTO rank VALUES (NEXTVAL('rank_seq'), 'старший сержант');
INSERT INTO rank VALUES (NEXTVAL('rank_seq'), 'сержант');
INSERT INTO rank VALUES (NEXTVAL('rank_seq'), 'младший сержант');
INSERT INTO rank VALUES (NEXTVAL('rank_seq'), 'рядовой');

INSERT INTO employee_base_link VALUES (1, 7, 2, 4);
INSERT INTO employee_base_link VALUES (2, 9, 4, 5);
INSERT INTO employee_base_link VALUES (3, 8, 5, 5);
INSERT INTO employee_base_link VALUES (4, 7, 6, 5);
INSERT INTO employee_base_link VALUES (5, 6, 2, 4);
INSERT INTO employee_base_link VALUES (6, 6, 4, 4);
INSERT INTO employee_base_link VALUES (7, 5, 6, 3);
INSERT INTO employee_base_link VALUES (8, 6, 6, 5);
INSERT INTO employee_base_link VALUES (9, 2, 1, 2);
INSERT INTO employee_base_link VALUES (10, 9, 4, 5);

CREATE SEQUENCE rank_log_seq START 1 INCREMENT 1;

INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 455, '2004-07-25', 9, 6);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 367, '2006-08-01', 9, 5);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 498, '2009-08-01', 9, 4);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 12, '2013-01-19', 9, 3);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 239, '2013-08-01', 7, 6);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 18, '2014-07-25', 1, 6);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 18, '2014-07-25', 6, 6);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 220, '2015-08-01', 7, 5);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 425, '2015-11-01', 5, 6);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 276, '2016-08-01', 1, 5);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 276, '2016-08-01', 10, 6);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 276, '2016-08-01', 6, 5);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 276, '2016-08-01', 4, 6);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 351, '2016-09-01', 2, 6);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 19, '2017-01-19', 3, 6);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 489, '2017-11-01', 5, 5);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 315, '2018-07-25', 8, 6);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 345, '2018-08-01', 10, 5);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 345, '2018-08-01', 7, 4);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 346, '2019-08-01', 3, 5);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 346, '2019-08-01', 1, 4);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 346, '2019-08-01', 9, 2);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 553, '2019-10-01', 4, 5);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 553, '2019-10-01', 2, 5);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 362, '2020-08-01', 8, 5);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 488, '2020-11-01', 5, 4);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 10, '2021-01-25', 6, 4);
INSERT INTO rank_log VALUES (NEXTVAL('rank_log_seq'), 401, '2021-08-01', 7, 3);
