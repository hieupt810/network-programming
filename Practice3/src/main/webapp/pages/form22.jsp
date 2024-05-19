<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="../assets/css/form22.css" />
        <script>
            function AddPrice(amount) {
                with (this) {
                    price = amount;
                }
            }

            function Food(img, name, type, content) {
                this.img = img;
                this.name = name;
                this.type = type;
                this.content = content;
                this.price = 0;
                this.AddPrice = AddPrice;
            }
        </script>
    </head>

    <body>
        <div class="container">
            <div class="row">
                <div class="content">
                    <script>
                        var MyFood = new Food(
                            "1",
                            "Mì trộn",
                            "Đồ ăn nhanh",
                            "Đảo trộn đều tay tô mì lòng mề siêu chất lượng"
                        );
                        MyFood.AddPrice(25000);
                        document.write(
                            '<img src="../assets/img/oop/' +
                                MyFood.img +
                                '.png">'
                        );
                        document.write("<h4>" + MyFood.content + "</h4>");
                        document.write(
                            "<p> <strong> Tên món ăn: </strong>" +
                                MyFood.name +
                                "</p>"
                        );
                        document.write(
                            "<p> <strong> Loại: </strong>" +
                                MyFood.type +
                                "</p>"
                        );
                        document.write(
                            "<p> <strong> Giá: </strong>" +
                                MyFood.price +
                                "</p>"
                        );
                    </script>
                </div>
                <div class="content">
                    <script>
                        var MyFood = new Food(
                            "2",
                            "Bánh Pía",
                            "Đồ ngọt",
                            "Thám thính tiệm bánh pía người Hoa hơn 70 năm tại Sài Gòn"
                        );
                        MyFood.AddPrice(50000);
                        document.write(
                            '<img src="../assets/img/oop/' +
                                MyFood.img +
                                '.png">'
                        );
                        document.write("<h4>" + MyFood.content + "</h4>");
                        document.write(
                            "<p> <strong> Tên món ăn: </strong>" +
                                MyFood.name +
                                "</p>"
                        );
                        document.write(
                            "<p> <strong> Loại: </strong>" +
                                MyFood.type +
                                "</p>"
                        );
                        document.write(
                            "<p> <strong> Giá: </strong>" +
                                MyFood.price +
                                "</p>"
                        );
                    </script>
                </div>
                <div class="content">
                    <script>
                        var MyFood = new Food(
                            "3",
                            "Phở bắc",
                            "Bữa chính",
                            "Tuyệt phẩm hương vị phở hai miền nam bắc"
                        );
                        MyFood.AddPrice(50000);
                        document.write(
                            '<img src="../assets/img/oop/' +
                                MyFood.img +
                                '.png">'
                        );
                        document.write("<h4>" + MyFood.content + "</h4>");
                        document.write(
                            "<p> <strong> Tên món ăn: </strong>" +
                                MyFood.name +
                                "</p>"
                        );
                        document.write(
                            "<p> <strong> Loại: </strong>" +
                                MyFood.type +
                                "</p>"
                        );
                        document.write(
                            "<p> <strong> Giá: </strong>" +
                                MyFood.price +
                                "</p>"
                        );
                    </script>
                </div>
            </div>

            <div class="row">
                <div class="content">
                    <script>
                        var MyFood = new Food(
                            "4",
                            "Cháo lòng",
                            "Bữa chính",
                            "Quán cháo lòng 40 năm tuổi tại Sài Gòn"
                        );
                        MyFood.AddPrice(30000);
                        document.write(
                            '<img src="../assets/img/oop/' +
                                MyFood.img +
                                '.png">'
                        );
                        document.write("<h4>" + MyFood.content + "</h4>");
                        document.write(
                            "<p> <strong> Tên món ăn: </strong>" +
                                MyFood.name +
                                "</p>"
                        );
                        document.write(
                            "<p> <strong> Loại: </strong>" +
                                MyFood.type +
                                "</p>"
                        );
                        document.write(
                            "<p> <strong> Giá: </strong>" +
                                MyFood.price +
                                "</p>"
                        );
                    </script>
                </div>
                <div class="content">
                    <script>
                        var MyFood = new Food(
                            "5",
                            "Cà phê muối",
                            "Nước uống",
                            "Giải mã cơn sốt cà phê muối"
                        );
                        MyFood.AddPrice(23000);
                        document.write(
                            '<img src="../assets/img/oop/' +
                                MyFood.img +
                                '.png">'
                        );
                        document.write("<h4>" + MyFood.content + "</h4>");
                        document.write(
                            "<p> <strong> Tên món ăn: </strong>" +
                                MyFood.name +
                                "</p>"
                        );
                        document.write(
                            "<p> <strong> Loại: </strong>" +
                                MyFood.type +
                                "</p>"
                        );
                        document.write(
                            "<p> <strong> Giá: </strong>" +
                                MyFood.price +
                                "</p>"
                        );
                    </script>
                </div>
                <div class="content">
                    <script>
                        var MyFood = new Food(
                            "6",
                            "Bánh tráng trộn",
                            "Đồ ăn vặt",
                            "Hú hồn kiểm chứng kem bánh tráng trộn"
                        );
                        MyFood.AddPrice(42000);
                        document.write(
                            '<img src="../assets/img/oop/' +
                                MyFood.img +
                                '.png">'
                        );
                        document.write("<h4>" + MyFood.content + "</h4>");
                        document.write(
                            "<p> <strong> Tên món ăn: </strong>" +
                                MyFood.name +
                                "</p>"
                        );
                        document.write(
                            "<p> <strong> Loại: </strong>" +
                                MyFood.type +
                                "</p>"
                        );
                        document.write(
                            "<p> <strong> Giá: </strong>" +
                                MyFood.price +
                                "</p>"
                        );
                    </script>
                </div>
            </div>
        </div>
    </body>
</html>
