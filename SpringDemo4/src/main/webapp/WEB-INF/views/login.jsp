<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/7/2
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/login1" method="post">
        <input type="text" name="username">
        <input type="password" name="password">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input type="submit">
    </form>
</body>
</html>
