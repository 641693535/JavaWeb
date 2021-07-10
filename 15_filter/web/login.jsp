<%--
  Created by IntelliJ IDEA.
  User: 64169
  Date: 2021/7/2
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/15_filter/">
</head>
<body>

    这里是Login.jsp登陆页面<br/>
    <form action="loginServlet" method="get">
        用户名:<input type="text" name="user" value="${cookie.user.value}"/><br/>
        密码:<input type="passwd" name="passwd"/><br/>
        <input type="submit" value="提交"/>
    </form>

</body>
</html>
