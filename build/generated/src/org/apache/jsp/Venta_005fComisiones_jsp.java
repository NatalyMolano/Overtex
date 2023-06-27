package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ModeloDAO.VentaDAO;
import ModeloVO.VentaVO;
import ModeloVO.UsuarioVO_1;

public final class Venta_005fComisiones_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("            .btn-bootstrap {\n");
      out.write("                padding: .375rem .75rem;\n");
      out.write("                border-radius: .25rem;\n");
      out.write("                background-color: darkorange;\n");
      out.write("                color: #ffffff;\n");
      out.write("                transition: background-color .15s ease-in-out;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .btn-bootstrap:hover, .btn-bootstrap:focus {\n");
      out.write("                background-color: orangered;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .btn-bootstrap:active {\n");
      out.write("                background-color: #0062cc;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
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
      out.write("                        <button style=\"border-radius: 12px;\" class=\"btn btn-outline-light\" type=\"submit\" value=\"Cerrar Sesion\">\n");
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
      out.write("        <script defer src=\"https://code.jquery.com/jquery-3.5.1.js\"></script>\n");
      out.write("        <script defer src=\"https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js\"></script>\n");
      out.write("        <script defer src=\"https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap5.min.js\"></script>\n");
      out.write("        <script defer src=\"script.js\"></script>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n");
      out.write("        <link href=\"https://cdn.datatables.net/1.13.4/css/dataTables.bootstrap5.min.css\" rel=\"stylesheet\"/>\n");
      out.write("        <link href=\"CSS/estilo_fondo.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <style>\n");
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
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <header class=\"site-header sticky-top py-1\" style=\"background-color: #4C4C4C;\">\n");
      out.write("            <nav class=\"container d-flex flex-column flex-md-row justify-content-between\" >\n");
      out.write("                <h3><span style=\"display: inline; color:#FFFFFF  \">Over</span><span style=\"display: inline; color: #EF6737;\">tex</span></h3>\n");
      out.write("                <a  type=\"button\" class=\"btn btn-custom\" href=\"Vista_Vendedor.jsp\" class=\"text-warning\">Menu</a>\n");
      out.write("\n");
      out.write("               <div class=\"dropdown\">\n");
      out.write("                    <button class=\"btn btn-custom\">Cliente</button>\n");
      out.write("                    <div class=\"dropdown-content\">\n");
      out.write("                        <a href=\"VendedorRegistrarCLiente.jsp\">Generar Cliente</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("       \n");
      out.write("        <div class=\"dropdown\">\n");
      out.write("            <button class=\"btn btn-custom\">Comision</button>\n");
      out.write("            <div class=\"dropdown-content\">\n");
      out.write("                <a href=\"Venta_Comisiones.jsp\">ver comisiones</a>\n");
      out.write("              </div>\n");
      out.write("        </div>\n");
      out.write("       \n");
      out.write("         </nav>\n");
      out.write("       </header>\n");
      out.write("         <br>\n");
      out.write("<div class=\"form-container\">    \n");
      out.write("    <div class=\"product-heading\">\n");
      out.write("        <i class=\"fas fa-list\"></i> Lista de Usuarios\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("            <form method=\"post\" action=\"Producto\">\n");
      out.write("                <table id=\"example\" class=\"table table-striped\" style=\"width:100%\">\n");
      out.write("                    <thead>\n");
      out.write("\n");
      out.write("                    </thead>\n");
      out.write("                    <tfoot>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>\n");
      out.write("                                <div class=\"col-12\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    ");
                                        // Recupera el ID de usuario almacenado en la sesión
                                        String Id = (String) mysession.getAttribute("UsuarioId");
                                    
      out.write("\n");
      out.write("                                    <input type=\"hidden\" name=\"idUsuario\" id=\"idUsuarioSesion\" value=\"");
      out.print(Id);
      out.write("\" size=\"1\">\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </th>        \n");
      out.write("                            <th>\n");
      out.write("                                <div class=\"col-12\" >\n");
      out.write("                                    <label>Seleccione el mes</label><br>\n");
      out.write("                                    <select name=\"Mes\"  class=\"btn btn-outline-secondary\">\n");
      out.write("                                        <option value=\"01\">Enero</option>\n");
      out.write("                                        <option value=\"02\">Febrero</option>\n");
      out.write("                                        <option value=\"03\">Marzo</option>\n");
      out.write("                                        <option value=\"04\">Abril</option>\n");
      out.write("                                        <option value=\"05\">Mayo</option>\n");
      out.write("                                        <option value=\"06\">Junio</option>\n");
      out.write("                                        <option value=\"07\">Julio</option>\n");
      out.write("                                        <option value=\"08\">Agosto</option>\n");
      out.write("                                        <option value=\"09\">Septiembre</option>\n");
      out.write("                                        <option value=\"10\">Octubre</option>\n");
      out.write("                                        <option value=\"11\">Noviembre</option>\n");
      out.write("                                        <option value=\"12\">diciembre</option>\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </th> \n");
      out.write("                            <th>\n");
      out.write("                                <button type=\"submit\" name=\"Opcion\" value=\"consultarcomisiones\" style=\"width: 30%;\" class=\"btn btn-secondary\" data-toggle=\"tooltip\" data-placement=\"top\"> Consultar</button>\n");
      out.write("\n");
      out.write("                            </th>\n");
      out.write("                        </tr>              \n");
      out.write("                    </tfoot>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("            <form>\n");
      out.write("                <table  class=\"table\" style=\"color: #333\">\n");
      out.write("\n");
      out.write("                    <tr >\n");
      out.write("                        <th>Cantidad vendida</th>\n");
      out.write("                        <th>idVendedor</th>\n");
      out.write("                        <th>Comisiones</th>\n");
      out.write("                        <th>Mes</th>\n");
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                        VentaVO vmVO = (VentaVO) request.getAttribute("comisionEncontrada");
                        VentaDAO vmDAO = new VentaDAO();
                        if (vmVO != null) {
                    
      out.write("\n");
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("\n");
      out.write("                        <th>");
      out.print(vmVO.getidVenta());
      out.write("</th>\n");
      out.write("                        <th>");
      out.print(vmVO.getPrecio());
      out.write("</th>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <th>");
      out.print(vmVO.getIdproductos());
      out.write("</th>\n");
      out.write("                        <th>");
      out.print(vmVO.getCantidad());
      out.write("</th>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </table>\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("            ");

                if (request.getAttribute("mensajeError") != null) {
      out.write("\n");
      out.write("            <div class=\"alert alert-danger\" role=\"alert\">\n");
      out.write("                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");
} else {
      out.write("\n");
      out.write("            <div class=\"alert alert-light\" role=\"alert\">\n");
      out.write("                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeExito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
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
