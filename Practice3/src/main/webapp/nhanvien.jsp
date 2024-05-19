<%@ page import="model.NhanVien" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách nhân viên</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #333;
            color: white;
            padding: 10px;
            text-align: center;
        }

        .container {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }

        .left-bar, .right-bar {
            background-color: #f1f1f1;
            padding: 10px;
            flex-basis: 20%;
        }

        .main-content {
            background-color: #fff;
            padding: 20px;
            flex-grow: 1;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>

<body>
<header>
    <h1>Danh sách nhân viên</h1>
</header>
<div class="container">
    <div class="left-bar">
        <h3>Left Sidebar</h3>
        <!-- Nội dung của left sidebar -->
    </div>
    <div class="main-content">
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
    <div class="right-bar">
        <h3>Right Sidebar</h3>
        <!-- Nội dung của right sidebar -->
    </div>
</div>
</body>
</html>
