<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/21
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="get">
       用户名： <input type="text" name="username" /><br>
        密码：<input type="text" name="password"/><br>

        <input type="submit" value="登录"/>
    </form>
</body>
</html>
