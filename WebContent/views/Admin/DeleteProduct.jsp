
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Подтверждение удаления</title>
</head>
<body>

<h1>Удаление товара из каталога</h1> <br>

	<p>
		Вы действительно хотите удалить товар ${product.id}
		${product.productName}? <br> Удаление товара из каталога может
		повлиять на корректность заказа пользователей, <br> в корзине
		которых сейчас присутствует данный товар.
	</p>
	<form
		action="${pageContext.servletContext.contextPath}/admin/delete-product"
		method="POST">
		<input type="hidden" name="id" value="${product.id}"> <input
			type="submit" align="center" value="Удалить товар из каталога">
	</form>

	<a href="${pageContext.servletContext.contextPath}/admin/view">
		Вернуться </a>


</body>
</html>
