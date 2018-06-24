
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Редактировать товар</title>
</head>
<body>

	<h1>Редактирование данных о товаре</h1>
	<br>

	<form
		action="${pageContext.servletContext.contextPath}/admin/edit-product"
		method="POST">
		<input type="hidden" name="id" value="${product.id}">
		<table>
			<tr>
				<td align="right">Новое наименование :</td>
				<td><input type="text" name="productname"
					value="test2"></td>
				<td align="right">Текущее наименование - "${product.productName}"</td>	
			</tr>
			</tr>
			<tr>
				<td align="right">Новая категория :</td>
				<td><input type="text" name="category_id_fk" value="2">
				</td>
				<td align="right">Текущая категория - "${product.categoryId}"</td>
			</tr>
			<tr>
				<td align="right">Новый производитель :</td> 
				<td><input type="text" name="manufacturer_name_fk" value="TEST">
				</td>
				<td align="right">Текущий производитель - "${product.manufacturerName}"</td>
			</tr>
			<tr>
				<td align="right">Новая цена :</td>
				<td><input type="text" name="price" value="222"></td>
				<td align="right">Текущая цена - "${product.price}"</td>
			</tr>
			<tr>
				<td align="right">Новая дата изготовления :</td>
				<td><input type="text" name="creation_date" value="2022.02.02">
				</td>
				<td align="right">Текущая дата изготовления - "${product.creationDate}"</td>
				<td align="right">Формат даты - yyyy.MM.dd</td>
			</tr>
			<tr>
				<td align="right">Новый цвет :</td>
				<td><input type="text" name="colour" value="test222"></td>
				<td align="right">Текущий цвет - "${product.colour}"</td>
			</tr>
			<tr>
				<td align="right">Новый размер :</td>
				<td><input type="text" name="size" value="test222"></td>
				<td align="right">Текущая размер - "${product.size}"</td>
			</tr>
			<tr>
				<td align="right">Новое количество на складе :</td>
				<td><input type="text" name="amount_in_storage" value="222">
				<td align="right">Текущее количество - "${product.amount}"</td>
				</td>
			</tr>
			<tr>
				<td>...</td>
			</tr>
			<tr>
				<td><input type="submit" align="center" value="Изменить" /></td>
			</tr>
		</table>
	</form>

	<a href="${pageContext.servletContext.contextPath}/admin/view">
		Вернуться </a>

</body>
</html>
