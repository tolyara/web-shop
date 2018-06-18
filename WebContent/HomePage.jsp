
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<title>Главная страница</title>
</head>
<body>

	<h1>Добро пожаловать в web-приложение "Интернет-магазин"!</h1>
	<a href="${pageContext.servletContext.contextPath}/login">
		Войти в систему как пользователь или администратор </a> <br> <br>
	<a href="${pageContext.servletContext.contextPath}/unregistered">
		Перейти к просмотру товаров как незарегистрированный пользователь </a>

</body>
</html>
