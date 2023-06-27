/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ModeloDAO.CompraDAO;
import ModeloDAO.CompraMDAO;
import ModeloVO.CompraMVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author natal
 */
@WebServlet(name = "compraMControlador", urlPatterns = {"/compraMControlador"})
public class compraMControlador extends HttpServlet {

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
       
        
        String gastos_mensuales = request.getParameter("gastos_mensuales");
        String mes= request.getParameter("mes");
        String cantidad_productos = request.getParameter("cantidad_productos");
        
       
        String id = request.getParameter("id");
        String idcompra= request.getParameter("idcompra");
        String idGerente = request.getParameter("idGerente");
        String NomProducto = request.getParameter("NomProducto");
        String new_PrecioUnidad= request.getParameter("new_PrecioUnidad");
        String old_PrecioUnidad = request.getParameter("old_PrecioUnidad");
        String new_cantidad = request.getParameter("new_cantidad");
        String old_cantidad= request.getParameter("old_cantidad");
        String new_ComFecha = request.getParameter("new_ComFecha");
        String old_ComFecha = request.getParameter("old_ComFecha");
        String Estado= request.getParameter("Estado");
        String Operacion = request.getParameter("Operacion");
        
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
        
        CompraMVO ComVO = new CompraMVO(idcompra, idGerente, NomProducto, new_PrecioUnidad, old_PrecioUnidad, new_cantidad, old_cantidad, new_ComFecha, old_ComFecha);
        CompraMDAO ComDAO = new CompraMDAO(ComVO);
        
        switch(opcion)
        { 
            case 1: 
            ComVO =ComDAO.consultarPorMes(mes);/*recibir el VO*/
            if(ComVO != null)
            {
                request.setAttribute("compraEncontrado", ComVO);
                request.getRequestDispatcher("Compra_Consultar_Cambios.jsp").forward(request, response);

            }else
            {
                request.setAttribute("MensajeError", "La compra no existe");
                request.getRequestDispatcher("Compra_Consulta_Cambios.jsp").forward(request, response);

            }
            //redireccionar
            break;
            
            case 2: 
            
            ComVO =ComDAO.consultarPortablaMes(mes);/*recibir el VO*/
            if(ComVO != null)
            {
                request.setAttribute("mesEncontado", ComVO);
                request.getRequestDispatcher("Compra_Consulta.jsp").forward(request, response);

            }else
            {
                request.setAttribute("MensajeError", "La compra no existe");
                request.getRequestDispatcher("Compra_Consulta.jsp").forward(request, response);

            }
            //redireccionar
            break;
            
            case 3:
            ComVO =ComDAO.consultarPorId(idcompra);/*recibir el VO*/
            if(ComVO != null)
            {
                request.setAttribute("compraEncontado", ComVO);
                request.getRequestDispatcher("Compra_Nuevo_1.jsp").forward(request, response);

            }else
            {
                request.setAttribute("MensajeError", "La compra no existe");
                request.getRequestDispatcher("Compra_Nuevo_1.jsp").forward(request, response);

            }
            //redireccionar
            break;
            case 4://Agregar Registro
                if(ComDAO.agregar())
                {
                    request.setAttribute("MensajeExito", "La compra se agrego de manera correcta");
                    
                }else
                {
                    request.setAttribute("MensajeError", "La compra no se agrego correctamente");
                    
                }
                request.getRequestDispatcher("Compra_Nuevo_1.jsp").forward(request, response);
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
