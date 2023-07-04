<%--
  Created by IntelliJ IDEA.
  User: Văn Bảo
  Date: 7/4/2023
  Time: 1:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Product</title>
</head>
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
<body>
<h1>Create new product</h1>
<form action="/product" method="post">
    <table>
        <tr>
            <td>ID</td>
            <td><input type="text" name="id"/></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td><input type="text" name="quantity"/></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price"/></td>
        </tr>
        <tr>
            <td>Date release</td>
            <td><input type="text" placeholder="dd/MM/yyyy" name="dateRelease"/></td>
        </tr>
    </table>
    <input type="hidden" name="action" value="create">
    <input id="submitBtn" type="submit" value="Add">
</form>
<a href="/product">Return to show list</a>
</body>
</html>
