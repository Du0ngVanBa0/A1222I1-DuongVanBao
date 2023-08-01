<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Văn Bảo
  Date: 7/19/2023
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Employee</title>
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
            color: whitesmoke;
            background-color: red;
            font-size: 15px;
        }
    </style>
</head>
<body>
<h1>Create new Employee</h1>
<a href="/employee">Return to list</a>
<form action="/employee" method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td><input type="date" placeholder="dd/MM/yyyy" name="birthday"/></td>
            <td class="error"><c:if test="${errorDate != null}">${errorDate}</c:if></td>
        </tr>
        <tr>
            <td>Card ID</td>
            <td><input type="text" name="id_card"/></td>
        </tr>
        <tr>
            <td>Salary</td>
            <td><input type="text" name="salary"/></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="text" name="phone"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address"/></td>
        </tr>
        <tr>
            <td>Position</td>
            <td>
                <select name="position">
                    <c:forEach items="${positions}" var="c">
                        <option value="${c.id}">${c.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Education Degree</td>
            <td>
                <select name="education_degree">
                    <c:forEach items="${education_degrees}" var="c">
                        <option value="${c.id}">${c.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Division</td>
            <td>
                <select name="division">
                    <c:forEach items="${divisions}" var="c">
                        <option value="${c.id}">${c.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>User</td>
            <td>
                <select name="user">
                    <c:forEach items="${users}" var="c">
                        <option value="${c.username}">${c.username}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>
    <input type="submit" value="Add">
    <input type="hidden" name="action" value="create">
</form>
</body>
</html>