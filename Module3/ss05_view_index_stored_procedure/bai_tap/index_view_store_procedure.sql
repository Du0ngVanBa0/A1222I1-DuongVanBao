create database demo;
use demo;

create table products
(
	id int auto_increment primary key,
    productCode int,
    productName varchar(50),
    productPrice int,
    productAmount int,
    productDescripition varchar(50),
    productStatus varchar(50)
);
insert into products(productCode,productname,productprice,productamount,productDescripition,productstatus) values
(123,'san pham',12345,12,'Description','con'),
(124,'san pham1',12346,12,'Description','con'),
(125,'san pham2',12347,12,'Description','con'),
(126,'san pham3',12348,12,'Description','con'),
(127,'san pham4',12349,12,'Description','con'),
(128,'san pham5',12350,12,'Description','con'),
(129,'san pham6',12352,12,'Description','con'),
(130,'san pham7',12353,12,'Description','con');

create unique index productCode_index on products(productCode);
create index productName_price_index on products(productName,productPrice);

explain select * from products where productCode = 130;

create view product_view as 
	select * from products
;
select * from product_view;

alter view product_view  as
	select *
    from products 
    where productCode like '1%'
;
drop view product_view;

Delimiter //
create procedure show_all_product()
begin
	select * from products;
end//
delimiter ;

call show_all_product

Delimiter //
create procedure edit_product(edit_id int)
begin
	update products
    set productName = 'duoc sua'
    where id = edit_id;
end//
delimiter ;

call edit_product(1);

Delimiter //
create procedure delete_product(edit_id int)
begin
	delete
    from products
    where id = edit_id;
end//
delimiter ;
call delete_product(1);