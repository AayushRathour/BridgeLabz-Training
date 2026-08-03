# Health Clinic Database Project


-- Created Health Clinic database
create database healthApp;

use healthApp;


-- Created Doctor table
create table Doctor(
	doc_id int primary key,
    doc_name varchar(50),
    doc_speciality varchar(50)
);


-- Created Patient table
create table patient(
	pat_id int primary key,
    pat_name varchar(50),
    pat_phone char(10)
);


-- Created Appointment table with foreign keys
create table Appointment(
	appoint_id int primary key auto_increment,
    pat_id int not null,
    doc_id int not null,
    appoint_date datetime not null,
    status varchar(20) default 'Scheduled',
    foreign key (pat_id) references patient(pat_id),
    foreign key(doc_id) references Doctor(doc_id)
);


-- Displayed all tables
show tables;

-- Displayed appointment records
select * from appointment;


-- Inserted patient records
insert into patient(pat_id, pat_name, pat_phone)
value
(01, 'Ravi Kumar', '9876500000'),
(02, 'Meena S', '9123400000');


-- Inserted doctor records
insert into doctor(doc_id, doc_name, doc_speciality)
value
(101, 'Dr. Anita', 'Cardiology'),
(102, 'Dr. Suresh', 'Orthopedic');


-- Inserted appointment records
insert into appointment(pat_id, doc_id, appoint_date, status)
values
(01, 101, '2026-08-05 10:00:00', 'Scheduled'),
(01, 102, '2026-08-06 11:30:00', 'Scheduled'),
(02, 101, '2026-08-07 09:00:00', 'Scheduled');


-- Created denormalized appointment table
create table appointment_bad(
    appt_id int primary key auto_increment,
    patient_name varchar(100),
    patient_phone varchar(15),
    doctor_name varchar(100),
    doctor_specialty varchar(50),
    appt_date datetime
);


-- Inserted duplicate data for normalization example
insert into appointment_bad(patient_name, patient_phone, doctor_name, doctor_specialty, appt_date)
values
('Ravi Kumar', '9876500000', 'Dr. Anita', 'Cardiology', '2026-08-05 10:00:00'),
('Ravi Kumar', '9876500000', 'Dr. Suresh', 'Orthopedic', '2026-08-06 11:30:00'),
('Meena S', '9123400000', 'Dr. Anita', 'Cardiology', '2026-08-07 09:00:00');


-- Displayed duplicate table data
select * from appointment_bad;


-- Updated patient's phone number
update patient
set pat_phone = '9999999999'
where pat_name = 'Ravi Kumar';


-- Added department column in Doctor table
alter table doctor
add department_name varchar(50);


-- Updated doctor department
update doctor
set department_name = 'Cardiology Dept'
where doc_id = 101;

update doctor
set department_name = 'Orthopedic Dept'
where doc_id = 102;


-- Displayed doctor details
select * from doctor;


-- Removed department column after normalization
alter table doctor
drop column department_name;


-- Created Department table
create table department(
    department_id int primary key auto_increment,
    department_name varchar(50) not null
);


-- Inserted department records
insert into department(department_name)
values('Cardiology Dept'),
('Orthopedic Dept');


-- Added department_id in Doctor table
alter table doctor
add department_id int;


-- Created foreign key between Doctor and Department
alter table doctor
add constraint fk_department
foreign key(department_id)
references department(department_id);


-- Disabled safe update mode
set sql_safe_updates = 0;


-- Linked doctors with departments
update doctor
set department_id = 1
where doc_speciality = 'Cardiology';

update doctor
set department_id = 2
where doc_speciality = 'Orthopedic';


-- Displayed doctor with department details
select
d.doc_name,
d.doc_speciality,
dep.department_name
from doctor d
join department dep
on d.department_id = dep.department_id;


-- Updated department name
update department
set department_name = 'Cardiology Department'
where department_id = 1;


-- Displayed department table
select * from department;


-- Created index on patient id
create index idx_patient
on appointment(pat_id);


-- Checked query execution plan
explain
select * from appointment
where pat_id = 1;


-- Created composite index
create index idx_doctor_date
on appointment(doc_id, appoint_date);


-- Checked composite index usage
explain
select * from appointment
where doc_id = 101
and appoint_date > '2026-08-05';


-- Displayed all tables
show tables;
