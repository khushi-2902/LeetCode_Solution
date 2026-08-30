# Write your MySQL query statement below
--  SELECT MAX(salary) AS SecondHighestSalary FROM
--  (SELECT salary,DENSE_RANK() 
-- OVER(ORDER BY salary DESC) as r
--  FROM Employee) t
-- WHERE r=2;)


select max(salary) as SecondHighestSalary from 
(select salary,DENSE_RANK() over(order by salary desc) as r
from Employee) t
where r=2;





-- SELECT MAX(salary) AS SecondHighestSalary 
-- FROM Employee 
-- WHERE salary<
-- (SELECT MAX(salary) FROM Employee);

-- SELECT salary AS SecondHighestSalary FROM
-- (SELECT salary,
-- DENSE_RANK() OVER(Order by salary) AS r From Employee)t 
-- WHERE r=2;


-- with old_cte as(select salary from employee),
--  new_cte as (select max(salary) as highest_Salary  from Employee),
-- second_cte as (select max(salary) as SecondHighestSalary from old_cte where salary< (select highest_Salary from new_cte))

--  SELECT SecondHighestSalary
-- FROM second_cte;


-- WITH Salary AS (
--     SELECT salary,
-- 	DENSE_RANK() OVER (ORDER BY salary DESC) AS rnk
--     FROM Employee
-- )
-- SELECT salary FROM Salary
-- WHERE rnk = 3;





-- select max(salary) as secondHighestSalary from employee where  salary<(select max(salary) from employee)

-- select MAX(salary) as secondHighestSalary from(
-- select salary, DENSE_RANK() OVER(ORDER BY salary DESC) as r from employee) T where r=2;