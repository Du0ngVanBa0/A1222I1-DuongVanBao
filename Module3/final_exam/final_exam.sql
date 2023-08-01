drop database if exists library;
create database library;
use library;

create table book(
	id varchar(45) primary key,
    book_name varchar(45) not null,
    author varchar(45) not null,
    quantity int not null,
    descr varchar(45) not null
);

create table student(
	id int auto_increment primary key,
    student_name varchar(45) not null,
    class varchar(45) not null
);

create table rent(
	id int auto_increment primary key,
	book_id varchar(45),
    student_id int,
    foreign key(student_id) references student(id),
    foreign key(book_id) references book(id),
    rent_status bit not null,
    rent_date date not null,
    back_date date not null
);

insert into book
	values ("MS-0001","Sổ đỏ","Vũ Trọng Phụng",10,"Nhân vật chính là Xuân tóc đỏ và ......."),
    ("MS-0002","Truyện Kiều","Nguyễn Du",15,"Cuộc đời Thúy Kiều.....");

insert into student(student_name,class)
	values("Nguyễn Văn A","10A1"),
	("Dương Văn Bảo","10A3");