--001. 전체 축구팀 목록을 팀이름 오름차순으로 출력하시오
SELECT team_name
FROM team
ORDER BY team_name
--002. 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포시젼이 없으면 빈공간으로 두시오.
SELECT distinct POSITION
FROM player
--003 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 '신입' 으로 기재하시오
select distinct if(position='','신입',position)
from player
--004 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. 단 수원팀 ID는 K02 입니다.
select player_name
from player
where team_id='k02' and position='GK';
--004-1 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. (ID 모를 경우)
select player_name
from player
where position ='GK'and team_id=(select team_id from team where region_name='수원');
--005 수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. 단 수원팀 ID는 K02 입니다.
select *
from player
where team_id='k02' and player_name like '고%' and height>=170;
--005-1 수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. (ID를 모를 경우)
select * from team;