SELECT product_group_name,
       image_id,
       maker,
       riding_level,
       equipment_size_id,
       cost
FROM rent.equipment
WHERE product_group_name = 'Сноуборд';

SELECT es.equipment_size_id,
       es.min_height,
       es.max_height,
       es.min_weight,
       es.max_weight,
       eq.available,
       eq.cost
FROM equipment AS eq
         JOIN equipment_size es ON eq.equipment_size_id = es.equipment_size_id
WHERE min_height > 168
  AND product_group_name = 'Сноуборд';

SELECT eq.boot_size,
       eq.available,
       eq.cost
FROM equipment AS eq
WHERE boot_size = 43;

SELECT eq.product_group_name,
       i.image_name
FROM equipment AS eq
         JOIN image i on eq.image_id = i.image_id
WHERE product_group_name = 'Сноуборд';

SELECT c.cart_id,
       eq.product_group_name,
       eq.maker,
       eq.cost
FROM equipment AS eq
         JOIN cart_equipment_link AS cel ON cel.equipment_id = eq.equipment_id
         JOIN cart c on cel.cart_id = c.cart_id
WHERE c.cart_id = 10;

SELECT sum(eq.cost)
FROM equipment AS eq
         JOIN cart_equipment_link AS cel ON cel.equipment_id = eq.equipment_id
         JOIN cart c on cel.cart_id = c.cart_id
WHERE c.cart_id = 10;

SELECT eq.product_group_name,
       es.equipment_size_id,
       eq.available,
       eq.cost
FROM equipment AS eq
         JOIN equipment_size es ON eq.equipment_size_id = es.equipment_size_id
WHERE es.min_height > 150;

SELECT eq.product_group_name,
       eq.boot_size,
       eq.cost
FROM equipment AS eq
WHERE eq.product_group_name = 'Ботинки лыжные'
  AND eq.boot_size = 43;

SELECT count(*) AS "Количество пользователей"
FROM "user"
WHERE role_id = 2;

SELECT eq.product_group_name,
       es.equipment_size_id,
       eq.maker,
       eq.cost
FROM equipment AS eq
         JOIN equipment_size es ON eq.equipment_size_id = es.equipment_size_id
WHERE eq.equipment_size_id = 'L'
   OR eq.equipment_size_id = 'XL'
ORDER BY cost;

SELECT product_group_name,
       i.image_name,
       eq.membrane,
       eq.gender,
       eq.cost
FROM equipment AS eq
         JOIN image i ON eq.image_id = i.image_id
WHERE eq.product_group_name = 'Куртка'
   OR eq.product_group_name = 'Штаны'
ORDER BY eq.gender;

SELECT oh.order_id,
       u.user_id,
       oh.order_date,
       oh.reservation_number_day
FROM order_history AS oh
         JOIN "user" u ON oh.user_id = u.user_id
WHERE u.user_id = 5;

SELECT eq.product_group_name,
       eq.maker,
       eq.membrane,
       es.equipment_size_id,
       eq.cost,
       eq.available
FROM equipment AS eq
         JOIN equipment_size es ON es.equipment_size_id = eq.equipment_size_id
WHERE membrane > 10000
  AND es.equipment_size_id = 'L';

SELECT eq.boot_size,
       eq.lacing_system,
       eq.maker,
       eq.cost
FROM equipment AS eq
WHERE lacing_system LIKE '%BOA%';

SELECT oh.order_date,
       oh.reservation_number_day,
       sum(eq.cost) AS sum
FROM order_history AS oh
         JOIN orderhistory_equipment_link oel ON oh.order_id = oel.order_id
         JOIN equipment eq ON eq.equipment_id = oel.equipment_id
WHERE oh.user_id = 3
GROUP BY oh.reservation_number_day, oh.order_date;

SELECT (order_date)::date,
       eq.product_group_name,
       eq.equipment_id,
       eq.equipment_size_id,
       eq.boot_size,
       eq.cost
FROM order_history AS oh
         JOIN orderhistory_equipment_link oel ON oh.order_id = oel.order_id
         JOIN equipment eq ON eq.equipment_id = oel.equipment_id
WHERE oh.user_id = 6;

SELECT eq.product_group_name,
       i.image_name,
       eq.gender,
       eq.cost
FROM equipment AS eq
         JOIN image i ON eq.image_id = i.image_id
WHERE maker LIKE 'PRIME';


SELECT eq.product_group_name,
       i.image_name,
       eq.maker,
       eq.available,
       eq.cost
FROM equipment AS eq
         JOIN image i ON eq.image_id = i.image_id
         JOIN equipment_size es on es.equipment_size_id = eq.equipment_size_id
ORDER BY eq.cost;


SELECT sum(eq.cost), count(*)
FROM equipment AS eq
         JOIN cart_equipment_link cel ON eq.equipment_id = cel.equipment_id
         JOIN cart c ON c.cart_id = cel.cart_id
WHERE c.cart_id = 6;

SELECT product_group_name,
       maker,
       riding_level,
       es.equipment_size_id,
       es.min_height,
       es.max_height,
       available,
       cost
FROM equipment
         JOIN equipment_size es ON es.equipment_size_id = equipment.equipment_size_id
WHERE product_group_name = 'Лыжи'
   OR product_group_name = 'Палки лыжные';

INSERT INTO rent.image(image_name)
VALUES ('imgSNB3.png');

INSERT INTO rent.equipment (product_group_name, image_id, maker, boot_size,
                            membrane, gender, lacing_system, riding_level, equipment_size_id,
                            hardness_level, available, cost)
VALUES ('Сноуборд', 25, 'NIDECKER', NULL, NULL, 'UNISEX', NULL, 'Опытный', 'SN160', '4/10', TRUE, 12.0);

DELETE
FROM rent."user"
WHERE user_id = 2;

INSERT INTO rent."user"(username, password, email, first_name, last_name, gender, user_height, user_weight, boot_size,
                        role_id)
VALUES ('max2123', 'max213424', 'max@gmail.com', NULL, NULL, 'Male', NULL, NULL, NULL, 2);

DELETE
FROM rent."user"
WHERE username LIKE '%max%';

INSERT INTO rent.order_history (user_id, order_date, reservation_number_day)
VALUES (10, '2022-01-10 12:06:31', 7);

INSERT INTO orderhistory_equipment_link (order_id, equipment_id)
VALUES (5, 13),
       (5, 15),
       (5, 25);

UPDATE rent.equipment
SET maker = 'Alpina Sports'
WHERE equipment_id = 20;

UPDATE order_history
SET user_id = 8
WHERE order_id = 5;

UPDATE "user"
SET first_name = 'Tom',
    last_name  = 'Sonberg'
WHERE user_id = 7;