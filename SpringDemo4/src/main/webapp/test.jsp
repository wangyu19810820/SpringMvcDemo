<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/6/17
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script
            src="https://code.jquery.com/jquery-3.2.1.js"
            integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
            crossorigin="anonymous"></script>
    <script src="base64.js" type="application/javascript"></script>
    <script>
        $(function() {
            var data1={"id":"2","message":"aaa"};
            console.log(JSON.stringify(data1));
            $.ajax({
                url:'http://localhost:8080/restful/get?id=1',
                dataType:'json',
                type:'get',
                contentType:'application/json',
                beforeSend:function(xhr){
                    xhr.setRequestHeader('Authorization', make_base_auth("admin", "1111"));
                },
//                data:JSON.stringify(data1),
                success:function(res) {
                    console.log(res)
                }
            })
        });

        function make_base_auth(user, password) {
            var tok = user + ':' + password;
            var hash = Base64.encode(tok);
            return "Basic " + hash;
        }
    </script>
</head>
<body>
    <form action="/logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input type="submit" value="退出">
    </form>
</body>
</html>
