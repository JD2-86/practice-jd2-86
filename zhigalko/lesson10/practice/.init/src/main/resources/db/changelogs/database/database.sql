--liquibase formatted sql

--changeset rakovets:database-1 dbms:postgresql
-- precondition
CREATE SCHEMA IF NOT EXISTS jdbc;
--rollback DROP SCHEMA jdbc CASCADE;

--changeset rakovets:database-1 dbms:mariadb
-- precondition
CREATE SCHEMA IF NOT EXISTS jdbc;
--rollback DROP SCHEMA jdbc;

--changeset rakovets:database-2 dbms:mariadb
GRANT ALL PRIVILEGES ON jdbc.* TO 'mariadb'@'%';
--rollback REVOKE ALL PRIVILEGES ON jdbc.* FROM 'mariadb'@'%';