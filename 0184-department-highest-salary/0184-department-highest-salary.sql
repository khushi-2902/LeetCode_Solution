

select d.name as Department,E.name as Employee,E.salary as Salary from employee E
JOIN Department d on E.departmentId=d.id
Where E.Salary=(Select MAX(salary) from Employee E2 where 
               E2.departmentId=E.departmentId);

