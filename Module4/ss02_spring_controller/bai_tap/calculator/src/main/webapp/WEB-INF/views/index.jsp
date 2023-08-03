<%--
  Created by IntelliJ IDEA.
  User: Văn Bảo
  Date: 8/3/2023
  Time: 11:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculate/result" method="post">
    <h1>Calculator</h1>
    <input type="number" name="nb1">
    <input type="number" name="nb2">
    <br>
    <input type="submit" name="type" value="addition">
    <input type="submit" name="type" value="subtraction">
    <input type="submit" name="type" value="multiplication">
    <input type="submit" name="type" value="division">
    <br>
    <span>Result Division: ${result}</span>
</form>
</body>
</html>
