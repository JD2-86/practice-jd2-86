-- task 1

SELECT count(*) AS "User Number"
FROM "user";

SELECT count(DISTINCT "group") AS "Group quantity"
FROM "user";

SELECT avg(age) AS "Average age"
FROM "user";

SELECT max(age) AS "Max age"
FROM "user";

SELECT username
FROM "user"
WHERE email LIKE '%mail%';

SELECT *
FROM "user"
WHERE operations LIKE '%CREATE%'
  AND operations LIKE '%DELETE%';

SELECT "group", count("group")
FROM "user"
WHERE "group" IS NOT NULl
GROUP BY "group";

-- task 2

SELECT "group"
FROM "user"
WHERE age = (SELECT max(age) FROM "user");

SELECT "group",count("group") AS count
FROM "user"
GROUP BY "group"
ORDER BY count DESC
LIMIT 1;

