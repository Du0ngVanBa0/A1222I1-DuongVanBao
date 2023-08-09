<%--
  Created by IntelliJ IDEA.
  User: Văn Bảo
  Date: 8/9/2023
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Mail</title>
</head>
<body>
<h1>Edit mail</h1>
<form:form action="/mail/edit" method="post" modelAttribute="mail">
    <table>
        <tr>
            <th>Languages:</th>
            <td>
                <form:hidden path="mailID"/>
                <form:select path="language" items="${languages}"/>
            </td>
        </tr>
        <tr>
            <th>Page Size:</th>
            <td>
                <form:select path="pageSize" items="${sizes}"/>
            </td>
        </tr>
        <tr>
            <th>Spams filter:</th>
            <td>
                <form:checkbox path="haveSpamsFilter" id="spam_filter"/>
                <label for="spam_filter">Enable spams filter</label>
            </td>
        </tr>
        <tr>
            <th>Signature:</th>
            <td>
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <th></th>
            <td>
                <input type="submit" value="Update">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
