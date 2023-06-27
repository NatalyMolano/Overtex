<%-- 
    Document   : newjsp
    Created on : 11/03/2023, 12:08:32 AM
    Author     : natal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Sesiones.jsp" %>
<!DOCTYPE html>
<!doctype html>
<html lang="en" class="h-100">
<head>
        <link href="CSS/cover.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/diseño_1.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

        <style>
            body {
                justify-content: center;
                align-items: center;
                height: 100vh;
            }

            .AdminUser {
                text-align: center;
                margin: 0 0px; /* Espacios laterales */
            }
            .AdminUser {
                text-align: center;
                margin: 0 20px;
                padding: 30px;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            .AdminUser h1 {
                color: #fff;

            }

            .AdminUser a {
                display: inline-block;
                margin-bottom: 10px;
                padding: 10px 20px;
                color: #ffffff; /* Color de texto personalizado */
                text-decoration: none;
                border-radius: 5px;
                transition: background-color 0.3s ease;
            }

            .AdminUser a i {
                margin-right: 5px;
            }

            .AdminUser a:hover {
                background-color: #EF6737; /* Color de fondo al pasar el cursor o enfocar */
                color: #ffffff; /* Color de texto al pasar el cursor o enfocar */
                border-color: #EF6737; /* Color del borde al pasar el cursor o enfocar */
            }

            .AdminUser h5 {
                color: #999;
            }
        </style>
        <script>
            function showDescription(description) {
                document.getElementById("description").textContent = description;
            }

            function hideDescription() {
                document.getElementById("description").textContent = "";
            }
        </script>
    </head>

    <body id="menus">
        <br>
        <header class="site-header sticky-top py-1" >
            <nav class="container d-flex flex-column flex-md-row justify-content-between" >
                <h2><span style="display: inline; color:#4C4C4C;  ">Over</span><span style="display: inline; color: #EF6737;">tex</span></h2>
         
            </nav>
            
        </header>
               
        <br>

        <div class="AdminUser">
            
            <br><br><br>
            <h1>¡Bienvenido al panel de Vendedor!</h1><br>

            <a href="Vista_Vendedor.jsp"onmouseover="showDescription('Obtén una visión general del negocio en el que haces parte y accede a estadísticas y métricas importantes.')" onmouseout="hideDescription()"><i class="fas fa-home"></i> Inicio</a>
            <a href="Venta_Comisiones.jsp" onmouseover="showDescription('Administra y actualiza tu inventario de productos, agrega nuevos elementos y realiza cambios en los existentes.')" onmouseout="hideDescription()"><i class="fas fa-cube"></i> Comision</a>
            <a href="VendedorRegistrarCLiente.jsp" onmouseover="showDescription('Gestiona tu base de datos de clientes, agrega nuevos clientes, actualiza información y visualiza historiales de compras.')" onmouseout="hideDescription()"><i class="fas fa-users"></i> Cliente</a>
           
            <br>

            <h5 id="description"></h5>

            <br><br>


        </div>
    </body>


</html>
