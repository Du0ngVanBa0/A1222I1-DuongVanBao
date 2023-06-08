create database QuanLySinhVien;
use QuanLySinhVien;
create table Class(
	ClassID int primary key auto_increment,
    ClassName varchar(60) not null,
    StartDate datetime not null,
    Status Bit
);

create table Student(
	StudentID Int primary key auto_increment,
    StudentName varchar(30) not null,
    Address varchar(50),
    Phone varchar(20),
    Status Bit,
    ClassID Int not null,
    foreign key (ClassID) references Class(ClassID)
);

create table Subject(
	SubID Int primary key auto_increment,
    SubName varchar(30) not null,
    Credit Tinyint not null default 1 check (Credit >=1),
    Status Bit default 1
);

create table Mark(
	MarkID Int primary key auto_increment,
    SubID Int not null unique,
	StudentID Int not null unique,
	Mark Float default 0 check (Mark between 0 and 100),
	ExamTimes Tinyint default 1,
    foreign key (SubID) references Subject(SubID),
    foreign key (StudentID) references Student(StudentID)
)