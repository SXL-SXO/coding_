-- 코드를 작성해주세요
with A as (
    select 
        case 
            when Month(DIFFERENTIATION_DATE) <= 3 then '1Q'
            when Month(DIFFERENTIATION_DATE) <= 6 then '2Q'
            when Month(DIFFERENTIATION_DATE) <= 9 then '3Q'
            else '4Q'
        END as QUARTER        
    from ECOLI_DATA        
)

select QUARTER, count(*) as ECOLI_COUNT
from A
group by QUARTER