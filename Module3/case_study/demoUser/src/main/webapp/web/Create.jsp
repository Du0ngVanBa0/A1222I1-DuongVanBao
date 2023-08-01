<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Create User</title>
    <style>
        /* styles.css */
        h1 {
            color: #333;
        }

        table {
            margin-top: 20px;
        }

        table td {
            padding: 5px;
        }

        input[type="text"], select {
            width: 200px;
            padding: 5px;
        }

        input[type="submit"] {
            margin-top: 10px;
            padding: 5px 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        input[type="hidden"] {
            display: none;
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

        .error {
            padding: 0;
            color: red;
            font-size: 15px;
        }
    </style>
</head>
<body>
<h1>Create new User</h1>
<a href="/user">Return to list</a>
<form action="/user" method="post">
    <table>
        <tr>
            <td>ID</td>
            <td><input type="text" name="id"/></td>
            <td class="error"><c:if test="${error_id != null}">${error_id}</c:if></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"/></td>
            <td class="error"><c:if test="${error_name != null}">${error_name}</c:if></td>
        </tr>
        <tr>
            <td>Code</td>
            <td><input placeholder="U-XXXX, X={1,9}" type="text" name="code"/></td>
            <td class="error"><c:if test="${error_code != null}">${error_code}</c:if></td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td><input type="date" placeholder="dd/MM/yyyy" id="birthday" name="birthday"/></td>
            <td class="error"><c:if test="${error_birthday != null}">${error_birthday}</c:if></td>
        </tr>
        <tr>
            <td>Role</td>
            <td>
                <c:forEach items="${roles}" var="r">
                    <label for="role_${r.id}">${r.name}</label>
                    <input type="checkbox" name="role" id="role_${r.id}" value="${r.id}">
                </c:forEach>
            </td>
        </tr>
    </table>
    <input type="submit" value="Add" id="submit_btn">
    <input type="hidden" name="action" value="create">
</form>
</body>
</html>
