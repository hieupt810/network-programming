<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Thêm nhân viên</title>
    </head>

    <body>
        <h1>Thêm nhân viên</h1>
        <form action="nhanVien?action=add" method="post">
            Họ và tên: <input type="text" name="hoTen" /><br />
            Địa chỉ: <input type="text" name="diaChi" /><br />
            <input type="submit" value="Thêm" />
        </form>
        <a href="nhanVien">Quay lại danh sách</a>
    </body>
</html>
