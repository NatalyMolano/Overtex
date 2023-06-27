<%-- 
    Document   : vista
    Created on : 26/03/2023, 02:35:06 PM
    Author     : natal
--%>

<%@page import="ModeloDAO.usuarioDAO"%>
<%@page import="ModeloVO.usuarioVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.CompraDAO"%>
<%@page import="ModeloVO.CompraVO"%>
<%@page import="ModeloVO.ProveedoresVO"%>
<%@page import="ModeloDAO.ProveedoresDAO"%>
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
            div.fixed {
                position: fixed;
                bottom: 0;
                right: 0;
                width: 100px;
                height: 50px;
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
        <i class="fas fa-list"></i> Lista de Usuarios
    </div>

    <div class="container">
        <form method="post" action="Usuario">
            <table id="example" class="table table-striped" style="width:100%">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                    <th scope="col">UsuDocumento</th>
                    <th scope="col">UsuNombre</th>
                    <th scope="col">Usudireccion</th>
                    <th scope="col">UsuTelefono</th>
                    <th scope="col">Estado</th>
                    <th scope="col">Editar</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>

                    <%
                        usuarioVO usuVO = new usuarioVO();
                        usuarioDAO usuDAO = new usuarioDAO();

                        ArrayList<usuarioVO> listarCompra = usuDAO.listar();

                        for (int i = 0; i < listarCompra.size(); i++) {
                            usuVO = listarCompra.get(i);
                    %>
                    <tr>
                        <td><%=usuVO.getIdUsuario()%></td>
                        <td><input style="background: transparent;border: none;" type="hidden" value="<%=usuVO.getIdUsuario()%>" size="4" name="idUsuario" required></input></td>
                        <td><input style="background: transparent;border: none;" type="hidden" value="<%=usuVO.getUsuContrasena()%>" size="4" name="Pass" required></input></td>
                        <td><input style="background: transparent;border: none;" type="text" value="<%=usuVO.getUsuDocumento()%>" size="6" name="UsuDocumento" required readonly></input></td>
                        <td><input style="background: transparent;border: none;" type="text" value="<%=usuVO.getUsuNombre()%>" size="6" name="UsuNombre" required> </input></td>
                        <td><input style="background: transparent;border: none;" type="text" value="<%=usuVO.getUsudireccion()%>" size="6"name="Usudireccion"required ></input></td>
                        <td><input style="background: transparent;border: none;" type="text" value="<%=usuVO.getUsuTelefono()%>"size="3" name="UsuTelefono" required></input></td>
                        <td><select style="background: transparent;border: none;"  name="UsuEstado">
                                            <option value="1">Activo</option>
                                            <option value="0">Desactivo</option>
                                        </select>
                                    </td>
                                 
                                    
                        <td>
                             <button class="btn btn-outline-secondary" type="submit" name="opcion" value="actualizarUsuario" >
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-clockwise" viewBox="0 0 16 016">
                                        <path fill-rule="evenodd" d="M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2v1z"/>
                                        <path d="M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466z"/>
                                        </svg>

                                    </button>
                             <button type="submit" name="opcion" value="borrarUsuario" class="btn botones-button">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                                <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z"/>
                                                <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z"/>
                                                </svg>
                                            </button>


                        </td>
                         <td><input style="background: transparent;border: none;" type="hidden" value="<%=usuVO.getIdRol()%>"size="3" name="IdRol" required></input></td>
                          

                    </tr>
                    <%}%>
                </tbody>
                <tfoot>
                    <tr>
                    </tr>
                </tfoot>
            </table>
        </form>
        <%
        if (request.getAttribute("MensajeError") != null) {%>
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
    </div>
</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>

<script>


            $(document).ready(function () {
                $('#example').DataTable({
                    dom: 'Bfrtip',
                    buttons: [
                        {
                            extend: 'copy',
                            text: 'Copiar',
                            className: 'btn btn-primary',
                        },
                        {
                            extend: 'excel',
                            className: 'btn btn-primary',
                            text: 'Exportar a Excel'
                        },
                        {
                            extend: 'pdf',
                            className: 'btn btn-primary',
                            text: 'Exportar a PDF'
                        },
                        {
                            extend: 'print',
                            className: 'btn btn-primary',
                            text: 'Imprimir'
                        }
                    ]
                });
            });

            $(document).ready(function () {
                $('#mitabla').DataTable({
                    dom: 'Bfrtip',
                    buttons: [
                        {
                            extend: 'copy',
                            text: 'Copiar',
                            className: 'btn btn-primary',
                        },
                        {
                            extend: 'excel',
                            className: 'btn btn-primary',
                            text: 'Exportar a Excel'
                        },
                        {
                            extend: 'pdf',
                            className: 'btn btn-primary',
                            text: 'Exportar a PDF'
                        },
                        {
                            extend: 'print',
                            className: 'btn btn-primary',
                            text: 'Imprimir'
                        }
                    ]
                });
            });

            $(document).ready(function ()
            {
                $('#ejemplo').DataTable({
                    language: {
                        url: 'https://cdn.datatables.net/plug-ins/1.13.4/i18n/es-ES.json',
                    }
                });

            });

</script>
<style>
    .modal-dialog {
        max-width: 80%;
    }
    .modal-body {
        max-height: 50vh;
        overflow-y: auto;
    }
    .table {
        width: 100%;
    }
</style>

</body>
</html>
