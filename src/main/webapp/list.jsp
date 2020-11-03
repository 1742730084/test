<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>显示</title>
<head>
    <title>Title</title>
</head>
<body>
    <img src="image/${user.image}">
    <br>
    <span>${user.name}</span>
    <br>
    <span>${user.signature}</span>
    <br>
    <a href="list2" style="font-size: 36px;">B</a>
</body>
</html>
