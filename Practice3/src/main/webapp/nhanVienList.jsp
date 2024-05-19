<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Danh sách nhân viên</title>
    </head>

    <body>
        <h1>Danh sách nhân viên</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Họ và tên</th>
                    <th>Địa chỉ</th>
                    <th>Thao tác</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="nhanVien" items="${nhanVienList}">
                    <tr>
                        <td>${nhanVien.id}</td>
                        <td>${nhanVien.hoTen}</td>
                        <td>${nhanVien.diaChi}</td>
                        <td>
                            <a href="nhanVien?action=edit&id=${nhanVien.id}"
                                >Sửa</a
                            >
                            <a href="nhanVien?action=delete&id=${nhanVien.id}"
                                >Xóa</a
                            >
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="nhanVien?action=add">Thêm nhân viên</a>
    </body>
</html>
