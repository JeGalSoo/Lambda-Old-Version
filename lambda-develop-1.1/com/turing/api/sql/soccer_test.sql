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
from schedule
where sche_date=20120317;;
select *
from team;
select *
from player
order by team_id,height
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
select concat(region_name,' ',team_name,' ',s.stadium_name) as team_name
from stadium s
join team t on s.stadium_id=t.stadium_id
-- 문제 12
-- 수원팀(K02) 과 대전팀(K10) 선수들 중
-- 키가 180 이상 183 이하인 선수들
-- 키, 팀명, 사람명 오름차순
select p.player_name
from team t
join player p on t.team_id=p.team_id
where p.height between 180 and 183 and t.team_id in ('k02','k10')
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
select (select team_name from team where team.team_id=schedule.awayteam_id) as awayteam_name,
(select stadium_name from stadium where stadium.stadium_id=schedule.stadium_id) as stadium_name,
(select team_name from team where team.stadium_id=schedule.stadium_id) as team_name
from schedule
where sche_date=20120317
-- 문제 15
-- 2012년 3월 17일 경기에
-- 포항 스틸러스 소속 골키퍼(GK)
-- 선수, 포지션,팀명 (연고지포함),
-- 스타디움, 경기날짜를 구하시오
-- 연고지와 팀이름은 간격을 띄우시오(수원[]삼성블루윙즈)
select player_name, POSITION,
(select concat(t.region_name,' ',t.team_name) from team t where p.team_id=t.team_id) as team_name,
(select stadium_id from stadium where stadium_id=(select)
from player p
where position='GK' AND
p.team_id = (SELECT hometeam_id from schedule s where sche_date=20120317 AND s.hometeam_id=
(SELECT team_id FROM team WHERE region_name='포항'));
-- 문제 16
-- 홈팀이 3점이상 차이로 승리한 경기의
-- 경기장 이름, 경기 일정
-- 홈팀 이름과 원정팀 이름을
-- 구하시오
select s.stadium_name, sc.sche_date,
      (select t.team_name
       from team t
       where sc.awayteam_id = t.team_id) 'awayteam',
      (select t.team_name
       from team t
       where sc.hometeam_id = t.team_id) 'hometeam'
from stadium s
join team t using(stadium_id)
join schedule sc using (stadium_id)
where sc.home_score-sc.away_score>=3
-- 문제 17
-- STADIUM 에 등록된 운동장 중에서
-- 홈팀이 없는 경기장까지 전부 나오도록
-- 카운트 값은 19
-- 힌트 : LEFT JOIN 사용해야함
select stadium_name,(select t.team_name
                     from team t
                     where t.stadium_id = st.stadium_id)
from stadium st;
------------------------------------------------위가 더 좋은 답안(join을 쓰면 더 느려지고 용량을 많이 먹음
select s.stadium_name, t.team_name
from stadium s left join team t using(stadium_id);
--문제 18 페이지네이션 로직을 위한
--플레이어 테이블에서 최상단 5개 로우를 출력
select *
from player
order by 1 limit 0, 5;
-- 문제 19 (그룹바이: 집계함수 - 딱 5개 min, max, count, sum, avg)
-- 평균키가 인천 유나이티스팀('K04')의 평균키  보다 작은 팀의
-- 팀ID, 팀명, 평균키 추출
-- 인천 유나이티스팀의 평균키 -- 176.59
-- 키와 몸무게가 없는 칸은 0 값으로 처리한 후 평균값에
-- 포함되지 않도록 하세요.
select team_id, team_name, round(avg(height),2)
from team t
join player p USING (team_id)
where height!=''
GROUP by p.team_id
HAVING AVG(height)<176.59;
-------------------------
select p.team_id, team_name,round(avg(height),2)
from team t
join player p on t.team_id = p.team_id
where if(p.height='',0,p.height)
group by p.team_id
having avg(p.height)<(select avg(p.height)
                      from team
                      join player p
                      using(team_id)
                      where region_name='인천');
-- 문제 20
-- 포지션이 MF 인 선수들의 소속팀명 및  선수명, 백넘버 출력
SELECT (SELECT team_name
        FROM team t
        WHERE t.team_id=player.team_id),
        back_no
FROM player
WHERE POSITION='mf';
-------------------------------------
select t.team_name, p.player_name, p.back_no
from team t
join player p on t.team_id =p.team_id
where p.position='mf'
-- 문제 21
-- 가장 키큰 선수 5명 소속팀명 및  선수명, 백넘버 출력,
-- 단 키  값이 없으면 제외
SELECT (SELECT team_name
        FROM team t
        WHERE t.team_id=player.team_id),
        player_name, back_no
FROM player
WHERE height!=''
ORDER BY height DESC limit 5;
----------------------------
select (select t.team_name from team t p.player_name)
from player p
order by height desc limit 5;
-- 문제 22
-- 선수 자신이 속한 팀의 평균키보다 작은  선수 정보 출력
-- (select round(avg(height),2) from player)
SELECT *
FROM player p
join team t on p.team_id=t.team_id
where height!='' and height<(select round(avg(height),2)
                             from player p
                             group by team_id
                             having p.team_id=t.team_id)
order by p.team_id
---------------------------------
select p.*
from player p
join (select p2.team_id, round(AVG(p2.height),2) avg
        from player p2
        where p2.height!=''
        group by p2.team_id) t_avg using(team_id)
where p.height !=''
and p.height<AVG
order by team_id, height desc
-- 문제 23
-- 2012년 5월 한달간 경기가 있는 경기장  조회
select distinct s.*
from schedule st
join stadium s on st.stadium_id=s.stadium_id
where sche_date like '201205%'
---------------------------------