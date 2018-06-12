<%--
  Created by IntelliJ IDEA.
  User: Толянчик
  Date: 29.11.2017
  Time: 1:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Подтверждение действия </title>
</head>
<body>

<p> Вы действительно хотите удалить клиента ${client.id} ${client.surname} ${client.name}?
    Удаление клиента повлечет за собой удаление всех его питомцев. </p>
<form action="${pageContext.servletContext.contextPath}/client/delete" method="POST">
    <input type="hidden" name="id" value="${client.id}">
    <input type="submit" align="center" value="Да">
</form>

</body>
</html>
