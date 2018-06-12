<%--
  Created by IntelliJ IDEA.
  User: Толянчик
  Date: 17.11.2017
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Создать клиента</title>
</head>
<body>

<form action="${pageContext.servletContext.contextPath}/client/create" method="POST">
    <table>
        <tr>
            <td align="right"> Введите фамилию клиента : </td>
            <td>
                <input type="text" name="surname">
            </td>
        </tr>
        <tr>
            <td align="right"> Введите имя клиента : </td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" align="center" value="Добавить">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
