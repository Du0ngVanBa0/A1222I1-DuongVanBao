create database QuanLyDiemThi;
use QuanLyDiemThi;
create table HocSinh(
	MaHS varchar(11) primary key,
    TenHS varchar(50),
    NgaySinh date,
    Lop varchar(5),
    GT bit
);

create table GiaoVien(
	MaGV varchar(9) primary key,
    TenGV varchar(50),
    SDT varchar(10)
);

create table MonHoc(
	MaMH varchar(10) primary key,
    TenMH varchar(50),
    MaGV varchar(9),
    foreign key (MaGV) references GiaoVien(MaGV)
);

create table BangDiem(
	MaHS varchar(11),
    MaMH varchar(10),
    DiemThi tinyint,
    NgayKT date,
    primary key(MaHS,MaMH),
    foreign key (MaHS) references HocSinh(MaHS),
    foreign key (MaMH) references MonHoc(MaMH)
)