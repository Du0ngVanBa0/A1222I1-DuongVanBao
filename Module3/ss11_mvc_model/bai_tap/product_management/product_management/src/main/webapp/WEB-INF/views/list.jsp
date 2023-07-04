<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Văn Bảo
  Date: 7/4/2023
  Time: 12:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
</head>
<style>
    h1 {
        text-align: center;
    }

    table {
        border-collapse: collapse;
        width: 100%;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: left;
    }

    th {
        background-color: #008080;
        color: #fff;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    a {
        display: inline-block;
        padding: 10px 20px;
        background-color: #008080;
        color: #fff;
        text-decoration: none;
        margin-top: 10px;
        border: 1px solid transparent;
    }

    a:hover {
        color: #008080;
        background-color: #fff;
        border-color: black;
    }
</style>
<body>
<h1>List Product</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Date release</th>
        <th>Change</th>
    </tr>
    <c:forEach items="${products}" var="s">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.quantity}</td>
            <td>${s.price}</td>
            <td><fmt:formatDate value="${s.dateRelease}" pattern="dd/MM/yyyy"/></td>
            <td><a href="/product?action=update&id=${s.id}">Update Product.</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/product?action=create">Add new Product.</a>
<a href="/product?action=delete">Delete Product.</a>
</body>
</html>
