INSERT INTO pet_project_schema.wallet (wallet)
VALUES (250000);

INSERT INTO pet_project_schema."user"
    (firstname, lastname, email, username, password, wallet_id, userstatus_id)
VALUES ('Elon', 'Mask', 'MaskE@gmail.com', 'Elon', 'ElonMask', 11, 5);

INSERT INTO pet_project_schema.gamestatus (status, date)
VALUES ('planned', '2022-03-08');

INSERT INTO pet_project_schema.gamestatus (status, date)
VALUES ('planned', '2022-03-08');

INSERT INTO pet_project_schema.game (gamestatus_id, fundaddress)
VALUES (4, 'Gasoline Engine Support Fund');

INSERT INTO pet_project_schema.gamedetails
    (game_id, user_id, bet)
VALUES (4, 11, 150000.0),
       (4, 2, 15.5),
       (4, 3, 23.5),
       (4, 4, 17.6),
       (4, 6, 120.0),
       (4, 7, 163.0),
       (4, 8, 600.0),
       (4, 9, 1000.0);

SELECT *
FROM game;

SELECT DISTINCT username
FROM "user";

SELECT status, date
FROM gamestatus
WHERE status = 'planned';

SELECT status, date
FROM gamestatus
WHERE status = 'finished';

SELECT user_id, bet
FROM gamedetails
WHERE game_id = 3 AND gameuserstatus = 'win';

SELECT *
FROM "user"
ORDER BY username DESC;

SELECT game_id, user_id, bet
FROM gamedetails
WHERE gameuserstatus IS NULL;

SELECT game_id, user_id, bet
FROM gamedetails
WHERE gameuserstatus IS NULL
LIMIT 5;

SELECT firstname, lastname, email
FROM "user"
WHERE email LIKE '%.com';

SELECT *
FROM "user"
WHERE userstatus_id IN (3, 4, 5);

SELECT *
FROM "user"
WHERE userstatus_id NOT IN (3, 4, 5);

SELECT *
FROM gamedetails
WHERE game_id = 1
AND bet BETWEEN 250 AND 100000;

SELECT u.firstname AS firstname, g.bet AS bet, g.game_id
FROM "user" AS u,
     gamedetails AS g
WHERE g.user_id = u.user_id AND g.game_id IN (1);

UPDATE gamestatus
SET status = 'finished',
    date = '2021-03-22'
WHERE gamestatus_id = 2;

UPDATE gamedetails
SET gameuserstatus = 'win'
WHERE game_id = 2 AND user_id BETWEEN 1 AND 9;

UPDATE gamedetails
SET gameuserstatus = 'lose'
WHERE game_id = 2 AND user_id = 10;

SELECT *
FROM gamedetails
WHERE game_id = 2;

UPDATE wallet
SET wallet = 72.3 WHERE wallet_id = 1;

UPDATE wallet
SET wallet = 118.3 WHERE wallet_id = 2;

UPDATE wallet
SET wallet = 221.11 WHERE wallet_id = 3;

UPDATE wallet
SET wallet = 308.25 WHERE wallet_id = 4;

UPDATE wallet
SET wallet = 224.51 WHERE wallet_id = 5;

UPDATE wallet
SET wallet = 505 WHERE wallet_id = 6;

UPDATE wallet
SET wallet = 1190.42 WHERE wallet_id = 7;

UPDATE wallet
SET wallet = 11088.61 WHERE wallet_id = 9;

UPDATE wallet
SET wallet = 90000 WHERE wallet_id = 10;