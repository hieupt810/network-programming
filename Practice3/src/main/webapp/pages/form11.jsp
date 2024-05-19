<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="../assets/css/form11.css" />
        <title>Login</title>
    </head>

    <body>
        <div class="container">
            <form action="" name="loginForm" id="loginForm">
                <div class="header">
                    <div class="icon">
                        <svg
                            xmlns="http://www.w3.org/2000/svg"
                            height="1em"
                            viewBox="0 0 448 512"
                        >
                            <path
                                d="M304 128a80 80 0 1 0 -160 0 80 80 0 1 0 160 0zM96 128a128 128 0 1 1 256 0A128 128 0 1 1 96 128zM49.3 464H398.7c-8.9-63.3-63.3-112-129-112H178.3c-65.7 0-120.1 48.7-129 112zM0 482.3C0 383.8 79.8 304 178.3 304h91.4C368.2 304 448 383.8 448 482.3c0 16.4-13.3 29.7-29.7 29.7H29.7C13.3 512 0 498.7 0 482.3z"
                            />
                        </svg>
                    </div>
                    <h2>Login</h2>
                </div>
                <div class="main">
                    <div class="form-control">
                        <span class="label">Username</span>
                        <input
                            type="text"
                            id="username"
                            name="username"
                            placeholder="Username"
                            onblur="checkValue('username')"
                        />
                        <span class="alert-username"
                            >Username must be at least 6 characters
                        </span>
                    </div>
                    <div class="form-control">
                        <span class="label">Password</span>
                        <input
                            type="password"
                            id="password"
                            name="password"
                            placeholder="Password"
                            onblur="checkValue('password')"
                        />
                        <span class="alert-password"
                            >Password must be at least 6 characters and not
                            contain spaces</span
                        >
                    </div>
                    <span class="reset" onclick="resetValue()">Reset all?</span>
                </div>
                <div class="footer">
                    <button type="button" onclick="handleSubmit()">
                        Get started
                    </button>
                </div>
            </form>
        </div>
    </body>
    <script>
        var password = document.getElementById("password");

        function checkValue(value) {
            var input = document.getElementById(value);
            var alert = document.querySelector(".alert-" + value);
            if (input.value.trim().length < 6) {
                input.classList.add("alert");
                alert.classList.add("show");
                return 0;
            } else {
                input.classList.remove("alert");
                alert.classList.remove("show");
                return 1;
            }
        }

        function resetValue() {
            document.getElementById("username").value = "";
            document.getElementById("password").value = "";
        }

        function handleSubmit() {
            if (checkValue("username") == !0 && checkValue("password") == !0) {
                document.getElementById("loginForm").submit();
            }
        }
    </script>
</html>
