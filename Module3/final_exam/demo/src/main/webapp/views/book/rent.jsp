<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Văn Bảo
  Date: 7/26/2023
  Time: 7:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rent Book</title>
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

        input[type="submit"], button {
            margin-top: 10px;
            padding: 5px 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover, button:hover {
            background-color: #0056b3;
        }

        input[type="hidden"] {
            display: none;
        }

        a {
            /*color: #007bff;*/
            text-decoration: none;
            /*font-size: 16px;*/
            /*padding: 10px 20px;*/
            /*background-color: #ddd;*/
        }

        /*a:hover {*/
        /*    color: #ddd;*/
        /*    background-color: darkgreen;*/
        /*}*/

        .error {
            color: red;
            padding: 0;
        }
    </style>
</head>
<body>
<h1 align="center">Mượn sách</h1>
<form action="/book" method="post">
    <table>
        <tr>
            <td>Mã mượn sách</td>
            <td><input type="text" name="id" value="${this_book.id}"/></td>
        </tr>
        <tr>
            <td>Tên sách</td>
            <td><input type="text" name="name" disabled value="${this_book.name}"/></td>
        </tr>
        <tr>
            <td>Tên học sinh</td>
            <td>
                <select name="student">
                    <c:forEach var="s" items="${student_list}">
                        <option value="${s.id}">${s.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Ngày mượn sách</td>
            <td><input type="date" disabled value="<fmt:formatDate value='${this_date}' pattern='yyyy-MM-dd'/>"
                       id="birthday"
                       name="rent_date"/></td>
        </tr>
        <tr>
            <td>Ngày trả sách</td>
            <td><input type="date" name="back_date"/></td>
            <td class="error"><c:if test="${errorDate != null}">${errorDate}</c:if></td>
        </tr>
    </table>
    <input type="submit" value="Mượn sách">
    <button><a onclick="confirmBack()">Hủy</a></button>
    <input type="hidden" name="action" value="rent">
</form>
</body>
<script>
    function confirmBack() {
        if (confirm("Bạn có chắc chắn muốn quay lại?")) {
            window.location.href = "/book";
        }
    }
</script>
</html>
