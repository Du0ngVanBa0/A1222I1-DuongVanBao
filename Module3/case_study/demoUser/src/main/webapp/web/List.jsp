<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Văn Bảo
  Date: 7/20/2023
  Time: 8:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List User</title>
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
<h1>User List</h1>
<form action="/user" method="get">
    <div>
        <label for="search_name_inp">Search name User</label>
        <input type="text" name="kw_name" id="search_name_inp">
    </div>
<%--    <div>--%>
    <%--        <label for="search_code_inp">Search code User</label>--%>
    <%--        <input type="text" name="kw_code" id="search_code_inp">--%>
    <%--    </div>--%>
    <br>
    <input type="submit" value="Search">
    <input type="hidden" name="action" value="search">
</form>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Code</th>
        <th>Birthday</th>
        <th>Date Release</th>
        <th>Role</th>
        <th colspan="2">Function</th>
    </tr>
    <c:forEach var="c" items="${users}">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.code}</td>
            <td>
                <fmt:formatDate value="${c.birthday}" pattern="dd/MM/yyyy"/>
            </td>
            <td>
                <fmt:formatDate value="${c.dateRelease}" pattern="dd/MM/yyyy"/>
            </td>
            <td>
                <c:forEach items="${c.roleList}" var="r">
                    <p>${r.name}</p>
                </c:forEach>
            </td>
            <td><a onclick="confirmDelete(${c.id},'${c.code}')">Delete</a></td>
            <td><a href="/user?action=edit&id=${c.id}">Edit</a></td>
        </tr>
    </c:forEach>
    <c:forEach items="${page_number}" var="n">
        <c:if test="${n==current_page}">
            <span class="page">${n}</span>
        </c:if>
        <c:if test="${n!=current_page}">
            <a class="page" href="/user?action=${dispatcher}&current_page=${n}">${n}</a>
        </c:if>
    </c:forEach>
    <a class="page" href="/user?action=create">Create a new User</a>
</table>
</body>
<script>
    function confirmDelete(id, code) {
        console.log("Bạn có chắc chắn muốn xóa User:[" + code + "]?");
        if (confirm("Bạn có chắc chắn muốn xóa User:[" + code + "]?")) {
            window.location.href = "user?action=delete&id=" + id;
        }
    }
</script>
</html>

