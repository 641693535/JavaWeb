<%--
  Created by IntelliJ IDEA.
  User: 64169
  Date: 2021/7/2
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="loginServlet" method="get">
    用户名：<input type="text" name="username" value="${cookie.username.value}"><br/>
    密  码：<input type="password" name="passwd"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
