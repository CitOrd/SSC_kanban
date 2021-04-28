<%-- 
    Document   : MateriasACM
    Created on : Apr 27, 2021, 7:19:16 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Materias</title>
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
    <main class="main-materias-acm">
        <div class="menu-materias-acm">
            <h2>Materias</h2>
            <h3>Selecciona una opción para continuar:</h3>
            <p class="center-btnmacm"><a href="AgregarMateria.html"><input class="button-btnmacm"
                        type="button" value="Agregar"></a></p>
            <p class="center-btnmacm"><a href="InicioMateriaPlanEstudio.html"></a><input class="button-btnmacm"
                    type="button" value="Consultar"></a></p>
            <p class="center-btnmacm"><a href="InicioMateriaPlanEstudio.html"></a><input class="button-btnmacm"
                    type="button" value="Modificar"></a></p>
        </div>
    </main>
    <footer>
        <p>Derechos Reservados. &copy</p>
    </footer>
</body>

</html>