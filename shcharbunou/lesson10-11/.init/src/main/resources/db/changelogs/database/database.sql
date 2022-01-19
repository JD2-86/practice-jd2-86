--liquibase formatted sql

--changeset rakovets:database-1 dbms:postgresql
-- precondition
CREATE SCHEMA IF NOT EXISTS jdbc;
CREATE SCHEMA IF NOT EXISTS dao;
--rollback DROP SCHEMA jdbc CASCADE;
--rollback DROP SCHEMA dao CASCADE;

--changeset rakovets:database-1 dbms:mariadb
-- precondition
CREATE SCHEMA IF NOT EXISTS jdbc;
CREATE SCHEMA IF NOT EXISTS dao;
--rollback DROP SCHEMA jdbc;
--rollback DROP SCHEMA dao;

--changeset rakovets:database-2 dbms:mariadb
GRANT ALL PRIVILEGES ON jdbc.* TO 'mariadb'@'%';
GRANT ALL PRIVILEGES ON dao.* TO 'mariadb'@'%';
--rollback REVOKE ALL PRIVILEGES ON jdbc.* FROM 'mariadb'@'%';
--rollback REVOKE ALL PRIVILEGES ON dao.* FROM 'mariadb'@'%';