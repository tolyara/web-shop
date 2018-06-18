
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Вход в систему </title>
</head>
<body>

<h1>Вход в систему</h1>
<p>Тестовые аккаунты для входа: </p>
<p>администратор - логин Admin, пароль 1234 </p>
<p>пользователь - логин User, пароль 5678 </p> <br>

<form action="${pageContext.servletContext.contextPath}/login" method="POST">
    <table>
        <tr>
            <td align="right"> Введите логин : </td>
            <td>
                <input type="text" name="login">
            </td>
        </tr>
        <tr>
            <td align="right"> Введите пароль : </td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
        <tr> 
        <tr> 
            <td>...</td>
        </tr>
         <tr> 
            <td>
                <input type="submit" align="center" value="Войти">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
