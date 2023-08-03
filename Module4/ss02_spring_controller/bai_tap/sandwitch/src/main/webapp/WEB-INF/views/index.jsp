<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Văn Bảo
  Date: 8/2/2023
  Time: 8:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${selected!=null}">
    <strong>Selected:
        <c:forEach items="${selected}" var="e">${e} </c:forEach>
    </strong>
</c:if>
<form action="/sandwich/save" method="post">
    <strong>Sandwich Condiments</strong>
    <input type="checkbox" name="condiments" id="Lettuce" value="Lettuce">
    <label for="Lettuce">Lettuce</label>
    <input type="checkbox" name="condiments" id="Tomato" value="Tomato">
    <label for="Tomato">Tomato</label>
    <input type="checkbox" name="condiments" id="Mustard" value="Mustard">
    <label for="Mustard">Mustard</label>
    <input type="checkbox" name="condiments" id="Sprouts" value="Sprouts">
    <label for="Sprouts">Sprouts</label>
    <input type="submit" value="Save">
</form>
</body>
</html>
