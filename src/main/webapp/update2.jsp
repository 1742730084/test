<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<head>
    <title>添加</title>
    <script src="js/jquery-3.2.1.min.js"></script>

</head>
<body>
    <form method="post" action="update2">
        <input type="hidden" name="id" value="${user.id}"/>
        姓名：<input type="text" name="name" value="${user.name}"/>
        年龄：<input type="text" name="age" value="${user.age}"/>
        性别：<input id="nan" name="sex" type="radio" value="男">男<input id="nv" name="sex" type="radio" value="女">女
        电话：<input name="phone" type="text" value="${user.phone}">
        地址：<input name="address" type="text" value="${user.address}">
        <input type="submit" value="修改"/>
    </form>
    <script>
        var j = jQuery.noConflict();

        var sex = "${user.sex}";

        if(sex == "男"){
            j("#nan").prop("checked",true);
        }else if(sex == "女"){
            j("#nv").prop("checked",true);
        }
    </script>
</body>
</html>
