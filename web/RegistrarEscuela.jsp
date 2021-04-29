<%-- 
    Document   : RegistrarEscuela
    Created on : Apr 27, 2021, 7:17:55 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>Registrar Escuela</title>
</head>
<body>
	<header>
		<img src="image.png" title="Seleccione una imagen">
		<h1>Nombre de la Universidad</h1>
	</header>
	<div class="navbar">
		<ul class="navbar">
				<li><a href="#">Inicio</a></li>
				<li><a href="#">Agregar Preparatoria</a></li>
				<li><a href="#">Bandeja de Validación</a></li>
		</ul>
	</div>
	<main>
		<form action="AgregarPreparatoria" method="post" name="capturaPreparatoria" >
                        
			<h2>Agregar una Preparatoria</h2>
			<h3>Por favor, llene el formulario para el registro de la preparatoria.</h3>
			<p>Nombre de la escuela:</p>
			<input type="text" id="nombre" class="field">
			<p>Clave:</p>
			<input type="text" id="clave" class="field">
			<p>Responsable:</p>
			<input type="text" id="responsable" class="field">
			<p>Logo:</p>
			<p class="center-content"><input type="file" id="imagen" class="button-file"></p>
			<p class="center-content"><input type="submit" class="button" value="Registrar Escuela"></p>
		</form>
	</main>
	<footer>
		<p>Derechos Reservados. &copy</p>
	</footer>
</body>
</html>