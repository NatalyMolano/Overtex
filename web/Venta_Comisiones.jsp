<%-- 
    Document   : Venta_Comisiones
    Created on : 22/05/2023, 09:36:33 PM
    Author     : natal
--%>

<%@page import="ModeloDAO.RolDAO"%>
<%@page import="ModeloVO.RolVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.VentaDAO"%>
<%@page import="ModeloVO.VentaVO"%>
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
        <i class="fas fa-list"></i> Lista de Usuarios
    </div>

            <form method="post" action="Producto">
                <table id="example" class="table table-striped" style="width:100%">
                    <thead>

                    </thead>
                    <tfoot>
                        <tr>
                            <th>
                                <div class="col-12">


                                    <%                                        // Recupera el ID de usuario almacenado en la sesión
                                        String Id = (String) mysession.getAttribute("UsuarioId");
                                    %>
                                    <input type="hidden" name="idUsuario" id="idUsuarioSesion" value="<%=Id%>" size="1">
                                </div>

                            </th>        
                            <th>
                                <div class="col-12" >
                                    <label>Seleccione el mes</label><br>
                                    <select name="Mes"  class="btn btn-outline-secondary">
                                        <option value="01">Enero</option>
                                        <option value="02">Febrero</option>
                                        <option value="03">Marzo</option>
                                        <option value="04">Abril</option>
                                        <option value="05">Mayo</option>
                                        <option value="06">Junio</option>
                                        <option value="07">Julio</option>
                                        <option value="08">Agosto</option>
                                        <option value="09">Septiembre</option>
                                        <option value="10">Octubre</option>
                                        <option value="11">Noviembre</option>
                                        <option value="12">diciembre</option>
                                    </select>
                                </div>


                            </th> 
                            <th>
                                <button type="submit" name="opcion" value="consultarcomisiones" style="width: 30%;" class="btn btn-secondary" data-toggle="tooltip" data-placement="top"> Consultar</button>
                            </th>
                        </tr>              
                    </tfoot>
                </table>
            </form>
            <form>
                <table  class="table" style="color: #333">

                    <tr >
                        <th>Cantidad vendida</th>
                        <th>idVendedor</th>
                        <th>Comisiones</th>
                        <th>Mes</th>

                    </tr>
                    <%
                        VentaVO vmVO = (VentaVO) request.getAttribute("comisionEncontrada");
                        VentaDAO vmDAO = new VentaDAO();
                        if (vmVO != null) {
                    %>

                    <tr>

                        <th><%=vmVO.getidVenta()%></th>
                        <th><%=vmVO.getPrecio()%></th>


                        <th><%=vmVO.getIdproductos()%></th>
                        <th><%=vmVO.getCantidad()%></th>


                    </tr>

                    <%}%>
                </table>

            </form>
            <%
                if (request.getAttribute("mensajeError") != null) {%>
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

    </body>
</html>
