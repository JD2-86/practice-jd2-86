CREATE DATABASE pet_project;

CREATE SCHEMA pet_project_schema;

CREATE TABLE pet_project_schema.wallet
(
    wallet_id SERIAL,
    wallet DECIMAL,
    CONSTRAINT PK_Wallet PRIMARY KEY (wallet_id)
);

CREATE TABLE pet_project_schema.userStatus
(
    userStatus_id SERIAL,
    status VARCHAR(32),
    CONSTRAINT PK_UserStatus PRIMARY KEY (userStatus_id)
);

CREATE TABLE pet_project_schema.user
(
    user_id SERIAL,
    firstName VARCHAR(32) NOT NULL,
    lastName VARCHAR(32) NOT NULL,
    email VARCHAR(32) NOT NULL,
    userName VARCHAR(32) NOT NULL,
    password VARCHAR(32) NOT NULL,
    wallet_id BIGINT NOT NULL,
    userStatus_id BIGINT NOT NULL,
    CONSTRAINT PK_User PRIMARY KEY (user_id),
    CONSTRAINT FK_User_Wallet FOREIGN KEY (wallet_id) REFERENCES pet_project_schema.wallet(wallet_id),
    CONSTRAINT FK_User_UserStatus FOREIGN KEY (userStatus_id) REFERENCES pet_project_schema.userStatus(userStatus_id),
    CONSTRAINT AK_User_Email UNIQUE (email),
    CONSTRAINT AK_User_UserName UNIQUE (userName)
);

CREATE TABLE pet_project_schema.gameStatus
(
    gameStatus_id SERIAL,
    status VARCHAR(32) NOT NULL,
    date DATE NOT NULL,
    CONSTRAINT PK_GameStatus PRIMARY KEY (gameStatus_id)
);

CREATE TABLE pet_project_schema.game
(
    game_id SERIAL,
    gameStatus_id INTEGER,
    fundAddress VARCHAR(32) NOT NULL,
    CONSTRAINT PK_Game PRIMARY KEY (game_id),
    CONSTRAINT FK_Game_GameStatus FOREIGN KEY (gameStatus_id) REFERENCES pet_project_schema.gameStatus(gameStatus_id)
);

CREATE TABLE pet_project_schema.gameDetails
(
    game_id INTEGER,
    user_id INTEGER,
    bet DECIMAL NOT NULL,
    gameUserStatus VARCHAR(32),
    CONSTRAINT PK_GameDetails PRIMARY KEY (game_id, user_id),
    CONSTRAINT FK_GameDetails_Game FOREIGN KEY (game_id) REFERENCES pet_project_schema.game(game_id),
    CONSTRAINT FK_GameDetails_User FOREIGN KEY (user_id) REFERENCES pet_project_schema.user(user_id)
);
