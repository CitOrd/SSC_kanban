<%-- 
    Document   : AgregarPlanEstudio
    Created on : Apr 27, 2021, 7:20:23 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Agregar Plan de Estudio</title>
</head>

<body>
    <header>
        <img src="image.png" title="Seleccione una imagen">
        <h1>Nombre de la Universidad</h1>
    </header>
    <div class="navbar">
        <ul class="navbar">
            <li><a href="InicioMateriaPlanEstudio.html">Inicio</a></li>
            <li><a href="MateriasACM.html">Materias</a></li>
            <li><a href="PlanEstudioACM.html">Planes de Estudio</a></li>
        </ul>
    </div>
    <main>
        <form>
			<h2>Agregar un Plan de Estudio</h2>
			<h3>Por favor, llene el formulario para agregar un nuevo plan de estudio.</h3>
			<p>Nombre del plan:</p>
			<input type="text" class="field">
			<p>Especialidad:</p>
			<input type="text" class="field">
			<p>Semestre:</p>
			<p class="center-content"><select name="semestre" class="field">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
              </select></p>
			<p class="center-content"><input type="submit" class="button" value="Registrar Plan de Estudio"></p>
		</form>
    </main>
    <footer>
        <p>Derechos Reservados. &copy</p>
    </footer>
</body>
</html>