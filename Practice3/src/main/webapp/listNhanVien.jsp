<%@ page import="model.NhanVien" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./assets/css/style.css">
    <title>Department Management</title>
</head>
<body>
<div class="container">
    <iframe src="./pages/header.jsp" id="header" frameborder="0"></iframe>
    <iframe src="./pages/sidebar.jsp" id="sidebar" frameborder="0"></iframe>
    <div id="main">
        <div class="body">
            <h1>Danh sách nhân viên</h1>
            <%
                // Lấy danh sách nhân viên từ request
                List<NhanVien> nhanVienList = (List<NhanVien>) request.getAttribute("nhanVienList");
                if (nhanVienList != null && !nhanVienList.isEmpty()) {
            %>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Họ và tên</th>
                    <th>Địa chỉ</th>
                </tr>
                <%
                    for (NhanVien nhanVien : nhanVienList) {
                %>
                <tr>
                    <td><%= nhanVien.getId() %></td>
                    <td><%= nhanVien.getHoten() %></td>
                    <td><%= nhanVien.getDiachi() %></td>
                </tr>
                <%
                    }
                %>
            </table>
            <%
            } else {
            %>
            <p>Không có nhân viên nào.</p>
            <%
                }
            %>
        </div>
    </div>

    <iframe src="./pages/right.jsp" id="right" frameborder="0"></iframe>
    <iframe src="./pages/footer.jsp" id="footer" frameborder="0"></iframe>
</div>
</body>
</html>
