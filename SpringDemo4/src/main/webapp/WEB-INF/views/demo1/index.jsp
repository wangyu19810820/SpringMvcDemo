<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page  isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>controller.Demo1</h1>
<s:url value="/spittler/register1/{aa}" var="registerUrl" scope="request">
    <s:param name="aa" value="b'b"/>
    <s:param name="cc" value="d'd"/>
</s:url>
<a href="${registerUrl}">${registerUrl}</a><br/>
<s:escapeBody htmlEscape="true">
    <h1>welcome</h1>
</s:escapeBody>
</body>
</html>
<script>
    var con = '<s:escapeBody javaScriptEscape="true"><h1>welcome</h1></s:escapeBody>';
    alert(con)
</script>