
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Создать новый аккаунт</title>
</head>
<body>

	<h1>Добавление нового аккаунта</h1>
	<br>

	<form
		action="${pageContext.servletContext.contextPath}/admin/create-user"
		method="POST">
		<table>
			<tr>
				<td align="right">Выберите роль (пользователь или
					администратор) :</td>
				<td><select size="1" name="role">
						<option selected disabled>Выберите роль</option>
						<option value="user">пользователь</option>
						<option value="admin">администратор</option>
				</select></td>
				</td>
			</tr>
			<tr>
				<td align="right">Введите логин :</td>
				<td><input type="text" name="accountName" autocomplete="new-password" value="">
				</td>
			</tr>
			<tr>
				<td align="right">Введите пароль :</td>
				<td><input type="password" name="accountPass" autocomplete="new-password" value="">
				</td>
			<tr>
				<td>...</td>
			</tr>
			<tr>
				<td><input type="submit" align="center" value="Добавить">
				</td>
			</tr>
		</table>
	</form>

	<a href="${pageContext.servletContext.contextPath}/admin/view">
		Вернуться </a>

</body>
</html>
