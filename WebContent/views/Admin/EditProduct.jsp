
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Редактировать товар</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/admin/edit-product" method="POST">
		<input type="hidden" name="id" value="${product.id}">
		<table>
			<tr>
				<td align="right">Новое наименование :</td>
				<td><input type="text" name="productname" value="${product.productName}">
				</td>
			</tr>
			<tr>
				<td><input type="submit" align="center" value="Изменить" /></td>
			</tr>
		</table>
	</form>

</body>
</html>
