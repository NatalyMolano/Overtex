/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import ModeloDAO.ProveedoresDAO;
import ModeloVO.CompraVO;
import ModeloVO.ProveedoresVO;
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
@WebServlet(name = "ProveedorControlador", urlPatterns = {"/Proveedor"})
public class ProveedorControlador extends HttpServlet {

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
        
        String idproveedores = request.getParameter("idproveedores");
        String Documento= request.getParameter("Documento");
        String ProvNombre= request.getParameter("ProvNombre");
        String ProvApellido = request.getParameter("ProvApellido");
        String NombreEmpresa= request.getParameter("NombreEmpresa");
        String Telefono= request.getParameter("Telefono");
        String Estado= request.getParameter("Estado");
        
        //recoger la opcion
        String opcion = request.getParameter("opcion");
        //2. canal a que le voy a enviar los datos  que es el VO por el constructor
        ProveedoresVO ProVO = new ProveedoresVO(idproveedores, Documento, ProvNombre, ProvApellido, NombreEmpresa, Telefono, Estado);
        //3. Hacer las operaciones del DAO
        ProveedoresDAO ProDAO = new ProveedoresDAO (ProVO);//datos que esten en el VO
        //4.Administrar operaciones
        switch(opcion)
        {
            case "registrarProveedor"://Agregar Registro
                if (ProDAO.agregar()) {
                    request.setAttribute("MensajeExito", "El Provedor se registro de manera correcta");

                } else {
                    request.setAttribute("MensajeError", "El Provedor no se registro correctamente");

                }
                request.getRequestDispatcher("Proveedor_Registro.jsp").forward(request, response);
                break;
                
            case "actualizarProveedor":

                if (ProDAO.actualizar()) {
                    request.setAttribute("mensajeExito", "El producto se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeError", "El producto NOse actualizo correctamente");
                }
                request.getRequestDispatcher("Proveedor_Registro.jsp").forward(request, response);
                break;
                
                
            case "borrarProveedor"://eliminar registro

                if (ProDAO.borrar()) {
                    request.setAttribute("mensajeExito", "El producto se elimino correctamente");
                } else {
                    request.setAttribute("mensajeError", "El producto NOse elimino correctamente");
                }
                request.getRequestDispatcher("Proveedor_Registro.jsp").forward(request, response);
                break;
            case "consultar": 
               ProVO =ProDAO.consultarPorProveedor(Documento);/*recibir el VO*/
                if(ProVO != null)
                {
                    request.setAttribute("proveedorEncontrado", ProVO);
                    request.getRequestDispatcher("Compra_Nuevo.jsp").forward(request, response);

                }else
                {
                    request.setAttribute("MensajeError", "El proveedor no existe");
                    request.getRequestDispatcher("Compra_NuevoProveedor.jsp").forward(request, response);

                }
                //redireccionar
                break;
                
            case "consultar_1": 
               ProVO =ProDAO.consultarPorProveedor(Documento);/*recibir el VO*/
                if(ProVO != null)
                {
                    request.setAttribute("proveedorEncontrado", ProVO);
                    request.getRequestDispatcher("Compra_Nuevo.jsp").forward(request, response);

                }else
                {
                    request.setAttribute("MensajeError", "El proveedor no existe");
                    request.getRequestDispatcher("Compra_Nuevo.jsp").forward(request, response);

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
