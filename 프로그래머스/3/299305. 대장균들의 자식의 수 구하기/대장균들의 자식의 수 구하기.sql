select A.Id as ID, count(case when B.PARENT_ID is not null and A.id = B.PARENT_ID then 1 end) as CHILD_COUNT
from ECOLI_DATA A, ECOLI_DATA B
group by ID
order by ID