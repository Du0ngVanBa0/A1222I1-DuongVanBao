<%--
  Created by IntelliJ IDEA.
  User: Văn Bảo
  Date: 8/11/2023
  Time: 8:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Medical Declaration</title>
</head>
<body>
<h1 align="center">Tờ Khai Y Tế</h1>
<form:form modelAttribute="declaration" method="post" action="create">
    <form:label path="name">Họ và tên</form:label>
    <br>
    <form:input path="name"/>
    <br>
    <form:label path="bornYear">Năm sinh</form:label>
    <form:select path="bornYear" items="${years}"/>
    <br>
    <form:label path="gender">Giới tính</form:label>
    <br>
    <form:radiobutton path="gender" value="1"/> Nam
    <form:radiobutton path="gender" value="0"/> Nữ
    <br>
    <form:label path="nationality">Quốc tịch</form:label>
    <form:select path="nationality" items="${nationalities}"/>
    <br>
    <form:label path="identityCard">Số hộ chiếu hoặc số CMND</form:label>
    <br>
    <form:input path="identityCard"/>
    <br>
    <form:label path="transport">Thông tin đi lại </form:label>
    <br>
    <form:radiobutton path="transport" value="Tàu bay"/> Tàu bay
    <form:radiobutton path="transport" value="Tàu thuyền"/> Tàu thuyền
    <form:radiobutton path="transport" value="Ô tô"/> Ô tô
    <form:radiobutton path="transport" value="Khác"/> Khác
    <br>
    <form:label path="transportCode">Số hiệu phương tiện</form:label>
    <br>
    <form:input path="transportCode"/>
    <br>
    <form:label path="seats">Số ghế</form:label>
    <br>
    <form:input path="seats"/>
    <br>
    <form:label path="dateStart">Ngày khởi hành</form:label>
    <form:input path="dateStart"/>
    <br>
    <form:label path="camePlace">Nơi đến</form:label>
    <form:select path="camePlace" items="${places}"/>
    <br>
    <form:label path="address">Địa chỉ</form:label>
    <form:input path="address"/>
    <br>
    <form:label path="phone">Số điện thoại</form:label>
    <form:input path="phone"/>
    <br>
    <form:label path="email">Email</form:label>
    <form:input path="email"/>
    <br>
    <table>
        <tr>
            <th>Triệu chứng</th>
            <th>Có</th>
            <th>không</th>
        </tr>
        <c:forEach items="${declaration.diseases}" var="c" varStatus="i">
            <tr>
                <td>${c.name}</td>
                <td><form:radiobutton  path="diseases"   value="true"/></td>
                <td><form:radiobutton path="diseases" value="false"/></td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Gửi tờ khai">
</form:form>
</body>
</html>
