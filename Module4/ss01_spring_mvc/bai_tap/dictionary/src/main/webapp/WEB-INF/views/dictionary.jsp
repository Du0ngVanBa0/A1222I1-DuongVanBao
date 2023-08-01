<%--
  Created by IntelliJ IDEA.
  User: Văn Bảo
  Date: 8/1/2023
  Time: 10:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
        <title>Translate to Vietnamese</title>
</head>
<body>
<form method="get" action="/search">
    <fieldset>
        <legend>Translate Vietnamese</legend>
        <table>
            <tr>
                <td>Enter English word:</td>
                <td><input type="text" name="word" placeholder="English"></td>
                <td><input type="submit" value="translate"></td>
            </tr>
            <tr>
                <td>${trans}</td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
