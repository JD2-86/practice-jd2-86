CREATE DATABASE rbac;

CREATE SCHEMA basics;

CREATE TABLE practice_schema.user
(
    username   VARCHAR(32) NOT NULL PRIMARY KEY,
    password   VARCHAR(32) NOT NULL,
    email      VARCHAR(32) NOT NULL,
    first_name VARCHAR(32) NOT NULL,
    last_name  VARCHAR(32) NOT NULL,
    age        INTEGER     NOT NULL,
    birthday   DATE        NOT NULL,
    "group"    VARCHAR(16),
    operations VARCHAR(128) NOT NULL,
    objects    VARCHAR(64) NOT NULL
);

ALTER TABLE practice_schema.user
ADD COLUMN address VARCHAR(64);

ALTER TABLE practice_schema.user
DROP COLUMN birthday;

DROP TABLE practice_schema.user;

DROP DATABASE rbac;