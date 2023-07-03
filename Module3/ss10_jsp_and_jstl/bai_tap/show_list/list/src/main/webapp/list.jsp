<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Customer list - JSTL</h1>
<table border="1px solid black">
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Tuổi</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach items="${customerList}" var="s">
        <tr>
            <td>${s.name}</td>
            <td>${s.dOB}</td>
            <td>${s.address}</td>
            <td><img src="${s.urlImage}" width="100px" alt=""></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>