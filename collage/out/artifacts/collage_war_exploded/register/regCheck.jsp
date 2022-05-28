<%--
  Created by IntelliJ IDEA.
  User: 11244
  Date: 2021/6/28
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Bean.userService" %>
<%@ page import="Bean.user" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>验证</title>
    <link rel="stylesheet" href="registerAll.css">
    <link rel="shortcut icon" href="image/ll.ico" type="image/x-ico">
</head>
<body>
<div class = "register">
<%
    userService userService = new userService();
    user user = null;
    boolean flag = false;
    //解决乱码
    request.setCharacterEncoding("utf-8");
    //获取注册用户名
    String jname = request.getParameter("username");
    //获取注册密码
    String jpwd = request.getParameter("userpwd");
    //打包
    user = new user(jname,jpwd);
    flag = userService.addUser(user);
    if (flag == true)
        out.print("注册成功！,6秒后跳回主页");
    else
        out.print("注册失败！,6秒后跳回主页");
    response.setHeader("Refresh","6;URL=../index.jsp");
%>
</div>
</body>
</html>
