# Write your MySQL query statement below

select player_id,event_date as first_login from (
select player_id,event_date,

ROW_NUMBER() OVER (PARTITION BY player_id
                   order by event_date) as first from Activity
) t where first=1;