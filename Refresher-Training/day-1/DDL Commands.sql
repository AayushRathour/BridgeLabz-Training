#DDL Commands 


-- Created new Database 
create database techno;

use techno;

-- Showed all database present 
show databases;

-- Created a table name stu for students 
create table stu(
	stu_no int primary key,
    stu_name varchar(20),
    stu_age int


);

-- use describe to see all colums of student table 
describe stu;

-- Added new colume using alter command
alter table stu
add stu_city varchar(10);

-- Used truncate to delete rows
truncate table stu;

-- used drop to delete  the table/database
drop table stu;

