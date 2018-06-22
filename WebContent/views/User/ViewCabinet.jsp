
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title> Личный кабинет </title>
    <style>
        <%@include file='/css/style.css' %>
    </style>
</head>
<body>

<h1>Личный кабинет</h1>
<p>Здесь Вы можете просмотреть свои заказы <br> <a href="${pageContext.servletContext.contextPath}/user/view"> Вернуться в магазин </a> </p> 

                <%-- Список заказов --%>

<div class="orders">
<table border="1">
    <caption> Заказы </caption>
    <tr class="table_head">
        <td> - ID заказа - </td>
        <td> - Статус - </td>
        
        <td> - Категория - </td>
        <td> - Производитель - </td>
        <td> - Цена - </td>
        <td> - Дата изготовления - </td>
        <td> - Цвет - </td>
        <td> - Размер - </td>
        <td> - Количество <br> на складе - </td>
        <td> - Действия - </td>
    </tr>
    <%-- В переменной products передаются только значения hashmap товаров --%>
    <c:forEach var="order" items="${userOrders}" varStatus="status">
        <tr valign="top">
            <td>${order.id}</td>
            <td>${order.status}</td>
            <td>
            <c:forEach var="product" items="${order.orderedProducts}" varStatus="status">
                ${product.productName}<br>
            </td>   
            <td>${product.categoryId}</td>
            <td>${product.manufacturerName}</td>
            <td>${product.price}</td>
            <td>${product.creationDate}</td>
            <td>${product.colour}</td>
            <td>${product.size}</td>
            <td>${product.amount}</td>
            </c:forEach>
        </tr>
    </c:forEach> 
</table> <br>         
<form action="${pageContext.servletContext.contextPath}/logout" method="POST">
    <input type="submit" align="center" value="Выйти из системы">
</form> <br>
</div>

</body>
</html>
