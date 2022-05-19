<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear</title>
</head> 	
<body>
<h1>Crear Suscriptor</h1>
<form action="controlServer" method="post">
<input type="hidden" name="opcion" value="insertar">
<table border>


<tr>Nombre pila:</tr>
<input type="text" name="nombre" size="25"></input>
<tr>Apellido Paterno:</tr>
<input type="text" name="paterno" size="25"></input>

<tr>Apellido Materno:</tr>
<input type="text" name="materno" size="25"></input>

<tr><td>Servicio</td></tr>
<td><input type="text" name="servicio" size="15"></input></td>

<tr><td>Fecha de nacimiento</td></tr>
<tr><td>Formato ddmmaaaa</td></tr>
<td><input type="text" name="fecha" size="10"></input></td>

<tr><td>Plan</td></tr>
<td><input type="text" name="plan" size="5"></input></td>


<tr><td>Estatus</td></tr>
<td><input type="text" name="estatus" size="2"></input></td>

</table>
<input type = "submit" value="Insertar">

</form>


</body>
</html>