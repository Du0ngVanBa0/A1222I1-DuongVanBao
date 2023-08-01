<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Văn Bảo
  Date: 7/26/2023
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rent List</title>
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
    </style>
</head>
<body>
<h1>Thống kê sách đang cho mượn</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Book</th>
        <th>Author</th>
        <th>Student</th>
        <th>Class</th>
        <th>Date Rent</th>
        <th>Date Back</th>
    </tr>
    <c:forEach var="c" items="${rents}">
        <tr>
            <td>${c.id}</td>
            <td>${c.book.name}</td>
            <td>${c.book.author}</td>
            <td>${c.student.name}</td>
            <td>${c.student.s_class}</td>
            <td>
                <fmt:formatDate value="${c.rent_date}" pattern="dd/MM/yyyy"/>
            </td>
            <td>
                <fmt:formatDate value="${c.back_date}" pattern="dd/MM/yyyy"/>
            </td>
            <td>
        </tr>
    </c:forEach>
</table>
</body>
</html>