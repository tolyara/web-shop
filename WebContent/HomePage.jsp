
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<title>Главная страница</title>
</head>
<body>

	<h1>Добро пожаловать в web-приложение "Интернет-магазин"!</h1>
	<a href="${pageContext.servletContext.contextPath}/user/view">
		Перейти к просмотру товаров в роли пользователя </a>
	<a href="${pageContext.servletContext.contextPath}/admin/view">
		Перейти к управлению в роли администратора </a>

</body>
</html>
