/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ModeloDAO.ClienteDAO;
import ModeloVO.ClienteVO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author APRENDIZ
 */
@WebServlet(name = "ClienteControlador", urlPatterns = {"/Cliente"})
public class ClienteControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String idCliente = request.getParameter("idCliente");
        String cliNombre = request.getParameter("cliNombre");
        String cliTelefono = request.getParameter("cliTelefono");
        String Documento = request.getParameter("Documento");
        String cliEstado = request.getParameter("cliEstado");
        String opcion = request.getParameter("opcion");

        ClienteVO cliVo = new ClienteVO(idCliente, cliNombre, cliTelefono, Documento, cliEstado);

        ClienteDAO cliDAO = new ClienteDAO(cliVo);

        switch (opcion) {

            case "registrar":
                if (cliDAO.agregar()) {
                    request.setAttribute("mensajeExito", "¡El Cliente se registro exitosamente!");
                } else {
                    request.setAttribute("mensajeError", "¡El Cliente no se pudo registrar! ");
                }
                request.getRequestDispatcher("AdministradorRegistrarCliente.jsp").forward(request, response);
                break;

            case "actualizar":
                if (cliDAO.actualizar()) {
                    request.setAttribute("mensajeExito", "¡El Cliente se actualizo exitosamente!");
                } else {
                    request.setAttribute("mensajeError", "¡El Cliente no se pudo actualizar! ");
                }
                request.getRequestDispatcher("AdministradorRegistrarCliente.jsp").forward(request, response);
                break;

            case "consultar":

                cliVo = cliDAO.consultarPoridCliente(idCliente);
                if (cliVo != null) {

                    request.setAttribute("clienteEncontrado", cliVo);
                    request.getRequestDispatcher("Cliente_Nueva.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "¡El el cliente no existe!");
                    request.getRequestDispatcher("AdministradorRegistrarCliente.jsp").forward(request, response);
                }

                break;
                
             case "borrar":
                if (cliDAO.borrar()) {
                    request.setAttribute("mensajeExito", "¡El Cliente se elimino exitosamente!");
                } else {
                    request.setAttribute("mensajeError", "¡El Cliente no se pudo eliminar! ");
                }
                request.getRequestDispatcher("AdministradorRegistrarCliente.jsp").forward(request, response);
                break;   
                
                
                 case "consultarid":

                cliVo = cliDAO.consultarPoridCliente(idCliente);
                if (cliVo != null) {

                    request.setAttribute("clienteEncontrado", cliVo);
                    request.getRequestDispatcher("Cliente_Nueva.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "¡El el cliente no existe!");
                    request.getRequestDispatcher("Cliente_Nueva.jsp").forward(request, response);
                }

                break;
                
            case "registrar1":
                if (cliDAO.agregar()) {
                    request.setAttribute("mensajeExito", "¡El Cliente se registro exitosamente!");
                } else {
                    request.setAttribute("mensajeError", "¡El Cliente no se pudo registrar! ");
                }
                request.getRequestDispatcher("VendedorRegistrarCLiente.jsp").forward(request, response);
                break;

            case "actualizar1":
                if (cliDAO.actualizar()) {
                    request.setAttribute("mensajeExito", "¡El Cliente se actualizo exitosamente!");
                } else {
                    request.setAttribute("mensajeError", "¡El Cliente no se pudo actualizar! ");
                }
                request.getRequestDispatcher("VendedorRegistrarCLiente.jsp").forward(request, response);
                break;

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
