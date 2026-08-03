use healthApp;

INSERT INTO Patient (pat_id, pat_name, pat_phone)
VALUES
(3, 'Amit Sharma', '9876511111'),
(4, 'Neha Verma', '9876522222'),
(5, 'Rohan Singh', '9876533333'),
(6, 'Pooja Patel', '9876544444'),
(7, 'Karan Mehta', '9876555555');

INSERT INTO Doctor (doc_id, doc_name, doc_speciality, department_id)
VALUES
(103, 'Dr. Kavita', 'Neurology', 1),
(104, 'Dr. Arjun', 'Dermatology', 2),
(105, 'Dr. Meera', 'Pediatrics', 1),
(106, 'Dr. Vivek', 'General Medicine', 2),
(107, 'Dr. Nisha', 'ENT', 2);



INSERT INTO Appointment (pat_id, doc_id, appoint_date, status)
VALUES
(3, 103, '2026-08-08 10:00:00', 'Scheduled'),
(4, 104, '2026-08-08 11:00:00', 'Completed'),
(5, 105, '2026-08-09 09:30:00', 'Pending'),
(6, 106, '2026-08-09 12:00:00', 'Scheduled'),
(7, 107, '2026-08-10 10:15:00', 'Cancelled'),
(3, 101, '2026-08-10 02:00:00', 'Completed'),
(4, 102, '2026-08-11 09:00:00', 'Pending'),
(5, 101, '2026-08-11 11:30:00', 'Scheduled'),
(6, 103, '2026-08-12 01:00:00', 'Completed'),
(7, 104, '2026-08-12 03:30:00', 'Scheduled');


SELECT * FROM Appointment;



select * from doctor;

select * from doctor
where doc_fee between 500 and 2000;




SELECT
    p.pat_name,
    COUNT(*) AS TotalAppointments
FROM Patient p
JOIN Appointment a
ON p.pat_id = a.pat_id
GROUP BY p.pat_id, p.pat_name
HAVING COUNT(*) > 0;


alter table doctor add doc_fee double(10,2);

alter table doctor modify column doc_fee varchar(21);

update doctor
set doc_fee = case doc_id
when 1 then 2000.00
when 2 then 1000.00
when 3 then 1200.00
when 4 then 1231.00
when 5 then 1231.00

else doc_fee
end ;



update doctor 
set doc_fee = case doc_id
when 1 then 1000.00
when 2 then 3123.00

else doc_fee
end; 



select * from doctor
where doc_speciality = "Cardiology";


select * from doctor;

update doctor 
set doc_speciality = "SOMETHING"
where doc_id = 102;


delete from doctor
where doc_id = 1;
 
