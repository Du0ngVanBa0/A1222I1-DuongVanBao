-- 21.	Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.
create view v_nhan_vien
as (select *
from nhan_vien
where dia_chi like '%Hải Châu%' and ma_nhan_vien in (
	select ma_nhan_vien 
    from hop_dong
    where ngay_lam_hop_dong = '2019-12-12'
	)
);

-- 22.	Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.
update nhan_vien
set dia_chi = replace(dia_chi,'Hải Châu','Liên Chiểu')
where ma_nhan_vien in (select ma_nhan_vien from (select ma_nhan_vien from v_nhan_vien) as temp);

-- 23.	Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang.
drop procedure if exists sp_xoa_khach_hang;
delimiter //
create procedure sp_xoa_khach_hang (mkh int)
	begin
        delete from hop_dong_chi_tiet where ma_hop_dong in (select ma_hop_dong from hop_dong where ma_khach_hang = mkh);
		delete from hop_dong where ma_khach_hang = mkh;
		delete from khach_hang where ma_khach_hang = mkh;
    end//
delimiter ;
call sp_xoa_khach_hang(1);
start transaction;
rollback;
commit;

-- 24.	Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong với yêu cầu sp_them_moi_hop_dong phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.
drop procedure if exists sp_them_moi_hop_dong;
delimiter //
create procedure sp_them_moi_hop_dong (ma_hd int, nlhd datetime, nkt datetime, tien_dc double, ma_nv int, ma_kh int, ma_dv int)
	begin
		declare check_var int default 0;
        select count(1) into check_var from hop_dong 
        where ma_hop_dong = ma_hd;
        if (check_var > 0) then
			signal sqlstate '45000'
            set message_text = 'Mã hợp đồng cần thêm đã tồn tại';
		else
			select count(1) into check_var from nhan_vien
            where ma_nhan_vien = ma_nv;
            if (check_var = 0) then
				signal sqlstate '45000'
				set message_text = 'Mã nhân viên không tồn tại';
			else
				select count(1) into check_var from khach_hang
				where ma_khach_hang = ma_kh;
				if (check_var = 0) then
					signal sqlstate '45000'
					set message_text = 'Mã khách hàng không tồn tại';
				else
					select count(1) into check_var from dich_vu
					where ma_dich_vu = ma_dv;
					if (check_var = 0) then
						signal sqlstate '45000'
						set message_text = 'Mã dịch vụ không tồn tại';
					else
						insert into hop_dong 
                        values(ma_hd,nlhd,nkt,tien_dc,ma_nv,ma_kh,ma_dv);
					end if;
                end if;
			end if;
        end if;
    end//
delimiter ;
call sp_them_moi_hop_dong(14, '2022-5-12','2022-12-12',3123,2,5,3);
start transaction;
rollback;
commit;

-- 25.	Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng hop_dong thì hiển thị tổng số lượng bản ghi còn lại có trong bảng hop_dong ra giao diện console của database. Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.
drop trigger if exists tr_xoa_hop_dong;
delimiter //
create trigger tr_xoa_hop_dong
	after delete on hop_dong
    for each row
	begin
		declare quantity int default 0;
        declare output_text varchar(255);
        select count(1) into quantity from hop_dong;
        set output_text = CONCAT('Số lượng bản ghi trong bảng hợp đồng còn lại là ', quantity);
        signal sqlstate '01000'
		set message_text = output_text;
    end//
delimiter ;
delete from hop_dong
where ma_hop_dong = 13;
start transaction;
rollback;
commit;