<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
spittle list<br/>
<c:forEach var="item" items="${spittleList}">
    <c:out value="${item.message}"></c:out><c:out value="${item.time}"></c:out><br/>
</c:forEach>
</body>
</html>
