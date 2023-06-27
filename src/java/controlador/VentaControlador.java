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
import ModeloDAO.VentaDAO;
import ModeloDAO.detalle_CompraDAO;
import ModeloDAO.detalle_VentaDAO;
import ModeloVO.ClienteVO;
import ModeloVO.CompraVO;
import ModeloVO.ProductoVO;
import ModeloVO.ProveedoresVO;
import ModeloVO.VentaVO;
import ModeloVO.detalle_CompraVO;
import ModeloVO.detalle_VentaVO;
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
@WebServlet(name = "productoControlador", urlPatterns = {"/Venta"})
public class VentaControlador extends HttpServlet {

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
        String Estado = request.getParameter("Estado");
        
        //cliente
        
        String CliNombre = request.getParameter("CliNombre");
        String Telefono = request.getParameter("Telefono");
        String cantidad = request.getParameter("Cantidad");
        String Documento = request.getParameter("Documento");

        //venta
        String Mes = request.getParameter("Mes");
        
        String idVenta = request.getParameter("IdVenta");
        String idCliente = request.getParameter("idCliente");
        String idUsuario = request.getParameter("idUsuario");
        String MontoVenta = request.getParameter("MontoVenta");
        String subtotal = request.getParameter("subtotal");

        //detalle venta
        String idDetalleVenta = request.getParameter("IdDetalleVenta");
        String idProductoParaVenta = request.getParameter("idProducto");
        String precioVenta = request.getParameter("precioVenta");

        //Intancia cliente
        ClienteVO cliVO = new ClienteVO(idCliente, CliNombre, Telefono, Documento, Estado);
        ClienteDAO cliDAO = new ClienteDAO(cliVO);
        
        
        //Intacia Compra con diferentes parametros para el VO
        VentaVO venVO = new VentaVO(idVenta, idCliente, idUsuario, MontoVenta, Estado);
        VentaVO venVO1 = new  VentaVO(idVenta, idProductoParaVenta, cantidad, precioVenta);
        
        VentaVO venMes = new VentaVO(Mes);
        
        VentaDAO venDAO = new  VentaDAO(venVO);
        VentaDAO venDAO1 = new  VentaDAO(venVO1);
        VentaDAO venDAOMes = new VentaDAO(venMes);
        String precioCompra = request.getParameter("PrecioUnidad");
        
        //Intancia detalle compra
        detalle_VentaVO deVenVO = new detalle_VentaVO(idDetalleVenta, idVenta, idProductos, cantidad,precioVenta, subtotal);
        detalle_VentaDAO deVenDAO = new detalle_VentaDAO(deVenVO);
         //Intacia de PRoducto
        ProductoVO proVO = new ProductoVO(idProductos, ProNombre, ProStock, precioCompra, Estado);
        ProductoDAO proDAO = new ProductoDAO(proVO);
        
        
        switch (Opcion) {
         case "registrarVenta"://Agregar Registro
                //clienteEncontrado y producto encontrado
                
                if (venDAO.agregar()) {
                    request.setAttribute("MensajeExito", "La venta se registro de manera correcta");

                } else {
                    request.setAttribute("MensajeError", "La venta no se registro correctamente");

                }
                request.getRequestDispatcher("Venta_Nuevo.jsp").forward(request, response);
                break;

            case "registrarDetalleVenta":
                request.setAttribute("productoencontrado", proVO);
                request.setAttribute("clienteEncontrado", cliVO);
                if (venDAO1.agregarDetalleVenta()) {

                    request.setAttribute("MensajeExito", "La venta se registro de manera correcta");

                } else {
                    request.setAttribute("MensajeError", "La venta no se registro correctamente");

                }
                request.getRequestDispatcher("Venta_Nuevo.jsp").forward(request, response);
                break;

           

            case "agregarDetalleVenta":
                request.setAttribute("productoencontrado", proVO);
                request.setAttribute("ventaparaconsultar", venVO);
                request.setAttribute("clienteEncontrado", cliVO);
                if (venDAO1.agregarDetalleVenta()) {

                    request.setAttribute("MensajeExito", "La venta se registro de manera correcta");

                } else {
                    request.setAttribute("MensajeError", "La venta no se registro correctamente");

                }
                request.getRequestDispatcher("Actualizar_Venta.jsp").forward(request, response);
                break;
                
            
                
             case "actualizarVenta"://actualizar registro
                request.setAttribute("productoencontrado", proVO);
                request.setAttribute("ventaparaconsultar", venVO);
                request.setAttribute("clienteEncontrado", cliVO);
                if (venDAO.actualizar()) {
                    request.setAttribute("mensajeExito", "la venta se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeError", "La venta NOse actualizo correctamente");
                }
                request.getRequestDispatcher("Actualizar_Venta.jsp").forward(request, response);
                break;
                
            
                
            case "borrarventa"://eliminar registro

                if (venDAO.borrar()) {
                    request.setAttribute("mensajeExito", "La venta se elimino correctamente");
                } else {
                    request.setAttribute("mensajeError", "La venta NO se elimino correctamente");
                }
                request.getRequestDispatcher("AdministradorListarCompra.jsp").forward(request, response);
                break;
                
            case "borrarDetalleVenta":
                request.setAttribute("productoencontrado", proVO);
                request.setAttribute("clienteEncontrado", cliVO);
                if (deVenDAO.borrarDetalleVenta()) {
                    request.setAttribute("mensajeExito", "Se elimino el registro correctamente");
                } else {
                    request.setAttribute("mensajeError", "No se elimino el registro correctamente");
                }
                request.getRequestDispatcher("Venta_Nuevo.jsp").forward(request, response);
                break;
                
            case "borrarDetalleVenta1":
                request.setAttribute("productoencontrado", proVO);
                request.setAttribute("ventaparaconsultar", venVO);
                request.setAttribute("clienteEncontrado", cliVO);
                if (deVenDAO.borrarDetalleVenta()) {
                    request.setAttribute("mensajeExito", "Se elimino el registro correctamente");
                } else {
                    request.setAttribute("mensajeError", "No se elimino el registro correctamente");
                }
                request.getRequestDispatcher("Actualizar_Venta.jsp").forward(request, response);
                break;   
                
                
            case "consultarVentaMensual":
                venMes = venDAOMes.consultarPorMes(Mes);
                if (venMes != null) {
                    request.setAttribute("Ventaencontrado", venMes);
                    request.getRequestDispatcher("GerenteListarVenta.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "la venta no existe");
                    request.getRequestDispatcher("GerenteListarVenta.jsp").forward(request, response);
                }
                break;
                
             case "consultarCliente":
                cliVO = cliDAO.consultarPorDocumento(Documento);/*recibir el VO*/
                if (cliVO != null) {

                    request.setAttribute("clienteEncontrado", cliVO);
                    request.getRequestDispatcher("Venta_Nuevo.jsp").forward(request, response);

                } else {
                    request.setAttribute("MensajeError", "El cliente no existe");
                    request.getRequestDispatcher("Venta_Nuevo.jsp").forward(request, response);

                }
                //redireccionar
                break;
                
                
            case "consultarCliente1":
                cliVO = cliDAO.consultarPoridCliente(Documento);/*recibir el VO*/
                request.setAttribute("productoencontrado", proVO);
                request.setAttribute("ventaparaconsultar", venVO);
                if (cliVO != null) {
                    
                    request.setAttribute("clienteEncontrado", cliVO);
                    request.getRequestDispatcher("Actualizar_Venta.jsp").forward(request, response);

                } else {
                    request.setAttribute("MensajeError", "El clirnte no existe");
                    request.getRequestDispatcher("Actualizar_Venta.jsp").forward(request, response);

                }
                //redireccionar
                break;

            case "consultarcodigoVenta":
                proVO = proDAO.consultarporCodigo(idProductos);

                if (proVO != null) {
                    request.setAttribute("clinteEncontrado", cliVO);
                    request.setAttribute("productoencontrado", proVO);
                    request.getRequestDispatcher("Venta_Nuevo.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El producto no existe");
                    request.getRequestDispatcher("Venta_Nuevo.jsp").forward(request, response);
                }
                break;

            case "consultarcodigoVenta1":
                proVO = proDAO.consultarporCodigo(idProductos);

                if (proVO != null) {
                    request.setAttribute("ventaparaconsultar", venVO);
                    request.setAttribute("clinteEncontrado", cliVO);
                    request.setAttribute("productoencontrado", proVO);
                    request.getRequestDispatcher("Actualizar_Venta.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El producto no existe");
                    request.getRequestDispatcher("Actualizar_Venta.jsp").forward(request, response);
                }
                break;
                
                
               case "consultarPorVenta":
                venVO = venDAO.consultarPorVenta(idVenta);
                if (venVO != null) {

                    request.setAttribute("ventaparaconsultar", venVO);
                    request.getRequestDispatcher("AdministradorListarVenta.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El producto no existe");
                    request.getRequestDispatcher("AdministradorListarVenta.jsp").forward(request, response);
                }
                break;

            case "consultarPorVenta1":
                venVO = venDAO.consultarPorVenta(idVenta);
                if (venVO != null) {
                    request.setAttribute("ventaparaconsultar", venVO);
                    request.getRequestDispatcher("GerenteListarVenta.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El producto no existe");
                    request.getRequestDispatcher("GerenteListarVenta.jsp").forward(request, response);
                }
                break;

            case "consultarPorVentaActualizar":
                venVO = venDAO.consultarPorVenta(idVenta);
                if (proVO != null) {
                    request.setAttribute("productoencontrado", proVO);
                   request.setAttribute("ventaparaconsultar", venVO);
                    request.getRequestDispatcher("Actualizar_Venta.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El producto no existe");
                    request.getRequestDispatcher("Actualizar_Venta.jsp").forward(request, response);
                }
                break;
                
                
                 case "consultarcomisiones": 
               venVO =venDAO.consultarPoridVendedor(Mes,idUsuario);
                if(venVO != null)
                {
                    request.setAttribute("comisionEncontrada", venVO);
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
