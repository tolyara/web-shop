
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Подтверждение удаления </title>
</head>
<body>

<p> Вы действительно хотите удалить товар ${product.id} ${product.productName}?
    Удаление товара из каталога может повлиять на текущие заказы пользователей. </p>
<form action="${pageContext.servletContext.contextPath}/admin/delete-product" method="POST">
    <input type="hidden" name="id" value="${product.id}">
    <input type="submit" align="center" value="Да">
</form>

</body>
</html>
