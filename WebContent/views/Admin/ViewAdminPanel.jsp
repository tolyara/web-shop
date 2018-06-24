
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Панель управления</title>
<style>
<%@
include file ='/css/style.css' 
%>
</style>
</head>
<body class="admin">

	<h1>Панель управления</h1>
	<p>Вы вошли под логином ${LOGGED_ACCOUNT}, роль ${ACCOUNT_ROLE}<br><br> <a href="${pageContext.servletContext.contextPath}/admin/orders"> Перейти к просмотру заказов пользователей</a></p> <br>

	<%--Каталог товаров--%>

	<div class="products">
		<table border="1" id="grid">
			<caption>Каталог товаров</caption>
			<thead>
			<tr class="table_head">
				<th>- ID -</th>
				<th class="th_productName" data-type="string">- Наименование -</th>
				<th>- Категория -</th>
				<th>- Производитель -</th>
				<th class="th_price" data-type="number">- Цена -</th>
				<th>- Дата изготовления -</th>
				<th>- Цвет -</th>
				<th>- Размер -</th>
				<th>- Количество <br> на складе -
				</th>
				<th>- Действия -</th>
			</tr>
			<thead>
			<%-- В переменной products передаются только значения hashmap товаров --%>
			<tbody>
			<c:forEach var="product" items="${products}" varStatus="status">
				<tr valign="top">
					<td>${product.id}</td>
					<td>${product.productName}</td>
					<td>${product.categoryId}</td>
					<td>${product.manufacturerName}</td>
					<td>${product.price}</td>
					<td>${product.creationDate}</td>
					<td>${product.colour}</td>
					<td>${product.size}</td>
					<td>${product.amount}</td>
					<td><a
						href="${pageContext.servletContext.contextPath}/admin/edit-product?id=${product.id}">
							Редактировать </a> <a
						href="${pageContext.servletContext.contextPath}/admin/delete-product?id=${product.id}">
							Удалить </a><br></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<a
			href="${pageContext.servletContext.contextPath}/views/Admin/CreateProduct.jsp">
			Добавить товар </a> <br> <br> <br> <br>
		<form action="${pageContext.servletContext.contextPath}/logout"
			method="POST">
			<input type="submit" align="center" value="Выйти из системы">
		</form>
		<p></p>
	</div>

	<%--Аккаунты--%>

	<div class="accounts">
		<table border="1">
			<caption>Аккаунты</caption>
			<tr class="table_head">
				<td>- Логин -</td>
				<td>- Статус -</td>
				<td>- Действия -</td>
			</tr>
			<%-- В переменной accounts передаются только значения hashmap аккаунтов --%>
			<c:forEach var="account" items="${accounts}" varStatus="status">
				<tr valign="top">
					<td>${account.login}</td>
					<td>${account.isActive}</td>
					<td><a href="${pageContext.servletContext.contextPath}/admin/change-account-status?login=${account.login}&currentStatus=${account.isActive}"> Изменить <br> статус </a><br></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<p style="margin-left: 50px;">true - активен, false - заблокирован</p>
		<p>  </p>
    	<p style="margin-left: 50px;"> Внимание! Изменение статуса на <br> противоположный происходит автоматически, <br> без подтверждения.
        </p>
	</div>

	<%--Данный скрипт взят и "допилен" под нужды проекта с ресурса http://plnkr.co/edit/im9GDgRDAHMGORMXeSvU?p=preview--%>
	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		// сортировка таблицы
		// использовать делегирование!
		// должно быть масштабируемо:
		// код работает без изменений при добавлении новых столбцов и строк

		var grid = document.getElementById('grid');

		grid.onclick = function(e) {
			if (e.target.tagName != 'TH')
				return;

			// Если TH -- сортируем
			sortGrid(e.target.cellIndex, e.target.getAttribute('data-type'));
		};

		function sortGrid(colNum, type) {
			var tbody = grid.getElementsByTagName('tbody')[0];

			// Составить массив из TR
			var rowsArray = [].slice.call(tbody.rows);

			// определить функцию сравнения, в зависимости от типа
			var compare;

			switch (type) {
			case 'number':
				compare = function(rowA, rowB) {
					return rowA.cells[colNum].innerHTML
							- rowB.cells[colNum].innerHTML;
				};
				break;
			case 'string':
				compare = function(rowA, rowB) {
					return rowA.cells[colNum].innerHTML > rowB.cells[colNum].innerHTML;
				};
				break;
			}

			// сортировать
			rowsArray.sort(compare);

			// Убрать tbody из большого DOM документа для лучшей производительности
			grid.removeChild(tbody);

			// добавить результат в нужном порядке в TBODY
			// они автоматически будут убраны со старых мест и вставлены в правильном порядке
			for (var i = 0; i < rowsArray.length; i++) {
				tbody.appendChild(rowsArray[i]);
			}

			grid.appendChild(tbody);

		}
	</script>

</body>
</html>
