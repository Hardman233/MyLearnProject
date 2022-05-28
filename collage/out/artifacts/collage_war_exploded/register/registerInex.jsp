<%--
  Created by IntelliJ IDEA.
  User: 11244
  Date: 2021/6/28
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册</title>
    <link rel="stylesheet" href="registerAll.css">
    <link rel="shortcut icon" href="image/ll.ico" type="image/x-ico">
</head>
<body>
    <form action="regCheck.jsp" method="post">
        <div class = "register">
            <h1 align="center">注册</h1>
            <input type="text" value="" name="username"  placeholder="UserName" class="utxt1" ><br/><br/>
            <input type="password" value="" name="userpwd"  placeholder="UserPassword" class = "utxt1"><br/><br/>

            <input type="submit" value="注册" class="submit1" >
            <br/><br/>
            <a href="../index.jsp"><input type="button" value="返回" class="submit1" ></a>
        </div>
    </form>
</body>
</html>
