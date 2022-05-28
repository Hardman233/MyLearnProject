<%@ page import="java.util.List" %>
<%@ page import="Bean.vote" %>
<%@ page import="Bean.voteService" %><%--
  Created by IntelliJ IDEA.
  User: 11244
  Date: 2021/6/30
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>参加投票</title>
    <link rel="stylesheet" href="join.css">
    <link rel="shortcut icon" href="image/ll.ico" type="image/x-ico">
</head>
<body>
<form action="joinVote.jsp" method="post">
    <div class = "voteBox">
        <h2 align="center">投票列表</h2>
    <h3><input type="checkbox" value="1" name = "votePro"/>1.是否召开班会，同意请投票</h3>
    <h3><input type="checkbox" value="2" name = "votePro"/>2.是否重新竞选班干部，同意请投票</h3>
    <h3><input type="checkbox" value="3" name = "votePro"/>3.周二下午上课，同意请投票</h3>
    <h3><input type="checkbox" value="5" name = "votePro"/>4.关于暑假不放假留校补课通知，同意请投票</h3>
    <h3><input type="checkbox" value="6" name = "votePro"/>5.关于寒假不放假留校进行党课学习，同意请投票</h3>
    <h3><input type="checkbox" value="7" name = "votePro"/>6.关于提前缴纳学费，同意请投票</h3>
    <input type="submit" value="确定投票" align="center" class = "joinSubmit">
    </div>
</form>
    <div class="show">
<%
    boolean flag = false;
    voteService voteService = new voteService();
    String[] checkID = request.getParameterValues("votePro");
    if (checkID != null) {

        int size = java.lang.reflect.Array.getLength(checkID);

        for (int i = 0; i < size;i ++){
            int id = Integer.parseInt(checkID[i]);
            flag = voteService.updateVote(id);
        }
    }
    out.print("<p align = 'center' color = '#E0E3DA'>显示结果</p>");
    if (flag == true) {
        out.print("<p align = 'center' color = '#E0E3DA'>投票成功(3秒后回到主页)</p>");
        response.setHeader("Refresh","3;URL=voteIndex.jsp");
    }
%>
    </div>
</body>
</html>
