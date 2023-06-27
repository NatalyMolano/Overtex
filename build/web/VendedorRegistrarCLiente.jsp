<%-- 
    Document   : diseño
    Created on : 24/03/2023, 06:16:08 PM
    Author     : natal
--%>

<%@page import="ModeloVO.RolVO"%>
<%@page import="ModeloDAO.RolDAO"%>
<%@page import="ModeloVO.ClienteVO"%>
<%@page import="ModeloDAO.ClienteDAO"%>
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
<%
    HttpSession mySession = request.getSession(false);
    String id = (String) mysession.getAttribute("UsuarioId");
    RolDAO rolDAO = new RolDAO();
    ArrayList<RolVO> listaRoles = rolDAO.listar(id);
    boolean hasRole5002 = false;
    for (RolVO rolVO : listaRoles) {
        if (rolVO.getROLID().equals("5002")) {
            hasRole5002 = true;
            break;
        }
    }
    
    if (!hasRole5002) {
        // El usuario no tiene el rol 5002, redirigir al formulario de inicio de sesión
        response.sendRedirect("login.jsp");
    }
%>
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
    <%        ClienteDAO cliDAO = new ClienteDAO();
        ClienteVO cliVO = new ClienteVO();

    %>
    <body>
        <header class="site-header sticky-top py-1" style="background-color: #4C4C4C;">
            <nav class="container d-flex flex-column flex-md-row justify-content-between" >
                <h3><span style="display: inline; color:#FFFFFF  ">Over</span><span style="display: inline; color: #EF6737;">tex</span></h3>
                <a  type="button" class="btn btn-custom" href="Vista_Vendedor.jsp" class="text-warning">Menu</a>

               <div class="dropdown">
                    <button class="btn btn-custom">Cliente</button>
                    <div class="dropdown-content">
                        <a href="VendedorRegistrarCLiente.jsp">Generar Cliente</a>
                    </div>
                </div>
       
        <div class="dropdown">
            <button class="btn btn-custom">Comision</button>
            <div class="dropdown-content">
                <a href="Venta_Comisiones.jsp">ver comisiones</a>
              </div>
        </div>
       
         </nav>
       </header>
        <br>
        
<div class="form-container">
    
    <div class="product-heading">
        <i class="fas fa-pencil-alt"></i> Registrar cliente
    </div>
    <div class="d-flex">

        <div class="col-sm-4">
            <div class="card">
                <div class="card-body">
                    <form class="row g-3" method="post" action="Cliente">
                        <div class="form-group">

                            <div class="col-md-7">

                                <label>Nombre y apellido del cliente</label>
                                <div class="input-group">

                                    <input type="text" name="cliNombre" class="form-control" size="11" minlength="3" maxlength="30" pattern="^[a-zA-Z\s]+$"> 
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
                                <label for="inputCity" class="form-label">Telefono del cliente</label>
                                <input type="text" value="" class="form-control" name="cliTelefono" required pattern="^[0-9]+$"  minlength="1" maxlength="12">
                                <label for="inputCity" class="form-label">Documento del cliente </label>
                                <input type="text" value="" class="form-control" name="Documento" required pattern="^[0-9]+$" minlength="1" maxlength="12">

                            </div>
                            <br>
                           <div class="col-md-5">
                                <input  type="hidden" name="cliEstado" value="1" >

                                <button class="btn btn-secondary" type="submit" name="opcion" value="registrar1" >Registrar</button>

                            </div>



                    </form>
                </div>     
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
                <form  class="row g-3" method="post" action="Cliente" >
                    <div class="card-body">
                        <table class="table" id="myTable">
                           
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col"></th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col"></th>
                                    <th scope="col">Documento</th>
                                    <th scope="col">Telefono</th>
                                    <th scope="col">Estado</th>
                                    <th scope="col">Editar</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    int con = 0;
                                    ArrayList<ClienteVO> listarCliente = cliDAO.listar();

                                    for (int i = 0; i < listarCliente.size(); i++) {
                                        cliVO = listarCliente.get(i);
                                        con = con + 1;
                                %>
                                <tr>
                                    <td><%=con%></td>
                                    <td><input type="hidden" value="<%=cliVO.getIdCliente()%>" size="1" name="idCliente"></input></td>
                                    <td><%=cliVO.getCliNombre()%></td>
                                    <td><input style="background: transparent;border: none;" type="hidden" value="<%=cliVO.getCliNombre()%>" size="1" name="cliNombre" minlength="2" maxlength="11" pattern="[0-9]+" readonly></input></td>
                                    <td><input  style="background: transparent;border: none;" type="text" value="<%=cliVO.getDocumento()%>" size="5" name="Documento" required  minlength="5" maxlength="12"> </input></td>
                                    
                                    <td><input style="background: transparent;border: none;" type="text" value="<%=cliVO.getCliTelefono()%>" size="4" name="cliTelefono" minlength="5" maxlength="11"  readonly></input></td>
                                    <td><select style="background: transparent;border: none;"  name="cliEstado">
                                         <option value="1">Activo</option>
                                         <option value="0">Desactivo</option>
                                        </select>
                                    <td>
                                        <button class="btn btn-outline-secondary" type="submit" name="opcion" value="actualizar1" >
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-clockwise" viewBox="0 0 16 016">
                                            <path fill-rule="evenodd" d="M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2v1z"/>
                                            <path d="M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466z"/>
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
