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
select *
from player
where height>=170 and player_name like '고%' and team_id=(select team_id from team where region_name='수원')
-----------------------------------------------------------
select *
from stadium;
select *
from schedule;
select *
from team;
select *
from player;
-- 문제 6
-- 다음 조건을 만족하는 선수명단을 출력하시오
-- 소속팀이 삼성블루윙즈이거나
-- 드래곤즈에 소속된 선수들이어야 하고,
-- 포지션이 미드필더(MF:Midfielder)이어야 한다.
-- 키는 170 센티미터 이상이고 180 이하여야 한다.
SELECT player_name, height, team_id
FROM player
WHERE POSITION='mf' AND height between 170 and 180 AND team_id in (SELECT team_id FROM team WHERE team_name='삼성블루윙즈' or team_id='드래곤즈');
--수원을 연고지로 하는 골키퍼는 누구인가?
select player_name
from player
where POSITION='GK' and team_id=(select team_id from team where region_name= '수원' );
-- 문제 8-- 서울팀 선수들 이름, 키, 몸무게 목록으로 출력하시오-- 키와 몸무게가 없으면 "0" 으로 표시하시오-- 키와 몸무게는 내림차순으로 정렬하시오
select player_name, if(height=0,0,height), if(weight=0,0,weight)
from player
order by height desc, weight desc;
-- 문제 9-- 서울팀 선수들 이름과 포지션과-- 키(cm표시)와 몸무게(kg표시)와  각 선수의 BMI지수를 출력하시오-- 단, 키와 몸무게가 없으면 "0" 표시하시오-- BMI는 "NONE" 으로 표시하시오(as bmi)-- 최종 결과는 이름내림차순으로 정렬하시오
select player_name, position, if(height='',0,concat(height,'cm')), if(weight='',0,concat(weight,'kg')), if(weight='' or height='','NONE',round(weight/((height/100)*(height/100)),1)) as bmi
from player
order by player_name desc;
select player_name, position, if(height='',0,concat(height,'cm')), if(weight='',0,concat(weight,'kg')), IFNULL(((weight/(height*height))*10000),'NONE') AS BMI
from player
order by player_name desc;
----------------------------------------------------------------------------