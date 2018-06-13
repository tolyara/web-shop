
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Создать новую позицию товара</title>
</head>
<body>

<form action="${pageContext.servletContext.contextPath}/admin/create-product" method="POST">
    <table>
        <tr>
            <td align="right"> Введите наименование товара : </td>
            <td>
                <input type="text" name="productname">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" align="center" value="Добавить">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
