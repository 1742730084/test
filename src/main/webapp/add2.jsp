<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
    <script src="js/jquery-3.2.1.min.js"></script>
    <script>
        $(function () {
            $("#sex1").click(function () {
                $("#sex").val("男");
            });
            $("#sex2").click(function () {
                $("#sex").val("女");
            });
        });
    </script>
</head>
<body>
<form method="post" action="add2">
    <input type="hidden" name="id" value=""/>
    姓名：<input type="text" name="name" value=""/>
    年龄：<input type="text" name="age" value=""/>
    性别：<input id="sex" name="sex" type="radio" value="男">男<input id="sex2" name="sex" type="radio" value="女">女
    电话：<input name="phone" type="text">
    地址：<input name="address" type="text">
    <input type="submit" value="添加"/>
</form>
</body>
</html>
