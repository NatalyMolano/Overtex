<%-- 
    Document   : diseño
    Created on : 24/03/2023, 06:16:08 PM
    Author     : natal
--%>

<%@page import="ModeloVO.usuarioVO"%>
<%@page import="ModeloDAO.usuarioDAO"%>
<%@page import="ModeloVO.detalle_VentaVO"%>
<%@page import="ModeloDAO.detalle_VentaDAO"%>
<%@page import="ModeloVO.VentaVO"%>
<%@page import="ModeloDAO.VentaDAO"%>
<%@page import="ModeloDAO.ClienteDAO"%>
<%@page import="ModeloVO.ClienteVO"%>
<%@page import="ModeloVO.detalle_CompraVO"%>
<%@page import="ModeloDAO.detalle_CompraDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="ModeloDAO.ProductoDAO"%>
<%@page import="ModeloVO.ProductoVO"%>
<%@page import="ModeloDAO.ProveedoresDAO"%>
<%@page import="ModeloVO.ProveedoresVO"%>
<%@page import="ModeloDAO.CompraDAO"%>
<%@page import="ModeloVO.CompraVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Sesiones.jsp" %>
<%--<%@include file="Sesiones.jsp" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compra</title>
        <link href="CSS/estilo_fondo.css" rel="stylesheet" type="text/css"/>
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

    <%        ClienteVO cliVO = new ClienteVO();
        ClienteDAO cliDAO = new ClienteDAO();
        ProductoVO ProdVO = new ProductoVO();
        ProductoDAO ProdDAO = new ProductoDAO();

    %>
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
        <i class="fas fa-pencil-alt"></i> Registro Venta
    </div>

    <div class="d-flex">
        <div class="col-sm-4">
            <div class="card">
                <div class="card-body">
                    <%                            if (request.getAttribute("MensajeError") != null) {%>
                    <div class="alert alert-danger" role="alert">
                        ${MensajeError}
                    </div>
                    <%} else {%>
                    <div class="alert alert-light" role="alert">
                        ${MensajeExito}
                    </div>

                    <%
                        }
                    %>
                    <form class="row g-3" method="post" action="Producto">
                        <div class="form-group">

                            <div class="col-md-10">


                                <label>Documento del cliente *</label>
                                <div class="input-group">
                                    <input type="text" name="Documento" class="form-control" value ="${clienteEncontrado.getDocumento()}" size="11" minlength="3" maxlength="11" pattern="[0-9]+">
                                    <input type="hidden" name="idCliente" class="form-control" min="7" max="11" value ="${clienteEncontrado.getIdCliente()}">
                                    
                                    <input type="hidden" name="MontoVenta" value ="0">
                                    <button class="btn botones-button" type="submit" name="opcion" value="consultarCliente" >
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                                        <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/></button>
                                    </svg>
                                    </button>
                                    <a href="AdministradorRegistrarCliente.jsp">
                                        <button type="button" class="btn botones-button" data-bs-dismiss="modal">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
                                            <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                                            <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                                            </svg>  
                                        </button>
                                    </a>

                                    <button type="submit" class="btn botones-button" type="submit" name="opcion" value="registrarVenta" >
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                                        <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                                        </svg>
                                    </button>

                                </div>
                                <p style="color: #666; font-size: smaller;">
                                    Presiona el botón de ☑ si es el cliente
                                </p>
                                <select name="idUsuario" class="btn botonesgris-button"> 
                                    * <option>Vendedor</option>
                                    <%
                                        usuarioDAO usuDAO = new usuarioDAO();
                                        usuarioVO usuVO = new usuarioVO();
                                        ArrayList<usuarioVO> listarVendedor = usuDAO.listarVendedor();
                                        for (int i = 0; i < listarVendedor.size(); i++) {
                                            usuVO = listarVendedor.get(i);
                                    %>
                                    <option value="<%=usuVO.getIdUsuario()%>"><%=usuVO.getUsuNombre()%></option>
                                    <%}%>
                                </select><br>




                                <div class="col-md-6">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                    <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                                    </svg> 
                                    <label>${clienteEncontrado.getCliNombre()}</label>

                                </div>
                                <div class="col-md-6">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar-week" viewBox="0 0 16 16">
                                    <path d="M11 6.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-5 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1z"/>
                                    <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z"/>
                                    </svg>
                                    <label id="fecha"></label>
                                    <script>
                                        // Obtener la fecha actual
                                        var fecha_actual = new Date();

                                        // Formatear la fecha
                                        var options = {year: 'numeric', month: 'numeric', day: 'numeric'};
                                        var fecha_formateada = fecha_actual.toLocaleDateString('es-ES', options);

                                        // Mostrar la fecha en la página web
                                        document.getElementById("fecha").innerHTML = fecha_formateada;
                                    </script>
                                </div>
                            </div>
                        </div><br>

                        <div class="form-group">


                            <h5>Producto</h5>
                            <div class="col-md-12">
                                <div class="input-group">
                                    <select name="idPro" class="btn botonesgris-button">
                                        <option>Seleccionar</option>
                                        <%
                                            ArrayList<ProductoVO> listarProducto = ProdDAO.listarProducto();
                                            for (int i = 0; i < listarProducto.size(); i++) {
                                                ProdVO = listarProducto.get(i);
                                        %>
                                        <option value="<%=ProdVO.getIdProductos()%>"><%=ProdVO.getProNombre()%></option>
                                        <%}%>
                                    </select><br>
                                    <button   type="submit" name="opcion" value="consultarcodigoVenta" class=" btn botones-button">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                                        <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/></button>
                                    </svg>
                                    </button>
                                    <%
                                        ProdVO = (ProductoVO) request.getAttribute("productoencontrado");
                                        if (ProdVO != null) {
                                    %>
                                </div>

                            </div>


                            <div class="col-md-10">
                                <label for="inputCity" class="form-label">Producto *</label>
                                <input type="text" value="<%=ProdVO.getProNombre()%>" class="form-control" name="ProNombre" readonly size="10">
                                <input type="hidden" value="<%=ProdVO.getIdProductos()%>" class="form-control" name="idProducto" readonly>

                            </div>

                            <div class="form-group">
                                <div class="row">       
                                    <div class="col-md-5">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-currency-dollar" viewBox="0 0 16 16">
                                        <path d="M4 10.781c.148 1.667 1.513 2.85 3.591 3.003V15h1.043v-1.216c2.27-.179 3.678-1.438 3.678-3.3 0-1.59-.947-2.51-2.956-3.028l-.722-.187V3.467c1.122.11 1.879.714 2.07 1.616h1.47c-.166-1.6-1.54-2.748-3.54-2.875V1H7.591v1.233c-1.939.23-3.27 1.472-3.27 3.156 0 1.454.966 2.483 2.661 2.917l.61.162v4.031c-1.149-.17-1.94-.8-2.131-1.718H4zm3.391-3.836c-1.043-.263-1.6-.825-1.6-1.616 0-.944.704-1.641 1.8-1.828v3.495l-.2-.05zm1.591 1.872c1.287.323 1.852.859 1.852 1.769 0 1.097-.826 1.828-2.2 1.939V8.73l.348.086z"/>
                                        </svg>
                                        <label class="form-label">Precio *</label>


                                        <input type="text" value="<%=ProdVO.getPrecioUnidad()%>" class="form-control" name="precioVenta" size="11" minlength="3" maxlength="9" placeholder="0" readonly>

                                        <script>
                                            window.addEventListener('DOMContentLoaded', function () {
                                                aumentarPrecio();
                                            });

                                            function aumentarPrecio() {
                                                var inputPrecio = document.getElementsByName("precioVenta")[0];
                                                var precioActual = parseFloat(inputPrecio.value);
                                                var nuevoPrecio = precioActual * 1.2;
                                                inputPrecio.value = nuevoPrecio.toFixed(2);
                                            }
                                        </script><%
                                            VentaDAO venDAO = new VentaDAO();
                                            for (VentaVO venVO : venDAO.listarCod()) {
                                        %>
                                        <input name="IdVenta" type="hidden" value="<%=venVO.getidVenta()%>">



                                    </div>
                                    <div class="col-md-5">
                                        <label class="form-label">Cantidad *</label>
                                        <input type="text" value="1" class="form-control" name="cantidadVenta" required size="11" minlength="1" maxlength="2" pattern="[0-9]+">


                                    </div>
                                    <p><small>En existencia hay <%=ProdVO.getProStock()%></small></p>



                                </div>
                                <button class="btn botonesgris-button" type="submit" name="opcion" value="registrarDetalleVenta" >Agregar</button>
                            </div>


                    </form>
                </div>     
            </div>

        </div>

    </div>
    <div class="col-sm-8">
        <div class="card">
            <div class="card-body">
                <form class="row g-3" method="post" action="Producto">
                    <div class="card-body">
                        <div >
                            <h4 align="right">#<%=venVO.getidVenta()%></h4>
                        </div>
                        <table class="table" id="myTable">

                            <thead class="thead-dark">

                                <tr>
                                    <td scope="col">#</td>
                                    <td scope="col"></td>
                                    <td>Id Producto</td>
                                    <td>Nombre Producto</td>
                                    <td>Cantidad</td>
                                    <td>Precio</td>
                                    <td>Sub Total </td>
                                    <td>Accion</td>
                                </tr>
                            </thead>
                            <tbody>

                                <%
                                    int cont = 0;
                                    detalle_VentaDAO devDAO = new detalle_VentaDAO();
                                    for (detalle_VentaVO devVO : devDAO.listarDetalleVenta(venVO.getidVenta())) {
                                        cont = cont + 1;
                                %>

                                <tr>
                                    <td scope="col"><%=cont%></td>
                                    <td><input style="background: transparent; border: none;" type="hidden" value="<%=devVO.getId_DetalleVenta()%>" name="IdDetalleVenta" size="1" readonly></td>
                                    <td><input style="background: transparent; border: none;" type="text" value="<%=devVO.getIdProducto()%>" size="4" readonly></td>
                                    <td><%=devVO.getNomProducto()%></td>
                                    <td><input style="background: transparent; border: none;" type="text" value="<%=devVO.getCantidad()%>" size="4" readonly></td>
                                    <td><input style="background: transparent; border: none;" type="text" value="<%=devVO.getPrecioUnitario()%>" size="4" readonly></td>
                                    <td><input style="background: transparent; border: none;" type="text" value="<%=devVO.getSubtotal()%>" size="4" readonly></td>
                                    <td>
                                        <button type="submit" name="opcion" value="borrarDetalleVenta" class="btn botones-button">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                            <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z"/>
                                            <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z"/>
                                            </svg>
                                        </button>
                                    </td>
                                </tr>


                                <%}%>
                            </tbody>

                        </table>

                    </div>
                    <div class="card-footer">
                        <div>


                            <h6 align="right">Total compra <%=venVO.getMonto()%></h6>
                            <%}%>
                            <button type="button" class="btn botonesgris-button" data-bs-toggle="modal" data-bs-target="#exampleModal">Finalizar venta</button>
                            <%}%>

                            <!-- Modal -->
                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Su venta se genero de forma correcta</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            ¿Desea consultar la venta?
                                        </div>
                                        <div class="modal-footer">
                                            <a href="Venta_Nuevo.jsp"><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Salir</button></a>
                                            <a href="AdministradorListarVenta.jsp"><button type="button" class="btn btn-primary" data-bs-dismiss="modal">Aceptar</button></a>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

        </div>
    </div>

</div>   
</div>   
<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap5.min.js"></script>
<script>
                                            $(document).ready(function ()
                                            {
                                                $('#myTable').DataTable({
                                                    language: {
                                                        url: 'https://cdn.datatables.net/plug-ins/1.13.4/i18n/es-ES.json',
                                                    }
                                                });

                                            });
</script>
</body>
</html>
