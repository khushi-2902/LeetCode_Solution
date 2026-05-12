# Write your MySQL query statement below


Select name as name from Employee where id IN (select managerId from Employee group by managerId having count(managerId)>=5);