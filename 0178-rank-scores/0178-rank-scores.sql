# Write your MySQL query statement below
-- select score,DENSE_RANK() OVER (ORDER BY score DESC) As 'rank' from Scores;



with scoreTable as 
(select score,DENSE_RANK() OVER(ORDER BY score DESC) As 'rank' from scores)
select * from scoreTable;
