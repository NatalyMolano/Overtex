/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ModeloDAO.usuarioDAO;
import ModeloVO.usuarioVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Janus
 */
@WebServlet(name = "usuarioControlador", urlPatterns = {"/Usuario"})
public class usuarioControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String servidor, puerto, usuario, clave;
        String asunto = "datos de tu usuario Overtex";

        String opcion = request.getParameter("opcion");
        String idUsuario = request.getParameter("idUsuario");
        String UsuDocumento = request.getParameter("UsuDocumento");
        String UsuNombre = request.getParameter("UsuNombre");
        String UsuContrasena = request.getParameter("Pass");
        String Usudireccion = request.getParameter("Usudireccion");
        String UsuTelefono = request.getParameter("UsuTelefono");
        String UsuEstado = request.getParameter("UsuEstado");
        String IdRol = request.getParameter("IdRol");
        String mensaje = "Bienvenido, usuario es: "+UsuNombre+ " y su contraseña es: " + UsuContrasena;

        // PropiedadesCorreo propiedadeC = new PropiedadesCorreo();
        ServletContext context = getServletContext();
        servidor = context.getInitParameter("servidor");
        puerto = context.getInitParameter("puerto");
        usuario = context.getInitParameter("usuario");
        clave = context.getInitParameter("clave");

        usuarioVO usuVO = new usuarioVO(idUsuario, UsuDocumento, UsuNombre, UsuContrasena, Usudireccion, UsuTelefono, UsuEstado, IdRol);
        usuarioDAO usuDAO = new usuarioDAO(usuVO);//datos que esten en el VO

        switch (opcion) {
            case "registrarUsuario"://Agregar Registro

                try {

                    if (usuDAO.agregar()) {
                        request.setAttribute("MensajeExito", "El usuario se registro de manera correcta");

                        //PropiedadesCorreo.envioCorreo(servidor, puerto, usuario, clave, Usudireccion, asunto, mensaje);

                        //Propiedades servidor SMTP
                        Properties propiedades = new Properties();
                        propiedades.put("mail.smtp.host", servidor);
                        propiedades.put("mail.smtp.port", puerto);
                        propiedades.put("mail.smtp.auth", "true");
                        propiedades.put("mail.smtp.starttls.enable", "true");

                        Authenticator autenticar = new Authenticator() {
                            public PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(usuario, clave);
                            }
                        };

                        Session sesion = Session.getInstance(propiedades, autenticar);
                        Message msg = new MimeMessage(sesion);
                        msg.setFrom(new InternetAddress(usuario));
                        InternetAddress[] direcciones = {new InternetAddress(Usudireccion)};
                        msg.setRecipients(Message.RecipientType.TO, direcciones);
                        msg.setSubject(asunto);
                        msg.setSentDate(new Date());
                        msg.setText(mensaje);
                        Transport.send(msg, usuario, clave);

                    } else {
                        request.setAttribute("MensajeError", "El usuario no se registro correctamente");

                    }

                    request.getRequestDispatcher("registrarUsuario.jsp").forward(request, response);
                    break;
                } catch (Exception e) {
                }

            case "actualizarUsuario": //Actualizar Registro
                try {
                    if (usuDAO.actualizar()) {
                        request.setAttribute("MensajeExito", "El usuario se actualizó de manera correcta");

                    } else {
                        request.setAttribute("MensajeError", "El usuario no se actualizó correctamente");

                    }
                    //redireccionar
                    request.getRequestDispatcher("UsuarioNuevo.jsp").forward(request, response);
                    break;
                } catch (Exception e) {
                }
            case "consultarUsuario":
                usuVO = usuDAO.consultarID(idUsuario);
                if (usuVO != null) {
                    request.setAttribute("usuarioencontrado", usuVO);
                    request.getRequestDispatcher("GerenteListarCompra.jsp").forward(request, response);
                    break;
                } else {
                    request.setAttribute("mensajeError", "¡el usuario no existe!");
                    request.getRequestDispatcher("GerenteListarCompra.jsp").forward(request, response);
                }

            case "borrarUsuario":
                try {
                    if (usuDAO.borrar()) {
                        request.setAttribute("MensajeExito", "La compra se borró de manera correcta");

                    } else {
                        request.setAttribute("MensajeError", "La compra no se borró correctamente");

                    }
                    //redireccionar
                    request.getRequestDispatcher("UsuarioNuevo.jsp").forward(request, response);
                    break;
                } catch (Exception e) {
                }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
