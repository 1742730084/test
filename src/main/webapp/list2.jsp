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
    <a href="add2.jsp">添加</a>
    <table>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>性别</td>
            <td>电话</td>
            <td>地址</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${user}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.name}</td>
                <td>${u.age}</td>
                <td>${u.sex}</td>
                <td>${u.phone}</td>
                <td>${u.address}</td>
                <td><a href="u?id=${u.id}">修改</a></td>
                <td><a onclick="del(${u.id})">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="list3" style="font-size: 36px;">C</a>
</body>
</html>
