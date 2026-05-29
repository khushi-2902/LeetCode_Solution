# Write your MySQL query statement below



SELECT e.name As Employee from Employee e
JOIN Employee m on m.id=e.managerId
WHERE e.salary>m.salary;
































































-- select e.Name As Employee
-- From Employee e
-- JOIN Employee m
-- ON e.ManagerId=m.Id
-- WHERE e.Salary>m.Salary