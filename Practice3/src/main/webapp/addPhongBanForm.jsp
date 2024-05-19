<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Thêm mới phòng ban</title>
    </head>

    <body>
        <h1>Thêm mới phòng ban</h1>
        <form action="phongBan" method="POST" accept-charset="UTF-8">
            <input type="hidden" name="action" value="add" />
            <label for="tenpb">Tên phòng ban:</label>
            <input type="text" id="tenpb" name="tenpb" />
            <br />
            <label for="mota">Mô tả:</label>
            <textarea id="mota" name="mota"></textarea>
            <br />
            <button type="submit">Thêm mới</button>
        </form>
        <a href="phongBan">Quay lại</a>
    </body>
</html>
