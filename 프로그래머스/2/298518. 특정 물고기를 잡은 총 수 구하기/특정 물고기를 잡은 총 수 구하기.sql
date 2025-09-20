-- 코드를 작성해주세요

select count(case when FISH_NAME = 'BASS' || FISH_NAME = 'SNAPPER' then 1 end) as FISH_COUNT 
from FISH_INFO left join FISH_NAME_INFO on FISH_INFO.FISH_TYPE = FISH_NAME_INFO.FISH_TYPE 