<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.PhongBan" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách phòng ban</title>
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
    <h1>Danh sách phòng ban</h1>
</header>
<div class="container">
    <div class="left-bar">
        <h3>Left Sidebar</h3>
        <!-- Nội dung của left sidebar -->
    </div>
    <div class="main-content">
        <h1>Danh sách phòng ban</h1>
        <%
            // Lấy danh sách phòng ban từ request
            List<PhongBan> phongBanList = (List<PhongBan>) request.getAttribute("phongBanList");
            if (phongBanList != null && !phongBanList.isEmpty()) {
        %>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Tên phòng ban</th>
                <th>Mô tả</th>
            </tr>
            <%
                for (PhongBan phongBan : phongBanList) {
            %>
            <tr>
                <td><%= phongBan.getId() %></td>
                <td><%= phongBan.getTenpb() %></td>
                <td><%= phongBan.getMota() %></td>
            </tr>
            <%
                }
            %>
        </table>
        <%
        } else {
        %>
        <p>Không có phòng ban nào.</p>
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
