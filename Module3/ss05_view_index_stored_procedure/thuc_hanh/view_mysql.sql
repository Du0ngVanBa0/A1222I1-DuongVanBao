CREATE VIEW customer_views AS

SELECT customerNumber, customerName, phone

FROM  customers;

select * from customer_views;

-- View được định nghĩ từ một và chỉ một bảng cơ sở
-- Trong câu lệnh SELECT định nghĩa view không được sử dụng từ khoá DISTINCT, TOP, GROUP BY, HAVING, ORDER_BY và UNION.
-- Trong view không có bất kỳ SUBQUERIES nào được định nghĩa
-- Các thành phần xuất hiện trong danh sách chọn của câu lệnh SELECT phải là các cột trong các bảng cơ sở. Trong danh sách chọn không được chứa các biểu thức tính toán, các hàm gộp.
-- Các cột được ước lượng không thể bị cập nhật.
-- Tất cả các cột NOT NULL từ bảng ban đầu phải được bao trong view để cho truy vấn INSERT vận hành.
CREATE OR REPLACE VIEW customer_views AS

SELECT customerNumber, customerName, contactFirstName, contactLastName, phone

FROM customers

WHERE city = 'Nantes';
-- Xoá view
DROP VIEW customer_views;
