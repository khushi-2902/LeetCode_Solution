# Write your MySQL query statement below


-- select m.name from Employees e join Employees m 
-- on e.manager_id=m.employee_id where


select employee_id from Employees where manager_id not in(select employee_id from Employees)
and salary<30000 order by employee_id asc;