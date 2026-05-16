# Write your MySQL query statement below



select 
CASE when id%2=1 AND id != (SELECT MAX(id) FROM Seat)
    then id+1 

    when id%2=0
     then id-1

    else id

    end as id,student

from seat  order by id;


