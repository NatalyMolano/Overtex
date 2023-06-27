/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ModeloDAO.Mod_VentaDAO;
import ModeloVO.Mod_VentaVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chiri
 */
@WebServlet(name = "Mod_VentaControlador", urlPatterns = {"/Mod_Venta"})
public class Mod_VentaControlador extends HttpServlet {

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
       String idVenta= request.getParameter("idVenta");
       String new_PrecioUnidad= request.getParameter("new_PrecioUnidad");
       String old_PrecioUnidad= request.getParameter("old_PrecioUnidad");
       String new_Cantidad= request.getParameter("new_Cantidad");
       String old_Cantidad= request.getParameter("old_Cantidad");
       String new_VenFecha= request.getParameter("new_VenFecha");
       String old_VenFecha= request.getParameter("old_VenFecha");
       String idVendedor= request.getParameter("idVendedor");
       String idCliente= request.getParameter("idCliente");
       String Estado= request.getParameter("Estado");
       String IdProductos= request.getParameter("IdProductos");
       String operacionv= request.getParameter("operacionv");
       String opcion = request.getParameter("opcion");
       
       Mod_VentaVO modvenVO = new Mod_VentaVO(idVenta, new_PrecioUnidad, old_PrecioUnidad, new_Cantidad, old_Cantidad, new_VenFecha, old_VenFecha, idVendedor, idCliente, Estado, IdProductos, operacionv);
       Mod_VentaDAO modvenDAO = new Mod_VentaDAO(modvenVO);
       
       switch(opcion){
           
           case "consultar":
                modvenVO = modvenDAO.consultar(idVenta);
                 if (modvenVO != null) {
                     
                     request.setAttribute("ventaEncontrada", modvenVO);
                    request.getRequestDispatcher("mod_ventaConsulta.jsp").forward(request, response);
                 }else {
                    request.setAttribute("mensajeError", "¡La venta  no existe!");
                    request.getRequestDispatcher("mod_ventaConsulta.jsp").forward(request, response);
                }

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
