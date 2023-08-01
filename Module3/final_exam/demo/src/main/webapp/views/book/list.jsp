<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Văn Bảo
  Date: 7/26/2023
  Time: 6:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Book</title>
    <style>
        table {
            margin: 20px 0;
            border-collapse: collapse;
            width: 100%;
        }

        th {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
            background-color: #007bff;
            color: #fff;
        }

        td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
            background-color: #f5f5f5;
        }

        tr:nth-child(even) td {
            background-color: #ddd;
        }

        tr:hover {
            background-color: #f0f0f0;
        }

        h1 {
            color: #333;
        }

        a {
            font-size: 16px;
            text-decoration: none;
            color: black;
        }

        a:hover {
            color: blue;
        }

        .page {
            color: #007bff;
            padding: 10px 20px;
            background-color: #ddd;
        }

        .page:hover {
            color: #ddd;
            background-color: darkgreen;
        }

        td a:hover {
            text-decoration: underline;
        }

        .error {
            color: red;
            font-size: 17px;
        }
    </style>
</head>
<body>
<h1 align="center">Danh sách sách</h1>
<table>
    <tr>
        <th>Mã Sách</th>
        <th>Tên Sách</th>
        <th>Tác giả</th>
        <th>Số lượng</th>
        <th>Mô tả</th>
        <th></th>
    </tr>
    <c:forEach var="c" items="${books}">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.author}</td>
            <td>${c.quantity}</td>
            <td>${c.description}</td>
            <td>
                <button><a href="/book?action=rent&id=${c.id}">Mượn</a></button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
