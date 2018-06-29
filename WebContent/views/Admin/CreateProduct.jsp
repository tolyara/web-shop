
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Создать новую позицию товара</title>
</head>
<body>

<h1>Добавление новой позиции товара</h1> <br>
<p align="center" style="color: red;"> ${ERROR_PRODUCT_CREATE} </p>

<form action="${pageContext.servletContext.contextPath}/admin/create-product" method="POST">
    <table>
        <tr>
            <td align="right"> Введите наименование : </td>
            <td>
                <input type="text" name="productname" value="test">
            </td>
        </tr>
                <tr>
            <td align="right"> Введите категорию : </td>
            <td>
                <input type="text" name="category_id_fk" value="1">
            </td>
        </tr>
                <tr>
            <td align="right"> Введите производителя : </td>
            <td>
                <input type="text" name="manufacturer_name_fk" value="TEST">
            </td>
        </tr>
                <tr>
            <td align="right"> Введите цену : </td>
            <td>
                <input type="text" name="price" value="111">
            </td>
            <td align="right"> Данное поле не может быть меньше 0 </td>
        </tr>
                <tr>
            <td align="right"> Введите дату изготовления : </td>
            <td>
                <input type="text" name="creation_date" value="2011.01.01">
            </td>
            <td align="right"> Формат даты - yyyy.MM.dd </td>
        </tr>
                <tr>
            <td align="right"> Введите цвет : </td>
            <td>
                <input type="text" name="colour" value="test">
            </td>
        </tr>
                <tr>
            <td align="right"> Введите размер : </td>
            <td>
                <input type="text" name="size" value="test">
            </td>
        </tr>
        <tr>
            <td align="right"> Введите доступное количество на складе : </td>
            <td>
                <input type="text" name="amount_in_storage" value="111">
            </td>
            <td align="right"> Данное поле не может быть меньше 0 </td>
        </tr> 
        <tr> 
        	<td>...</td>
         </tr>
        <tr>
            <td>
                <input type="submit" align="center" value="Добавить">
            </td>
        </tr>
    </table>
</form>

<a href="${pageContext.servletContext.contextPath}/admin/view">
		Вернуться </a>

</body>
</html>
