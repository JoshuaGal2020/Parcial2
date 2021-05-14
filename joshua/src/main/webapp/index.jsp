<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<meta charset="ISO-8859-1">
<title>Inicio - Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js&quot; integrity="
	sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</head>
<body>
	<script type="text/javascript">
			$(document).ready(function () {
				$.post('ControllerConsulta', {
					//Envio de datos a js
				}, function (response) {
					let datos = JSON.parse(response);

					console.log(datos);

					var tabla = document.getElementById('tablaDatos');
					for (let item of datos) {
						tabla.innerHTML +=
							`
					<tr>
						<td>${item.Id}</td>
						<td>${item.Nombre}</td>
						<td>${item.Apellido}</td>
						<td><a href="ControllerConsulta?Id=${item.Id}&Eliminar=btne" class="btn btn-danger">Eliminar</a>
						</td>
					</tr>
					`
						console.log(item.Pass);
					}
				});
			});
		</script>

	<form action="ControllerUser" method="post">
		<input type="submit" name="btniniciar" value="Iniciar sesion">
		<br>
		<input type="submit" name="btncerrar" value="Cerrar sesion">

	</form>
	<br>
	<table class="table table-dark table-striped" id="tablaDatos">
	<thead>
		<th>ID</th>
		<th>Nombre</th>
		<th>Apellido</th>
		<th>Acciones</th>	
	</thead>
	</table>
</body>

</html>