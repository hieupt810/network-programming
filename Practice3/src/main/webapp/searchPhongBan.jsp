<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.PhongBan" %>
<%@ page import="bo.PhongBanBo" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tìm kiếm phòng ban</title>
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
            width: 80%;
            margin: 0 auto;
            margin-top: 20px;
        }

        .search-form {
            margin-bottom: 20px;
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
    <h1>Tìm kiếm phòng ban</h1>
</header>
<div class="container">
    <div class="search-form">
        <form action="searchPhongBan.jsp" method="GET">
            <input type="text" name="searchKeyword" placeholder="Nhập từ khóa tìm kiếm">
            <button type="submit">Tìm kiếm</button>
        </form>
    </div>
    <%
        // Xử lý yêu cầu tìm kiếm phòng ban
        String searchKeyword = request.getParameter("searchKeyword");
        if (searchKeyword != null && !searchKeyword.isEmpty()) {
            PhongBanBo phongBanBo = new PhongBanBo();
            List<PhongBan> phongBanList = phongBanBo.searchPhongBan(searchKeyword);
            if (!phongBanList.isEmpty()) {
    %>
    <h2>Kết quả tìm kiếm cho từ khóa: <%= searchKeyword %></h2>
    <table>
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
    <p>Không tìm thấy kết quả phù hợp với từ khóa <%= searchKeyword %>.</p>
    <%
        }
    } else {
    %>
    <p>Vui lòng nhập từ khóa tìm kiếm và nhấn nút "Tìm kiếm".</p>
    <%
        }
    %>
</div>
</body>
</html>
