<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Sửa thông tin nhân viên</title>
    </head>

    <body>
        <h1>Sửa thông tin nhân viên</h1>
        <form action="nhanVien?action=edit" method="post">
            <input type="hidden" name="id" value="${nhanVien.id}" />
            Họ và tên:
            <input type="text" name="hoTen" value="${nhanVien.hoTen}" /><br />
            Địa chỉ:
            <input type="text" name="diaChi" value="${nhanVien.diaChi}" /><br />
            <input type="submit" value="Lưu" />
        </form>
        <a href="nhanVien">Quay lại danh sách</a>
    </body>
</html>
