<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page import="model.PhongBan" %> <%@ page
import="bo.PhongBanBo" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Sửa phòng ban</title>
    </head>

    <body>
        <h1>Sửa phòng ban</h1>
        <% int id = Integer.parseInt(request.getParameter("id")); PhongBanBo
        phongBanBo = new PhongBanBo(); PhongBan phongBan =
        phongBanBo.getById(id); %>
        <form action="phongBan" method="POST" accept-charset="UTF-8">
            <input type="hidden" name="action" value="edit" />
            <input type="hidden" name="id" value="<%= phongBan.getId() %>" />
            <label for="tenpb">Tên phòng ban:</label>
            <input
                type="text"
                id="tenpb"
                name="tenpb"
                value="<%= phongBan.getTenpb() %>"
            />
            <br />
            <label for="mota">Mô tả:</label>
            <textarea id="mota" name="mota"><%= phongBan.getMota() %></textarea>
            <br />
            <button type="submit">Lưu thay đổi</button>
        </form>
        <a href="phongBan">Quay lại</a>
    </body>
</html>
