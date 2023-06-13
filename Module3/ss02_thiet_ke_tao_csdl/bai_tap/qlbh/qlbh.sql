create database QuanLyBanHang;
use QuanLyBanHang;
create table Customertbl(
	cID tinyint auto_increment primary key,
    cName varchar(50) not null,
    cAge tinyint not null
);

create table Ordertbl(
	oID tinyint auto_increment primary key,
    cID tinyint,
    oDate date not null,
    oTotalPrice int,
    foreign key(cID) references Customertbl(cID)
);

create table Producttbl(
	pID tinyint auto_increment primary key,
    pName varchar(50) not null,
    pPrice int not null
);

create table OrderDetailtbl(
	oID tinyint,
    pID tinyint,
    odQTY tinyint not null,
    foreign key (oID) references Ordertbl(oID),
    foreign key (pID) references Producttbl(pID),
    primary key (oID,pID)
)