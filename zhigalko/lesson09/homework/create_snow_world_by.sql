CREATE DATABASE snow_world_database;

CREATE SCHEMA rent;

CREATE TABLE rent.image
(
    image_id   SERIAL PRIMARY KEY,
    image_name VARCHAR(128) UNIQUE NOT NULL
);

INSERT INTO rent.image (image_name)
VALUES ('imgJacket1.png'),
       ('imgJacket2.png'),
       ('imgPants1.png'),
       ('imgPants2.png'),
       ('imgSnbHelmet1.png'),
       ('imgSnbHelmet2.png'),
       ('imgSkiHelmet1.png'),
       ('imgSkiHelmet2.png'),
       ('imgMittens1.png'),
       ('imgGloves1.png'),
       ('imgMask1.png'),
       ('imgMask2.png'),
       ('imgSNB1.png'),
       ('imgSNB2.png'),
       ('imgSKI1.png'),
       ('imgSKI2.png'),
       ('imgSkiPole1.png'),
       ('imgSkiPole2.png'),
       ('imgSnbBoots1.png'),
       ('imgSnbBoots2.png'),
       ('imgSkiBoots1.png'),
       ('imgSkiBoots2.png'),
       ('imgCap1.png'),
       ('imgCap2.png');

CREATE TABLE rent.equipment_size
(
    equipment_size_id VARCHAR(12) PRIMARY KEY,
    min_height        INTEGER
        CHECK (min_height > 39),
    max_height        INTEGER
        CHECK (max_height < 250),
    min_weight        INTEGER
        CHECK (min_weight > 30),
    max_weight        INTEGER
        CHECK (max_weight < 150)
);

INSERT INTO rent.equipment_size
(equipment_size_id, min_height, max_height, min_weight, max_weight)
VALUES ('XS', NULL, NULL, NULL, NULL),
       ('S', NULL, NULL, NULL, NULL),
       ('M', NULL, NULL, NULL, NULL),
       ('L', NULL, NULL, NULL, NULL),
       ('XL', NULL, NULL, NULL, NULL),
       ('XXL', NULL, NULL, NULL, NULL),
       ('SN134', 140, 145, 40, 45),
       ('SN136', 145, 150, 40, 45),
       ('SN138', 145, 150, 45, 50),
       ('SN139', 150, 160, 45, 55),
       ('SN140', 150, 165, 50, 60),
       ('SN141', 155, 165, 50, 60),
       ('SN142', 155, 160, 60, 65),
       ('SN143', 160, 170, 50, 60),
       ('SN145', 160, 170, 55, 65),
       ('SN148', 165, 175, 55, 75),
       ('SN149', 160, 165, 65, 70),
       ('SN150', 160, 175, 60, 75),
       ('SN151', 160, 175, 65, 80),
       ('SN152', 165, 180, 60, 75),
       ('SN153', 160, 180, 65, 80),
       ('SN154', 165, 175, 70, 80),
       ('SN155', 165, 180, 70, 85),
       ('SN156', 165, 185, 65, 90),
       ('SN157', 170, 190, 70, 85),
       ('SN158', 170, 190, 75, 95),
       ('SN159', 170, 195, 75, 100),
       ('SN160', 175, 195, 80, 110),
       ('SN161', 190, 195, 85, 90),
       ('SN162', 180, 200, 85, 105),
       ('SN163', 180, 200, 90, 115),
       ('SN164', 190, 200, 100, 105),
       ('SN165', 185, 205, 95, 105),
       ('SN166', 200, 205, 105, 120),
       ('SN167', 195, 210, 105, 115),
       ('SN168', 190, 205, 110, 120),
       ('SN170', 205, 210, 110, 115),
       ('SN172', 190, 210, 115, 130),
       ('SN175', 195, 205, 120, 130),
       ('SN180', 165, 185, 120, 130),
       ('SK135', 145, 150, NULL, NULL),
       ('SK137', 147, 152, NULL, NULL),
       ('SK140', 150, 155, NULL, NULL),
       ('SK142', 147, 158, NULL, NULL),
       ('SK145', 155, 160, NULL, NULL),
       ('SK148', 158, 163, NULL, NULL),
       ('SK150', 160, 165, NULL, NULL),
       ('SK152', 162, 167, NULL, NULL),
       ('SK154', 159, 169, NULL, NULL),
       ('SK155', 165, 170, NULL, NULL),
       ('SK157', 167, 172, NULL, NULL),
       ('SK159', 169, 174, NULL, NULL),
       ('SK161', 171, 176, NULL, NULL),
       ('SK163', 173, 178, NULL, NULL),
       ('SK165', 175, 180, NULL, NULL),
       ('SK167', 177, 182, NULL, NULL),
       ('SK169', 179, 184, NULL, NULL),
       ('SK170', 180, 185, NULL, NULL),
       ('SK172', 182, 187, NULL, NULL),
       ('SK174', 184, 189, NULL, NULL),
       ('SK175', 185, 190, NULL, NULL),
       ('SK177', 187, 192, NULL, NULL),
       ('SK179', 189, 194, NULL, NULL),
       ('SK181', 191, 196, NULL, NULL),
       ('SK183', 193, 198, NULL, NULL),
       ('SK185', 195, 200, NULL, NULL),
       ('SK190', 200, 205, NULL, NULL),
       ('SK193', 203, 208, NULL, NULL),
       ('SK195', 205, 210, NULL, NULL),
       ('SP90', 125, 132, NULL, NULL),
       ('SP95', 133, 139, NULL, NULL),
       ('SP100', 140, 146, NULL, NULL),
       ('SP105', 147, 152, NULL, NULL),
       ('SP110', 153, 160, NULL, NULL),
       ('SP115', 161, 165, NULL, NULL),
       ('SP120', 166, 173, NULL, NULL),
       ('SP125', 174, 181, NULL, NULL),
       ('SP130', 182, 189, NULL, NULL),
       ('SP135', 190, 210, NULL, NULL);

CREATE TABLE rent.equipment
(
    equipment_id SERIAL PRIMARY KEY,
    product_group_name VARCHAR(64) NOT NULL,
    image_id         INTEGER REFERENCES rent.image (image_id),
    maker            VARCHAR(64)   NOT NULL,
    boot_size         INTEGER,
    CHECK (boot_size > 30),
    CHECK (boot_size < 46),
    membrane INTEGER
        CHECK (membrane > 3000),
        CHECK (membrane < 25000),
    gender            VARCHAR(6),
    lacing_system     VARCHAR(32),
    riding_level      VARCHAR(32),
    equipment_size_id VARCHAR(8) REFERENCES rent.equipment_size (equipment_size_id),
    hardness_level    VARCHAR(32),
    available         BOOLEAN       NOT NULL,
    cost              DECIMAL(5, 2) NOT NULL
        CHECK (cost > 0)
);

INSERT INTO rent.equipment (product_group_name, image_id, maker, boot_size, membrane, gender, lacing_system,
                            riding_level, equipment_size_id, hardness_level, available, cost)
VALUES ('Куртка', 1,'Quicksilver', NULL, 15000, 'Male', NULL, NULL, 'XL', NULL, TRUE, 7.0),
       ('Штаны', 3,'Quicksilver', NULL, 15000, 'Male', NULL, NULL, 'L', NULL, TRUE, 5.0),
       ('Куртка', 2,'ROXY', NULL, 15000, 'Female', NULL, NULL, 'L', NULL, TRUE, 7.0),
       ('Штаны', 4,'ROXY', NULL, 15000, 'Female', NULL, NULL, 'M', NULL, TRUE, 5.0),
       ('Шапка', 23,'DC SHOES', NULL, NULL, 'UNISEX', NULL, NULL, 'M', NULL, TRUE, 2.0),
       ('Шапка', 23,'DC SHOES', NULL, NULL, 'UNISEX', NULL, NULL, 'S', NULL, TRUE, 2.0),
       ('Варежки', 9,'CRAB GRAB', NULL, 15000, 'UNISEX', NULL, NULL, 'M',NULL, TRUE, 2.0),
       ('Перчатки', 10,'POW', NULL, 15000, 'UNISEX', NULL, NULL, 'L',NULL, TRUE, 2.0),
       ('Маска', 11,'PRIME', NULL, NULL, 'UNISEX', NULL, NULL, NULL,NULL, TRUE, 2.0),
       ('Маска', 12,'TERROR', NULL, NULL, 'UNISEX', NULL, NULL, NULL,NULL, TRUE, 2.0),
       ('Сноуборд', 13,'ROSSIGNOL', NULL, NULL, 'UNISEX', NULL, 'Новичок', 'SN152', '3/10', TRUE, 10.0),
       ('Сноуборд', 14,'PRIME', NULL, NULL, 'UNISEX', NULL, 'Новичок', 'SN157', '1/10', TRUE, 10.0),
       ('Ботинки сноубордные', 19,'NITRO', 42, NULL, 'Male', 'BOA(кнопка)', NULL, NULL, NULL, TRUE, 7.0),
       ('Ботинки сноубордные', 20,'DC SHOES', 38, NULL, 'Female', 'Шнурки', NULL, NULL, NULL, TRUE, 7.0),
       ('Шлем сноубордный', 5,'PRIME', NULL, NULL, 'UNISEX', NULL, NULL, 'L', NULL, TRUE, 3.0),
       ('Шлем сноубордный', 6,'NITRO', NULL, NULL, 'UNISEX', NULL, NULL, 'M', NULL, TRUE, 3.0),
       ('Лыжи', 15,'ROSSIGNOL', NULL, NULL, 'UNISEX', NULL, 'Новичок', 'SK148', NULL, TRUE, 10.0),
       ('Лыжи', 16,'SALOMON', NULL, NULL, 'UNISEX', NULL, 'Новичок', 'SK161', NULL, TRUE, 10.0),
       ('Палки лыжные', 17,'FISCHER', NULL, NULL, 'UNISEX', NULL, NULL, 'SP115', NULL, TRUE, 2.0),
       ('Палки лыжные', 18,'FISCHER', NULL, NULL, 'UNISEX', NULL, NULL, 'SP125', NULL, TRUE, 2.0),
       ('Ботинки лыжные',21,'Atomic',43,NULL,'Male',NULL,NULL,NULL,NULL,TRUE,7.0),
       ('Ботинки лыжные',22,'Atomic',38,NULL,'Female',NULL,NULL,NULL,NULL,TRUE,7.0),
       ('Шлем лыжный', 7,'Glissade', NULL, NULL, 'UNISEX', NULL, NULL, 'L', NULL, TRUE, 3.0),
       ('Шлем лыжный', 8,'Alpina Sports', NULL, NULL, 'UNISEX', NULL, NULL, 'M', NULL, TRUE, 3.0);

CREATE TABLE rent.action
(
    action_id   SERIAL PRIMARY KEY,
    action_name VARCHAR(64) NOT NULL UNIQUE
);

INSERT INTO rent.action(action_name)
VALUES ('Добавить в корзину'),
       ('Просмотреть корзину'),
       ('Удалить из корзины'),
       ('Оформить заказ'),
       ('Внести предоплату'),
       ('Посмотреть историю заказов'),
       ('Регистрация'),
       ('Авторизация'),
       ('Изменить данные пользователя'),
       ('Удалить пользователя'),
       ('Редактировать доступность снаряжения'),
       ('Изменить стоимость проката');

CREATE TABLE rent.role
(
    role_id   SERIAL PRIMARY KEY,
    role_name VARCHAR(32) NOT NULL UNIQUE
);

INSERT INTO rent.role(role_name)
VALUES ('Guest'),
       ('User'),
       ('Admin');

CREATE TABLE rent.role_action_link
(
    role_id   INTEGER REFERENCES rent.role (role_id),
    action_id INTEGER REFERENCES rent.action (action_id)
);

INSERT INTO rent.role_action_link (role_id, action_id)
VALUES (1, 7),
       (1, 8),
       (2, 1),
       (2, 2),
       (2, 3),
       (2, 4),
       (2, 5),
       (2, 6),
       (2, 7),
       (2, 8),
       (2, 9),
       (3, 1),
       (3, 2),
       (3, 3),
       (3, 4),
       (3, 5),
       (3, 6),
       (3, 7),
       (3, 8),
       (3, 10),
       (3, 11),
       (3, 12);

CREATE TABLE rent.user
(
    user_id     SERIAL PRIMARY KEY,
    username    VARCHAR(32),
    password    VARCHAR(32)
        CHECK (length(password) > 6),
    email       VARCHAR(64),
    first_name  VARCHAR(32),
    last_name   VARCHAR(32),
    gender      VARCHAR(6),
    user_height INTEGER
        CHECK ( user_height > 50 ),
        CHECK ( user_height < 230 ),
    user_weight INTEGER
        CHECK (user_weight > 20),
        CHECK (user_weight < 150),
    boot_size INTEGER
        CHECK (boot_size > 30),
        CHECK (boot_size < 46),
    role_id INTEGER REFERENCES rent.role(role_id)
);

INSERT INTO rent.user (username, password, email, first_name, last_name,
                       gender, user_height, user_weight,boot_size, role_id)
VALUES ('admin_admin','qwerty321','admin@admin.com',NULL,NULL,NULL,NULL,NULL,NULL,3),
       (NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),
       ('alex_s','alexsmith2022','alex@smith.com','Alex','Smith','Male',180,75,43,2),
       ('barb_ara21','bar!123','barbara@walloum.com','Barbara','Walloum','Female',167,55,38,2),
       ('nicolas_bart','nicbart1','nicolas@bart.com','Nicolas','Bart','Male',187,86,45,2),
       ('carol_mitchell','carmi12345','car@mitch.com','Caroline',NULL,'Female',170,59,37,2),
       ('tom_son','tttson123','tom@somain.com',NULL,NULL,'Male',193,90,44,2),
       ('harry_clum','harry3124','harry@clum.com','Harry','Clum','Male',187,86,45,2),
       ('jessica_norwith','norw_jes','jess@norwith.com','Jess','Norwith','Female',160,53,38,2),
       ('mark_arrow','markarrow3','mark@arrow.com','Mark','Arrow','Male',176,80,43,2);

CREATE TABLE rent.order_history
(
    order_id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES rent.user(user_id),
    order_date             TIMESTAMP     NOT NULL,
    reservation_number_day INTEGER       NOT NULL
        CHECK (reservation_number_day > 0)
);

INSERT INTO rent.order_history (user_id, order_date, reservation_number_day)
VALUES (3,'2021-12-21 16:05:32',2),
       (4,'2021-12-20 14:12:21',1),
       (5,'2022-01-10 12:12:45',3),
       (6,'2022-01-11 12:12:45',1);

CREATE TABLE rent.orderhistory_equipment_link
(
    order_id INTEGER REFERENCES rent.order_history(order_id),
    equipment_id INTEGER REFERENCES rent.equipment(equipment_id),
    PRIMARY KEY (order_id,equipment_id)
);

INSERT INTO rent.orderhistory_equipment_link (order_id, equipment_id)
VALUES (1,1),
       (1,2),
       (1,3),
       (2,4),
       (2,5),
       (2,6),
       (3,7),
       (3,8),
       (3,9),
       (3,10),
       (3,11),
       (4,12),
       (4,13);


CREATE TABLE rent.cart
(
    cart_id                INTEGER REFERENCES rent.user (user_id) PRIMARY KEY,
    start_reservation_date TIMESTAMP NOT NULL,
    reservation_number_day INTEGER   NOT NULL
        CHECK (reservation_number_day > 0)
);

INSERT INTO rent.cart (cart_id, start_reservation_date, reservation_number_day)
VALUES (3,'2021-12-21 16:05:32',1),
       (4,'2022-01-12 12:35:46',3),
       (5,'2021-12-18 15:05:00',2),
       (6,'2022-01-03 11:03:00',1),
       (7,'2021-12-27 12:00:00',4),
       (8,'2021-12-29 14:00:00',5),
       (9,'2022-01-15 15:00:00',2),
       (10,'2021-12-20 18:00:00',2);

CREATE TABLE rent.cart_equipment_link
(
    cart_id INTEGER REFERENCES rent.cart(cart_id),
    equipment_id INTEGER REFERENCES rent.equipment(equipment_id),
    PRIMARY KEY (cart_id, equipment_id)
);

INSERT INTO rent.cart_equipment_link (cart_id, equipment_id)
VALUES (3,1),
       (3,2),
       (3,11),
       (3,13),
       (4,3),
       (4,4),
       (4,6),
       (4,12),
       (4,13),
       (5,11),
       (5,13),
       (6,24),
       (6,18),
       (6,21),
       (6,17),
       (7,11),
       (7,13),
       (7,9),
       (8,10),
       (8,20),
       (8,22),
       (8,24),
       (9,11),
       (9,13),
       (9,15),
       (10,1),
       (10,2),
       (10,9),
       (10,12),
       (10,16);
