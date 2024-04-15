# Write your MySQL query statement below
select Visits.customer_id, COUNT(*) as count_no_trans 
from Visits left join Transactions
on Visits.visit_id = Transactions.visit_id
where Transactions.visit_id is null
group by Visits.customer_id