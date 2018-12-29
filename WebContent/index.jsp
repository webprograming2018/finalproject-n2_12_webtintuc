<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
	<title>login</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
    <div class="large-header">
        <h1>Ðăng Nhập Hệ Thống</h1>
        <div class="main-agileits">
            <div class="form-w3-agile">
                <h2>Login Now</h2>
                <form action="login" method="post">
                    <div class="form-sub-w3">
                        <input type="text" name="username" autocomplete="off" placeholder="abc@gmail.com "  />
                    </div>
                    <div class="form-sub-w3">
                        <input type="password" name="password" autocomplete="off" placeholder="******" required="" />
                    </div>
                    <input type="checkbox" name=""><span> Remember</span>
                    <div>
                        <input type="submit" value="Login">
                    </div>
                    <div class="top">
                        <a class href="#">Forget password ?</a>
                        <a class href="#">Register account ?</a>
                    </div>                    
                </form>
            </div>
        </div>
    </div>
</body>
</html>
