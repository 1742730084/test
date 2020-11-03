<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<html>
<head>
    <meta charset="utf-8">
    <title>注册</title>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-3.2.1.min.js"></script>
    <script>
        $(function () {
            $("#email").change(function () {
                $.post("cong?email="+$("#email").val(),
                    function (date) {
                        if(date == 1){
                            alert("邮箱名已被注册！");
                        }
                    }
                );
            });
        });
    </script>
</head>
<body>
    <h1>A</h1>
    <form method="post" action="add">
        邮箱：<input id="email" name="email"/><span style="color: red;">${cong}</span>
        <br>
        密码：<input name="password"/>
        <br>
        <input type="submit" value="注册"/>
    <form>
</body>
</html>
