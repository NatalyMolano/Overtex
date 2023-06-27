<%-- 
    Document   : diseño
    Created on : 24/03/2023, 06:16:08 PM
    Author     : natal
--%>

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
        <link href="CSS/estilo_fondo.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-npDw/WzrMb9PejXUu6C/uGVhxV2k5v9aohqSk2OqU79FaDJiHvj/5raWd4Le7+j9RJJDrTtSfpK5vlb7CnXUsg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link href="https://cdn.datatables.net/1.13.4/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>
        <link href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css" rel="stylesheet"/>
        <link href="https://cdn.datatables.net/buttons/2.3.6/css/buttons.dataTables.min.css" rel="stylesheet"/>
        <script>
            function copiarDatos() {
                var numeroid = document.getElementById("ND").value;
                var url = numeroid + '.pdf';
                window.open(url, 'Download');
            }
        </script>
        <style>
            div.bajar {
                position: fixed;
                bottom: 0;
                right: 0;
                width: 100px;
                height: 40px;
            }
            div.fixed {
                position: fixed;
                bottom: 0;
                right: 0;
                width: 100px;
                height: 80px;
            }
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

    <%        ProveedoresVO ProVO = new ProveedoresVO();
        ProveedoresDAO ProDAO = new ProveedoresDAO();
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
        <i class="fas fa-list"></i> Editar Compra
    </div>
    <div class="d-flex">
        <%                CompraDAO proDAO = new CompraDAO();
            CompraVO comVO = (CompraVO) request.getAttribute("compraparaconsultar");
            if (comVO != null) {

        %> 
        <div class="col-sm-4">

            <div class="card">
                <%                if (request.getAttribute("MensajeError") != null) {%>
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
                <div class="card-body">
                    <form class="row g-3" method="post" action="Producto">
                        <div class="form-group">
                            <%                                    HttpSession mySession = request.getSession();
                                String valor = (String) session.getAttribute("IdCompra");
                            %>
                            <div class="col-md-7">

                                <label>Documento del proveedor *</label>
                                <div class="input-group">

                                    <input type="text" name="Documento" class="form-control" min="7" max="11" value ="${proveedorEncontrado.getDocumento()}" size="11">
                                    <button  class="btn btn-outline-primary" type="submit" name="opcion" value="consultarProveedor1" >
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                                        <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/></button>
                                    </svg>
                                    </button>
                                    <%
                                        String opcion = request.getParameter("opcion");

                                        if (opcion != null && opcion.equals("consultarProveedor1")) {
                                    %>
                                    <input type="hidden" name="idproveedores" class="form-control" min="7" max="11" value ="${proveedorEncontrado.getIdproveedores()}">
                                    <%
                                    } else {
                                    %>
                                    <input type="hidden" name="idproveedores" class="form-control" min="7" max="11" value ="<%=comVO.getIdProveedor()%>">
                                    <%
                                        }
                                    %>


                                    <input type="hidden" value="${sessionScope.IdCompra}" name="IdCompra">
                                    <%
                                        // Recupera el ID de usuario almacenado en la sesión
                                        String Id = (String) mysession.getAttribute("UsuarioId");
                                    %>

                                    <input type="hidden" name="idGerente" id="idUsuarioSesion" value="<%=Id%>" size="1">
                                    <button type="submit" class="btn btn-outline-success" name="opcion" value="actualizarCompra">
                                         <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-clockwise" viewBox="0 0 16 016">
                                        <path fill-rule="evenodd" d="M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2v1z"/>
                                        <path d="M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466z"/>
                                        </svg>
                                    </button>

                                </div>
                                    <p style="color: #666; font-size: smaller;">
                                    Presiona el botón de <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-clockwise" viewBox="0 0 16 016">
                                        <path fill-rule="evenodd" d="M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2v1z"/>
                                        <path d="M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466z"/>
                                        </svg> para actualizar proveedor y cliente
                                </p>




                                <div class="col-md-6">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                    <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                                    </svg> 
                                    <label>${proveedorEncontrado.getProvNombre()} ${proveedorEncontrado.getProvApellido()} </label>

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
                        </div>

                        <div class="form-group">
                            <h5>Producto</h5>
                            <div class="col-md-12">
                                <div class="input-group">
                                    <select name="idPro" class="btn btn-outline-secondary">
                                        <option>Seleccionar</option>
                                        <%
                                            ArrayList<ProductoVO> listarProducto = ProdDAO.listar();
                                            for (int i = 0; i < listarProducto.size(); i++) {
                                                ProdVO = listarProducto.get(i);
                                        %>
                                        <option value="<%=ProdVO.getIdProductos()%>"><%=ProdVO.getProNombre()%></option>
                                        <%}%>
                                    </select><br>
                                    <button type="submit" name="opcion" value="consultarcodigoCompra1" class="btn btn-outline-primary">
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


                            <div class="col-md-7">
                                <label for="inputCity" class="form-label">Producto *</label>
                                <input type="text" value="<%=ProdVO.getProNombre()%>" class="form-control" name="ProNombre" readonly>
                                <input type="hidden" value="<%=ProdVO.getIdProductos()%>" class="form-control" name="idProducto" readonly>

                            </div>
                            <div class="col-md-5">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-currency-dollar" viewBox="0 0 16 16">
                                <path d="M4 10.781c.148 1.667 1.513 2.85 3.591 3.003V15h1.043v-1.216c2.27-.179 3.678-1.438 3.678-3.3 0-1.59-.947-2.51-2.956-3.028l-.722-.187V3.467c1.122.11 1.879.714 2.07 1.616h1.47c-.166-1.6-1.54-2.748-3.54-2.875V1H7.591v1.233c-1.939.23-3.27 1.472-3.27 3.156 0 1.454.966 2.483 2.661 2.917l.61.162v4.031c-1.149-.17-1.94-.8-2.131-1.718H4zm3.391-3.836c-1.043-.263-1.6-.825-1.6-1.616 0-.944.704-1.641 1.8-1.828v3.495l-.2-.05zm1.591 1.872c1.287.323 1.852.859 1.852 1.769 0 1.097-.826 1.828-2.2 1.939V8.73l.348.086z"/>
                                </svg>
                                <label class="form-label">Precio *</label>


                                <input type="text" value="<%=ProdVO.getPrecioUnidad()%>" class="form-control" name="PrecioUnidad" size="11" minlength="3" maxlength="9"  placeholder="0">





                            </div>
                            <div class="col-md-5">
                                <label class="form-label">Cantidad *</label>
                                <input type="text" value="1" class="form-control" name="Cantidad" size="11" minlength="1" maxlength="3" required>
                                <p><small>En existencia hay <%=ProdVO.getProStock()%></small></p>

                                <button class="btn btn-outline-primary" type="submit" name="opcion" value="agregarDetalleCompra" >Agregar</button>

                            </div>



                    </form>
                </div>     
            </div>

        </div>
        
    </div>
    <div class="col-sm-13">
        <div class="card">
            <div class="card-body">
                <form  class="row g-3" method="post" action="Producto" >
                    <div class="card-body">
                        <div >
                            <h4 align="right">${sessionScope.IdCompra}</h4>

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
                                    detalle_CompraDAO deDAO = new detalle_CompraDAO();
                                    for (detalle_CompraVO deVO : deDAO.listarDetalleCompra((String) session.getAttribute("IdCompra"))) {
                                        cont = cont + 1;
                                %>

                                <tr>
                                    <td scope="col"><%=cont%></td>
                                    <td><input style="background: transparent; border: none;" type="hidden" value="<%=deVO.getId_DetalleCompra()%>" name="IdDetalleCompra" size="0" readonly></td>
                                    <td><input style="background: transparent; border: none;" type="text" value="<%=deVO.getIdProducto()%>" size="4" readonly></td>
                                    <td><%=deVO.getNomProducto()%></td>
                                    <td><input style="background: transparent; border: none;" type="text" value="<%=deVO.getCantidad()%>" size="4" readonly></td>
                                    <td><input style="background: transparent; border: none;" type="text" value="<%=deVO.getPrecioUnitario()%>" size="4" readonly></td>
                                    <td><input style="background: transparent; border: none;" type="text" value="<%=deVO.getSubtotal()%>" size="4" readonly></td>
                                    <td>
                                        <button type="submit" name="opcion" value="borrarDetalleCompra1" class="btn btn-outline-danger">
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



                            <button type="button" class="btn btn-outline-success" data-bs-toggle="modal" data-bs-target="#exampleModal">Finalizar</button>
                            <%}%>



                            <!-- Modal -->
                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Su compra se genero de forma correcta</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            ¿Desea ir a la pagina anterior?
                                        </div>
                                        <div class="modal-footer">
                                            <a href="Actualizar_Compra.jsp"><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Salir</button></a>
                                            <a href="AdministradorListarCompra.jsp"><button type="button"  class="btn btn-primary" data-bs-dismiss="modal">Aceptar</button></a>

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
    <%}%>                     
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
