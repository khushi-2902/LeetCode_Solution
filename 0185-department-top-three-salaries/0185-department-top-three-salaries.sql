# Write your MySQL query statement below

SELECT Employee,Salary,Department from 
(select e.name as Employee,e.salary as Salary,d.name as Department,
DENSE_RANK() OVER (PARTITION BY d.name 
                  ORDER BY e.salary DESC) as rnk from Employee e
join Department d on e.departmentId=d.id 
) t
where rnk<=3;