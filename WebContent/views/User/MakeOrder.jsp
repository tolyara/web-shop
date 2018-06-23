
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Подтверждение заказа</title>
</head>
<body class="user">

<h1>Проверка данных</h1>
<p>Проверьте данные, и, если все корректно, подтвердите действие </p>

	<table border="1">
		<caption>Заказ</caption>
		<tr class="table_head">
			<td>- ID продукта -</td>
			<td>- Наименование -</td>
			<td>- Количество -</td>
		</tr>
		<c:forEach var="bufferProduct" items="${bufferProducts}"
			varStatus="status">
			<tr valign="top">
				<td>${bufferProduct.id}</td>
				<td>${bufferProduct.productName}</td>
				<td>${bufferProduct.amount}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<form
		action="${pageContext.servletContext.contextPath}/user/make-order"
		method="POST">
		<input type="hidden" name="userLogin" value="${userLogin}"> <input
			type="submit" align="center" value="Оформить заказ">
	</form>

</body>
</html>
