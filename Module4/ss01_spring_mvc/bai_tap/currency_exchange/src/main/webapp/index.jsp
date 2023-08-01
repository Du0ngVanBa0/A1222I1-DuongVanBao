<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/currency">
    <label for="usd">usd</label>
    <input type="number" name="usd" id="usd" value="1">
    <label for="rate"></label>
    <input type="number" name="rate" id="rate" value="23000">
    <input type="submit" value="Exchange">
</form>
</body>
</html>