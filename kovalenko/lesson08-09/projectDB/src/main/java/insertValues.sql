INSERT INTO pet_project_schema.userstatus (status)
VALUES
       ('normal'),
       ('bronze'),
       ('silver'),
       ('gold'),
       ('vip');

INSERT INTO pet_project_schema.wallet (wallet)
VALUES
       (10.0),
       (25.0),
       (50.0),
       (75.0),
       (100.0),
       (250.0),
       (500.0),
       (1000.0),
       (10000.0),
       (100000.0);

INSERT INTO pet_project_schema.user
    (firstname, lastname, email, username, password, wallet_id, userstatus_id)
VALUES ('Yoel', 'Miller', 'MillerY@gmail.com', 'Yoel', 'YoelMiller', 1, 1),
       ('Dania', 'Barnes', 'BarnesD@gmail.com', 'Dania', 'DaniaBarnes', 2, 1),
       ('Izaac', 'Diaz', 'DiazI@gmail.com', 'Izaac', 'IzaacDiaz', 3, 1),
       ('Orilla', 'Hill', 'HillO@gmail.com', 'Orilla', 'OrillaHill', 4, 1),
       ('Norman', 'Bryant', 'BryantN@gmail.com', 'Norman', 'NormanBryant', 5, 2),
       ('Margaret', 'Thompson', 'ThompsonM@gmail.com', 'Margaret', 'MargaretThompson', 6, 2),
       ('Salem', 'Jackson', 'JacksonS@gmail.com', 'Salem', 'SalemJackson', 7, 3),
       ('Faith', 'Baker', 'BakerF@gmail.com', 'Faith', 'FaithBaker', 8, 3),
       ('Jax', 'Henderson', 'HendersonJ@gmail.com', 'Jax', 'JaxHenderson', 9, 4),
       ('Magnus', 'Carlsen', 'CarlsenM@gmail.com', 'Magnus', 'MagnusCarlsen', 10, 5);

INSERT INTO pet_project_schema.gamestatus (status, date)
VALUES ('planned', '2022-02-12'),
       ('during', '2021-01-07'),
       ('finished', '2021-12-31');

INSERT INTO pet_project_schema.game (gamestatus_id, fundaddress)
VALUES (3, 'Insect Eviction Foundation'),
       (2, 'Assistance to cats who are there'),
       (1, 'The Wind of Change Foundation');

INSERT INTO pet_project_schema.gamedetails
    (game_id, user_id, bet, gameuserstatus)
VALUES (3, 1, 10.0, 'win'),
       (3, 3, 45.0, 'win'),
       (3, 4, 25.0, 'win'),
       (3, 6, 105.0, 'win'),
       (3, 8, 95.0, 'win'),
       (3, 10, 1000.0, 'lose');

INSERT INTO pet_project_schema.gamedetails
    (game_id, user_id, bet)
VALUES (2, 1, 20.0),
       (2, 2, 30.0),
       (2, 3, 55.0),
       (2, 4, 75.0),
       (2, 5, 40.0),
       (2, 6, 82.0),
       (2, 7, 222.0),
       (2, 9, 350.0),
       (2, 10, 10000.0);

INSERT INTO pet_project_schema.gamedetails
    (game_id, user_id, bet)
VALUES (1, 1, 15.0),
       (1, 2, 66.0),
       (1, 3, 29.0),
       (1, 4, 45.0),
       (1, 5, 90.0),
       (1, 6, 162.0),
       (1, 7, 137.0),
       (1, 8, 263.0),
       (1, 9, 501.0),
       (1, 10, 50000.0);
