<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/5/20
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sm" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
    <style>
        span.error {
            color: coral;
        }
        div span.error {
            color: red;
        }
        label.error {
            color: deeppink;
        }
        input.error {
            border: 1px solid red;
        }
    </style>
</head>
<body>
    <h1><sm:message code="welcome"></sm:message></h1>
    <sf:form method="post" commandName="spittler" enctype="multipart/form-data">

        <p><input type="file" name="profilePicture"></p>

        <input type="submit" value="Register">

    </sf:form>
</body>
</html>
