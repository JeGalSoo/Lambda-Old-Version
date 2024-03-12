-- Soccer JPA 버전
select * from player;
DROP TABLE stadium;
show tables;
CREATE TABLE stadium(
id int AUTO_INCREMENT,
statdium_name varchar(40),
hometeam_id varchar(10),
seat_count integer,
address varchar(60),
ddd varchar(10),
tel varchar(10),
primary key(id)
);
CREATE TABLE schedule(
id int AUTO_INCREMENT,
stadium_id int,
gubun varchar(10),
hometeam_id varchar(60),
awayteam_id varchar(10),
home_score integer,
away_score integer,
primary key(id),
foreign key(stadium_id) REFERENCES stadium(id)
);
CREATE TABLE team(
id int AUTO_INCREMENT,
region_name varchar(10),
team_name varchar(40),
e_team_name varchar(50),
orig_yyyy varchar(10),
zip_code1 varchar(10),
zip_code2 varchar(10),
address varchar(80),
ddd varchar(10),
tel varchar(10),
fax varchar(10),
homepage varchar(50),
owner varchar(10),
stadium_id int,
primary key (id),
foreign key(stadium_id) references stadium(id)
);
CREATE TABLE player(
id int AUTO_INCREMENT,
player_name varchar(10),
e_okater_name varchar(20),
nickname varchar(40),
join_yyyy varchar(30),
position varchar(10),
back_no int,
nation varchar(20),
birth_date date,
solar varchar(10),
height int,
weight int,
team_id int,
primary key (id),
foreign key(team_id) references team(id)
);