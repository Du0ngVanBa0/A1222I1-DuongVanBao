<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Văn Bảo
  Date: 7/19/2023
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Customer</title>
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
<h1>Create new product</h1>
<a href="/customer">Return to list</a>
<form action="/customer" method="post">
    <table>
        <tr>
            <td>Type</td>
            <td>
                <select name="category_id">
                    <c:forEach items="${customer_types}" var="ct">
                        <option
                                <c:if test="${this_customer.type.id == ct.id}">selected</c:if>
                                value="${ct.id}">${ct.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" value=${this_customer.name} name="name"/></td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td><input type="text" value=${this_customer.birthday} placeholder="dd/MM/yyyy" name="birthday"/></td>
            <td class="error"><c:if test="${errorDate != null}">${errorDate}</c:if></td>
        </tr>
        <tr>
            <td>Gender</td>
            <td><select name="gender">
                <option
                        <c:if test="${this_customer.gender == true}">selected</c:if> value="true">Male
                </option>
                <option
                        <c:if test="${this_customer.gender == false}">selected</c:if> value="false">Female
                </option>
            </select></td>
        </tr>
        <tr>
            <td>ID Card</td>
            <td><input type="text" value=${this_customer.cardID} name="id_card"/></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="text" value=${this_customer.phone} name="phone"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" value=${this_customer.email} name="email"/></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" value=${this_customer.address} name="address"/></td>
        </tr>
    </table>
    <input type="submit" value="Edit">
    <input type="hidden" name="action" value="edit">
    <input type="hidden" name="id" value="${this_customer.id}">
</form>
</body>
</html>
