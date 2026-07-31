# DML Commands

use techno;

-- Added new data using insert command
insert into stu(stu_no, stu_name, stu_age, stu_city)
value(1, "Aayush", 21, "Bhopal");

-- used the update command to update the values to new 
update stu
set stu_age = 22
where stu_no = 1;

update stu
set stu_name ="Aayush R"
where stu_no =1;


-- used the select command to retrive data 
select * from stu;


delete from stu
where stu_no = 1;