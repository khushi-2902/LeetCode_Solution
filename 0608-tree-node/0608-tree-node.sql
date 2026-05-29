# Write your MySQL query statement below

SELECT  id,
CASE

    WHEN p_id is null then 'Root'
  
    -- inner
    WHEN id IN (select p_id from Tree where p_id is not NULL) then 'Inner'

     else 'Leaf'

     END AS type
from tree;




-- SELECT id,
--        CASE
--            WHEN p_id IS NULL THEN 'Root'

--            WHEN id IN
--                 (
--                   SELECT p_id
--                   FROM Tree
--                   WHERE p_id IS NOT NULL
--                 )
--            THEN 'Inner'

--            ELSE 'Leaf'
--        END AS type
-- FROM Tree;