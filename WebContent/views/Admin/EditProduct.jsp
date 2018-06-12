<%--
  Created by IntelliJ IDEA.
  User: Толянчик
  Date: 17.11.2017
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Редактировать клиента</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/client/edit" method="POST">
    <input type="hidden" name="id" value="${client.id}">
    <table>
        <tr>
            <td align="right" > Новая фамилия : </td>
            <td>
                <input type="text" name="surname" value="${client.surname}">
            </td>
        </tr>
        <tr>
            <td align="right" > Новое имя : </td>
            <td>
                <input type="text" name="name" value="${client.name}">
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Изменить"/></td>
        </tr>
    </table>
</form>

</body>
</html>
