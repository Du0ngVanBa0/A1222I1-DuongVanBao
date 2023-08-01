<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Văn Bảo
  Date: 7/21/2023
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Employee</title>
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
<h1>Employee List</h1>
<form action="/employee" method="get">
    <div>
        <label for="search_name_inp">Search name Employee</label>
        <input type="text" name="kw_name" id="search_name_inp">
        <br>
    </div>
    <div>
        <label for="search_id_inp">Search ID Employee</label>
        <input type="text" name="kw_id" id="search_id_inp">
        <span class="error"><c:if test="${id_error != null}">${id_error}</c:if></span>
        <br>
    </div>
    <input type="submit" value="Search">
    <input type="hidden" name="action" value="search">
</form>
<form action="/employee" method="post" id="main_form">
    <table>
        <tr>
            <th>Select</th>
            <th>ID</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Card ID</th>
            <th>Salary</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Position</th>
            <th>Education Degree</th>
            <th>Division</th>
            <th>User</th>
            <th colspan="2">Function</th>
        </tr>
        <c:forEach var="c" items="${employees}">
            <tr>
                <td><input type="checkbox" name="ids" value="${c.id}"></td>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>
                    <fmt:formatDate value="${c.birthday}" pattern="dd/MM/yyyy"/>
                </td>
                <td>${c.cardID}</td>
                <td>${c.salary}</td>
                <td>${c.phone}</td>
                <td>${c.email}</td>
                <td>${c.address}</td>
                <td>${c.position.name}</td>
                <td>${c.educationDegree.name}</td>
                <td>${c.division.name}</td>
                <td>${c.user.username}</td>
                <td><a onclick="confirmDelete(${c.id})">Delete</a></td>
                <td><a href="/employee?action=edit&id=${c.id}">Edit</a></td>
            </tr>
        </c:forEach>
        <a class="page" href="/employee?action=create">Create a new Employee</a>
    </table>
    <input type="button" value="Delete All Selection" onclick="confirmDeleteAll()">
    <input type="hidden" name="action" value="delete_all">
</form>
</body>
<script>
    function confirmDelete(id) {
        if (confirm("Bạn có chắc chắn muốn xóa Employee có id:" + id + "?")) {
            window.location.href = "employee?action=delete&id=" + id;
        }
    }
    function confirmDeleteAll(){
        if (confirm("Bạn có chắc chắn muốn xóa tất cả Employee đã chọn hay không?")) {
            document.getElementById("main_form").submit();
        }
    }
</script>
</html>
