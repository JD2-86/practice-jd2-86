CREATE DATABASE design_relational_database;

CREATE SCHEMA user_schema;

CREATE TABLE user_schema.operation
(
    operation_id SERIAL PRIMARY KEY,
    operation_name VARCHAR (128) NOT NULL
);

INSERT INTO user_schema.operation (operation_name)
VALUES ('CREATE'),
       ('READ'),
       ('UPDATE'),
       ('DELETE');

CREATE TABLE user_schema.object
(
    object_id SERIAL PRIMARY KEY,
    object_name VARCHAR(32) NOT NULL
);

INSERT INTO user_schema.object (object_name)
VALUES ('USER'),
       ('DOCUMENT'),
       ('WORKFLOW'),
       ('DICTIONARY');

CREATE TABLE user_schema.permission
(
    permission_id SERIAL PRIMARY KEY,
    operation_id INTEGER REFERENCES user_schema.operation(operation_id),
    object_id INTEGER REFERENCES user_schema.object(object_id)
);

INSERT INTO user_schema.permission (operation_id, object_id)
VALUES (1,1),
       (1,2),
       (1,3),
       (1,4),
       (2,1),
       (2,2),
       (2,3),
       (2,4),
       (3,1),
       (3,2),
       (3,3),
       (3,4),
       (4,1),
       (4,2),
       (4,3),
       (4,4);

CREATE TABLE user_schema.role (
                                  role_id SERIAL PRIMARY KEY,
                                  role_name VARCHAR(16) NOT NULL
);

INSERT INTO user_schema.role(role_name)
VALUES ('USER'),
       ('ADMIN'),
       ('GUEST');


CREATE TABLE user_schema.role_permission(
                                            role_id INTEGER REFERENCES user_schema.role(role_id),
                                            permission_id INTEGER REFERENCES user_schema.permission(permission_id),
                                            PRIMARY KEY (role_id,permission_id)
);

INSERT INTO user_schema.role_permission(role_id, permission_id)
VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),
       (2,1),(2,2),(2,3),(2,4),(2,5),(2,6),(2,7),(2,8),(2,9),(2,10),(2,11),(2,12), (2,13),(2,14),(2,15), (2,16),
       (3,5),(3,6), (3,7), (3,8);

CREATE TABLE user_schema.group
(
    group_id SERIAL PRIMARY KEY,
    group_name VARCHAR(64) NOT NULL,
    role_id INTEGER REFERENCES user_schema.role(role_id)
);

INSERT INTO user_schema.group(group_name, role_id)
VALUES ('MANAGEMENT',1),
       ('IT', 2),
       ('HR',1),
       ('SALES',3),
       ('MARKETING',3);

CREATE TABLE user_schema.birthday
(
    birthday DATE PRIMARY KEY,
    age INTEGER NOT NULL
        CHECK ( age > -1 )
);

INSERT INTO user_schema.birthday (birthday, age)
VALUES ('1989-12-22',32);

CREATE TABLE user_schema.user
(
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(64) UNIQUE NOT NULL,
    password VARCHAR(64) NOT NULL
        CHECK ( length(password) > 6),
    email VARCHAR(64) NOT NULL,
    first_name VARCHAR(64) NOT NULL,
    last_name VARCHAR(64) NOT NULL,
    birthday DATE REFERENCES user_schema.birthday(birthday),
    group_id INTEGER REFERENCES user_schema.group(group_id)
);

INSERT INTO user_schema.user(username, password, email, first_name, last_name, birthday, group_id)
VALUES ('alex_s','qwerty123','alex@smith.com','Alex','Smith','1989-12-22',1);