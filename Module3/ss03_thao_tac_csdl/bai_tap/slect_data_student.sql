use quanlysinhvien;

select *
from student
where studentname like 'h%';

select *
from class
where Month(StartDate) = 12;

select *
from Subject
where Credit between 3 and 5;

Update Student
set ClassID = 2
where StudentName = 'Hung';

select * from student;