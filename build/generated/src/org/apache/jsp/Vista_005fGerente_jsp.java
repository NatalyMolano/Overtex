package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ModeloVO.UsuarioVO_1;

public final class Vista_005fGerente_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\" class=\"h-100\">\n");
      out.write("    <head>\n");
      out.write("        <link href=\"CSS/cover.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"CSS/diseño_1.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\">\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                justify-content: center;\n");
      out.write("                align-items: center;\n");
      out.write("                height: 100vh;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .AdminUser {\n");
      out.write("                text-align: center;\n");
      out.write("                margin: 0 0px; /* Espacios laterales */\n");
      out.write("            }\n");
      out.write("            .AdminUser {\n");
      out.write("                text-align: center;\n");
      out.write("                margin: 0 20px;\n");
      out.write("                padding: 30px;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .AdminUser h1 {\n");
      out.write("                color: #fff;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .AdminUser a {\n");
      out.write("                display: inline-block;\n");
      out.write("                margin-bottom: 10px;\n");
      out.write("                padding: 10px 20px;\n");
      out.write("                color: #ffffff; /* Color de texto personalizado */\n");
      out.write("                text-decoration: none;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                transition: background-color 0.3s ease;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .AdminUser a i {\n");
      out.write("                margin-right: 5px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .AdminUser a:hover {\n");
      out.write("                background-color: #EF6737; /* Color de fondo al pasar el cursor o enfocar */\n");
      out.write("                color: #ffffff; /* Color de texto al pasar el cursor o enfocar */\n");
      out.write("                border-color: #EF6737; /* Color del borde al pasar el cursor o enfocar */\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .AdminUser h5 {\n");
      out.write("                color: #999;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("            function showDescription(description) {\n");
      out.write("                document.getElementById(\"description\").textContent = description;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function hideDescription() {\n");
      out.write("                document.getElementById(\"description\").textContent = \"\";\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <body id=\"menus\">\n");
      out.write("        <br>\n");
      out.write("        <header class=\"site-header sticky-top py-1\" >\n");
      out.write("            <nav class=\"container d-flex flex-column flex-md-row justify-content-between\" >\n");
      out.write("                <h2><span style=\"display: inline; color:#4C4C4C;  \">Over</span><span style=\"display: inline; color: #EF6737;\">tex</span></h2>\n");
      out.write("         \n");
      out.write("            </nav>\n");
      out.write("            \n");
      out.write("        </header>\n");
      out.write("        <div class=\"AdminUser\">\n");
      out.write("\n");
      out.write("            <br><br><br>\n");
      out.write("            <h1>¡Bienvenido al panel de Gerente!</h1><br>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <a href=\"Vista_Gerente.jsp\" onmouseover=\"showDescription('Obtén una visión general de tu negocio para redirigirte al modulo deseado')\" onmouseout=\"hideDescription()\"><i class=\"fas fa-home\"></i> \n");
      out.write("            <a href=\"GerenteListarproducto.jsp\" onmouseover=\"showDescription('Descarga y revisa los reportes de Producto')\" onmouseout=\"hideDescription()\"><i class=\"fas fa-cube\"></i> Producto</a>\n");
      out.write("            <a href=\"Cliente_Consulta.jsp\">Cliente</a>\n");
      out.write("            <a href=\"GerenteListarCompra.jsp\">Consultar Compras</a>\n");
      out.write("            <a href=\"Compra_Consultar_Cambios.jsp\">Modificaciones Compras</a>\n");
      out.write("            <a href=\"Venta_Consulta.jsp\">Venta</a>\n");
      out.write("            <a href=\"GerenteListarProveedor.jsp\">Proveedor</a>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <h1>Inicio</h1>\n");
      out.write("            <p class=\"lead\">Bienvenido Gerente <p class=\"lead\">\n");
      out.write("            </p>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
