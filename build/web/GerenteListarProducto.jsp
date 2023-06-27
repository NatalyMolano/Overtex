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
                <i class="fas fa-pencil-alt"></i> Listar  Producto
            </div>
            <form method="post" action="Producto">
                <table id="example" class="display nowrap" style="width:100%">
                    <thead>
                        <tr>

                            <th scope="col">#</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Cantidad</th>
                            <th scope="col">Precio Unidad</th>
                            <th scope="col">Estado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%                            int con = 0;
                            ProveedoresVO proVO = new ProveedoresVO();
                            ProveedoresDAO proDAO = new ProveedoresDAO();

                            ProductoVO ProdVO = new ProductoVO();
                            ProductoDAO ProdDAO = new ProductoDAO();

                            ArrayList<ProductoVO> listarProducto = ProdDAO.listar();

                            for (int i = 0; i < listarProducto.size(); i++) {
                                ProdVO = listarProducto.get(i);
                                con = con + 1;
                        %>


                        <tr>
                            <td><%=con%></td>
                            <td><%= ProdVO.getProNombre()%></td>
                            <td><%=ProdVO.getProStock()%></td>
                            <td><%=ProdVO.getPrecioUnidad()%></td>
                            <td>Activo</td>


                        </tr>
                        <%}%>

                    </tbody>

                </table>


            </form>
                        <div class="fixed">
        
        <form method="POST" action="GeneradorReporte.jsp" target="_blank">
            <input style="border-radius: 50%;" class="btn botones-naranja" type="submit" value="PDF">
            <input type="hidden" name="reportName" value="productos">
        </form>
         
    </div>

        </div>




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
