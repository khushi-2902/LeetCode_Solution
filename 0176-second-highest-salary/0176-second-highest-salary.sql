# Write your MySQL query statement below
--  SELECT MAX(salary) AS SecondHighestSalary FROM
--  (SELECT salary,DENSE_RANK() 
-- OVER(ORDER BY salary DESC) as r
--  FROM Employee) t
-- -- WHERE r=2;

-- SELECT MAX(salary) AS SecondHighestSalary 
-- FROM Employee 
-- WHERE salary<
-- (SELECT MAX(salary) FROM Employee);

-- SELECT salary AS SecondHighestSalary FROM
-- (SELECT salary,
-- DENSE_RANK() OVER(Order by salary) AS r From Employee)t 
-- WHERE r=2;


with old_cte as(select salary from employee),
 new_cte as (select max(salary) as highest_Salary  from Employee),
second_cte as (select max(salary) as SecondHighestSalary from old_cte where salary< (select highest_Salary from new_cte))

 SELECT SecondHighestSalary
FROM second_cte;