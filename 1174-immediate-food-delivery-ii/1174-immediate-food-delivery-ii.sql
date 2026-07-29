# Write your MySQL query statement below


select 
 ROUND(
    100*
 sum(case when order_date=customer_pref_delivery_date then 1 else 0 END)/count(customer_id),2) as immediate_percentage from delivery
 where (customer_id,order_date) in (
select customer_id,MIN(order_date) from Delivery group by customer_id)


-- SELECT 
-- ROUND(
--     100 * SUM(
--         CASE 
--             WHEN order_date = customer_pref_delivery_date THEN 1
--             ELSE 0
--         END
--     ) / COUNT(*)
-- ,2) AS immediate_percentage
-- FROM Delivery
-- WHERE (customer_id, order_date) IN
-- (
-- SELECT customer_id, MIN(order_date)
-- FROM Delivery
-- GROUP BY customer_id
-- );
