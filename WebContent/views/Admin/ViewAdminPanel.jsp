
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title> Панель управления </title>
    <style>
        <%@include file='/css/style.css' %>
    </style>
</head>
<body class="admin">

<h1>Панель управления</h1>
<p>Вы вошли под логином ${LOGGED_ACCOUNT}, роль ${ACCOUNT_ROLE}</p>

                <%--Каталог товаров--%>

<div class="products">
<table border="1">
    <caption> Каталог товаров </caption>
    <tr class="table_head">
        <td> - ID - </td>
        <td> - Наименование - </td>
        <td> - Категория - </td>
        <td> - Производитель - </td>
        <td> - Цена - </td>
        <td> - Дата изготовления - </td>
        <td> - Цвет - </td>
        <td> - Размер - </td>
        <td> - Действия - </td>
    </tr>
    <%-- В переменной products передаются только значения hashmap товаров --%>
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
            <td>
                <a href="${pageContext.servletContext.contextPath}/admin/edit-product?id=${product.id}"> Редактировать </a>
                <a href="${pageContext.servletContext.contextPath}/admin/delete-product?id=${product.id}"> Удалить </a><br>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.servletContext.contextPath}/views/Admin/CreateProduct.jsp"> Добавить товар </a> <br> <br> <br> <br>
<form action="${pageContext.servletContext.contextPath}/logout" method="POST">
    <input type="submit" align="center" value="Выйти из системы">
</form>
<p>  </p>
</div>

                    <%--Корзина--%>

<div class="basket">
    <table border="1">
        <caption> Корзина </caption>
        <tr class="table_head">
            <td> - ID - </td>
            <td> - Наименование - </td>
            <td> - Количество - </td>
        </tr>
        <c:forEach var="selectedProduct" items="${selectedProducts}" varStatus="status">
            <tr valign="top">
                <td>${selectedProduct.id}</td>
                <td>${selectedProduct.productName}</td>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/basket/delete?id=${selectedProduct.id}"> Удалить </a><br>
                </td>
            </tr>
        </c:forEach>
    </table> <br>
    <a class="link-make-order" href="${pageContext.servletContext.contextPath}/views/User/MakeOrder.jsp"> Оформить заказ </a> <br>
    <p>  </p>
    <p style="margin-left: 50px;"> Внимание! Удаление товара(-ов) из <br> корзины происходит автоматически, без <br> подтверждения.
        </p>
</div>

<%--Данный скрипт взят и "допилен" под нужды проекта с ресурса http://plnkr.co/edit/im9GDgRDAHMGORMXeSvU?p=preview--%>
<script>
    // сортировка таблицы
    // использовать делегирование!
    // должно быть масштабируемо:
    // код работает без изменений при добавлении новых столбцов и строк

    var grid = document.getElementById('grid');

    grid.onclick = function(e) {
        if (e.target.tagName != 'TH') return;

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
                    return rowA.cells[colNum].innerHTML - rowB.cells[colNum].innerHTML;
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
