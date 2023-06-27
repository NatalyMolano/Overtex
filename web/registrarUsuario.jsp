<%-- 
    Document   : registrarUsuario
    Created on : 23/03/2023, 10:05:19 PM
    Author     : Janus
--%>

<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Sesiones.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compra</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
        <link href="CSS/diseño.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.2.0/css/bootstrap.min.css">
        <link href="CSS/diseño.css" rel="stylesheet" type="text/css"/>
        <script defer src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script defer src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
        <script defer src="https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap5.min.js"></script>
        <script defer src="script.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link href="https://cdn.datatables.net/1.13.4/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>
        <link href="CSS/estilo_fondo.css" rel="stylesheet" type="text/css"/>
        <style>
            body {
                background-color: #f2f2f2;
            }

            .form-container {
                background-color: #ffffff;
                padding: 20px;
                margin-top: 50px;
                width: 70%;
                margin: 0 auto;
            }

            .form-usuario {
                background-color: #ffffff;
                padding: 20px;
                margin-top: 50px;
                width: 80%;
                margin: 0 auto;
            }

            .form-group label, .form-group input {
                font-size: 15px;
            }

            .product-heading {
                background-color: #dddddd;
                color: #000000;
                padding: 10px;
                margin-bottom: 20px;
                text-align: left;
                font-weight: bold;
                border-radius: 5px;
                margin-top: -20px;
            }

            .btn-icon {
                display: flex;
                align-items: center;
                justify-content: center;
            }

            .btn-icon i {
                margin-right: 5px;
            }
        </style>

    </head>

    <body>
        <header class="site-header sticky-top py-1" style="background-color: #4C4C4C;">
            <nav class="container d-flex flex-column flex-md-row justify-content-between" >
                <h3><span style="display: inline; color:#FFFFFF  ">Over</span><span style="display: inline; color: #EF6737;">tex</span></h3>
                <a  type="button" class="btn btn-custom" href="Vista_Administrador.jsp" class="text-warning">Menu</a>


                <div class="dropdown">
                    <button class="btn btn-custom">Producto</button>
                    <div class="dropdown-content">
                        <a href="AdministradorRegistrarProducto.jsp">Generar Producto</a>
                        <a href="AdministradorListaProductos.jsp">Listar Producto</a>
                        <a href="AdministradorListaProductosMovimientos.jsp">Movimientos Producto</a>
                    </div>
                </div>
                <div class="dropdown">
                    <button class="btn btn-custom">Compra</button>
                    <div class="dropdown-content">
                        <a href="Compra_Nuevo.jsp">Generar compra</a>
                        <a href="AdministradorListarCompra.jsp">Listar Compras</a>
                        <a href="AdministradorListaComprasMovimientos.jsp">Movimientos Compras</a>

                    </div>
                </div>

            </div><div class="dropdown">
            <button class="btn btn-custom">Venta</button>
            <div class="dropdown-content">
                <a href="Venta_Nuevo.jsp">Registrar Venta</a>
                <a href="AdministradorListarVenta.jsp">Listar Ventas</a>
                <a href="AdministradorListaVentasMovimientos.jsp">Movimientos Ventas</a>
            </div>
        </div>
        <div class="dropdown">
            <button class="btn btn-custom">Cliente</button>
            <div class="dropdown-content">
                <a href="AdministradorRegistrarCliente.jsp">Generar Cliente</a>
                <a href="AdministradorListarCliente.jsp">Listar Cliente</a>
            </div>
        </div>
        <div class="dropdown">
            <button class="btn btn-custom">Proveedor</button>
            <div class="dropdown-content">
                <a href="Proveedor_Registro.jsp" >Registro Proveedor</a>
                <a href="AdministradorListarProveedor.jsp">Lista Proveedor</a>
                <a href="AdministradorListarProveedorMovimientos.jsp">Movimientos Proveedor</a>
            </div>
        </div>
        <div class="dropdown">
            <button class="btn btn-custom">Usuario</button>
            <div class="dropdown-content">
                <a href="registrarUsuario.jsp">Registrar</a>
                <a href="UsuarioNuevo.jsp">Modificar</a>
            </div>
        </div>


    </nav>
</header>
<br>
<div class="form-container">
    <div class="product-heading">
        <i class="fas fa-pencil-alt"></i> 
        Registro Usuario
    </div>


    <%                String validChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; // Definimos los caracteres vÃ¡lidos
        int strLength = 10; // Definimos la longitud de la cadena de caracteres

        Random random = new Random(); // Creamos un objeto Random para generar nÃºmeros aleatorios
        StringBuilder strBuilder = new StringBuilder(strLength); // Creamos un objeto StringBuilder con la longitud deseada

        // Generamos 10 caracteres aleatorios
        strBuilder.append(validChars.charAt(random.nextInt(validChars.length())));
        strBuilder.append(validChars.charAt(random.nextInt(validChars.length())));
        strBuilder.append(validChars.charAt(random.nextInt(validChars.length())));
        strBuilder.append(validChars.charAt(random.nextInt(validChars.length())));
        strBuilder.append(validChars.charAt(random.nextInt(validChars.length())));
        strBuilder.append(validChars.charAt(random.nextInt(validChars.length())));
        strBuilder.append(validChars.charAt(random.nextInt(validChars.length())));
        strBuilder.append(validChars.charAt(random.nextInt(validChars.length())));
        strBuilder.append(validChars.charAt(random.nextInt(validChars.length())));
        strBuilder.append(validChars.charAt(random.nextInt(validChars.length())));

        String randomStr = strBuilder.toString(); // Convertimos el objeto StringBuilder en una cadena de caracteres
%>


    <div class="form-usuario">
        <form method="post" action="Usuario">
            <input type="hidden"  name="asunto" value="Datos de Usuario">
            <label>Documento Usuario *</label>
            <input  type="text" class="form-control" name="UsuDocumento" pattern="^[0-9]+$" required minlength="8" maxlength="10">
            <label>Ingrese Nombre y Apellido *</label>
            <input type="text" class="form-control" name="UsuNombre" required pattern="[a-zA-Z ]{4,15}" maxlength="30" size="20">

            <input type="hidden" name="Pass" value="<%=randomStr%>">
            <label>Email Usuario *</label><br>
            <input type="email" class="form-control" name="Usudireccion" required minlegth="5" maxlength="50" size="80">
            <label>Telefono Usuario *</label><br>
            <input  type="text" class="form-control" name="UsuTelefono" pattern="^[0-9]+$" required minlength="7" maxlength="10">

            <input  type="hidden"  name="UsuEstado" value="1" >
            <label>Rol Usuario *</label><br>
            <select style="width: 100%;" name='IdRol' class="btn btn-outline-secondary" >
                <option value='5001'>gerente</option>
                <option value='5000'>administrador</option>
                <option value ='5002'>Vendedor</option>
            </select>
            <br>
            <br>
            <center>
                <button style="width: 30%;" class="btn btn-secondary" data-toggle="tooltip" data-placement="top"> Registrar</button>
            </center>


            <input type="hidden" name="opcion" value="registrarUsuario">
        </form>
    </div>



    <%
        if (request.getAttribute("MensajeError") != null) {%>
    ${MensajeError}
    <%} else {%>
    ${MensajeExito}
    <% }
    %>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>
