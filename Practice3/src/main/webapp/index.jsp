<%-- Created by IntelliJ IDEA. To change this template use File | Settings |
File Templates. --%> <%@ page contentType="text/html;charset=UTF-8"
language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./assets/css/style.css" />
        <title>Department Management</title>
    </head>
    <body>
        <div class="container">
            <iframe
                src="./pages/header.jsp"
                id="header"
                frameborder="0"
            ></iframe>
            <div class="body">
                <iframe
                    src="./pages/sidebar.jsp"
                    id="sidebar"
                    frameborder="0"
                ></iframe>
                <iframe
                    src="./pages/home.jsp"
                    id="main"
                    frameborder="0"
                ></iframe>
                <iframe
                    src="./pages/right.jsp"
                    id="right"
                    frameborder="0"
                ></iframe>
            </div>
            <iframe
                src="./pages/footer.jsp"
                id="footer"
                frameborder="0"
            ></iframe>
        </div>
    </body>
</html>
