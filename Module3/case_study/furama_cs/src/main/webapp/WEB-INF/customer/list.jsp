<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Văn Bảo
  Date: 7/17/2023
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customer</title>
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
<h1>Customer List</h1>
<form action="/customer" method="get">
    <label for="search_inp">Search name Customer</label>
    <input type="text" name="kw" id="search_inp">
    <input type="submit">
    <input type="hidden" name="action" value="search">
</form>
<table>
    <tr>
        <th>ID</th>
        <th>Type</th>
        <th>Name</th>
        <th>Birthday</th>
        <th>Gender</th>
        <th>ID Card</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Address</th>
        <th colspan="2">Function</th>
    </tr>
    <c:forEach var="c" items="${customer_list}">
        <tr>
            <td>${c.id}</td>
            <td>${c.type.name}</td>
            <td>${c.name}</td>
            <td>
                <fmt:formatDate value="${c.birthday}" pattern="dd/MM/yyyy"/>
            </td>
            <td>
                <c:if test="${c.gender}">Male</c:if>
                <c:if test="${c.gender == false}">Female</c:if>
            </td>
            <td>${c.cardID}</td>
            <td>${c.phone}</td>
            <td>${c.email}</td>
            <td>${c.address}</td>
            <td><a onclick="confirmDelete(${c.id})">Delete</a></td>
            <td><a href="/customer?action=edit&id=${c.id}">Edit</a></td>
        </tr>
    </c:forEach>
    <c:forEach items="${page_number}" var="n">
        <c:if test="${n==current_page}">
            <span class="page">${n}</span>
        </c:if>
        <c:if test="${n!=current_page}">
            <a class="page" href="/customer?action=list&current_page=${n}">${n}</a>
        </c:if>
    </c:forEach>
    <a class="page" href="/customer?action=create">Create a new Customer</a>
</table>
</body>
<script>
    function confirmDelete(id) {
        if (confirm("Bạn có chắc chắn muốn xóa dữ liệu này?")) {
            window.location.href = "customer?action=delete&id=" + id;
        }
    }
</script>
</html>
