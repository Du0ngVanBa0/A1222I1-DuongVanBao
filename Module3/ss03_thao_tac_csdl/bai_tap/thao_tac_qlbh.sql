use quanlybanhang;

--  Thêm dữ liệu vào trong 4 bảng
insert into customertbl(cName,cAge)
values
('Minh Quan',10),
('Ngoc Oanh',20),
('Hong Ha',50);

insert into ordertbl(cID,oDate,oTotalPrice)
values 
(1,'2016-3-21',Null),
(2,'2016-3-23',Null),
(1,'2016-3-16',Null);

insert into producttbl(pName,pPrice)
values
('May Giat',3),
('Tu Lanh',5),
('Dieu Hoa',7),
('Quat',1),
('Bep Dien',2);

insert into orderdetailtbl
values
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select oID, oDate, oTotalPrice 
from Ordertbl;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select cName, pName
from Ordertbl o
join Customertbl c on o.cID = c.cID
join Orderdetailtbl od on o.oID = od.oID
join Producttbl p on p.pID = od.pID ;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select cName as CustomerNotBuy
from Customertbl
where cID not in (
	select cID
    from Ordertbl
);

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
select o.oID as maHD, oDate as ngayBan, sum(od.odQTY * p.pPrice) as giaTien
from Ordertbl o
join OrderDetailtbl od on o.oID = od.oID
join Producttbl p on p.pID = od.pID
group by o.oID 