# Write your MySQL query statement below
-- SELECT 
--     CONCAT(
--         UPPER(LEFT(name,1)),
--         LOWER(SUBSTRING(name,2))
--     ) AS fixed_name
-- FROM Users;




select user_id,concat(upper(left(name,1)),
LOWER(substring(name,2)) ) as name
From Users order by user_id;


