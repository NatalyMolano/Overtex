package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ModeloVO.ClienteVO;
import ModeloDAO.ClienteDAO;
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

public final class VendedorRegistrarCLiente_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  <head>\n");
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
      out.write("    ");
        ClienteDAO cliDAO = new ClienteDAO();
        ClienteVO cliVO = new ClienteVO();

    
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
      out.write("        <br>\n");
      out.write("        \n");
      out.write("<div class=\"form-container\">\n");
      out.write("    \n");
      out.write("    <div class=\"product-heading\">\n");
      out.write("        <i class=\"fas fa-pencil-alt\"></i> Registrar cliente\n");
      out.write("    </div>\n");
      out.write("    <div class=\"d-flex\">\n");
      out.write("\n");
      out.write("        <div class=\"col-sm-4\">\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <form class=\"row g-3\" method=\"post\" action=\"Cliente\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("\n");
      out.write("                            <div class=\"col-md-7\">\n");
      out.write("\n");
      out.write("                                <label>Nombre y apellido del cliente</label>\n");
      out.write("                                <div class=\"input-group\">\n");
      out.write("\n");
      out.write("                                    <input type=\"text\" name=\"cliNombre\" class=\"form-control\" size=\"11\" minlength=\"3\" maxlength=\"30\" pattern=\"^[a-zA-Z\\s]+$\"> \n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
      out.write("                        </div><br>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <div class=\"col-md-7\">\n");
      out.write("                                <label for=\"inputCity\" class=\"form-label\">Telefono del cliente</label>\n");
      out.write("                                <input type=\"text\" value=\"\" class=\"form-control\" name=\"cliTelefono\" required pattern=\"^[0-9]+$\"  minlength=\"1\" maxlength=\"12\">\n");
      out.write("                                <label for=\"inputCity\" class=\"form-label\">Documento del cliente </label>\n");
      out.write("                                <input type=\"text\" value=\"\" class=\"form-control\" name=\"Documento\" required pattern=\"^[0-9]+$\" minlength=\"1\" maxlength=\"12\">\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <br>\n");
      out.write("                           <div class=\"col-md-5\">\n");
      out.write("                                <input  type=\"hidden\" name=\"cliEstado\" value=\"1\" >\n");
      out.write("\n");
      out.write("                                <button class=\"btn btn-secondary\" type=\"submit\" name=\"opcion\" value=\"registrar1\" >Registrar</button>\n");
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
                if (request.getAttribute("mensajeError") != null) {
      out.write("\n");
      out.write("        <div class=\"alert alert-danger\" role=\"alert\">\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");
} else {
      out.write("\n");
      out.write("        <div class=\"alert alert-light\" role=\"alert\">\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeExito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("    </div>\n");
      out.write("   <div class=\"col-sm-14\">\n");
      out.write("        <div class=\"card\">\n");
      out.write("            <div class=\"card-body\">\n");
      out.write("                <form  class=\"row g-3\" method=\"post\" action=\"Cliente\" >\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <table class=\"table\" id=\"myTable\">\n");
      out.write("                           \n");
      out.write("                            <thead class=\"thead-dark\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <th scope=\"col\">#</th>\n");
      out.write("                                    <th scope=\"col\"></th>\n");
      out.write("                                    <th scope=\"col\">Nombre</th>\n");
      out.write("                                    <th scope=\"col\"></th>\n");
      out.write("                                    <th scope=\"col\">Documento</th>\n");
      out.write("                                    <th scope=\"col\">Telefono</th>\n");
      out.write("                                    <th scope=\"col\">Estado</th>\n");
      out.write("                                    <th scope=\"col\">Editar</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("                                ");

                                    int con = 0;
                                    ArrayList<ClienteVO> listarCliente = cliDAO.listar();

                                    for (int i = 0; i < listarCliente.size(); i++) {
                                        cliVO = listarCliente.get(i);
                                        con = con + 1;
                                
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>");
      out.print(con);
      out.write("</td>\n");
      out.write("                                    <td><input type=\"hidden\" value=\"");
      out.print(cliVO.getIdCliente());
      out.write("\" size=\"1\" name=\"idCliente\"></input></td>\n");
      out.write("                                    <td>");
      out.print(cliVO.getCliNombre());
      out.write("</td>\n");
      out.write("                                    <td><input style=\"background: transparent;border: none;\" type=\"hidden\" value=\"");
      out.print(cliVO.getCliNombre());
      out.write("\" size=\"1\" name=\"cliNombre\" minlength=\"2\" maxlength=\"11\" pattern=\"[0-9]+\" readonly></input></td>\n");
      out.write("                                    <td><input  style=\"background: transparent;border: none;\" type=\"text\" value=\"");
      out.print(cliVO.getDocumento());
      out.write("\" size=\"5\" name=\"Documento\" required  minlength=\"5\" maxlength=\"12\"> </input></td>\n");
      out.write("                                    \n");
      out.write("                                    <td><input style=\"background: transparent;border: none;\" type=\"text\" value=\"");
      out.print(cliVO.getCliTelefono());
      out.write("\" size=\"4\" name=\"cliTelefono\" minlength=\"5\" maxlength=\"11\"  readonly></input></td>\n");
      out.write("                                    <td><select style=\"background: transparent;border: none;\"  name=\"cliEstado\">\n");
      out.write("                                         <option value=\"1\">Activo</option>\n");
      out.write("                                         <option value=\"0\">Desactivo</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    <td>\n");
      out.write("                                        <button class=\"btn btn-outline-secondary\" type=\"submit\" name=\"opcion\" value=\"actualizar1\" >\n");
      out.write("                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-arrow-clockwise\" viewBox=\"0 0 16 016\">\n");
      out.write("                                            <path fill-rule=\"evenodd\" d=\"M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2v1z\"/>\n");
      out.write("                                            <path d=\"M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466z\"/>\n");
      out.write("                                            </svg>\n");
      out.write("                                        </button>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-footer\">\n");
      out.write("                        <div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>                   \n");
      out.write("</div>   \n");
      out.write("</div>\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.6.4.min.js\" integrity=\"sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe\" crossorigin=\"anonymous\"></script>\n");
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
      out.write("\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("\n");
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
