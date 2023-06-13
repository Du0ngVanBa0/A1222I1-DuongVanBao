use quanlysinhvien;

select *
from subject 
having Credit = (select max(credit) from subject);

select  s.SubName, m.Mark
from Mark m join subject s on s.subID = m.subID
where Mark = (Select max(Mark) from Mark);

select s.*, AVG(m.mark)
from student s join mark m on s.StudentID = m.SubID
group by m.SubID
order by AVG(m.mark) desc;