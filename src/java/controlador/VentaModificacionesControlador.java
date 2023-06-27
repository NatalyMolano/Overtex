/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ModeloDAO.ProductoModificacionesDAO;
import ModeloDAO.VentaModificacionesDAO;
import ModeloVO.VentaModificacionesVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author APRENDIZ
 */
@WebServlet(name = "VentaModificacionesControlador", urlPatterns = {"/VentaModificaciones"})
public class VentaModificacionesControlador extends HttpServlet {

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

        String idVenta = request.getParameter("idVenta");
        String new_PrecioUnidad = request.getParameter("new_PrecioUnidad");
        String new_Cantidad = request.getParameter("new_Cantidad");
        String new_VenFecha = request.getParameter("new_VenFecha");
        String IdProductos = request.getParameter("IdProductos");
        String Mes = request.getParameter("Mes");
        String IdVendedor = request.getParameter("IdVendedor");
        String opcion = request.getParameter("opcion");
        
        VentaModificacionesVO vmVO = new VentaModificacionesVO(idVenta, new_PrecioUnidad, new_Cantidad, new_VenFecha, IdProductos);
        
        VentaModificacionesDAO vmDAO = new VentaModificacionesDAO(vmVO);
        
        switch (opcion){
            
            case "registrar":

                vmVO = vmDAO.consultarPorMes(new_VenFecha);
                if (vmVO != null) {

                    request.setAttribute("VentaEncontradaMes", vmVO);
                    request.getRequestDispatcher("Venta_Consulta.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "¡La venta no existe!");
                    request.getRequestDispatcher("Venta_Consulta.jsp").forward(request, response);
                }

                break;
                  case "consultar": 
               vmVO =vmDAO.consultarPoridVendedor(Mes,IdVendedor);/*recibir el VO*/
                if(vmVO != null)
                {
                    request.setAttribute("comisionEncontrada", vmVO);
                    request.getRequestDispatcher("Venta_Consulta.jsp").forward(request, response);

                }else
                {
                    request.setAttribute("MensajeError", "El proveedor no existe");
                    request.getRequestDispatcher("Venta_Consulta.jsp").forward(request, response);

                }
                //redireccionar
                break;
                
                 case "consultarcomisiones": 
               vmVO =vmDAO.consultarPoridVendedor(Mes,IdVendedor);/*recibir el VO*/
                if(vmVO != null)
                {
                    request.setAttribute("comisionEncontrada", vmVO);
                    request.getRequestDispatcher("Venta_Comisiones.jsp").forward(request, response);

                }else
                {
                    request.setAttribute("MensajeError", "El proveedor no existe");
                    request.getRequestDispatcher("Venta_Comisiones.jsp").forward(request, response);

                }
                //redireccionar
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
