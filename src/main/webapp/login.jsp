<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>登录</title>
</head>
<body>
<form method="post" action="login">
    邮箱：<input name="email"/>
    <br>
    密码：<input name="password"/><span style="color: red;">${cw}</span>
    <br>
    <input type="submit" value="登录"/>
    <form>
</body>
</html>
