<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Văn Bảo
  Date: 7/5/2023
  Time: 6:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail of ${product.name}</title>
    <style>
        /* styles.css */
        h1 {
            color: #333;
        }

        a {
            color: #007bff;
            text-decoration: none;
            font-size: 16px;
            padding: 10px 20px;
            background-color: #ddd;
        }

        a:hover {
            color: #ddd;
            background-color: darkgreen;
        }

        table {
            margin-top: 20px;
        }

        table th, table td {
            padding: 5px;
        }

        table th {
            background-color: #007bff;
            color: #fff;
        }

        table td {
            background-color: #f5f5f5;
        }

    </style>
</head>
<body>
<h1>Detail of ${product.name}</h1>
<a href="/product">Return to list</a>
<table>
    <tr>
        <th>ID</th>
        <td>${product.id}</td>
    </tr>
    <tr>
        <th>Name</th>
        <td>${product.name}</td>
    </tr>
    <tr>
        <th>Quantity</th>
        <td>${product.quantity}</td>
    </tr>
    <tr>
        <th>Price</th>
        <td>${product.price}</td>
    </tr>
    <tr>
        <th>Date release</th>
        <td>
            <fmt:formatDate value="${product.dateRelease}" pattern="dd/MM/yyyy"/>
        </td>
    </tr>
    <tr>
        <th>Category</th>
        <td>${product.category.name}</td>
    </tr>
</table>
</body>
</html>
