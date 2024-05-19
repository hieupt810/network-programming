<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="../assets/css/binding.css"/>
</head>

<body>
<div class="container">
    <div class="content">
        <h1>Đồng bộ dữ liệu từ text sang select</h1>
        <form action="" name="form1" method="">
            <select name="select1" id="">
                <option value="0">0</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
            </select>
            <input type="text" name="input1" id="" autofocus/>
            <button onclick="bindingData()" class="btn" type="button">
                Chọn
            </button>
        </form>
    </div>
</div>
</body>
<script>
    function bindingData() {
        var input1 = document.form1.input1.value;
        document.form1.select1.value = input1;
    }
</script>
</html>
