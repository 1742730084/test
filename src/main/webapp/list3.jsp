<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>列表</title>
    <script src="js/jquery-3.2.1.min.js"></script>
    <script>
        function del(id) {
            var flag = confirm("确定删除吗？");
            if(flag){
                location.href="delete2?id="+id;
            }
        }
    </script>
</head>
<body>
<form action="list3" method="post">
姓名：<input type="text" name="name" value="${name}"/><input type="submit" value="查询"/>
<table>
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
        <td>电话</td>
        <td>地址</td>
    </tr>
    <c:forEach items="${page}" var="u">
        <tr>
            <td>${u.id}</td>
            <td>${u.name}</td>
            <td>${u.age}</td>
            <td>${u.sex}</td>
            <td>${u.phone}</td>
            <td>${u.address}</td>
        </tr>
    </c:forEach>
</table>
</form>
<a href="list3?shang=s&page1=${shu}">上一页</a><span>${shu}</span><a href="list3?shang=x&page1=${shu}">下一页</a>
</body>
</html>

