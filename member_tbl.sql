--IMPORT
LOAD DATA LOCAL INFILE '/tmp/data.csv' INTO TABLE table_name FIELDS TERMINATED BY ',' ENCLOSED BY '"'

--DDL
create table members(
	first_name varchar(30),
	middle_name varchar(30),
	last_name varchar(30),
	sex_flg char(1),
	age integer(3),
	company varchar(30),
	career varchar(30),
	address varchar(50)
)