<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
    <form method="post" action="update" enctype="multipart/form-data">
        选择头像：<input type="file" name="img">
        <br>
        昵称：<input type="text" name="name">
        <br>
        个性签名：<input type="text" name="signature">
        <br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
