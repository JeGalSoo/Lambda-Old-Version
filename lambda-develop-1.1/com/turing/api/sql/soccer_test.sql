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
--full scan
--4개의 테이블을 모두 조회하시오
select count(*) count
from stadium s
join team t on t.stadium_id = s.stadium_id
join schedule g on g.stadium_id=s.stadium_id
join player p on p.team_id=t.team_id
-- 문제 10
-- 수원팀(K02) 과 대전팀(K10) 선수들 중 포지션이 골키퍼(GK)인 선수를 출력하시오
-- 단 , 팀명, 선수명 오름차순 정렬하시오
select player_name
from team t
join player p on t.team_id=p.team_id
where position='GK' and t.team_id in ('K02','K10')
order by t.team_id ,p.player_name;
-- 문제 11
-- 팀과 연고지를 연결해서 출력하시오
-- [팀 명]             [홈구장]
-- 수원[ ]삼성블루윙즈 수원월드컵경기장
select concat(region_name,'[]',team_name,' ',s.stadium_name)
from stadium s
join team t on s.stadium_id=t.stadium_id
-- 문제 12
-- 수원팀(K02) 과 대전팀(K10) 선수들 중
-- 키가 180 이상 183 이하인 선수들
-- 키, 팀명, 사람명 오름차순
select player_name
from team t
join player p on t.team_id=p.team_id
where p.height between 180 and 183 and team_id in ('k02','k10')
order by team_name, player_name;
-- 문제 13
-- 모든 선수들 중 포지션을 배정 받지 못한 선수들의
-- 팀명과 선수이름 출력 둘다 오름차순
select team_name, player_name
from team t
join player p on t.team_id=p.team_id
where `POSITION`=''
order by team_name, player_name
--스칼라와 조인  사용
 -- 문제 14
-- 팀과 스타디움, 스케줄을 조인하여
-- 2012년 3월 17일에 열린 각 경기의
-- 팀이름, 스타디움, 어웨이팀 이름 출력
-- 다중테이블 join 을 찾아서 해결하시오.
select awayteam_id,
(select stadium_name from stadium where stadium.stadium_id=schedule.stadium_id) as stadium_name,
(select team_name from team where team.stadium_id=schedule.stadium_id) as team_name
from schedule
where sche_date=20120317;