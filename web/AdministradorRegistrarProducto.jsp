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
        <i class="fas fa-pencil-alt"></i> Registro Producto
    </div>
    <div class="d-flex">

        <div class="col-sm-4">
            <div class="card">
                <div class="card-body">
                    <form class="row g-3" method="post" action="Cambios">
                        <div class="form-group">


                            <div class="col-md-7">

                                <label>Nombre del producto *</label>
                                <div class="input-group">

                                    <input type="text" name="ProNombre" class="form-control" size="20" minlength="3" maxlength="20" pattern="^[a-zA-Z\s]+$" required>
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




                            <div class="col-md-7">
                                <label for="inputCity" class="form-label">Stock del producto * </label>
                                <input type="text" value="" class="form-control" name="ProStock" required pattern="^[0-9]+$" minlength="1" maxlength="12">
                                <label for="inputCity" class="form-label">Precio por unidad * </label>
                                <input type="text" value="" class="form-control" name="PrecioUnidad" required pattern="^[0-9]+$" minlength="1" maxlength="12">

                            </div>
                            <div class="col-md-5">
                                <input type="hidden" value="1" name='Estado'>
                                <br>
                                <button class="btn btn-secondary" type="submit" name="opcion" value="agregarProducto" >Registrar</button>

                            </div>




                        </div> 
                    </form>
                </div>

            </div>
            <%                if (request.getAttribute("mensajeError") != null) {%>
            <div class="alert alert-danger" role="alert">
                ${mensajeError}
            </div>

            <%} else {%>
            <div class="alert alert-light" role="alert">
                ${mensajeExito}
            </div>

            <%
                }
            %>
        </div>

        <div class="col-sm-14">
            <div class="card">
                <div class="card-body">
                    <form  class="row g-3" method="post" action="Cambios" >
                        <div class="card-body">

                            <table class="table" id="myTable">

                                <thead class="thead-dark">


                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col"></th>
                                        <th scope="col">Nombre</th>
                                        <th scope="col"></th>
                                        <th scope="col">ProStock</th>
                                        <th scope="col">Precio Unidad</th>

                                        <th scope="col">Editar</th>
                                    </tr>


                                </thead>
                                <tbody>


                                    <%
                                        int con = 0;
                                        ProveedoresVO proVO = new ProveedoresVO();
                                        ProveedoresDAO proDAO = new ProveedoresDAO();

                                        ArrayList<ProductoVO> ListaProductos = ProdDAO.listar();

                                        for (int i = 0; i < ListaProductos.size(); i++) {
                                            ProdVO = ListaProductos.get(i);
                                            con = con + 1;
                                    %>


                                    <tr>
                                        <td><%=con%></td>
                                        <td><input type="hidden" value="<%=ProdVO.getIdProductos()%>" size="1" name="idPro"></input></td>
                                        <td><%=ProdVO.getProNombre()%></td>
                                        <td><input style="background: transparent;border: none;" type="hidden" value="<%=ProdVO.getProNombre()%>" size="1" name="ProNombre" minlength="1" maxlength="11" pattern="[0-9]+" readonly></input></td>
                                        <td><input style="background: transparent;border: none;" type="text" value="<%=ProdVO.getProStock()%>" size="4" name="ProStock" minlength="1" maxlength="11"  readonly></input></td>
                                        <td><input  style="background: transparent;border: none;" type="text" value="<%=ProdVO.getPrecioUnidad()%>" size="5" name="PrecioUnidad" required  minlength="3" maxlength="12"> </input></td>
                                        <input  style="background: transparent;border: none;" type="hidden" value="1" size="5" name="Estado" required  minlength="3" maxlength="12"> </input>
                                <td>
                                    <button class="btn btn-outline-secondary" type="submit" name="opcion" value="actualizarProducto" >
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-clockwise" viewBox="0 0 16 016">
                                        <path fill-rule="evenodd" d="M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2v1z"/>
                                        <path d="M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466z"/>
                                        </svg>

                                    </button>

                                    <button class="btn botones-button"  type="submit" name="opcion" value="borrarProducto">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
                                        <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"/>
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



                                <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal">Finalizar</button>




                                <!-- Modal -->
                                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel">El producto se registro de forma exitosa</h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                Si desea consultar Proveedores elija la opcion de Consultar y si desea mantenerse en esta ventana elija cancelar
                                            </div>
                                            <div class="modal-footer">
                                                <a href="AdministradorListaProductos.jsp"><button type="button" class="btn btn-primary" data-bs-dismiss="modal">Consular</button></a>
                                                <a href="AdministradorRegistrarProducto.jsp"><button type="button" class="btn btn-success" data-bs-dismiss="modal">Cancelar</button></a>

                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="modal fade" id="eliminar" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel">ADVERTENCIA</h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                Si elimina el producto

                                            </div>
                                            <div class="modal-footer">
                                                <button class="btn btn-danger"  type="submit" name="opcion" value="borrar" >
                                                    Eliminar

                                                </button>
                                                <button class="btn btn-secondary"  type="submit" name="opcion" value="borrar" >
                                                    Cerrar

                                                </button>
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
