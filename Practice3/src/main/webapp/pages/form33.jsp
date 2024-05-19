<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="../assets/css/form33.css" />
    </head>

    <body>
        <div class="container">
            <div class="content">
                <h1>Chuyển chữ thành vừa hoa vừa thường</h1>
                <form action="">
                    <input
                        type="text"
                        name="text1"
                        onblur="handleChangeType()"
                        id="text1"
                        placeholder="Enter input..."
                    />
                    <input
                        type="text"
                        name="text2"
                        placeholder="Result"
                        id="text2"
                    />
                </form>
            </div>
        </div>
    </body>
    <script>
        function handleChangeType() {
            var text1 = document.getElementById("text1");
            var text2 = document.getElementById("text2");
            var result = "";
            var str = text1.value;

            for (var i = 0; i < str.length; i++) {
                var char = str[i];
                if (char === char.toLowerCase()) {
                    result += char.toUpperCase();
                } else {
                    result += char.toLowerCase();
                }
            }

            text2.value = result;
        }
    </script>
</html>
