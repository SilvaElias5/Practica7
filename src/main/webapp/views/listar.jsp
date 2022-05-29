<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar suscriptores</title>
</head>
<body>
	<h1>Listar Suscriptores</h1>
	<table border>
		<tr>
			<td>|Id |</td>
			<td>|Nombre pila|</td>
			<td>|Apellido paterno|</td>
			<td>|Apellido materno|</td>
			<td>|Servicio|</td>
			<td>|Fecha de nacimiento|</td>
			<td>|Plan|</td>
			<td>|Estatus|</td>
		</tr>

		<c:forEach var="usuario" items=" ${lista}">
			<tr>
				<td><c:out value="${usuario.id}"></c:out></td>

				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>