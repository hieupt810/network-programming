<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="../assets/css/sidebar.css" />
    </head>

    <body>
        <div class="container">
            <ul>
                <li>Action</li>
                <li onclick="changeFrameSrc('home')" class="home selected">
                    Trang chủ
                </li>
                <li onclick="changeFrameSrc('nhanvien')" class="nhanvien">
                    Xem nhân viên
                </li>
                <li onclick="changeFrameSrc('form22')" class="form22">
                    Xem phòng ban
                </li>
                <li onclick="changeFrameSrc('form33')" class="form33">
                    Tìm kiếm
                </li>
                <li onclick="changeFrameSrc('form44')" class="form44">
                    Cập nhật thông tin
                </li>
                <li onclick="changeFrameSrc('form55')" class="form55">
                    Xoá tất cả
                </li>
                <li onclick="changeFrameSrc('form66')" class="form66">
                    Trợ giúp chương trình
                </li>
            </ul>
        </div>
    </body>
    <script>
        function changeFrameSrc(option) {
            const iframe = parent.document.getElementById("main");
            const selectedItem = document.querySelector(`.${option}`);
            const allItems = document.querySelectorAll(".container li");

            iframe.src = `pages/${option}.jsp`;

            allItems.forEach((item) => {
                item.classList.remove("selected");
            });

            selectedItem.classList.add("selected");
        }
    </script>
</html>
