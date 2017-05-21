<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/5/19
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>id:<c:out value="${spittle.id}"></c:out></p>
<p>msg:<c:out value="${spittle.message}"></c:out></p>
<p>date:<c:out value="${spittle.time}"></c:out></p>
</body>
</html>
