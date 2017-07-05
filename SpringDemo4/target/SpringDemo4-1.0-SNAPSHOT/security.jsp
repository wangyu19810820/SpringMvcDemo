<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/7/4
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>username:<security:authentication property="principal.username"
                                var="loginid" scope="request"/></p>
    <p>Credentials:<security:authentication property="Credentials" /></p>
    <p>details:<security:authentication property="details" /></p>
    username:${loginid}<br/>

    <security:authorize access="hasRole('ROLE_admin')">
        admin content<br/>
    </security:authorize>

    <security:authorize access="isAuthenticated() and principal.username == 'admin' ">
        authenticated and name is admin, can see<br/>
    </security:authorize>

    <security:authorize url="/admin">
        has authenticated of /admin can see<br/>
    </security:authorize>
</body>
</html>
