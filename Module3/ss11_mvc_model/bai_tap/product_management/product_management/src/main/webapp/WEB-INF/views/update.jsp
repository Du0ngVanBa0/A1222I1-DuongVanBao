<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Văn Bảo
  Date: 7/4/2023
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
            background-color: #FFFFFF;
            color: #000000;
        }

        th, td {
            border: 1px solid #000000;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #000000;
            color: #FFFFFF;
        }

        tr:nth-child(even) {
            background-color: #FFFFFF;
            color: #000000;
        }

        form {
            margin-top: 20px;
        }

        input[type="text"], input[type="submit"] {
            padding: 6px 10px;
            border: 1px solid #000000;
            background-color: #FFFFFF;
            color: #000000;
        }

        input[type="text"]::placeholder {
            color: #000000;
        }

        a, #submitBtn {
            display: inline-block;
            padding: 10px 20px;
            text-decoration: none;
            margin-top: 10px;
            border: 1px solid #FFFFFF;
            color: #FFFFFF;
            background-color: #000000;
        }

        a:hover, #submitBtn:hover {
            background-color: #FFFFFF;
            color: #000000;
            border-color: black;
        }
    </style>
</head>
<body>
<h1>Update product</h1>
<form action="/product" method="post">
    <table>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Quantity</td>
            <td>Price</td>
            <td>Date release</td>
        </tr>
        <tr>
            <td><input readonly type="text" name="id" value="${product.id}"/></td>
            <td><input type="text" name="name" value="${product.name}"/></td>
            <td><input type="text" name="quantity" value="${product.quantity}"/></td>
            <td><input type="text" name="price" value="${product.price}"/></td>
            <td><input type="text" name="dateRelease" value="${dateRelease}"/></td>
    </table>
    <input type="hidden" name="action" value="create">
    <input type="submit" id="submitBtn" value="Add">
</form>
<a href="/product">Return to show list</a>
</body>
</html>
