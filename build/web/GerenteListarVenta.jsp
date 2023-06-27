<%-- 
    Document   : diseño
    Created on : 24/03/2023, 06:16:08 PM
    Author     : natal
--%>

<%@page import="ModeloVO.detalle_VentaVO"%>
<%@page import="ModeloDAO.detalle_VentaDAO"%>
<%@page import="ModeloVO.VentaVO"%>
<%@page import="ModeloDAO.VentaDAO"%>
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
    <%
        ProveedoresVO ProVO = new ProveedoresVO();
        ProveedoresDAO ProDAO = new ProveedoresDAO();
        ProductoVO ProdVO = new ProductoVO();
        ProductoDAO ProdDAO = new ProductoDAO();

    %>
    <body>
       <header class="site-header sticky-top py-1" style="background-color: #4C4C4C;">
            <nav class="container d-flex flex-column flex-md-row justify-content-between" >
                <h3><span style="display: inline; color:#FFFFFF  ">Over</span><span style="display: inline; color: #EF6737;">tex</span></h3>
                <a  type="button" class="btn btn-custom" href="Vista_Gerente.jsp" class="text-warning">Menu</a>


                <div class="dropdown">
                    <button class="btn btn-custom">Producto</button>
                    <div class="dropdown-content">
                        <a href="GerenteListarProducto.jsp">Listar Producto</a>
                    </div>
                </div>
                <div class="dropdown">
                    <button class="btn btn-custom">Compra</button>
                    <div class="dropdown-content">
                        <a href="GerenteListarCompra.jsp">Listar Compras</a>

                    </div>
                </div>

                <div class="dropdown">
                    <button class="btn btn-custom">Venta</button>
                    <div class="dropdown-content">
                        <a href="GerenteListarVenta.jsp">Listar Ventas</a>
                    </div>
                </div>
                <div class="dropdown">
                    <button class="btn btn-custom">Cliente</button>
                    <div class="dropdown-content">
                        <a href="GerenteListarCliente.jsp">Listar Cliente</a>
                    </div>
                </div>
                <div class="dropdown">
                    <button class="btn btn-custom">Proveedor</button>
                    <div class="dropdown-content">
                        <a href="GerenteListarProveedor.jsp">Lista Proveedor</a>

                    </div>
                </div>




            </nav>
        </header>


        <br>
        <div class="form-container">
            <div class="product-heading">
                <i class="fas fa-pencil-alt"></i> Listar  Venta
            </div>
            <form method="post" action="Producto">
                <table id="example" class="display nowrap" style="width:100%">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>id venta</th>
                            <th>Documento cliente</th>
                            <th>Documento usuario</th>
                            <th>Fecha</th>
                            <th>Total</th>
                            <th>Estado</th>
                            <th>Accion</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%                           
                            VentaDAO venDAO = new VentaDAO();
                            for (VentaVO venVO : venDAO.listarVenta()) {

                        %>

                        <tr>
                            <td><input type="hidden" value="<%=venVO.getidVenta()%>" name="IdVenta"></td>
                            <td><%=venVO.getidVenta()%></td>
                            <td><%=venVO.getIdidCliente()%></td>
                            <td><%=venVO.getIdUsuario()%></td>
                            <td><%=venVO.getFecha()%></td>
                            <td><%=venVO.getMonto()%></td>
                            <td>Activo</td>
                            <td>
                                <button type="submit" name="opcion" value="consultarPorVenta1" class="btn btn-outline-secondary">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                                    <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                                    </svg>
                                </button>
                               
                            </td>
                        </tr>
                        <%}%>

                    </tbody>

                </table>
                <%
                    String valor = request.getParameter("IdVenta");
                    HttpSession mySession = request.getSession();
                    session.setAttribute("IdVenta", valor);
                %>
                
                

            </form>
                <div class="fixed">

                    <button style="border-radius: 50%;" type="button"  class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                        <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                        <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                        </svg>
                    </button> 


                    <form method="POST" action="GeneradorReporte.jsp" target="_blank">
                        <input style="border-radius: 50%;" class="btn botones-naranja" type="submit" value="PDF">
                        <input type="hidden" name="reportName" value="venta">
                    </form>

                </div>
        <%
            VentaDAO ven1DAO = new VentaDAO();
            VentaVO venVO = (VentaVO) request.getAttribute("ventaparaconsultar");
            if (venVO != null) {
        %>
        <form  method="post" action="Producto">
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Su venta se generó de forma correcta</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">

                            <table id="mitabla" class="display nowrap" style="width:100%">
                                <h4 align="center">Venta  #<%=venVO.getidVenta()%></h4>
                                <thead class="thead-dark">

                                    <tr>
                                        <td scope="col">#</td>
                                        <td>Id Producto</td>
                                        <td>Nombre Producto</td>
                                        <td>Cantidad</td>
                                        <td>Precio</td>
                                        <td>Sub Total </td>
                                    </tr>
                                </thead>
                                <tbody>

                                    <%
                                        int cont = 0;
                                        detalle_VentaDAO devDAO = new detalle_VentaDAO();
                                        for (detalle_VentaVO deVO : devDAO.listarDetalleVenta(venVO.getidVenta())) {
                                            cont = cont + 1;
                                    %>

                                    <tr>
                                        <td scope="col"><%=cont%></td>
                                        <td><%=deVO.getIdProducto()%></td>
                                        <td><%=deVO.getNomProducto()%></td>
                                        <td><%=deVO.getCantidad()%></td>
                                        <td><%=deVO.getPrecioUnitario()%></td>
                                        <td><%=deVO.getSubtotal()%></td>

                                    </tr>


                                    <%}%>
                                </tbody>

                            </table>
                        </div>
                        <div class="modal-footer">
                            <a href="Venta_Nuevo.jsp"><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Salir</button></a>
                            <button type="button" class="btn btn-primary">Ir</button>
                        </div>
                    </div>
                </div>
            </div>
            
        </form>
        <%}%>


        </form>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/2.3.6/js/dataTables.buttons.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
        <script src="https://cdn.datatables.net/buttons/2.3.6/js/buttons.html5.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/2.3.6/js/buttons.print.min.js"></script>

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
        
            
        </style>


    </body>
</html>
