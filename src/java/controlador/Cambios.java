/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ModeloDAO.ClienteDAO;
import ModeloDAO.CompraDAO;
import ModeloDAO.ProductoDAO;
import ModeloDAO.ProveedoresDAO;
import ModeloDAO.detalle_CompraDAO;
import ModeloVO.ClienteVO;
import ModeloVO.CompraVO;
import ModeloVO.ProductoVO;
import ModeloVO.ProveedoresVO;
import ModeloVO.detalle_CompraVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gajop
 */
@WebServlet(name = "Cambios", urlPatterns = {"/Cambios"})
public class Cambios extends HttpServlet {

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

        //producto
        String Opcion = request.getParameter("opcion");
        String idProductos = request.getParameter("idPro");
        String ProNombre = request.getParameter("ProNombre");
        String ProStock = request.getParameter("ProStock");
        String PrecioUnidad = request.getParameter("PrecioUnidad");
        String Estado = request.getParameter("Estado");

      //Intacia de PRoducto
        ProductoVO proVO = new ProductoVO(idProductos, ProNombre, ProStock, PrecioUnidad, Estado);
        ProductoDAO proDAO = new ProductoDAO(proVO);

        

        switch (Opcion) {

            case "agregarProducto"://Agregar registro
                if (proDAO.agregar()) {
                    request.setAttribute("mensajeExito", "El producto se registro correctamente");
                } else {
                    request.setAttribute("mensajeError", "El producto NO se registro correctamente");
                }
                request.getRequestDispatcher("AdministradorRegistrarProducto.jsp").forward(request, response);
                break;

            case "actualizarProducto"://actualizar registro

                if (proDAO.actualizar()) {
                    request.setAttribute("mensajeExito", "El producto se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeError", "El producto NO se actualizo correctamente");
                }
                request.getRequestDispatcher("AdministradorRegistrarProducto.jsp").forward(request, response);
                break;
                
            case "borrarProducto"://eliminar registro

                if (proDAO.borrar()) {
                    request.setAttribute("mensajeExito", "El producto se elimino correctamente");
                } else {
                    request.setAttribute("mensajeError", "El producto NOse elimino correctamente");
                }
                request.getRequestDispatcher("AdministradorRegistrarProducto.jsp").forward(request, response);
                break;
            case "consultarcodigo":
                proVO = proDAO.consultarporCodigo(idProductos);
                if (proVO != null) {
                    request.setAttribute("productoencontrado", proVO);
                    request.getRequestDispatcher("AdministradorRegistrarProducto.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El producto no existe");
                    request.getRequestDispatcher("AdministradorRegistrarProducto.jsp").forward(request, response);
                }
                break;

            case "consultaractualizar":
                proVO = proDAO.consultarporCodigo(idProductos);
                if (proVO != null) {
                    request.setAttribute("productoencontrado", proVO);
                    request.getRequestDispatcher("AdministradorRegistrarProducto.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El producto no existe");
                    request.getRequestDispatcher("AdministradorRegistrarProducto.jsp").forward(request, response);
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
