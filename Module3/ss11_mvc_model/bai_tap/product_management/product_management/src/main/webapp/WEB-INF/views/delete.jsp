<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Văn Bảo
  Date: 7/4/2023
  Time: 1:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
    <style>
        h1 {
            color: #333;
            background-color: #F2F2F2;
            padding: 10px;
            border-radius: 5px;
        }

        form {
            margin-top: 20px;
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #333;
        }

        select {
            width: 200px;
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
        }

        input[type="submit"] {
            background-color: #FFCC00;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
        }

        a {
            text-decoration: none;
            display: inline-block;
            margin-top: 10px;
            padding: 5px 10px;
            background-color: #FFCC00;
            color: #fff;
            border: 1px solid  #FFCC00;
            transition: border-color 0.3s, background-color 0.3s;
        }

        a:hover {
            color: #333;
            background-color: #F2F2F2;
            border-color: #333;
        }
    </style>
</head>
<body>
<h1>Delete Product</h1>
<form action="/product" method="post">
    <label for="product">ID</label>
    <select name="productID" id="product">
        <c:forEach items="${products}" var="e">
            <option value="${e.id}">${e.id}: ${e.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Delete">
    <input type="hidden" name="action" value="delete">
</form>
<a href="/product">Return to show list</a>
</body>
</html>
