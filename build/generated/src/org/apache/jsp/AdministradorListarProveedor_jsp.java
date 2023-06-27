package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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

public final class AdministradorListarProveedor_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
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
      out.write("    <body>\n");
      out.write("        <header class=\"site-header sticky-top py-1\" style=\"background-color: #4C4C4C;\">\n");
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
      out.write("\n");
      out.write("    <div class=\"product-heading\">\n");
      out.write("        <i class=\"fas fa-pencil-alt\"></i> Listar Proveedor\n");
      out.write("    </div>\n");
      out.write("    <div class=\"d-flex\">\n");
      out.write("        <div class=\"col-sm-10\" >\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <form method=\"post\" action=\"Producto\">\n");
      out.write("                        <table id=\"example\" class=\"display nowrap\" style=\"width:100%\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("\n");
      out.write("                                    <th scope=\"col\">#</th>\n");
      out.write("                                    <th scope=\"col\">ID Empresa</th>\n");
      out.write("                                    <th scope=\"col\">Nombre Encargado</th>\n");
      out.write("                                    <th scope=\"col\">Direccion</th>\n");
      out.write("                                    <th scope=\"col\">NombreEmpresa</th>\n");
      out.write("                                    <th scope=\"col\">Telefono</th>\n");
      out.write("\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("                                ");
                            int con = 0;
                                    ProveedoresVO proVO = new ProveedoresVO();
                                    ProveedoresDAO proDAO = new ProveedoresDAO();

                                    ArrayList<ProveedoresVO> listarCompra = proDAO.listar();

                                    for (int i = 0; i < listarCompra.size(); i++) {
                                        proVO = listarCompra.get(i);
                                        con = con + 1;
                                
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>");
      out.print(con);
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(proVO.getDocumento());
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(proVO.getProvNombre());
      out.write(" </input></td>\n");
      out.write("                                    <td>");
      out.print(proVO.getProvApellido());
      out.write("</input></td>\n");
      out.write("                                    <td>");
      out.print(proVO.getNombreEmpresa());
      out.write("</input></td>\n");
      out.write("                                    <td>");
      out.print(proVO.getTelefono());
      out.write("</input></td>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                </tr>\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("\n");
      out.write("                        </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                                <div class=\"my-4\"></div>\n");
      out.write("        <div class=\"col-sm-2\">\n");
      out.write("    <div class=\"card border-0\">\n");
      out.write("        <div class=\"card-body\">\n");
      out.write("            <h4 class=\"d-flex justify-content-between align-items-center mb-3\">\n");
      out.write("                <div class=\"text-center\">\n");
      out.write("                    \n");
      out.write("                    <span class=\"text-body-secondary\">Destacados</span>\n");
      out.write("                </div>\n");
      out.write("            </h4>\n");
      out.write("            <ul class=\"list-group mb-2\">\n");
      out.write("                ");
 ProveedoresDAO proveedoresDAO = new ProveedoresDAO();
                ArrayList<ProveedoresVO> pro = proveedoresDAO.ListarProveedor();

                for (ProveedoresVO cliente : pro) {
                    con = con + 1;
                
      out.write("\n");
      out.write("                <li class=\"list-group-item d-flex justify-content-between lh-sm\">\n");
      out.write("                    <div>\n");
      out.write("                        <h6 class=\"my-0\">");
      out.print(cliente.getNombreEmpresa());
      out.write("</h6>\n");
      out.write("                        <small class=\"text-body-secondary\">");
      out.print(cliente.getDocumento());
      out.write("</small>\n");
      out.write("                    </div>\n");
      out.write("                    <span class=\"text-body-secondary\">");
      out.print(cliente.getConteo());
      out.write("</span>\n");
      out.write("                </li>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("                    <div class=\"my-4\"></div>\n");
      out.write("    <div class=\"fixed\">\n");
      out.write("        <a href=\"Proveedor_Registro.jsp\">\n");
      out.write("            <button style=\"border-radius: 50%; \" type=\"button\"  class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">\n");
      out.write("                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-pen\" viewBox=\"0 0 16 16\">\n");
      out.write("                <path d=\"m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z\"/>\n");
      out.write("                </svg>\n");
      out.write("            </button>\n");
      out.write("        </a>\n");
      out.write("        <form method=\"POST\" action=\"GeneradorReporte.jsp\" target=\"_blank\">\n");
      out.write("            <input style=\"border-radius: 50%;\" class=\"btn botones-naranja\" type=\"submit\" value=\"PDF\">\n");
      out.write("            <input type=\"hidden\" name=\"reportName\" value=\"proveedor\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.5.1.js\"></script>\n");
      out.write("<script src=\"https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js\"></script>\n");
      out.write("<script src=\"https://cdn.datatables.net/buttons/2.3.6/js/dataTables.buttons.min.js\"></script>\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js\"></script>\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js\"></script>\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js\"></script>\n");
      out.write("<script src=\"https://cdn.datatables.net/buttons/2.3.6/js/buttons.html5.min.js\"></script>\n");
      out.write("<script src=\"https://cdn.datatables.net/buttons/2.3.6/js/buttons.print.min.js\"></script>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("\n");
      out.write("\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $('#example').DataTable({\n");
      out.write("                    dom: 'Bfrtip',\n");
      out.write("                    buttons: [\n");
      out.write("                        {\n");
      out.write("                            extend: 'copy',\n");
      out.write("                            text: 'Copiar',\n");
      out.write("                            className: 'btn btn-primary',\n");
      out.write("                        },\n");
      out.write("                        {\n");
      out.write("                            extend: 'excel',\n");
      out.write("                            className: 'btn btn-primary',\n");
      out.write("                            text: 'Exportar a Excel'\n");
      out.write("                        },\n");
      out.write("                        {\n");
      out.write("                            extend: 'pdf',\n");
      out.write("                            className: 'btn btn-primary',\n");
      out.write("                            text: 'Exportar a PDF'\n");
      out.write("                        },\n");
      out.write("                        {\n");
      out.write("                            extend: 'print',\n");
      out.write("                            className: 'btn btn-primary',\n");
      out.write("                            text: 'Imprimir'\n");
      out.write("                        }\n");
      out.write("                    ]\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $('#mitabla').DataTable({\n");
      out.write("                    dom: 'Bfrtip',\n");
      out.write("                    buttons: [\n");
      out.write("                        {\n");
      out.write("                            extend: 'copy',\n");
      out.write("                            text: 'Copiar',\n");
      out.write("                            className: 'btn btn-primary',\n");
      out.write("                        },\n");
      out.write("                        {\n");
      out.write("                            extend: 'excel',\n");
      out.write("                            className: 'btn btn-primary',\n");
      out.write("                            text: 'Exportar a Excel'\n");
      out.write("                        },\n");
      out.write("                        {\n");
      out.write("                            extend: 'pdf',\n");
      out.write("                            className: 'btn btn-primary',\n");
      out.write("                            text: 'Exportar a PDF'\n");
      out.write("                        },\n");
      out.write("                        {\n");
      out.write("                            extend: 'print',\n");
      out.write("                            className: 'btn btn-primary',\n");
      out.write("                            text: 'Imprimir'\n");
      out.write("                        }\n");
      out.write("                    ]\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            $(document).ready(function ()\n");
      out.write("            {\n");
      out.write("                $('#ejemplo').DataTable({\n");
      out.write("                    language: {\n");
      out.write("                        url: 'https://cdn.datatables.net/plug-ins/1.13.4/i18n/es-ES.json',\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("\n");
      out.write("            });\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("    .modal-dialog {\n");
      out.write("        max-width: 80%;\n");
      out.write("    }\n");
      out.write("    .modal-body {\n");
      out.write("        max-height: 50vh;\n");
      out.write("        overflow-y: auto;\n");
      out.write("    }\n");
      out.write("    .table {\n");
      out.write("        width: 100%;\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("\n");
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
