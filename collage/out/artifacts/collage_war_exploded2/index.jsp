<%--
  Created by IntelliJ IDEA.
  User: 11244
  Date: 2021/6/28
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>登录</title>
  <link rel="stylesheet" href="all.css">
  <link rel="shortcut icon" href="image/ll.ico" type="image/x-ico">
</head>
<body>
<form action="loginChe.jsp" method="POST">
  <div class = "login">
    <h1 align="center">登入</h1>
    <input type="text" value="" name="username"  placeholder="UserName" class="utxt1" ><br/><br/>
    <input type="password" value="" name="userpwd"  placeholder="UserPassword" class = "utxt1"><br/><br/>

    <input type="submit" value="登录" class="submit1" >
    <br/><br/>
    <a href="register/registerInex.jsp"><input type="button" value="注册" class="submit1" ></a>
  </div>
</form>
</body>
</html>
