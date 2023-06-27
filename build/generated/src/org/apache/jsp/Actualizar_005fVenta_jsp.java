package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ModeloVO.detalle_VentaVO;
import ModeloDAO.detalle_VentaDAO;
import ModeloVO.VentaVO;
import ModeloDAO.VentaDAO;
import ModeloVO.detalle_CompraVO;
import ModeloDAO.detalle_CompraDAO;
import ModeloDAO.ProductoDAO;
import ModeloVO.ProductoVO;
import ModeloDAO.ProveedoresDAO;
import ModeloVO.ProveedoresVO;
import ModeloDAO.CompraDAO;
import ModeloVO.CompraVO;
import java.util.ArrayList;
import ModeloVO.UsuarioVO_1;

public final class Actualizar_005fVenta_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Sesiones.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"CSS/diseño.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"CSS/cover.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ\" crossorigin=\"anonymous\">\n");
      out.write("        <title>Overtex</title>\n");
      out.write("        <style>\n");
      out.write("            div.fixed {\n");
      out.write("                position: fixed;\n");
      out.write("                bottom: 0;\n");
      out.write("                right: 0;\n");
      out.write("                width: 100px;\n");
      out.write("                height: 50px;\n");
      out.write("            }\n");
      out.write("                \n");
      out.write("\n");
      out.write("            div.fixed {\n");
      out.write("                position: fixed;\n");
      out.write("                bottom: 0;\n");
      out.write("                right: 0;\n");
      out.write("                width: 100px;\n");
      out.write("                height: 1px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    ");

        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-control", "no-cache,no-strore,must-revalidate");
        response.setDateHeader("Expires", 0);
    
      out.write("\n");
      out.write("    <body>\n");
      out.write("        ");

            String usuario = "";
            String UsuarioId = "";
            HttpSession buscarSesion = (HttpSession) request.getSession();
            HttpSession mysession = request.getSession();
            if (buscarSesion.getAttribute("datosUsuario") != null) {
                UsuarioVO_1 usuVO = (UsuarioVO_1) buscarSesion.getAttribute("datosUsuario");
                usuario = usuVO.getUsulogin();
                UsuarioId = usuVO.getUsuId();
                mysession.setAttribute("UsuarioId", UsuarioId);
            } else {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        <div style=\"position: fixed;\n");
      out.write("             top: 0;\n");
      out.write("             right: 0;\n");
      out.write("             z-index: 9999;\" class=\"fixed\">\n");
      out.write("            <div class=\"menuSesion\">\n");
      out.write("\n");
      out.write("                <input type=\"hidden\" name=\"IdUsuario\" value=\"");
      out.print(UsuarioId);
      out.write("\" id=\"");
      out.print(UsuarioId);
      out.write("\">\n");
      out.write("                <form method=\"post\" action=\"Sesiones\">\n");
      out.write("                    <div class=\"dropdown\">\n");
      out.write("                        <button style=\"border-radius: 12px;\" class=\"btn btn-light\" type=\"submit\" value=\"Cerrar Sesion\">\n");
      out.write("                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-door-closed\" viewBox=\"0 0 16 16\">\n");
      out.write("                            <path d=\"M3 2a1 1 0 0 1 1-1h8a1 1 0 0 1 1 1v13h1.5a.5.5 0 0 1 0 1h-13a.5.5 0 0 1 0-1H3V2zm1 13h8V2H4v13z\"/>\n");
      out.write("                            <path d=\"M9 9a1 1 0 1 0 2 0 1 1 0 0 0-2 0z\"/>\n");
      out.write("                            </svg> Cerrar\n");
      out.write("                        </button>\n");
      out.write("                        <div class=\"dropdown-content\" style=\"background-color:white\">\n");
      out.write("                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-person-circle\" viewBox=\"0 0 16 16\">\n");
      out.write("                            <path d=\"M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z\"/>\n");
      out.write("                            <path fill-rule=\"evenodd\" d=\"M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z\"/>\n");
      out.write("                            </svg>\n");
      out.write("                            <a  >");
      out.print(usuario);
      out.write("</a>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Compra</title>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp\" crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"CSS/diseño.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.2.0/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.2.0/css/bootstrap.min.css\">\n");
      out.write("        <link href=\"CSS/diseño.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"CSS/estilo_fondo.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\" integrity=\"sha512-npDw/WzrMb9PejXUu6C/uGVhxV2k5v9aohqSk2OqU79FaDJiHvj/5raWd4Le7+j9RJJDrTtSfpK5vlb7CnXUsg==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n");
      out.write("        <link href=\"https://cdn.datatables.net/1.13.4/css/dataTables.bootstrap5.min.css\" rel=\"stylesheet\"/>\n");
      out.write("        <link href=\"https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css\" rel=\"stylesheet\"/>\n");
      out.write("        <link href=\"https://cdn.datatables.net/buttons/2.3.6/css/buttons.dataTables.min.css\" rel=\"stylesheet\"/>\n");
      out.write("        <script>\n");
      out.write("            function copiarDatos() {\n");
      out.write("                var numeroid = document.getElementById(\"ND\").value;\n");
      out.write("                var url = numeroid + '.pdf';\n");
      out.write("                window.open(url, 'Download');\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <style>\n");
      out.write("            div.bajar {\n");
      out.write("                position: fixed;\n");
      out.write("                bottom: 0;\n");
      out.write("                right: 0;\n");
      out.write("                width: 100px;\n");
      out.write("                height: 40px;\n");
      out.write("            }\n");
      out.write("            div.fixed {\n");
      out.write("                position: fixed;\n");
      out.write("                bottom: 0;\n");
      out.write("                right: 0;\n");
      out.write("                width: 100px;\n");
      out.write("                height: 80px;\n");
      out.write("            }\n");
      out.write("            body {\n");
      out.write("                background-color: #f2f2f2;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .form-container {\n");
      out.write("                background-color: #ffffff;\n");
      out.write("                padding: 20px;\n");
      out.write("                margin-top: 50px;\n");
      out.write("                width: 70%;\n");
      out.write("                margin: 0 auto;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .form-group label, .form-group input {\n");
      out.write("                font-size: 15px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .product-heading {\n");
      out.write("                background-color: #dddddd;\n");
      out.write("                color: #000000;\n");
      out.write("                padding: 10px;\n");
      out.write("                margin-bottom: 20px;\n");
      out.write("                text-align: left;\n");
      out.write("                font-weight: bold;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                margin-top: -20px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .btn-icon {\n");
      out.write("                display: flex;\n");
      out.write("                align-items: center;\n");
      out.write("                justify-content: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .btn-icon i {\n");
      out.write("                margin-right: 5px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    ");

        ProveedoresVO ProVO = new ProveedoresVO();
        ProveedoresDAO ProDAO = new ProveedoresDAO();
        ProductoVO ProdVO = new ProductoVO();
        ProductoDAO ProdDAO = new ProductoDAO();

    
      out.write("\n");
      out.write("    <body>\n");
      out.write("         <header class=\"site-header sticky-top py-1\" style=\"background-color: #4C4C4C;\">\n");
      out.write("            <nav class=\"container d-flex flex-column flex-md-row justify-content-between\" >\n");
      out.write("                <h3><span style=\"display: inline; color:#FFFFFF  \">Over</span><span style=\"display: inline; color: #EF6737;\">tex</span></h3>\n");
      out.write("                <a  type=\"button\" class=\"btn btn-custom\" href=\"Vista_Administrador.jsp\" class=\"text-warning\">Menu</a>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"dropdown\">\n");
      out.write("                    <button class=\"btn btn-custom\">Producto</button>\n");
      out.write("                    <div class=\"dropdown-content\">\n");
      out.write("                        <a href=\"AdministradorRegistrarProducto.jsp\">Generar Producto</a>\n");
      out.write("                        <a href=\"AdministradorListaProductos.jsp\">Listar Producto</a>\n");
      out.write("                        <a href=\"AdministradorListaProductosMovimientos.jsp\">Movimientos</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"dropdown\">\n");
      out.write("                    <button class=\"btn btn-custom\">Compra</button>\n");
      out.write("                    <div class=\"dropdown-content\">\n");
      out.write("                        <a href=\"Compra_Nuevo.jsp\">Generar compra</a>\n");
      out.write("                        <a href=\"AdministradorListarCompra.jsp\">Listar Compras</a>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div><div class=\"dropdown\">\n");
      out.write("            <button class=\"btn btn-custom\">Venta</button>\n");
      out.write("            <div class=\"dropdown-content\">\n");
      out.write("                <a href=\"Venta_Nuevo.jsp\">Registrar Venta</a>\n");
      out.write("                <a href=\"AdministradorListarVenta.jsp\">Listar Ventas</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"dropdown\">\n");
      out.write("            <button class=\"btn btn-custom\">Cliente</button>\n");
      out.write("            <div class=\"dropdown-content\">\n");
      out.write("                <a href=\"AdministradorRegistrarCliente.jsp\">Generar Cliente</a>\n");
      out.write("                <a href=\"AdministradorListarCliente.jsp\">Listar Cliente</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"dropdown\">\n");
      out.write("            <button class=\"btn btn-custom\">Proveedor</button>\n");
      out.write("            <div class=\"dropdown-content\">\n");
      out.write("                <a href=\"Proveedor_Registro.jsp\" >Registro Proveedor</a>\n");
      out.write("                <a href=\"AdministradorListarProveedor.jsp\">Lista Proveedor</a>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"dropdown\">\n");
      out.write("            <button class=\"btn btn-custom\">Usuario</button>\n");
      out.write("            <div class=\"dropdown-content\">\n");
      out.write("                <a href=\"registrarUsuario.jsp\">Registrar</a>\n");
      out.write("                <a href=\"UsuarioNuevo.jsp\">Modificar</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </nav>\n");
      out.write("</header>\n");
      out.write("<br>\n");
      out.write("<div class=\"form-container\">\n");
      out.write("    <div class=\"product-heading\">\n");
      out.write("        <i class=\"fas fa-list\"></i> Editar Venta\n");
      out.write("    </div>\n");
      out.write("    <div class=\"d-flex\">\n");
      out.write("        ");
                VentaDAO venDAO = new VentaDAO();
            VentaVO venVO = (VentaVO) request.getAttribute("ventaparaconsultar");
            if (venVO != null) {

        
      out.write(" \n");
      out.write("        <div class=\"col-sm-4\">\n");
      out.write("\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <form class=\"row g-3\" method=\"post\" action=\"Producto\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            ");
                                    
                                HttpSession mySession = request.getSession();
                                String valor = (String) session.getAttribute("IdVenta");
                            
      out.write("\n");
      out.write("                            <div class=\"col-md-10\">\n");
      out.write("\n");
      out.write("                                <label>Documento del cliente</label>\n");
      out.write("                                <div class=\"input-group\">\n");
      out.write("\n");
      out.write("                                    <input type=\"text\" name=\"Documento\" class=\"form-control\" min=\"7\" max=\"11\" value =\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clienteEncontrado.getDocumento()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" size=\"11\">\n");
      out.write("                                    <button  class=\"btn btn-outline-primary\" type=\"submit\" name=\"opcion\" value=\"consultarCliente1\" >\n");
      out.write("                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-search\" viewBox=\"0 0 16 16\">\n");
      out.write("                                        <path d=\"M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z\"/></button>\n");
      out.write("                                    </svg>\n");
      out.write("                                    </button>\n");
      out.write("                                    ");

                                        String opcion = request.getParameter("opcion");

                                        if (opcion != null && opcion.equals("consultarCliente1")) {
                                    
      out.write("\n");
      out.write("                                    <input type=\"hidden\" name=\"idCliente\" class=\"form-control\" min=\"7\" max=\"11\" value =\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clienteEncontrado.getIdCliente()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                    ");

                                    } else {
                                    
      out.write("\n");
      out.write("                                    <input type=\"hidden\" name=\"idCliente\" class=\"form-control\" min=\"7\" max=\"11\" value =\"");
      out.print(venVO.getIdidCliente());
      out.write("\">\n");
      out.write("                                    ");

                                        }
                                    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    <input type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.IdVenta}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"IdVenta\">\n");
      out.write("                                    ");

                                        // Recupera el ID de usuario almacenado en la sesión
                                        String Id = (String) mysession.getAttribute("UsuarioId");
                                    
      out.write("\n");
      out.write("                                    <input type=\"hidden\" name=\"idUsuario\" id=\"idUsuarioSesion\" value=\"");
      out.print(Id);
      out.write("\" size=\"1\">\n");
      out.write("                                     <button class=\"btn btn-outline-secondary\" type=\"submit\" name=\"opcion\"  value=\"actualizarVenta\" >\n");
      out.write("                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-arrow-clockwise\" viewBox=\"0 0 16 016\">\n");
      out.write("                                        <path fill-rule=\"evenodd\" d=\"M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2v1z\"/>\n");
      out.write("                                        <path d=\"M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466z\"/>\n");
      out.write("                                        </svg>\n");
      out.write("\n");
      out.write("                                    </button>\n");
      out.write("                                    \n");
      out.write("                                </div>\n");
      out.write("                                    <p style=\"color: #666; font-size: smaller;\">\n");
      out.write("                                    Presiona el botón de <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-arrow-clockwise\" viewBox=\"0 0 16 016\">\n");
      out.write("                                        <path fill-rule=\"evenodd\" d=\"M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2v1z\"/>\n");
      out.write("                                        <path d=\"M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466z\"/>\n");
      out.write("                                        </svg> para actualizar usuario\n");
      out.write("                                </p>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                <div class=\"col-md-6\">\n");
      out.write("                                    <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-person-circle\" viewBox=\"0 0 16 16\">\n");
      out.write("                                    <path d=\"M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z\"/>\n");
      out.write("                                    <path fill-rule=\"evenodd\" d=\"M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z\"/>\n");
      out.write("                                    </svg> \n");
      out.write("                                    <label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clienteEncontrado.getCliNombre()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("  </label>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-6\">\n");
      out.write("                                    <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-calendar-week\" viewBox=\"0 0 16 16\">\n");
      out.write("                                    <path d=\"M11 6.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-5 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1z\"/>\n");
      out.write("                                    <path d=\"M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z\"/>\n");
      out.write("                                    </svg>\n");
      out.write("                                    <label id=\"fecha\"></label>\n");
      out.write("                                    <script>\n");
      out.write("                                        // Obtener la fecha actual\n");
      out.write("                                        var fecha_actual = new Date();\n");
      out.write("\n");
      out.write("                                        // Formatear la fecha\n");
      out.write("                                        var options = {year: 'numeric', month: 'numeric', day: 'numeric'};\n");
      out.write("                                        var fecha_formateada = fecha_actual.toLocaleDateString('es-ES', options);\n");
      out.write("\n");
      out.write("                                        // Mostrar la fecha en la página web\n");
      out.write("                                        document.getElementById(\"fecha\").innerHTML = fecha_formateada;\n");
      out.write("                                    </script>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <h5>Producto</h5>\n");
      out.write("                            <div class=\"col-md-12\">\n");
      out.write("                                <div class=\"input-group\">\n");
      out.write("                                    <select name=\"idPro\" class=\"btn btn-outline-secondary\">\n");
      out.write("                                        <option>Seleccionar</option>\n");
      out.write("                                        ");

                                            ArrayList<ProductoVO> listarProducto = ProdDAO.listar();
                                            for (int i = 0; i < listarProducto.size(); i++) {
                                                ProdVO = listarProducto.get(i);
                                        
      out.write("\n");
      out.write("                                        <option value=\"");
      out.print(ProdVO.getIdProductos());
      out.write('"');
      out.write('>');
      out.print(ProdVO.getProNombre());
      out.write("</option>\n");
      out.write("                                        ");
}
      out.write("\n");
      out.write("                                    </select><br>\n");
      out.write("                                    <button type=\"submit\" name=\"opcion\" value=\"consultarcodigoVenta1\" class=\"btn btn-outline-primary\">\n");
      out.write("                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-search\" viewBox=\"0 0 16 16\">\n");
      out.write("                                        <path d=\"M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z\"/></button>\n");
      out.write("                                    </svg>\n");
      out.write("                                    </button>\n");
      out.write("                                    ");

                                        ProdVO = (ProductoVO) request.getAttribute("productoencontrado");
                                        if (ProdVO != null) {
                                    
      out.write("\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <div class=\"col-md-7\">\n");
      out.write("                                <label for=\"inputCity\" class=\"form-label\">Producto</label>\n");
      out.write("                                <input type=\"text\" value=\"");
      out.print(ProdVO.getProNombre());
      out.write("\" class=\"form-control\" name=\"ProNombre\" readonly>\n");
      out.write("                                <input type=\"hidden\" value=\"");
      out.print(ProdVO.getIdProductos());
      out.write("\" class=\"form-control\" name=\"idProducto\" readonly>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-5\">\n");
      out.write("                                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-currency-dollar\" viewBox=\"0 0 16 16\">\n");
      out.write("                                <path d=\"M4 10.781c.148 1.667 1.513 2.85 3.591 3.003V15h1.043v-1.216c2.27-.179 3.678-1.438 3.678-3.3 0-1.59-.947-2.51-2.956-3.028l-.722-.187V3.467c1.122.11 1.879.714 2.07 1.616h1.47c-.166-1.6-1.54-2.748-3.54-2.875V1H7.591v1.233c-1.939.23-3.27 1.472-3.27 3.156 0 1.454.966 2.483 2.661 2.917l.61.162v4.031c-1.149-.17-1.94-.8-2.131-1.718H4zm3.391-3.836c-1.043-.263-1.6-.825-1.6-1.616 0-.944.704-1.641 1.8-1.828v3.495l-.2-.05zm1.591 1.872c1.287.323 1.852.859 1.852 1.769 0 1.097-.826 1.828-2.2 1.939V8.73l.348.086z\"/>\n");
      out.write("                                </svg>\n");
      out.write("                                <label class=\"form-label\">Precio</label>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                <input type=\"text\" value=\"");
      out.print(ProdVO.getPrecioUnidad());
      out.write("\" class=\"form-control\" name=\"precioVenta\" size=\"11\" minlength=\"3\" maxlength=\"9\"  placeholder=\"0\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-5\">\n");
      out.write("                                <label class=\"form-label\">Cantidad</label>\n");
      out.write("                                <input type=\"text\" value=\"1\" class=\"form-control\" name=\"cantidadVenta\" size=\"11\" minlength=\"1\" maxlength=\"3\" required>\n");
      out.write("                                <p><small>En existencia hay ");
      out.print(ProdVO.getProStock());
      out.write("</small></p>\n");
      out.write("\n");
      out.write("                                <button class=\"btn btn-outline-primary\" type=\"submit\" name=\"opcion\" value=\"agregarDetalleVenta\" >Agregar</button>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("                </div>     \n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        ");
                if (request.getAttribute("MensajeError") != null) {
      out.write("\n");
      out.write("        <div class=\"alert alert-danger\" role=\"alert\">\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MensajeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");
} else {
      out.write("\n");
      out.write("        <div class=\"alert alert-light\" role=\"alert\">\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MensajeExito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <div class=\"col-sm-13\">\n");
      out.write("        <div class=\"card\">\n");
      out.write("            <div class=\"card-body\">\n");
      out.write("                <form  class=\"row g-3\" method=\"post\" action=\"Producto\" >\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <div >\n");
      out.write("                            <h4 align=\"right\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.IdCompra}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h4>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <table class=\"table\" id=\"myTable\">\n");
      out.write("\n");
      out.write("                            <thead class=\"thead-dark\">\n");
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <td scope=\"col\">#</td>\n");
      out.write("                                    <td scope=\"col\"></td>\n");
      out.write("                                    <td>Id Producto</td>\n");
      out.write("                                    <td>Nombre Producto</td>\n");
      out.write("                                    <td>Cantidad</td>\n");
      out.write("                                    <td>Precio</td>\n");
      out.write("                                    <td>Sub Total </td>\n");
      out.write("                                    <td>Accion</td>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("\n");
      out.write("                                ");

                                    int cont = 0;
                                    detalle_VentaDAO devDAO = new detalle_VentaDAO();
                                    for (detalle_VentaVO deVO : devDAO.listarDetalleVenta((String) session.getAttribute("IdVenta"))) {
                                        cont = cont + 1;
                                
      out.write("\n");
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <td scope=\"col\">");
      out.print(cont);
      out.write("</td>\n");
      out.write("                                    <td><input style=\"background: transparent; border: none;\" type=\"hidden\" value=\"");
      out.print(deVO.getId_DetalleVenta());
      out.write("\" name=\"IdDetalleVenta\" size=\"0\" readonly></td>\n");
      out.write("                                    <td><input style=\"background: transparent; border: none;\" type=\"text\" value=\"");
      out.print(deVO.getIdProducto());
      out.write("\" size=\"4\" readonly></td>\n");
      out.write("                                    <td>");
      out.print(deVO.getNomProducto());
      out.write("</td>\n");
      out.write("                                    <td><input style=\"background: transparent; border: none;\" type=\"text\" value=\"");
      out.print(deVO.getCantidad());
      out.write("\" size=\"4\" readonly></td>\n");
      out.write("                                    <td><input style=\"background: transparent; border: none;\" type=\"text\" value=\"");
      out.print(deVO.getPrecioUnitario());
      out.write("\" size=\"4\" readonly></td>\n");
      out.write("                                    <td><input style=\"background: transparent; border: none;\" type=\"text\" value=\"");
      out.print(deVO.getSubtotal());
      out.write("\" size=\"4\" readonly></td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <button type=\"submit\" name=\"opcion\" value=\"borrarDetalleVenta1\" class=\"btn btn-outline-danger\">\n");
      out.write("                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-trash\" viewBox=\"0 0 16 16\">\n");
      out.write("                                            <path d=\"M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z\"/>\n");
      out.write("                                            <path d=\"M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z\"/>\n");
      out.write("                                            </svg>\n");
      out.write("                                        </button>\n");
      out.write("                                    </td>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("\n");
      out.write("                        </table>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-footer\">\n");
      out.write("                        <div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <button type=\"button\" class=\"btn btn-outline-success\" data-bs-toggle=\"modal\" data-bs-target=\"#exampleModal\">Finalizar</button>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <!-- Modal -->\n");
      out.write("                            <div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("                                <div class=\"modal-dialog\">\n");
      out.write("                                    <div class=\"modal-content\">\n");
      out.write("                                        <div class=\"modal-header\">\n");
      out.write("                                            <h5 class=\"modal-title\" id=\"exampleModalLabel\">Su compra se genero de forma correcta</h5>\n");
      out.write("                                            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"modal-body\">\n");
      out.write("                                            ¿Desea ir a la pagina anterior?\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"modal-footer\">\n");
      out.write("                                            <a href=\"Actualizar_Venta.jsp\"><button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Salir</button></a>\n");
      out.write("                                            <a href=\"AdministradorListarVenta.jsp\"><button type=\"button\"  class=\"btn btn-primary\" data-bs-dismiss=\"modal\">Aceptar</button></a>\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    ");
}
      out.write("                     \n");
      out.write("</div> \n");
      out.write("</div> \n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.6.4.min.js\" integrity=\"sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("<script src=\"https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js\"></script>\n");
      out.write("<script src=\"https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap5.min.js\"></script>\n");
      out.write("<script>\n");
      out.write("                                        $(document).ready(function ()\n");
      out.write("                                        {\n");
      out.write("                                            $('#myTable').DataTable({\n");
      out.write("                                                language: {\n");
      out.write("                                                    url: 'https://cdn.datatables.net/plug-ins/1.13.4/i18n/es-ES.json',\n");
      out.write("                                                }\n");
      out.write("                                            });\n");
      out.write("\n");
      out.write("                                        });\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
