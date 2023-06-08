create database QLBanHang;
use QLBanHang;
create table PhieuXuat(
	SoPX tinyint auto_increment primary key,
    NgayXuat date not null
);

create table VatTu(
	MaVTu tinyint auto_increment primary key,
	TenVTu varchar(100) not null
);

create table NhaCC(
	MaNCC tinyint auto_increment primary key,
    TenNCC varchar(100) not null,
    DiaChi varchar(100) not null
);

create table SDT(
	id int auto_increment primary key,
    MaNCC tinyint, 
    SDT varchar(13) not null,
    foreign key(MaNCC) references NhaCC(MaNCC)
);

create table DonDH(
	SoDH tinyint auto_increment primary key,
    NgayDH date not null,
    MaNCC tinyint,
    foreign key (MaNCC) references NhaCC(MaNCC)
);

create table PhieuNhap(
	SoPN tinyint auto_increment primary key,
    NgayNhap date not null
);

create table ChiTietPhieuXuat(
	id int auto_increment primary key,
	MaVTu tinyint, 
    SoPX tinyint,
    DGXuat int not null,
    SLXuat tinyint not null,
    foreign key (MaVTu) references VatTu(MaVTu),
    foreign key (SoPX) references PhieuXuat(SoPX)
);

create table ChiTietPhieuNhap(
	id int auto_increment primary key,
	MaVTu tinyint, 
    SoPN tinyint,
    DGNhap int not null,
    SLNhap tinyint not null,
    foreign key (MaVTu) references VatTu(MaVTu),
    foreign key (SoPN) references PhieuNhap(SoPN)
);

create table ChiTietDonDatHang(
	id int auto_increment primary key,
    MaVTu tinyint, 
    SoDH tinyint,
	foreign key (MaVTu) references VatTu(MaVTu),
    foreign key (SoDH) references DonDH(SoDH)
);