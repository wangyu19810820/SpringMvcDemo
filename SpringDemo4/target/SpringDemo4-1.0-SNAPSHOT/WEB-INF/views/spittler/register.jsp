<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/5/19
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <p>name:<input type="text" name="name"></p>
    <p>password:<input type="text" name="password"></p>
    <input type="submit">
</form>
</body>
</html>
