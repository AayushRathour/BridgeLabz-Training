# Perfoming Join oprations 
use healthApp;

select * from patient;
select * from doctor;
select* from appointment;


-- perfomed inner join opration to show who has booked there appointment
select p.pat_name,
d.doc_name
from patient p
join appointment a

on p.pat_id =a.pat_id
join doctor d
on a.doc_id = d.doc_id;


-- now Left join 

select p.pat_name,
a.appoint_date
from  patient p
left join appointment a
on p.pat_id = a.pat_id;

-- now Right join

select p.pat_name, 
a.appoint_date 

from patient p
Right join appointment a
on p.pat_id = a.pat_id;


-- full outer join 

select p.pat_name,
a.appoint_date
from patient p
left join appointment a
on p.pat_id = a.pat_id

union 

select p.pat_name,
a.appoint_date
from patient p
right join appointment a
on p.pat_id = a.pat_id;



-- created procedure to show all patients
delimiter //
create procedure showPatients()
begin

select * from patient;
end //
delimiter ;

call showPatients();

-- created the procedure to show all doctors

delimiter // 
create procedure showDoctor()
begin 

select * from doctor;
end //
delimiter ;

call showDoctor;




-- Created patient log table
create table patient_log(
log_id int primary key auto_increment,
message varchar(100)
);

-- Created trigger after inserting patient
delimiter //

create trigger patient_insert
after insert
on patient
for each row
begin
insert into patient_log(message)
values(concat(new.pat_name,' Added Successfully'));

end //
delimiter ;


-- Inserted a new patient
insert into patient
values(8,'Ritika Jain','9876599999');

select * from patient_log;


-- Created delete log table
create table delete_log(
id int primary key auto_increment,
patient_name varchar(50)
);

-- Created trigger after deleting the patient
delimiter //
create trigger patient_delete
after delete
on patient
for each row
begin
insert into delete_log(patient_name)
values(old.pat_name);
end //

delimiter ;

-- Deleted the patient
delete from patient
where pat_id=8;

select * from delete_log;


-- Inserted another patient to check automatic logging
insert into patient
values(9,'Mohit Sharma','9876548888');

select * from patient_log;