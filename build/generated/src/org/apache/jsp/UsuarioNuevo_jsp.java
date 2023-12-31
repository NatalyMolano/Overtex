package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ModeloDAO.usuarioDAO;
import ModeloVO.usuarioVO;
import java.util.ArrayList;
import ModeloDAO.CompraDAO;
import ModeloVO.CompraVO;
import ModeloVO.ProveedoresVO;
import ModeloDAO.ProveedoresDAO;

public final class UsuarioNuevo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("   <head>\n");
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
      out.write("            div.fixed {\n");
      out.write("                position: fixed;\n");
      out.write("                bottom: 0;\n");
      out.write("                right: 0;\n");
      out.write("                width: 100px;\n");
      out.write("                height: 50px;\n");
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
      out.write("        <br>\n");
      out.write("<div class=\"form-container\">    \n");
      out.write("    <div class=\"product-heading\">\n");
      out.write("        <i class=\"fas fa-list\"></i> Lista de Usuarios\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <form method=\"post\" action=\"Usuario\">\n");
      out.write("            <table id=\"example\" class=\"table table-striped\" style=\"width:100%\">\n");
      out.write("                <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th scope=\"col\">#</th>\n");
      out.write("                    <th scope=\"col\"></th>\n");
      out.write("                    <th scope=\"col\">UsuDocumento</th>\n");
      out.write("                    <th scope=\"col\">UsuNombre</th>\n");
      out.write("                    <th scope=\"col\">Usudireccion</th>\n");
      out.write("                    <th scope=\"col\">UsuTelefono</th>\n");
      out.write("                    <th scope=\"col\">Estado</th>\n");
      out.write("                    <th scope=\"col\">Editar</th>\n");
      out.write("                </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("\n");
      out.write("                    ");

                        usuarioVO usuVO = new usuarioVO();
                        usuarioDAO usuDAO = new usuarioDAO();

                        ArrayList<usuarioVO> listarCompra = usuDAO.listar();

                        for (int i = 0; i < listarCompra.size(); i++) {
                            usuVO = listarCompra.get(i);
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(usuVO.getIdUsuario());
      out.write("</td>\n");
      out.write("                        <td><input style=\"background: transparent;border: none;\" type=\"hidden\" value=\"");
      out.print(usuVO.getIdUsuario());
      out.write("\" size=\"4\" name=\"idUsuario\" required></input></td>\n");
      out.write("                        <td><input style=\"background: transparent;border: none;\" type=\"text\" value=\"");
      out.print(usuVO.getUsuDocumento());
      out.write("\" size=\"6\" name=\"UsuDocumento\" required readonly></input></td>\n");
      out.write("                        <td><input style=\"background: transparent;border: none;\" type=\"text\" value=\"");
      out.print(usuVO.getUsuNombre());
      out.write("\" size=\"6\" name=\"UsuNombre\" required> </input></td>\n");
      out.write("                        <td><input style=\"background: transparent;border: none;\" type=\"text\" value=\"");
      out.print(usuVO.getUsudireccion());
      out.write("\" size=\"6\"name=\"Usudireccion\"required ></input></td>\n");
      out.write("                        <td><input style=\"background: transparent;border: none;\" type=\"text\" value=\"");
      out.print(usuVO.getUsuTelefono());
      out.write("\"size=\"3\" name=\"UsuTelefono\" required></input></td>\n");
      out.write("                        <td><input style=\"background: transparent;border: none;\" type=\"text\" value=\"");
      out.print(usuVO.getUsuEstado());
      out.write("\"size=\"1\" name=\"UsuEstado\" required></input></td>\n");
      out.write("\n");
      out.write("                        <td>\n");
      out.write("                             <button class=\"btn btn-outline-secondary\" type=\"submit\" name=\"opcion\" value=\"actualizarUsuario\" >\n");
      out.write("                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-arrow-clockwise\" viewBox=\"0 0 16 016\">\n");
      out.write("                                        <path fill-rule=\"evenodd\" d=\"M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2v1z\"/>\n");
      out.write("                                        <path d=\"M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466z\"/>\n");
      out.write("                                        </svg>\n");
      out.write("\n");
      out.write("                                    </button>\n");
      out.write("                             <button type=\"submit\" name=\"opcion\" value=\"borrarUsuario\" class=\"btn botones-button\">\n");
      out.write("                                                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-trash\" viewBox=\"0 0 16 16\">\n");
      out.write("                                                <path d=\"M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z\"/>\n");
      out.write("                                                <path d=\"M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z\"/>\n");
      out.write("                                                </svg>\n");
      out.write("                                            </button>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </td>\n");
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("                <tfoot>\n");
      out.write("                    <tr>\n");
      out.write("                    </tr>\n");
      out.write("                </tfoot>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
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
      out.write("</div>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.5.1.js\"></script>\n");
      out.write("<script src=\"https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js\"></script>\n");
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
